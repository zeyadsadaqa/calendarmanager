package zeyad.com.calendarmanager;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.util.Log;

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
                displayName = cur.getString(CalendarConstants.PROJECTION_DISPLAY_NAME_INDEX);
                calendarAccountName = cur.getString(CalendarConstants.PROJECTION_ACCOUNT_NAME_INDEX);

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
                calendarID = cur.getInt(CalendarConstants.PROJECTION_ID_INDEX);
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
                displayName = cur.getString(CalendarConstants.PROJECTION_DISPLAY_NAME_INDEX);
                if(displayName.equals(calendarName))
                    calendarExists = true;
            }
        }

        return calendarExists;
    }

    /**
     * This method logs all the calendars with Account type local.
     */
    public void logAllCalendars(){
        if(!CalendarPermissionWrapper.checkCalendarPermission(context)){
            CalendarPermissionWrapper.requestCalendarPermission(context);
        }

        if(CalendarPermissionWrapper.checkCalendarPermission(context)){
            // Run query
            Cursor cur = null;
            String selection = "( ("+ CalendarContract.Calendars.ACCOUNT_TYPE + " = ?) )";
            String[] selectionArgs = new String[]{ CalendarContract.ACCOUNT_TYPE_LOCAL};
            cur = getCalendarsCursor(selection,selectionArgs);

            // Use the cursor to step through the returned records
            while (cur.moveToNext()) {
                long calID = 0;

                // Get the field values
                calID = cur.getLong(CalendarConstants.PROJECTION_ID_INDEX);
                String displayName = cur.getString(CalendarConstants.PROJECTION_DISPLAY_NAME_INDEX);
                String accountName = cur.getString(CalendarConstants.PROJECTION_ACCOUNT_NAME_INDEX);
                String ownerName = cur.getString(CalendarConstants.PROJECTION_OWNER_ACCOUNT_INDEX);

                // Do something with the values...
                Log.i("calID",Long.toString(calID));
                Log.i("displayName",displayName);
                Log.i("accountName",accountName);
                Log.i("ownerName",ownerName);

            }
        }
    }

    /**
     * This helper method returns cursor with calendar specified arguments
     * @param selection the selection statement.
     * @param selectionArguments the values of the columns specified in the selection statement.
     * @return Cursor of all calendars with specified arguments.
     */
    private Cursor getCalendarsCursor(String selection, String []selectionArguments){
        Cursor cur = contentResolver.query(CalendarConstants.calendarURI, CalendarConstants.CALENDAR_PROJECTION,
                selection, selectionArguments, null);
        return cur;
    }


}
