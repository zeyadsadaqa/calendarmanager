package zeyad.com.calendarmanager;

import android.net.Uri;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import java.net.URI;

/**
 * @author Zeyad Assem
 * Created by Zeyad Assem on 23/03/16.
 */
public class CalendarConstants {
    public static final String[] CALENDAR_PROJECTION = new String[]{
            Calendars.SYNC_EVENTS,
            Calendars.OWNER_ACCOUNT,
            Calendars.MAX_REMINDERS,
            Calendars.CAN_PARTIALLY_UPDATE,
            Calendars._SYNC_ID,
            Calendars._ID,
            Calendars.ALLOWED_REMINDERS,
            Calendars.CALENDAR_TIME_ZONE,
            Calendars.CALENDAR_ACCESS_LEVEL,
            Calendars.CALENDAR_DISPLAY_NAME,
            Calendars.DIRTY,
            Calendars.CALENDAR_COLOR,
            Calendars.CAN_ORGANIZER_RESPOND,
            Calendars.VISIBLE,
            Calendars.CAN_MODIFY_TIME_ZONE,
            Calendars.ACCOUNT_TYPE,
            Calendars.ALLOWED_ATTENDEE_TYPES,
            Calendars.CALENDAR_LOCATION,
            Calendars.CALENDAR_COLOR_KEY,
            Calendars.ALLOWED_AVAILABILITY,
            Calendars.NAME,
            Calendars.DELETED,
            Calendars.ACCOUNT_NAME
    };


    // The indices for the calendar projection array above.
    public static final int PROJECTION_SYNC_EVENTS_INDEX = 0;
    public static final int PROJECTION_OWNER_ACCOUNT_INDEX = 1;
    public static final int PROJECTION_MAX_REMINDERS_INDEX = 2;
    public static final int PROJECTION_CAN_PARTIALLY_UPDATE_INDEX = 3;
    public static final int PROJECTION__SYNC_ID_TYPE = 4;
    public static final int PROJECTION_ID_TYPE = 5;
    public static final int PROJECTION_ALLOWED_REMINDERS_TYPE = 6;
    public static final int PROJECTION_CALENDAR_TIME_ZONE_TYPE = 7;
    public static final int PROJECTION_CALENDAR_ACCESS_LEVEL_TYPE = 8;
    public static final int PROJECTION_CALENDAR_DISPLAY_NAME_TYPE = 9;
    public static final int PROJECTION_DIRTY_TYPE = 10;
    public static final int PROJECTION_CALENDAR_COLOR_TYPE = 11;
    public static final int PROJECTION_CAN_ORGANIZER_RESPOND_TYPE = 12;
    public static final int PROJECTION_VISIBLE_TYPE = 13;
    public static final int PROJECTION_CAN_MODIFY_TIME_ZONE_TYPE = 14;
    public static final int PROJECTION_ACCOUNT_TYPE_TYPE = 15;
    public static final int PROJECTION_ALLOWED_ATTENDEE_TYPES_TYPE = 16;
    public static final int PROJECTION_CALENDAR_LOCATION_TYPE = 17;
    public static final int PROJECTION_CALENDAR_COLOR_KEY_TYPE = 18;
    public static final int PROJECTION_ALLOWED_AVAILABILITY_TYPE = 19;
    public static final int PROJECTION_NAME_TYPE = 20;
    public static final int PROJECTION_DELETED_TYPE = 21;
    public static final int PROJECTION_ACCOUNT_NAME_TYPE = 22;





