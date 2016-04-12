package zeyad.com.calendarmanager;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.CalendarContract.Events;
import android.util.Log;

/**
 * @author Zeyad Assem
 * Created by Zeyad Assem on 10/04/16.
 * This class enables you to create new Calendar.
 */
public class EventCreator {
    private Uri target;
    private ContentValues values;
    private Context context;

    public EventCreator(Context context, int calendarID){
        values = new ContentValues();
        values.put(Events.CALENDAR_ID,calendarID);
        this.context = context;
        this.target = Events.CONTENT_URI;
    }

    public EventCreator setEventOrganizer(String organizerMail){
        values.put(Events.ORGANIZER,organizerMail);
        return this;
    }

    public EventCreator setEventTitle(String title){
        values.put(Events.TITLE, title);
        return this;
    }

    public EventCreator setEventLocation(String location){
        values.put(Events.EVENT_LOCATION, location);
        return this;
    }

    public EventCreator setEventDescription(String description){
        values.put(Events.DESCRIPTION, description);
        return this;
    }

    public EventCreator setEventStartingDate(long startingDate){
        values.put(Events.DTSTART, startingDate);
        return this;
    }

    public EventCreator setEventEndDate(long endDate){
        values.put(Events.DTEND, endDate);
        return this;
    }

    public EventCreator setEventTimeZone(String timeZone){
        values.put(Events.EVENT_TIMEZONE, timeZone);
        return this;
    }

    public EventCreator setEventEndTimeZone(String timeZone){
        values.put(Events.EVENT_END_TIMEZONE, timeZone);
        return this;
    }

    public EventCreator setEventDuration(String duration){
        values.put(Events.DURATION, duration);
        return this;
    }


    public EventCreator setAllDay(boolean isAllDay){
        values.put(Events.ALL_DAY, isAllDay);
        return this;
    }

    public EventCreator setReOccurrence(String reOccurrence){
        values.put(Events.RRULE, reOccurrence);
        return this;
    }

    public EventCreator setReOccurrenceDate(String reOccurrenceDate){
        values.put(Events.RDATE, reOccurrenceDate);
        return this;
    }

    public EventCreator setAvailability(Availability availability){
        values.put(Events.AVAILABILITY, getAvailability(availability));
        return this;
    }

    public void create(){
        if(CalendarPermissionWrapper.checkCalendarPermission(context)){
            try{
                Uri uri = context.getContentResolver().insert(target, values);
                long eventID = Long.parseLong(uri.getLastPathSegment());
                 Log.i("CalendarManager", "eventID "+Long.toString(eventID));
            }catch (Exception e){
                Log.i("CalendarManager","CalendarManager "+e.getMessage());
            }
        }else{
            CalendarPermissionWrapper.requestCalendarPermission(context);
            Log.i("CalendarManager","try again");
        }
    }

    public enum Availability{
        BUSY,
        FREE,
        TENTATIVE
    }

    private int getAvailability(Availability eventAvailability ){
        int availability = Events.AVAILABILITY_FREE;
        switch (eventAvailability){
            case BUSY:
                availability = Events.AVAILABILITY_BUSY;
                break;
            case TENTATIVE:
                availability = Events.AVAILABILITY_TENTATIVE;
                break;
            default:
                availability = Events.AVAILABILITY_FREE;
        }
        return availability;
    }


}
