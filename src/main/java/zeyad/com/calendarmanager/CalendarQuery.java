package zeyad.com.calendarmanager;

import android.net.Uri;
import android.provider.CalendarContract.Calendars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import zeyad.com.calendarmanager.enums.CalendarAccessLevel;
import zeyad.com.calendarmanager.enums.SortOrder;

/**
 * @author Zeyad Assem
 * Created by Zeyad Assem on 5/7/2017.
 * This class design to build the query paramaters for calendars
 */

public class CalendarQuery {
    private Uri calendarUri;
    private String [] calendarProjection;
    private String calendarSelection;
    private static String [] calendarSelectionArguments;
    private String calendarSortOrder;

    public Uri getCalendarUri() {
        return calendarUri;
    }

    public String[] getCalendarProjection() {
        return calendarProjection;
    }

    public String getCalendarSelection() {
        return calendarSelection;
    }

    public String[] getCalendarSelectionArguments() {
        return calendarSelectionArguments;
    }

    public String getCalendarSortOrder() {
        return calendarSortOrder;
    }

    private CalendarQuery(CalendarQueryBuilder calendarQueryBuilder){
        this.calendarUri =  Calendars.CONTENT_URI;
        this.calendarProjection = CalendarConstants.CALENDAR_PROJECTION;
        this.calendarSelection = calendarQueryBuilder.calendarSelection;
        if(calendarQueryBuilder.calendarSortOrder != null){
            this.calendarSortOrder = calendarQueryBuilder.calendarSortOrder.getValue();
        }
        this.calendarSelectionArguments = calendarQueryBuilder.calendarSelectionArguments;


    }

    public static class CalendarQueryBuilder{
        private String calendarSelection = null;
        private String [] calendarSelectionArguments = null;
        private SortOrder calendarSortOrder = null;


        HashMap<String, String> argumentsWithValues;

        public CalendarQueryBuilder(){
            argumentsWithValues = new HashMap<>();
        }

        public CalendarQueryBuilder withSyncEvent(boolean hasSyncEvents){
            if(hasSyncEvents){
                argumentsWithValues.put(Calendars.SYNC_EVENTS, "1");
            }else {
                argumentsWithValues.put(Calendars.SYNC_EVENTS,"0");
            }
            return this;
        }

        public CalendarQueryBuilder withOwnerAccount(String ownerAccount){
            argumentsWithValues.put(Calendars.OWNER_ACCOUNT, ownerAccount);
            return this;
        }

        public CalendarQueryBuilder withMaxReminders(int maxRemindersNumber){
            argumentsWithValues.put(Calendars.MAX_REMINDERS, Integer.toString(maxRemindersNumber));
            return this;
        }

        public CalendarQueryBuilder withCanPartially_update(boolean canPartially_update){
            if(canPartially_update){
                argumentsWithValues.put(Calendars.CAN_PARTIALLY_UPDATE, "1");
            }else {
                argumentsWithValues.put(Calendars.CAN_PARTIALLY_UPDATE,"0");
            }
            return this;
        }

        public CalendarQueryBuilder withSyncId(int syncId ){
            argumentsWithValues.put(Calendars._SYNC_ID, Integer.toString(syncId));
            return this;
        }

        public CalendarQueryBuilder withId(int id){
            argumentsWithValues.put(Calendars._ID, Integer.toString(id));
            return this;
        }

        public CalendarQueryBuilder withAllowedReminders(String allowedReminders){
            argumentsWithValues.put(Calendars.ALLOWED_REMINDERS, allowedReminders);
            return this;
        }

        public CalendarQueryBuilder withTimezone(String timezone){
            argumentsWithValues.put(Calendars.CALENDAR_TIME_ZONE, timezone);
            return this;
        }


        public CalendarQueryBuilder withCalendarAccessLevel(CalendarAccessLevel calendarAccessLevel){
            argumentsWithValues.put(Calendars.CALENDAR_ACCESS_LEVEL, Integer.toString(calendarAccessLevel.getValue()));
            return this;
        }

        public CalendarQueryBuilder withCalendarDisplayName(String displayName){
            argumentsWithValues.put(Calendars.CALENDAR_DISPLAY_NAME, displayName);
            return this;
        }

        public CalendarQueryBuilder withDirty(long dirty){
            argumentsWithValues.put(Calendars.DIRTY, Long.toString(dirty));
            return this;
        }

