package zeyad.com.calendarmanager;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.util.Log;

import java.util.ArrayList;

import zeyad.com.calendarmanager.models.CalendarModel;

/**
 * @author Zeyad Assem
 * Created by Zeyad Assem on 23/03/16.
 */
public class CalendarFunctionsWrapper  {

    private Context context;
    ContentResolver contentResolver;

    public CalendarFunctionsWrapper(Context context){
        this. context = context;
        contentResolver = context.getContentResolver();
    }

    /**
     * This method check if there are one calendar or more calendar with
     * the specified account name and display or not
     * @param calendarName display name of the calendar.
     * @param accountName account name of the calendar.
     * @return True if one calendar with the specified criteria exists.
     * @return false if the one calendar with the specified criteria doesn't exist.
     */
    public boolean checkCalendarExists(String calendarName, String accountName){
        boolean calendarExists = false;

        if(!CalendarPermissionWrapper.checkCalendarPermission(context)){
            CalendarPermissionWrapper.requestCalendarPermission(context);
        }
        if(CalendarPermissionWrapper.checkCalendarPermission(context)){
            Cursor cur = null;
            String selection = "( (" + CalendarContract.Calendars.ACCOUNT_TYPE + " = ?) )";
            String[] selectionArgs = new String[]{ CalendarContract.ACCOUNT_TYPE_LOCAL};
            cur = getCalendarsCursor(selection,selectionArgs);
            String displayName = null;
            String calendarAccountName = null;
            String calendarType = null;
            // Use the cursor to step through the returned records
            while (cur.moveToNext()) {
                displayName = cur.getString(CalendarConstants.PROJECTION_CALENDAR_DISPLAY_NAME_TYPE);
                calendarAccountName = cur.getString(CalendarConstants.PROJECTION_ACCOUNT_NAME_TYPE);

                try{
                    Log.i("displayName",displayName);
                    Log.i("accountName",calendarAccountName);

                    if(displayName.equals(calendarName) && calendarAccountName.equals(accountName))
                        calendarExists = true;
                }catch (NullPointerException e){
                    Log.i("exception","NullPointerException");
                }
            }
        }

        return calendarExists;

    }


    /**
     * This method returns calendar ID by providing its name and account name
     * @param calendarName display name of the calendar.
     * @param accountName account name of the calendar.
     * @return calendar ID.
     */
    public int getCalendarID(String calendarName, String accountName){
        int calendarID = 0;
        if(checkCalendarExists(calendarName,accountName)){
            Cursor cur = null;
            String selection = "( (" + CalendarContract.Calendars.ACCOUNT_TYPE + " = ?) AND("+ CalendarContract.Calendars.CALENDAR_DISPLAY_NAME+" = ?) AND ("+CalendarContract.Calendars.ACCOUNT_NAME+" = ?) )";
            String[] selectionArgs = new String[]{ CalendarContract.ACCOUNT_TYPE_LOCAL , calendarName, accountName};
            cur = getCalendarsCursor(selection,selectionArgs);
            // Use the cursor to step through the returned records
            while (cur.moveToNext()) {
                calendarID = cur.getInt(CalendarConstants.PROJECTION_ID_TYPE);
            }
        }
        return calendarID;
    }



    public boolean checkCalendarExistsByDisplayName(String calendarName){
        boolean calendarExists = false;

        if(!CalendarPermissionWrapper.checkCalendarPermission(context)){
            CalendarPermissionWrapper.requestCalendarPermission(context);
        }

        if(CalendarPermissionWrapper.checkCalendarPermission(context)){
            Cursor cur = null;
            String selection = "( (" + CalendarContract.Calendars.ACCOUNT_TYPE + " = ?) )";
            String[] selectionArgs = new String[]{ CalendarContract.ACCOUNT_TYPE_LOCAL};
            cur = getCalendarsCursor(selection,selectionArgs);
            String displayName = null;
            // Use the cursor to step through the returned records
            while (cur.moveToNext()) {
                displayName = cur.getString(CalendarConstants.PROJECTION_CALENDAR_DISPLAY_NAME_TYPE);
                if(displayName.equals(calendarName))
                    calendarExists = true;
            }
        }

        return calendarExists;
    }

    /**
     * This method logs all the calendars with Account type local.
     * modified
     */
    public void logAllCalendars(){
        if(!CalendarPermissionWrapper.checkCalendarPermission(context)){
            CalendarPermissionWrapper.requestCalendarPermission(context);
        }

        if(CalendarPermissionWrapper.checkCalendarPermission(context)){
            // Run query
            CalendarQuery calendarQuery = new CalendarQuery.CalendarQueryBuilder().build();
            ArrayList<CalendarModel> calendarModels = getAllCalendars();
            for(CalendarModel model: calendarModels){
                Log.i("calendar", model.toString());
            }
        }
    }


