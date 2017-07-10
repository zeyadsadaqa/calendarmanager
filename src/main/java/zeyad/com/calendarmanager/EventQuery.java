package zeyad.com.calendarmanager;

import android.net.Uri;
import android.provider.CalendarContract.Events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import zeyad.com.calendarmanager.enums.Availability;
import zeyad.com.calendarmanager.enums.CalendarAccessLevel;
import zeyad.com.calendarmanager.enums.EventAccessLevel;
import zeyad.com.calendarmanager.enums.EventStatus;
import zeyad.com.calendarmanager.enums.SortOrder;

/**
 * @author Zeyad Assem
 * Created by Zeyad Assem on 5/7/2017.
 * This class enables you to create event query
 */

public class EventQuery {

    private Uri eventUri;
    private String [] EventProjection;
    private String eventSelection;
    private String [] eventSelectionArguments;
    private String sortOrder;

    private EventQuery(EventQueryBuilder eventQueryBuilder){
        this.eventUri =  Events.CONTENT_URI;
        this.EventProjection = CalendarConstants.EVENT_PROJECTION;
        this.eventSelection = eventQueryBuilder.eventSelection;
        if(eventQueryBuilder.sortOrder != null){
            this.sortOrder = eventQueryBuilder.sortOrder.getValue();
        }
        this.eventSelectionArguments = eventQueryBuilder.eventSelectionArguments;


    }

    public Uri getEventUri() {
        return eventUri;
    }

    public String[] getEventProjection() {
        return EventProjection;
    }

    public String getEventSelection() {
        return eventSelection;
    }

    public  String[] getEventSelectionArguments() {
        return eventSelectionArguments;
    }

    public String getEventSortOrder() {
        return sortOrder;
    }


    public static class EventQueryBuilder{
        private String eventSelection = null;
        private String [] eventSelectionArguments = null;
        private SortOrder sortOrder = null;

        private LinkedHashMap<String, String> argumentsWithValues;
        private ArrayList<String> operators;

        public EventQueryBuilder() {
            this.argumentsWithValues = new LinkedHashMap<>();
            this.operators = new ArrayList<>();
        }

