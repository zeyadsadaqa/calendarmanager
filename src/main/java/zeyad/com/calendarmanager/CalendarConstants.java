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
            Calendars._ID,                           // 0
            Calendars.ACCOUNT_NAME,                  // 1
            Calendars.CALENDAR_DISPLAY_NAME,         // 2
            Calendars.OWNER_ACCOUNT,                  // 3
            Calendars.ACCOUNT_TYPE
    };

    public static final String [] EVENT_PROJECTION = new String[]{
          Events._ID,
          Events.TITLE,
          Events.DTSTART,
          Events.DTEND
    };

    // The indices for the calendar projection array above.
    public static final int PROJECTION_ID_INDEX = 0;
    public static final int PROJECTION_ACCOUNT_NAME_INDEX = 1;
    public static final int PROJECTION_DISPLAY_NAME_INDEX = 2;
    public static final int PROJECTION_OWNER_ACCOUNT_INDEX = 3;
    public static final int PROJECTION_OWNER_ACCOUNT_TYPE = 4;

    //The indices for the event projection array above.
    public static final int PROJECTION_EVENT_ID_INDEX = 0;
    public static final int PROJECTION_EVENT_TITLE_INDEX = 1;
    public static final int PROJECTION_EVENT_START_DATE_INDEX = 2;
    public static final int PROJECTION_EVENT_END_DATE_INDEX = 3;

    //The permission constants.
    public static final int MY_PERMISSIONS_REQUEST_READ_CALENDAR = 1;
    public static final Uri calendarURI = Calendars.CONTENT_URI;
    public static final Uri EVENT_URI = Events.CONTENT_URI;
}