        public CalendarQueryBuilder withColor(int color){
            argumentsWithValues.put(Calendars.CALENDAR_COLOR, Integer.toString(color));
            return this;
        }

        /*
        * Can the organizer respond to the event? If no,
        * the status of the organizer should not be shown by the UI. Defaults to 1. Column name.
        */
        public CalendarQueryBuilder withCanOrganizerRespond(boolean canOrganizerRespond){
            if(canOrganizerRespond){
                argumentsWithValues.put(Calendars.CAN_ORGANIZER_RESPOND, "1");
            }else {
                argumentsWithValues.put(Calendars.CAN_ORGANIZER_RESPOND, "0");
            }
            return this;
        }

        /*
        * Is the calendar selected to be displayed?
        * 0 - do not show events associated with this calendar.
         * 1 - show events associated with this calendar
        * */
        public CalendarQueryBuilder withVisible(boolean visible){
            if(visible){
                argumentsWithValues.put(Calendars.VISIBLE, "1");
            }else{
                argumentsWithValues.put(Calendars.VISIBLE, "0");
            }
            return this;
        }

        /*
        * Can the organizer modify the time zone of the event? Column name.
        * */
        public CalendarQueryBuilder withCanModifyTimezone(boolean canModifyTimezone){
            if(canModifyTimezone){
                argumentsWithValues.put(Calendars.CAN_MODIFY_TIME_ZONE, "1");
            }else{
                argumentsWithValues.put(Calendars.CAN_MODIFY_TIME_ZONE, "0");
            }
            return this;
        }

        public CalendarQueryBuilder withAccountType(String accountType){
            argumentsWithValues.put(Calendars.ACCOUNT_TYPE, accountType);
            return this;
        }

        /*
        *A comma separated list of attendee types supported for this calendar in the format "#,#,#".
        * Valid types are TYPE_NONE, TYPE_OPTIONAL, TYPE_REQUIRED, TYPE_RESOURCE.
        * Setting this field to only TYPE_NONE should be used to indicate that changing the attendee type is not supported.
        * */
        public CalendarQueryBuilder withAllowedAttendeesTypes(String allowedAttendeesTypes){
            argumentsWithValues.put(Calendars.ALLOWED_ATTENDEE_TYPES, allowedAttendeesTypes);
            return this;
        }

         /*
          *A comma separated list of availability types supported for this calendar in the format "#,#,#".
          * Valid types are AVAILABILITY_BUSY, AVAILABILITY_FREE, AVAILABILITY_TENTATIVE.
          * Setting this field to only AVAILABILITY_BUSY should be used to indicate that changing the availability is not supported.
          * */
        public CalendarQueryBuilder withAllowedAvailability(String availability){
            argumentsWithValues.put(Calendars.ALLOWED_AVAILABILITY, availability);
            return this;
        }

        public CalendarQueryBuilder withName(String name){
            argumentsWithValues.put(Calendars.NAME, name);
            return this;
        }

        /*
        * Whether the row has been deleted but not synced to the server. A deleted row should be ignored.
        * */
        public CalendarQueryBuilder withDeleted(boolean deleted){
            if (deleted){
                argumentsWithValues.put(Calendars.DELETED, "1");
            }else{
                argumentsWithValues.put(Calendars.DELETED, "0");
            }
            return this;
        }

        public CalendarQueryBuilder withAccountName(String accountName){
            argumentsWithValues.put(Calendars.ACCOUNT_NAME, accountName);
            return this;
        }

        public CalendarQueryBuilder withSortOrder(SortOrder calendarSortOrder){
            this.calendarSortOrder = calendarSortOrder;
            return this;
        }

        public CalendarQuery build(){
            List<String> values = new ArrayList<>();
            int count = 0;
            if(argumentsWithValues.size() >0){
                calendarSelection = "(";
                Iterator iterator = argumentsWithValues.entrySet().iterator();
                while (iterator.hasNext()){
                    HashMap.Entry entry = (HashMap.Entry) iterator.next();
                    if(count>0){
                        calendarSelection += (" AND ("+entry.getKey()+" =?)");
                    }else{
                        calendarSelection += ("("+entry.getKey()+" =?)");
                    }
                    values.add((String) entry.getValue());
                    count++;
                }
                calendarSelection += ")";
                this.calendarSelectionArguments = new String[values.size()];
                calendarSelectionArguments = values.toArray(calendarSelectionArguments);
            }
            return new CalendarQuery(this);
        }

    }

}