        public EventQueryBuilder withHasAttendeeData(boolean hasAttendeeData){
            if(hasAttendeeData){
                argumentsWithValues.put(Events.HAS_ATTENDEE_DATA, "1");
            }else {
                argumentsWithValues.put(Events.HAS_ATTENDEE_DATA,"0");
            }
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withCustomAppPackage(String customAppPackage){
            argumentsWithValues.put(Events.CUSTOM_APP_PACKAGE, customAppPackage);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withOriginalInstanceTime(Long originalInstanceTime){
            argumentsWithValues.put(Events.ORIGINAL_INSTANCE_TIME, Long.toString(originalInstanceTime));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withAllowedReminders(String allowedReminders){
            argumentsWithValues.put(Events.ALLOWED_REMINDERS, allowedReminders);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withUid2445(String uid2445){
            argumentsWithValues.put(Events.UID_2445, uid2445);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withCalendarTimezone(String calendarTimezone){
            argumentsWithValues.put(Events.CALENDAR_TIME_ZONE, calendarTimezone);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withDirty(Long dirty){
            argumentsWithValues.put(Events.DIRTY, Long.toString(dirty));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withOriginalAllDay(boolean originalAllDay){
            if(originalAllDay){
                argumentsWithValues.put(Events.ORIGINAL_ALL_DAY, "1");
            }else {
                argumentsWithValues.put(Events.ORIGINAL_ALL_DAY,"0");
            }
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withExrule(String exrule){
            argumentsWithValues.put(Events.EXRULE, exrule);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withCalendar_color(int calendarColor){
            argumentsWithValues.put(Events.CALENDAR_COLOR, Integer.toString(calendarColor));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withLastDate(Long lastDate){
            argumentsWithValues.put(Events.LAST_DATE, Long.toString(lastDate));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withVanOrganizerRespond(boolean canOrganizerRespond){
            if(canOrganizerRespond){
                argumentsWithValues.put(Events.CAN_ORGANIZER_RESPOND, "1");
            }else {
                argumentsWithValues.put(Events.CAN_ORGANIZER_RESPOND,"0");
            }
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withGuestsCanSeeGuests(boolean guestsCanSeeGuests){
            if(guestsCanSeeGuests){
                argumentsWithValues.put(Events.GUESTS_CAN_SEE_GUESTS, "1");
            }else {
                argumentsWithValues.put(Events.GUESTS_CAN_SEE_GUESTS,"0");
            }
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withRDate(String rDate){
            argumentsWithValues.put(Events.RDATE, rDate);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withAccountType(String accountType){
            argumentsWithValues.put(Events.ACCOUNT_NAME, accountType);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withEventEndTimezone(String eventEndTimezone){
            argumentsWithValues.put(Events.EVENT_END_TIMEZONE, eventEndTimezone);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withSelfAttendeeStatus(Integer selfAttendeeStatus){
            argumentsWithValues.put(Events.SELF_ATTENDEE_STATUS, Integer.toString(selfAttendeeStatus));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withMutators(String mutators){
            argumentsWithValues.put(Events.MUTATORS, mutators);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withExDate(String exDate){
            argumentsWithValues.put(Events.EXDATE, exDate);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withHasExtendedProperties(boolean hasExtendedProperties){
            if(hasExtendedProperties){
                argumentsWithValues.put(Events.HAS_EXTENDED_PROPERTIES, "1");
            }else {
                argumentsWithValues.put(Events.HAS_EXTENDED_PROPERTIES,"0");
            }
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withEventColorKey(String eventColorKey){
            argumentsWithValues.put(Events.EVENT_COLOR_KEY, eventColorKey);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withOrganizer(String organizer){
            argumentsWithValues.put(Events.ORGANIZER, organizer);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withCalendarColorIndex(String calendarColorIndex){
            argumentsWithValues.put(Events.CALENDAR_COLOR_KEY, calendarColorIndex);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withEventColor(Integer eventColor){
            argumentsWithValues.put(Events.EVENT_COLOR, Integer.toString(eventColor));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withAvailability(Availability availability){
            argumentsWithValues.put(Events.AVAILABILITY, Integer.toString(availability.getValue()));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withStartDate(Long startDate){
            argumentsWithValues.put(Events.DTSTART, Long.toString(startDate));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withOwnerAccount(String ownerAccount){
            argumentsWithValues.put(Events.OWNER_ACCOUNT, ownerAccount);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder WithLastSynced(boolean lastSynced){
            if(lastSynced){
                argumentsWithValues.put(Events.LAST_SYNCED, "1");
            }else {
                argumentsWithValues.put(Events.LAST_SYNCED,"0");
            }
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withDuration(String duration){
            argumentsWithValues.put(Events.DURATION, duration);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withEventAccessLevel(EventAccessLevel eventAccessLevel){
            argumentsWithValues.put(Events.ACCESS_LEVEL, Integer.toString(eventAccessLevel.getValue()));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withMaxReminders(Integer maxReminders){
            argumentsWithValues.put(Events.ACCESS_LEVEL, Integer.toString(maxReminders));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withDisplayColor(Integer displayColor){
            argumentsWithValues.put(Events.DISPLAY_COLOR, Integer.toString(displayColor));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withAllDay(boolean allDay){
            if(allDay){
                argumentsWithValues.put(Events.ALL_DAY, "1");
            }else {
                argumentsWithValues.put(Events.ALL_DAY,"0");
            }
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withEventStatus(EventStatus eventStatus){
            argumentsWithValues.put(Events.STATUS, Integer.toString(eventStatus.getValue()));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withEndDate(Long endDate){
            argumentsWithValues.put(Events.DTEND, Long.toString(endDate));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withOriginalId(String originalId){
            argumentsWithValues.put(Events.ORIGINAL_ID, originalId);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withId(Integer id){
            argumentsWithValues.put(Events._ID, Integer.toString(id));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withCustomAppUri(String customAppUri){
            argumentsWithValues.put(Events.CUSTOM_APP_URI, customAppUri);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withCalendarAccessLevel(CalendarAccessLevel calendarAccessLevel){
            argumentsWithValues.put(Events.CALENDAR_ACCESS_LEVEL, Integer.toString(calendarAccessLevel.getValue()));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withCalendarDisplayName(String calendarDisplayName){
            argumentsWithValues.put(Events.CALENDAR_DISPLAY_NAME, calendarDisplayName);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withGuestsCanInviteOthers(Boolean guestsCanInviteOthers ){
            if(guestsCanInviteOthers){
                argumentsWithValues.put(Events.GUESTS_CAN_INVITE_OTHERS, "1");
            }else {
                argumentsWithValues.put(Events.GUESTS_CAN_INVITE_OTHERS,"0");
            }
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withOriginal_sync_id(String originalSyncId){
            argumentsWithValues.put(Events.ORIGINAL_SYNC_ID, originalSyncId);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withCanModifyTimeZone(boolean canModifyTimeZone){
            if(canModifyTimeZone){
                argumentsWithValues.put(Events.CAN_MODIFY_TIME_ZONE, "1");
            }else {
                argumentsWithValues.put(Events.CAN_MODIFY_TIME_ZONE,"0");
            }
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withVisible(boolean visible){
            if(visible){
                argumentsWithValues.put(Events.VISIBLE, "1");
            }else {
                argumentsWithValues.put(Events.VISIBLE,"0");
            }
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withAllowedAttendeeTypes(String allowedAttendeeTypes){
            argumentsWithValues.put(Events.ALLOWED_ATTENDEE_TYPES, allowedAttendeeTypes);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withAllowedAvailability(String allowedAvailability){
            argumentsWithValues.put(Events.ALLOWED_AVAILABILITY, allowedAvailability);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withDescription(String description){
            argumentsWithValues.put(Events.DESCRIPTION, description);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withTitle(String title){
            argumentsWithValues.put(Events.TITLE, title);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withCalendarId(Integer calendarId){
            argumentsWithValues.put(Events.CALENDAR_ID, Integer.toString(calendarId));
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withDeleted(boolean deleted){
            if(deleted){
                argumentsWithValues.put(Events.DELETED, "1");
            }else {
                argumentsWithValues.put(Events.DELETED,"0");
            }
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withEventLocation(String eventLocation){
            argumentsWithValues.put(Events.EVENT_LOCATION, eventLocation);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withAccountName(String accountName){
            argumentsWithValues.put(Events.ACCOUNT_NAME, accountName);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withHasAlarm(boolean hasAlarm){
            if(hasAlarm){
                argumentsWithValues.put(Events.HAS_ALARM, "1");
            }else {
                argumentsWithValues.put(Events.HAS_ALARM,"0");
            }
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder withIsOrganizer(String isOrganizer){
            argumentsWithValues.put(Events.IS_ORGANIZER, isOrganizer);
            operators.add(" = ");
            return this;
        }

        public EventQueryBuilder addSortOrder(SortOrder sortOrder){
            this.sortOrder = sortOrder;
            return this;
        }

        public EventQueryBuilder withStartDateGreaterThan(Long startDate){
            argumentsWithValues.put(Events.DTSTART, Long.toString(startDate));
            operators.add(" > ");
            return this;
        }

        public EventQueryBuilder withStartDateLessThan(Long startDate){
            argumentsWithValues.put(Events.DTSTART, Long.toString(startDate));
            operators.add(" < ");
            return this;
        }

        public EventQueryBuilder withEndDateLessThan(Long endDate){
            argumentsWithValues.put(Events.DTEND, Long.toString(endDate));
            operators.add(" < ");
            return this;
        }

        public EventQueryBuilder withEndDateGreaterThan(Long endDate){
            argumentsWithValues.put(Events.DTEND, Long.toString(endDate));
            operators.add(" > ");
            return this;
        }



        public EventQuery build(){
            List<String> values = new ArrayList<>();
            int count = 0;
            if(argumentsWithValues.size() >0){
                 this.eventSelection= "(";
                Iterator iterator = argumentsWithValues.entrySet().iterator();
                while (iterator.hasNext()){
                    HashMap.Entry entry = (HashMap.Entry) iterator.next();
                    if(count>0){
                        this.eventSelection += (" AND ("+entry.getKey()+" "+operators.get(count)+" ?)");
                    }else{
                        this.eventSelection += ("("+entry.getKey()+" "+operators.get(count)+"?)");
                    }
                    values.add((String) entry.getValue());
                    count++;
                }
                this.eventSelection += ")";
                eventSelectionArguments = new String[values.size()];
                eventSelectionArguments = values.toArray(eventSelectionArguments);
            }
            return new EventQuery(this);
        }

    }


}
