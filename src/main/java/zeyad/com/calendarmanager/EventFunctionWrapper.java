package zeyad.com.calendarmanager;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.util.Log;

import java.util.ArrayList;

import zeyad.com.calendarmanager.enums.Availability;
import zeyad.com.calendarmanager.models.EventModel;

/**
 * @author Zeyad Assem
 * Created by Zeyad Assem on 11/04/16.
 * This class wraps most of the functions needed to query or delete events.
 */
public class EventFunctionWrapper {
    private ContentResolver contentResolver;
    private Context context;

    /**
     * Constructor initialize the context and the content resolver.
     * @param context This is the activity context that will call this class.
     */
    public EventFunctionWrapper(Context context){
        this.context = context;
        this.contentResolver = context.getContentResolver();
    }

    /**
     * This method returns event IDs in array list of longs.
     * @param calendarID The calendar id that the event is related to.
     * @param title The event title.
     * @param startDate The start date of the event in millisecond.
     * @return the IDs of the events related.
     */
    public ArrayList<Long> getEventsID(long calendarID, String title, long startDate){
        ArrayList<Long> eventsID = new ArrayList<Long>() ;
        if(!CalendarPermissionWrapper.checkCalendarPermission(context)){
            CalendarPermissionWrapper.requestCalendarPermission(context);
        }

        if(CalendarPermissionWrapper.checkCalendarPermission(context)){
            String selection = "( ("+ Events.CALENDAR_ID + " = ?) AND ("+Events.TITLE+"=?) AND ("+Events.DTSTART+"=?))";
            String[] selectionArgs = new String[]{ ""+calendarID,title,Long.toString(startDate)};
            Cursor cur = getEventsCursor(selection,selectionArgs);
            // Use the cursor to step through the returned records
            while (cur.moveToNext()) {
                long eventID = cur.getLong(CalendarConstants.PROJECTION_ID_INDEX);
                eventsID.add(eventID);
            }
        }
        return eventsID;
    }

    public ArrayList<EventModel> getEventsByDate(long startDate, long endDate){
        ArrayList<EventModel> events = new ArrayList<>();

//        ArrayList<Long> eventsID = new ArrayList<Long>() ;
        if(!CalendarPermissionWrapper.checkCalendarPermission(context)){
            CalendarPermissionWrapper.requestCalendarPermission(context);
        }

        if(CalendarPermissionWrapper.checkCalendarPermission(context)){
            Cursor cur = null;
            EventQuery eventQuery = new EventQuery.EventQueryBuilder().withStartDateGreaterThan(startDate).withEndDateLessThan(endDate).build();
            cur = getEventCursor(eventQuery);
            // Use the cursor to step through the returned records
            events = getEventsFromCursor(cur);
        }
        return events;
    }


    public ArrayList<EventModel> getEvents(){
        ArrayList<EventModel> events = new ArrayList<>();
        if(!CalendarPermissionWrapper.checkCalendarPermission(context)){
            CalendarPermissionWrapper.requestCalendarPermission(context);
        }

        if(CalendarPermissionWrapper.checkCalendarPermission(context)){
            Cursor cur = null;
            EventQuery eventQuery =new  EventQuery.EventQueryBuilder().build();
            cur = context.getContentResolver().query(eventQuery.getEventUri(), eventQuery.getEventProjection(), eventQuery.getEventSelection(), eventQuery.getEventSelectionArguments(),eventQuery.getEventSortOrder());
             events = getEventsFromCursor(cur);
        }
        return events;
    }

    public ArrayList<EventModel> getEvents(EventQuery eventQuery){
        ArrayList<EventModel> events = new ArrayList<>();
        if(!CalendarPermissionWrapper.checkCalendarPermission(context)){
            CalendarPermissionWrapper.requestCalendarPermission(context);
        }

        if(CalendarPermissionWrapper.checkCalendarPermission(context)){
            Cursor cur = context.getContentResolver().query(eventQuery.getEventUri(), eventQuery.getEventProjection(), eventQuery.getEventSelection(), eventQuery.getEventSelectionArguments(),eventQuery.getEventSortOrder());
            events = getEventsFromCursor(cur);
        }
        return events;
    }



