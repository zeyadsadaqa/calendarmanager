package zeyad.com.calendarmanager;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Calendars;
import android.util.Log;


/**
 * @author Zeyad Assem
 * Created by Zeyad Assem on 24/03/16.
 * This class alows you to create new Calendar.
 */
public class CalendarCreator {
    private Uri target;
    private ContentValues values;
    private Context context;

    //@ToDo check if the user enter wrong type
    public CalendarCreator(String accountName, String accountType, Context context){
        this.context = context;
        Uri target = Uri.parse(CalendarConstants.calendarURI.toString());
        values = new ContentValues();
        this.target = target.buildUpon().appendQueryParameter(CalendarContract.CALLER_IS_SYNCADAPTER, "true")
                .appendQueryParameter(Calendars.ACCOUNT_NAME, accountName)
                .appendQueryParameter(Calendars.ACCOUNT_TYPE, accountType).build();
        values.put(Calendars.ACCOUNT_NAME, accountName);
        values.put(Calendars.ACCOUNT_TYPE, accountType);

    }

    //the account type will be default local.
    public CalendarCreator(String accountName, Context context){
        this.context = context;
        values = new ContentValues();
        Uri target = Uri.parse(CalendarContract.Calendars.CONTENT_URI.toString());
        this.target = target.buildUpon().appendQueryParameter(CalendarContract.CALLER_IS_SYNCADAPTER, "true")
                .appendQueryParameter(Calendars.ACCOUNT_NAME, accountName)
                .appendQueryParameter(Calendars.ACCOUNT_TYPE, CalendarContract.ACCOUNT_TYPE_LOCAL).build();
        values.put(Calendars.ACCOUNT_NAME, accountName);
        values.put(Calendars.ACCOUNT_TYPE, CalendarContract.ACCOUNT_TYPE_LOCAL);
    }

    /**
     * @param displayName The display name of the calendar.
     * @reference http://developer.android.com/reference/android/graphics/Color.html#parseColor(java.lang.String)
     * @return the CalendarCreator object.
     */
    public CalendarCreator addDisplayName(String displayName){
        values.put(Calendars.CALENDAR_DISPLAY_NAME, displayName);
        values.put(Calendars.NAME, displayName);
        return this;
    }

    /**
     * @param color it should match android colorString Format.
     * @reference http://developer.android.com/reference/android/graphics/Color.html#parseColor(java.lang.String)
     * @return the CalendarCreator object.
     */
    public CalendarCreator addColor(String color){
        try{
            values.put(CalendarContract.Calendars.CALENDAR_COLOR, Color.parseColor(color));
        }catch (IllegalArgumentException e){
            Log.i("CalendarManager", "Illegal color format, it will work with the default color" );
            values.put(CalendarContract.Calendars.CALENDAR_COLOR, Color.parseColor("#CCEFFF"));
        }
        return this;
    }

    /**
     * @param calendarAccessLevel defined constant values in an enumeration.
     * @reference http://developer.android.com/reference/android/provider/CalendarContract.Calendars.html
     * @return the CalendarCreator object.
     */
    public CalendarCreator addCalendarAccessLevel(CalendarAccessLevel calendarAccessLevel){
        values.put(Calendars.CALENDAR_ACCESS_LEVEL, getAccessLevel(calendarAccessLevel));
        return this;
    }

    /**
     * @param ownerAccount The account that was used to sync the entry to the device.
     * If the account_type is not ACCOUNT_TYPE_LOCAL then the name and type must match an account on the device or the calendar will be deleted.
     * @reference http://developer.android.com/reference/android/provider/CalendarContract.Calendars.html
     * @return the CalendarCreator object.
     */
    public CalendarCreator addOwnerAccount(String ownerAccount){
        values.put(Calendars.OWNER_ACCOUNT, ownerAccount);
        return this;
    }

    /**
     * @param visibility  0 - do not show events associated with this calendar.
     *                    1 - show events associated with this calendar.
     *                    Any integer - will make it visible as a default option.
     * @reference http://developer.android.com/reference/android/provider/CalendarContract.Calendars.html
     * @return the CalendarCreator object.
     */
    public CalendarCreator setVisibility(int visibility){
        switch (visibility){
            case 0:
                values.put(Calendars.VISIBLE, 0);
                break;
            case 1:
            default:
                values.put(Calendars.VISIBLE, 1);
                break;
        }
        return this;
    }

    /**
     * @param sync  0 - Do not sync this calendar or store events for this calendar.
     *              1 - Sync down events for this calendar.
     *              Any integer - will make it sync as a default option.
     * @reference http://developer.android.com/reference/android/provider/CalendarContract.Calendars.html
     * @return the CalendarCreator object.
     */
    public CalendarCreator syncData(int sync){
        switch (sync){
            case 0:
                values.put(Calendars.SYNC_EVENTS, 0);
                break;
            case 1:
            default:
                values.put(Calendars.VISIBLE, 1);
                break;
        }
        return this;
    }

    /**
     * This method will create your calendar.
     */
    public void build(){
        if(CalendarPermissionWrapper.checkCalendarPermission(context)){
            context.getContentResolver().insert(target, values);
        }else{
            CalendarPermissionWrapper.requestCalendarPermission(context);
            Log.i("CalendarManager","try again");
        }

    }

    public enum CalendarAccessLevel {
        NONE, /** Cannot access the calendar */
        FREEBUSY, /** Can only see free/busy information about the calendar */
        READ, /** Can read all event details */
        RESPOND, /** Can reply yes/no/maybe to an event */
        OVERRIDE,  /** not used */
        CONTRIBUTOR, /** Full access to modify the calendar, but not the access control settings*/
        EDITOR, /** Full access to modify the calendar, but not the access control settings */
        OWNER,  /** Full access to the calendar */
        ROOT /** Domain admin */
    }

    private int getAccessLevel(CalendarAccessLevel calendarAccessLevel){
        int accessLevel = Calendars.CAL_ACCESS_READ;
        switch (calendarAccessLevel){
            case NONE:
                accessLevel = Calendars.CAL_ACCESS_NONE;
                break;
            case FREEBUSY:
                accessLevel =  Calendars.CAL_ACCESS_FREEBUSY;
                break;
            case READ:
                accessLevel =  Calendars.CAL_ACCESS_READ;
                break;
            case RESPOND:
                accessLevel =  Calendars.CAL_ACCESS_RESPOND;
                break;
            case OVERRIDE:
                accessLevel =  Calendars.CAL_ACCESS_OVERRIDE;
                break;
            case CONTRIBUTOR:
                accessLevel =  Calendars.CAL_ACCESS_CONTRIBUTOR;
                break;
            case EDITOR:
                accessLevel = Calendars.CAL_ACCESS_EDITOR;
                break;
            case OWNER:
                accessLevel =  Calendars.CAL_ACCESS_OWNER;
                break;
            case ROOT:
                accessLevel =  Calendars.CAL_ACCESS_ROOT;
                break;
        }
        return accessLevel;
    }
}