    //new method
    public ArrayList<CalendarModel> getAllCalendars() {
        CalendarQuery calendarQuery = new CalendarQuery.CalendarQueryBuilder().build();
        Cursor cur = getCalendarCursor(calendarQuery);
        return getCalendarsFromCursor(cur);
    }

    //new method
    public ArrayList<CalendarModel> getCalendarsFromCursor(Cursor calendarCursor){
        ArrayList<CalendarModel> calendars = new ArrayList<>();
        if(calendarCursor != null && calendarCursor.getCount() >0){
            while(calendarCursor.moveToNext()){
                CalendarModel calendarModel = new CalendarModel();
                calendarModel.setSyncEvents(calendarCursor.getInt(CalendarConstants.PROJECTION_SYNC_EVENTS_INDEX));
                calendarModel.setOwnerAccount(calendarCursor.getString(CalendarConstants.PROJECTION_OWNER_ACCOUNT_INDEX));
                calendarModel.setMaxReminders(calendarCursor.getInt(CalendarConstants.PROJECTION_MAX_REMINDERS_INDEX));
                calendarModel.setCanPartiallyUpdate(calendarCursor.getInt(CalendarConstants.PROJECTION_CAN_PARTIALLY_UPDATE_INDEX)>0);
                calendarModel.setSyncId(calendarCursor.getInt(CalendarConstants.PROJECTION__SYNC_ID_TYPE));
                calendarModel.setId(calendarCursor.getInt(CalendarConstants.PROJECTION_ID_TYPE));
                calendarModel.setAllowedReminders(calendarCursor.getString(CalendarConstants.PROJECTION_ALLOWED_REMINDERS_TYPE));
                calendarModel.setCalendarTimezone(calendarCursor.getString(CalendarConstants.PROJECTION_CALENDAR_TIME_ZONE_TYPE));
                calendarModel.setCalendarAccessLevel(calendarCursor.getInt(CalendarConstants.PROJECTION_CALENDAR_ACCESS_LEVEL_TYPE));
                calendarModel.setDisplayName(calendarCursor.getString(CalendarConstants.PROJECTION_CALENDAR_DISPLAY_NAME_TYPE));
                calendarModel.setDirty(calendarCursor.getLong(CalendarConstants.PROJECTION_DIRTY_TYPE));
                calendarModel.setCalendarColor(calendarCursor.getInt(CalendarConstants.PROJECTION_CALENDAR_COLOR_TYPE));
                calendarModel.setCanOrganizerRespond(calendarCursor.getInt(CalendarConstants.PROJECTION_CAN_ORGANIZER_RESPOND_TYPE)>0);
                calendarModel.setVisible(calendarCursor.getInt(CalendarConstants.PROJECTION_VISIBLE_TYPE)>0);
                calendarModel.setCanModifyTimezone(calendarCursor.getInt(CalendarConstants.PROJECTION_CAN_MODIFY_TIME_ZONE_TYPE)>0);
                calendarModel.setAccountType(calendarCursor.getString(CalendarConstants.PROJECTION_ACCOUNT_TYPE_TYPE));
                calendarModel.setAllowedAttendees(calendarCursor.getString(CalendarConstants.PROJECTION_ALLOWED_ATTENDEE_TYPES_TYPE));
                calendarModel.setCalendarLocation(calendarCursor.getString(CalendarConstants.PROJECTION_CALENDAR_LOCATION_TYPE));
                calendarModel.setCalendarColorKey(calendarCursor.getString(CalendarConstants.PROJECTION_CALENDAR_COLOR_KEY_TYPE));
                calendarModel.setAllowedAvailability(calendarCursor.getString(CalendarConstants.PROJECTION_ALLOWED_AVAILABILITY_TYPE));
                calendarModel.setName(calendarCursor.getString(CalendarConstants.PROJECTION_NAME_TYPE));
                calendarModel.setDeleted(calendarCursor.getInt(CalendarConstants.PROJECTION_DELETED_TYPE)>0);
                calendarModel.setAccountName(calendarCursor.getString(CalendarConstants.PROJECTION_ACCOUNT_NAME_TYPE));

                calendars.add(calendarModel);
            }
        }
        return calendars;
    }

    /**
     * This helper method returns cursor with calendar specified arguments
     * @param selection the selection statement.
     * @param selectionArguments the values of the columns specified in the selection statement.
     * @return Cursor of all calendars with specified arguments.
     */
    public Cursor getCalendarsCursor(String selection, String []selectionArguments){
        Cursor cur = contentResolver.query(CalendarConstants.calendarURI, /*CalendarConstants.CALENDAR_PROJECTION*/null,
                selection, selectionArguments, null);
        return cur;
    }

    public Cursor getCalendarCursor(CalendarQuery query){
        Cursor cursor = contentResolver.query(query.getCalendarUri(), query.getCalendarProjection(), query.getCalendarSelection(), query.getCalendarSelectionArguments(), query.getCalendarSortOrder());
        return cursor;
    }


}