    /**
     * This method logs all the events in a certain calendar.
     * @param calendarID The calendar id that the event is related to.
     */
    public void logAllEvents(){
        if(!CalendarPermissionWrapper.checkCalendarPermission(context)){
            CalendarPermissionWrapper.requestCalendarPermission(context);
        }

        if(CalendarPermissionWrapper.checkCalendarPermission(context)){
            ArrayList<EventModel> events  = getEvents();
            for(int i=0; i<events.size();i++){
                Log.i("event" , events.get(i).toString());
            }

        }
    }

    /**
     * This method checks if the event exists or not.
     * @param eventID the event id i want to check.
     * @return true if event exists.
     * @return false if event not found.
     */
    public boolean checkEventExists(long eventID){
        String selection = "( ("+ Events._ID + " = ?))";
        String[] selectionArgs = new String[]{ Long.toString(eventID)};
        Cursor cur = getEventsCursor(selection,selectionArgs);
        if(cur.getCount()>0)
            return true;
        else
            return false;
    }

    /**
     * This method delete an event,
     * @param eventID the event id i want to delete.
     */
    public void deleteEvent(long eventID){
        Uri deleteUri =  ContentUris.withAppendedId(Events.CONTENT_URI, eventID);
        int rows = contentResolver.delete(deleteUri, null, null);
        Log.i("deleted rows", "Rows deleted: " + rows);
    }

    /**
     * This is advanced method enables you to pass your favourite query arguments
     * @param eventsColumnsToQuery array of events columns you want to query.
     * @param selectionArguments array of strings represent columns values.
     * @param EventColumnsInResult array of events columns you want to get in your cursor.
     * @return Cursor with the specified events related to the arguments.
     */
    public Cursor generalQueryEvent(EventTableColumns[] eventsColumnsToQuery,String[] selectionArguments,
                                    EventTableColumns [] EventColumnsInResult ){

        if(selectionArguments.length == eventsColumnsToQuery.length){
            if(!CalendarPermissionWrapper.checkCalendarPermission(context)){
                CalendarPermissionWrapper.requestCalendarPermission(context);
            }

            if(CalendarPermissionWrapper.checkCalendarPermission(context)){
                Cursor cur = getEventsCursor(buildSelectionStatement(eventsColumnsToQuery),
                        selectionArguments,buildProjection(EventColumnsInResult));
                return cur;
            }
        }else{
            Log.i("Calendar Manager Error","Number of arguments not matching number of selections");
        }

        return null;
    }

    /**
     * This is helper method build the selection statement.
     * @param eventTableColumns any number EventTableColumns items
     * @return String represents selection statement.
     */
    private String buildSelectionStatement(EventTableColumns...eventTableColumns){
        StringBuilder selectionStatement = new StringBuilder("(");
        for(int i=0;i<eventTableColumns.length;i++){
            if(i ==0)
                selectionStatement.append("("+getEventTableColumns(eventTableColumns[i])+"=?)");
            else
                selectionStatement.append("AND ("+getEventTableColumns(eventTableColumns[i])+"=?)");
        }
        selectionStatement.append(")");
        return selectionStatement.toString();
    }

    /**
     * This is helper method build projection to get the selected columns in your cursor.
     * @param eventTableColumns any number EventTableColumns items
     * @return String represents selection statement.
     */
    private String[] buildProjection(EventTableColumns[] eventTableColumns){
        String [] columns = new String [eventTableColumns.length];
        for(int i =0; i<eventTableColumns.length;i++){
            columns[i] = getEventTableColumns(eventTableColumns[i]);
        }
        return columns;
    }

    /**
     * This enum prevent the user to enter unacceptable columns.
     */
    public static enum EventTableColumns{
        calendarID,
        eventID,
        eventOrganizerMail,
        eventTitle,
        eventLocation,
        eventDescription,
        eventStartDate,
        eventEndDate,
        eventTimeZone,
        eventEndTimeZone,
        eventDuration,
        eventIsAllDay,
        eventReOccurrence,
        eventAvailability,
    }