    public static final String [] EVENT_PROJECTION = new String[]{
            Events.RRULE,
            Events.EVENT_TIMEZONE,
            Events.HAS_ATTENDEE_DATA,
            Events._SYNC_ID,
            Events.CUSTOM_APP_PACKAGE,
            Events.ORIGINAL_INSTANCE_TIME,
            Events.ALLOWED_REMINDERS,
            Events.UID_2445,
            Events.CALENDAR_TIME_ZONE,
            Events.DIRTY,
            Events.ORIGINAL_ALL_DAY,
            Events.EXRULE,
            Events.CALENDAR_COLOR,
            Events.LAST_DATE,
            Events.CAN_ORGANIZER_RESPOND,
            Events.GUESTS_CAN_SEE_GUESTS,
            Events.RDATE,
            Events.ACCOUNT_TYPE,
            Events.EVENT_END_TIMEZONE,
            Events.SELF_ATTENDEE_STATUS,
            Events.EXDATE,
            Events.HAS_EXTENDED_PROPERTIES,
            Events.EVENT_COLOR_KEY,
            Events.ORGANIZER,
            Events.CALENDAR_COLOR_KEY,
            Events.EVENT_COLOR,
            Events.AVAILABILITY,
            Events.DTSTART,
            Events.OWNER_ACCOUNT,
            Events.LAST_SYNCED,
            Events.DURATION,
            Events.ACCESS_LEVEL,
            Events.MAX_REMINDERS,
            Events.DISPLAY_COLOR,
            Events.ALL_DAY,
            Events.STATUS,
            Events.DTEND,
            Events.ORIGINAL_ID,
            Events._ID,
            Events.GUESTS_CAN_MODIFY,
            Events.CUSTOM_APP_URI,
            Events.CALENDAR_ACCESS_LEVEL,
            Events.CALENDAR_DISPLAY_NAME,
            Events.GUESTS_CAN_INVITE_OTHERS,
            Events.ORIGINAL_SYNC_ID,
            Events.CAN_MODIFY_TIME_ZONE,
            Events.VISIBLE,
            Events.ALLOWED_ATTENDEE_TYPES,
            Events.ALLOWED_AVAILABILITY,
            Events.DESCRIPTION,
            Events.TITLE,
            Events.CALENDAR_ID,
            Events.DELETED,
            Events.EVENT_LOCATION,
            Events.ACCOUNT_NAME,
            Events.HAS_ALARM,
            Events.IS_ORGANIZER

    };
    //The indices for the event projection array above.
    public static final int PROJECTION_RRULE_INDEX = 0;
    public static final int PROJECTION_EVENT_TIMEZONE_INDEX = 1;
    public static final int PROJECTION_HAS_ATTENDEE_DATA_INDEX = 2;
    public static final int PROJECTION_SYNC_ID_INDEX = 3;
    public static final int PROJECTION_CUSTOM_APP_PACKAGE_INDEX = 4;
    public static final int PROJECTION_INSTANCE_TIME_INDEX = 5;
    public static final int PROJECTION_ALLOWED_REMINDERS_INDEX = 6;
    public static final int PROJECTION_UID_2445_INDEX = 7;
    public static final int PROJECTION_CALENDAR_TIME_ZONE_INDEX = 8;
    public static final int PROJECTION_DIRTY_INDEX = 9;
    public static final int PROJECTION_ORIGINAL_ALL_DAY_INDEX = 10;
    public static final int PROJECTION_EXRULE_INDEX = 11;
    public static final int PROJECTION_CALENDAR_COLOR_INDEX = 12;
    public static final int PROJECTION_LAST_DATE_INDEX = 13;
    public static final int PROJECTION_CAN_ORGANIZER_RESPOND_INDEX = 14;
    public static final int PROJECTION_GUESTS_CAN_SEE_GUESTS_INDEX = 15;
    public static final int PROJECTION_RDATE_INDEX = 16;
    public static final int PROJECTION_ACCOUNT_TYPE_INDEX = 17;
    public static final int PROJECTION_EVENT_END_TIMEZONE_INDEX = 18;
    public static final int PROJECTION_SELF_ATTENDEE_STATUS_INDEX = 19;
    public static final int PROJECTION_EXDATE_INDEX = 20;
    public static final int PROJECTION_HAS_EXTENDED_PROPERTIES_INDEX = 21;
    public static final int PROJECTION_EVENT_COLOR_KEY_INDEX = 22;
    public static final int PROJECTION_ORGANIZER_INDEX = 23;
    public static final int PROJECTION_CALENDAR_COLOR_KEY_INDEX = 24;
    public static final int PROJECTION_EVENT_COLOR_INDEX = 25;
    public static final int PROJECTION_AVAILABILITY_INDEX = 26;
    public static final int PROJECTION_DTSTART_INDEX = 27;
    public static final int PROJECTION_EVENT_OWNER_ACCOUNT_INDEX = 28;
    public static final int PROJECTION_LAST_SYNCED_INDEX = 29;
    public static final int PROJECTION_DURATION_INDEX = 30;
    public static final int PROJECTION_ACCESS_LEVEL_INDEX = 31;
    public static final int PROJECTION_EVENT_MAX_REMINDERS_INDEX = 32;
    public static final int PROJECTION_DISPLAY_COLOR_INDEX = 33;
    public static final int PROJECTION_ALL_DAY_INDEX = 34;
    public static final int PROJECTION_STATUS_INDEX = 35;
    public static final int PROJECTION_DTEND_INDEX = 36;
    public static final int PROJECTION_ORIGINAL_ID_INDEX = 37;
    public static final int PROJECTION_ID_INDEX = 38;
    public static final int PROJECTION_GUESTS_CAN_MODIFY_INDEX = 39;
    public static final int PROJECTION_CUSTOM_APP_URI_INDEX = 40;
    public static final int PROJECTION_CALENDAR_ACCESS_LEVEL_INDEX = 41;
    public static final int PROJECTION_CALENDAR_DISPLAY_NAME_INDEX = 42;
    public static final int PROJECTION_GUESTS_CAN_INVITE_OTHERS_INDEX = 43;
    public static final int PROJECTION_ORIGINAL_SYNC_ID_INDEX = 44;
    public static final int PROJECTION_CAN_MODIFY_TIME_ZONE_INDEX = 45;
    public static final int PROJECTION_VISIBLE_INDEX = 46;
    public static final int PROJECTION_ALLOWED_ATTENDEE_TYPES_INDEX = 47;
    public static final int PROJECTION_ALLOWED_AVAILABILITY_INDEX = 48;
    public static final int PROJECTION_DESCRIPTION_INDEX = 49;
    public static final int PROJECTION_TITLE_INDEX = 50;
    public static final int PROJECTION_CALENDAR_ID_INDEX = 51;
    public static final int PROJECTION_DELETED_INDEX = 52;
    public static final int PROJECTION_EVENT_LOCATION_INDEX = 53;
    public static final int PROJECTION_ACCOUNT_NAME_INDEX = 54;
    public static final int PROJECTION_HAS_ALARM_INDEX = 55;
    public static final int PROJECTION_IS_ORGANIZER_INDEX = 56;


    //The permission constants.
    public static final int MY_PERMISSIONS_REQUEST_READ_CALENDAR = 1;
    public static final Uri calendarURI = Calendars.CONTENT_URI;
    public static final Uri EVENT_URI = Events.CONTENT_URI;
}