    /**
     * This is helper method map the enum values with the real columns values.
     * @param eventTableColumn one of the enum values you want to map.
     * @return String represents the actual string value.
     */
    private String getEventTableColumns(EventTableColumns eventTableColumn){
        String tableColumn = Events._ID;
        switch (eventTableColumn){
            case calendarID:
                tableColumn = Events.CALENDAR_ID;
                break;
            case eventID:
                tableColumn = Events._ID;
                break;
            case eventOrganizerMail:
                tableColumn = Events.ORGANIZER;
                break;
            case eventTitle:
                tableColumn = Events.TITLE;
                break;
            case eventLocation:
                tableColumn= Events.EVENT_LOCATION;
                break;
            case eventDescription:
                tableColumn = Events.DESCRIPTION;
                break;
            case eventStartDate:
                tableColumn = Events.DTSTART;
                break;
            case eventEndDate:
                tableColumn = Events.DTEND;
                break;
            case eventTimeZone:
                tableColumn = Events.EVENT_TIMEZONE;
                break;
            case eventEndTimeZone:
                tableColumn = Events.EVENT_END_TIMEZONE;
                break;
            case eventDuration:
                tableColumn = Events.DURATION;
                break;
            case eventIsAllDay:
                tableColumn = Events.ALL_DAY;
                break;
            case eventReOccurrence:
                tableColumn  = Events.RRULE;
                break;
            case eventAvailability:
                tableColumn = Events.AVAILABILITY;
                break;

        }
        return tableColumn;
    }

    /**
     * This is helper method that query your content provider.
     * @param selection represents the selection statement.
     * @param selectionArguments the values of the columns specified in the selection statement.
     * @return cursor with the data needed.
     */
    private Cursor getEventsCursor(String selection, String []selectionArguments){
        Cursor cur = contentResolver.query(CalendarConstants.EVENT_URI, /*projection*/CalendarConstants.EVENT_PROJECTION,
                selection, selectionArguments, null);
        return cur;
    }

    public ArrayList<EventModel> getEventsFromCursor(Cursor eventCursor){
        ArrayList<EventModel> events = new ArrayList<>();

        if(eventCursor != null && eventCursor.getCount()>0){
            while (eventCursor.moveToNext()){
                String stringCursor = DatabaseUtils.dumpCurrentRowToString(eventCursor);
                EventModel eventModel = new EventModel();
                eventModel.setRRule(eventCursor.getString(CalendarConstants.PROJECTION_RRULE_INDEX));
                eventModel.setEventTimeZone(eventCursor.getString(CalendarConstants.PROJECTION_EVENT_TIMEZONE_INDEX));
                eventModel.setHasAttendeeData(eventCursor.getInt(CalendarConstants.PROJECTION_HAS_ATTENDEE_DATA_INDEX)>0);
                eventModel.setSyncId(eventCursor.getString(CalendarConstants.PROJECTION_SYNC_ID_INDEX));
                eventModel.setCustomAppPackage(eventCursor.getString(CalendarConstants.PROJECTION_CUSTOM_APP_PACKAGE_INDEX));
                eventModel.setOriginalInstanceTime(eventCursor.getLong(CalendarConstants.PROJECTION_INSTANCE_TIME_INDEX));
                eventModel.setAllowedReminders(eventCursor.getString(CalendarConstants.PROJECTION_ALLOWED_REMINDERS_INDEX));
                eventModel.setUid2445(eventCursor.getString(CalendarConstants.PROJECTION_UID_2445_INDEX));
                eventModel.setCalendarTimezone(eventCursor.getString(CalendarConstants.PROJECTION_CALENDAR_TIME_ZONE_INDEX));
                eventModel.setDirty(eventCursor.getLong(CalendarConstants.PROJECTION_DIRTY_INDEX));
                eventModel.setOriginalAllDay(eventCursor.getInt(CalendarConstants.PROJECTION_ORIGINAL_ALL_DAY_INDEX)>0);
                eventModel.setExrule(eventCursor.getString(CalendarConstants.PROJECTION_EXRULE_INDEX));
                eventModel.setCalendarColor(eventCursor.getInt(CalendarConstants.PROJECTION_CALENDAR_COLOR_INDEX));
                eventModel.setLastDate(eventCursor.getLong(CalendarConstants.PROJECTION_LAST_DATE_INDEX));
                eventModel.setCanOrganizerRespond(eventCursor.getInt(CalendarConstants.PROJECTION_CAN_ORGANIZER_RESPOND_INDEX)>0);
                eventModel.setGuestsCanSeeGuests(eventCursor.getInt(CalendarConstants.PROJECTION_GUESTS_CAN_SEE_GUESTS_INDEX)>0);
                eventModel.setrDate(eventCursor.getString(CalendarConstants.PROJECTION_RDATE_INDEX));
                eventModel.setAccountType(eventCursor.getString(CalendarConstants.PROJECTION_ACCOUNT_TYPE_INDEX));
                eventModel.setEventEndTimezone(eventCursor.getString(CalendarConstants.PROJECTION_EVENT_END_TIMEZONE_INDEX));
                eventModel.setSelfAttendeeStatus(eventCursor.getInt(CalendarConstants.PROJECTION_SELF_ATTENDEE_STATUS_INDEX));
                eventModel.setExDate(eventCursor.getString(CalendarConstants.PROJECTION_EXDATE_INDEX));
                eventModel.setHasExtendedProperties(eventCursor.getInt(CalendarConstants.PROJECTION_HAS_EXTENDED_PROPERTIES_INDEX)>0);
                eventModel.setEventColorKey(eventCursor.getString(CalendarConstants.PROJECTION_EVENT_COLOR_KEY_INDEX));
                eventModel.setOrganizer(eventCursor.getString(CalendarConstants.PROJECTION_ORGANIZER_INDEX));
                eventModel.setCalendarColorIndex(eventCursor.getString(CalendarConstants.PROJECTION_CALENDAR_COLOR_KEY_INDEX));
                eventModel.setEventColor(eventCursor.getInt(CalendarConstants.PROJECTION_EVENT_COLOR_INDEX));
                eventModel.setAvailability(eventCursor.getInt(CalendarConstants.PROJECTION_AVAILABILITY_INDEX));
                eventModel.setAvailability(eventCursor.getInt(CalendarConstants.PROJECTION_AVAILABILITY_INDEX));
                eventModel.setStartDate(eventCursor.getLong(CalendarConstants.PROJECTION_DTSTART_INDEX));
                eventModel.setOwnerAccount(eventCursor.getString(CalendarConstants.PROJECTION_EVENT_OWNER_ACCOUNT_INDEX));
                eventModel.setLastSynced(eventCursor.getInt(CalendarConstants.PROJECTION_LAST_SYNCED_INDEX)>0);
                eventModel.setDuration(eventCursor.getString(CalendarConstants.PROJECTION_DURATION_INDEX));
                eventModel.setAccessLevel(eventCursor.getInt(CalendarConstants.PROJECTION_ACCESS_LEVEL_INDEX));
                eventModel.setMaxReminders(eventCursor.getInt(CalendarConstants.PROJECTION_EVENT_MAX_REMINDERS_INDEX));
                eventModel.setDisplayColor(eventCursor.getInt(CalendarConstants.PROJECTION_DISPLAY_COLOR_INDEX));
                eventModel.setAllDay(eventCursor.getInt(CalendarConstants.PROJECTION_ALL_DAY_INDEX)>0);
                eventModel.setEventStatus(eventCursor.getInt(CalendarConstants.PROJECTION_STATUS_INDEX));
                eventModel.setEndDate(eventCursor.getLong(CalendarConstants.PROJECTION_DTEND_INDEX));
                eventModel.setOriginalId(eventCursor.getString(CalendarConstants.PROJECTION_ORIGINAL_ID_INDEX));
                eventModel.setId(eventCursor.getInt(CalendarConstants.PROJECTION_ID_INDEX));
                eventModel.setGuestsCanModify(eventCursor.getInt(CalendarConstants.PROJECTION_GUESTS_CAN_MODIFY_INDEX)>0);
                eventModel.setCustomAppUri(eventCursor.getString(CalendarConstants.PROJECTION_CUSTOM_APP_URI_INDEX));
                eventModel.setCalendarAccessLevel(eventCursor.getInt(CalendarConstants.PROJECTION_CALENDAR_ACCESS_LEVEL_INDEX));
                eventModel.setCalendarDisplayName(eventCursor.getString(CalendarConstants.PROJECTION_CALENDAR_DISPLAY_NAME_INDEX));
                eventModel.setGuestsCanInviteOthers(eventCursor.getInt(CalendarConstants.PROJECTION_GUESTS_CAN_INVITE_OTHERS_INDEX)>0);
                eventModel.setOriginalSyncId(eventCursor.getString(CalendarConstants.PROJECTION_ORIGINAL_SYNC_ID_INDEX));
                eventModel.setCanModifyTimeZone(eventCursor.getInt(CalendarConstants.PROJECTION_CAN_MODIFY_TIME_ZONE_INDEX)>0);
                eventModel.setVisible(eventCursor.getInt(CalendarConstants.PROJECTION_VISIBLE_INDEX)>0);
                eventModel.setAllowedAttendeeTypes(eventCursor.getString(CalendarConstants.PROJECTION_ALLOWED_ATTENDEE_TYPES_INDEX));
                eventModel.setAllowedAvailability(eventCursor.getString(CalendarConstants.PROJECTION_ALLOWED_AVAILABILITY_INDEX));
                eventModel.setDescription(eventCursor.getString(CalendarConstants.PROJECTION_DESCRIPTION_INDEX));
                eventModel.setTitle(eventCursor.getString(CalendarConstants.PROJECTION_TITLE_INDEX));
                eventModel.setCalendarId(eventCursor.getInt(CalendarConstants.PROJECTION_CALENDAR_ID_INDEX));
                eventModel.setDeleted(eventCursor.getInt(CalendarConstants.PROJECTION_DELETED_INDEX)>0);
                eventModel.setEventLocation(eventCursor.getString(CalendarConstants.PROJECTION_EVENT_LOCATION_INDEX));
                eventModel.setAccountName(eventCursor.getString(CalendarConstants.PROJECTION_ACCOUNT_NAME_INDEX));
                eventModel.setHasAlarm(eventCursor.getInt(CalendarConstants.PROJECTION_HAS_ALARM_INDEX)>0);
                eventModel.setIsOrganizer(eventCursor.getString(CalendarConstants.PROJECTION_IS_ORGANIZER_INDEX));
                events.add(eventModel);
            }

        }
        return events;
    }

/**
 * This is helper method that query your content provider.
 * Enables you to specify also what columns you need in your cursor.
 * @param selection represents the selection statement.
 * @param selectionArguments the values of the columns specified in the selection statement.
 * @param projection array of strings represents the column names retrieved in your cursor.
 * @return cursor with the data needed.
 */
    private Cursor getEventsCursor(String selection, String []selectionArguments, String [] projection){
        Cursor cur = contentResolver.query(CalendarConstants.EVENT_URI, projection,
                selection, selectionArguments, null);
        return cur;
    }

    private Cursor getEventsCursor(Uri uri, String selection, String []selectionArguments){
        Cursor cur = contentResolver.query(uri, CalendarConstants.EVENT_PROJECTION,
                selection, selectionArguments, null);
        return cur;
    }

    private Cursor getEventCursor(EventQuery eventQuery){
        Cursor cur = contentResolver.query(eventQuery.getEventUri(), eventQuery.getEventProjection(),
                eventQuery.getEventSelection(), eventQuery.getEventSelectionArguments(), eventQuery.getEventSortOrder());
        return cur;
    }
}
