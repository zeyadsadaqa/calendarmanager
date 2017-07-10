package zeyad.com.calendarmanager.models;

import zeyad.com.calendarmanager.enums.Availability;
import zeyad.com.calendarmanager.enums.CalendarAccessLevel;
import zeyad.com.calendarmanager.enums.EventAccessLevel;
import zeyad.com.calendarmanager.enums.EventStatus;

/**
 * Created by Zeyad Assem on 4/7/2017.
 */

public class EventModel {

    //The recurrence rule for the event.
    private String RRule;

    private String eventTimeZone;

    //Whether the event has attendee information.
    // True if the event has full attendee data,
    // false if the event has information about self only
    private Boolean hasAttendeeData;

    //The unique ID for a row assigned by the sync source.
    // NULL if the row has never been synced.
    // This is used as a reference id for exceptions along with _ID.
    private String syncId;

    //The package name of the custom app that can provide a richer experience for the event.
    // Use the ACTION TYPE ACTION_HANDLE_CUSTOM_EVENT
    private String customAppPackage;

    //The original instance time of the recurring event for which this event is an exception
    private Long originalInstanceTime;

    //A comma separated list of reminder methods supported for this calendar in the format "#,#,#".
    // Valid types are METHOD_DEFAULT, METHOD_ALERT, METHOD_EMAIL, METHOD_SMS, METHOD_ALARM
    private String allowedReminders;

    //The UID for events added from the RFC 2445 iCalendar format
    private String uid2445;

    private String calendarTimezone;

    //Used to indicate that local, unsynced, changes are present.
    private Long dirty;

    //The allDay status (true or false) of the original recurring event for which this event is an exception.
    private Boolean originalAllDay;

    //The recurrence exception rule for the event
    private String exrule;

    private Integer calendarColor;

    //The last date this event repeats on, or NULL if it never ends.
    private Long lastDate;

    //Can the organizer respond to the event? If no, the status of the organizer should not be shown by the UI
    private Boolean canOrganizerRespond;

    private Boolean guestsCanSeeGuests;

    //The recurrence dates for the event.
    private String rDate;

    private String accountType;

    private String eventEndTimezone;

    //This is a copy of the attendee status for the owner of this event.
    // This field is copied here so that we can efficiently filter out events that are declined without having to look in the Attendees table.
    private Integer selfAttendeeStatus;

//    //Used in conjunction with DIRTY to indicate what packages wrote local changes.
//    private String mutators;

    //The recurrence exception dates for the event
    private String exDate;

    private Boolean hasExtendedProperties;

    //A secondary color key for the individual event.
    // NULL or an empty string are reserved for indicating that the event does not use a key for looking up the color.
    // The provider will update EVENT_COLOR automatically when a valid key is written to this column.
    // The key must reference an existing row of the CalendarContract.Colors table.
    private String eventColorKey;

    //Email of the organizer (owner) of the event
    private String organizer;

    private String calendarColorIndex;

    //A secondary color for the individual event
    private Integer eventColor;

    //If this event counts as busy time or is still free time that can be scheduled over.
    //the value is (One of AVAILABILITY_BUSY, AVAILABILITY_FREE, AVAILABILITY_TENTATIVE)
    private Availability availability;

    //The time the event starts in UTC millis since epoch
    private Long startDate;

    private String ownerAccount;

    private Boolean lastSynced;

    //The duration of the event in RFC2445 format.
    private String duration;

    //Defines how the event shows up for others when the calendar is shared
    private EventAccessLevel accessLevel;

    //The maximum number of reminders allowed for an event.
    private Integer maxReminders;

    //This will be EVENT_COLOR if it is not null; otherwise, this will be CALENDAR_COLOR. Read-only value.
    // To modify, write to EVENT_COLOR or CALENDAR_COLOR directly.
    private Integer displayColor;

    //Is the event all day (time zone independent)
    private Boolean allDay;

    //The event status.
    private EventStatus eventStatus;

    //the time the event ends in UTC millis since epoch.
    private Long endDate;

    //The _ID of the original recurring event for which this event is an exception.
    private String originalId;

    private Integer id;

    //Whether guests can modify the event.
    private Boolean guestsCanModify;

    //The URI used by the custom app for the event.
    private String customAppUri;

    //The level of access that the user has for the calendar
    private CalendarAccessLevel calendarAccessLevel;

    //The display name of the calendar.
    private String calendarDisplayName;

    //Whether guests can invite other guests.
    private Boolean guestsCanInviteOthers;

    //The _sync_id of the original recurring event for which this event is an exception.
    // The provider should keep the original_id in sync when this is updated.
    private String originalSyncId;

    //Can the organizer modify the time zone of the event?
    private Boolean canModifyTimeZone;

    //Is the calendar selected to be displayed? 0 - do not show events associated with this calendar.
    // 1 - show events associated with this calendar
    private Boolean visible;

    // comma separated list of attendee types supported for this calendar in the format "#,#,#".
    // Valid types are TYPE_NONE, TYPE_OPTIONAL, TYPE_REQUIRED, TYPE_RESOURCE.
    // Setting this field to only TYPE_NONE should be used to indicate that changing the attendee type is not supported.
    private String allowedAttendeeTypes;

    //A comma separated list of availability types supported for this calendar in the format "#,#,#".
    // Valid types are AVAILABILITY_BUSY, AVAILABILITY_FREE, AVAILABILITY_TENTATIVE.
    // Setting this field to only AVAILABILITY_BUSY should be used to indicate that changing the availability is not supported.
    private String allowedAvailability;

    //The description of the event.
    private String description;

    //The title of the event.
    private String title;

    //The _ID of the calendar the event belongs to.
    private Integer calendarId;

    //Whether the row has been deleted but not synced to the server. A deleted row should be ignored.
    private Boolean deleted;

    //Where the event takes place.
    private String eventLocation;

    //The account that was used to sync the entry to the device.
    // If the account_type is not ACCOUNT_TYPE_LOCAL then the name and type must match an account on the device or the calendar will be deleted.
    private String accountName;

    //Whether the event has an alarm or not.
    private Boolean hasAlarm;

    //Are we the organizer of this event. If this column is not explicitly set, the provider will return 1 if ORGANIZER is equal to OWNER_ACCOUNT.
    private String isOrganizer;


    public String getRRule() {
        return RRule;
    }

    public void setRRule(String RRule) {
        this.RRule = RRule;
    }

    public String getEventTimeZone() {
        return eventTimeZone;
    }

    public void setEventTimeZone(String eventTimeZone) {
        this.eventTimeZone = eventTimeZone;
    }

    public Boolean getHasAttendeeData() {
        return hasAttendeeData;
    }

    public void setHasAttendeeData(Boolean hasAttendeeData) {
        this.hasAttendeeData = hasAttendeeData;
    }

    public String getSyncId() {
        return syncId;
    }

    public void setSyncId(String syncId) {
        this.syncId = syncId;
    }

    public String getCustomAppPackage() {
        return customAppPackage;
    }

    public void setCustomAppPackage(String customAppPackage) {
        this.customAppPackage = customAppPackage;
    }

    public Long getOriginalInstanceTime() {
        return originalInstanceTime;
    }

    public void setOriginalInstanceTime(Long originalInstanceTime) {
        this.originalInstanceTime = originalInstanceTime;
    }

    public String getAllowedReminders() {
        return allowedReminders;
    }

    public void setAllowedReminders(String allowedReminders) {
        this.allowedReminders = allowedReminders;
    }

    public String getUid2445() {
        return uid2445;
    }

    public void setUid2445(String uid2445) {
        this.uid2445 = uid2445;
    }

    public String getCalendarTimezone() {
        return calendarTimezone;
    }

    public void setCalendarTimezone(String calendarTimezone) {
        this.calendarTimezone = calendarTimezone;
    }

    public Long getDirty() {
        return dirty;
    }

    public void setDirty(Long dirty) {
        this.dirty = dirty;
    }

    public Boolean getOriginalAllDay() {
        return originalAllDay;
    }

    public void setOriginalAllDay(Boolean originalAllDay) {
        this.originalAllDay = originalAllDay;
    }

    public String getExrule() {
        return exrule;
    }

    public void setExrule(String exrule) {
        this.exrule = exrule;
    }

    public Integer getCalendarColor() {
        return calendarColor;
    }

    public void setCalendarColor(Integer calendarColor) {
        this.calendarColor = calendarColor;
    }

    public Long getLastDate() {
        return lastDate;
    }

    public void setLastDate(Long lastDate) {
        this.lastDate = lastDate;
    }

    public Boolean getCanOrganizerRespond() {
        return canOrganizerRespond;
    }

    public void setCanOrganizerRespond(Boolean canOrganizerRespond) {
        this.canOrganizerRespond = canOrganizerRespond;
    }

    public Boolean getGuestsCanSeeGuests() {
        return guestsCanSeeGuests;
    }

    public void setGuestsCanSeeGuests(Boolean guestsCanSeeGuests) {
        this.guestsCanSeeGuests = guestsCanSeeGuests;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getEventEndTimezone() {
        return eventEndTimezone;
    }

    public void setEventEndTimezone(String eventEndTimezone) {
        this.eventEndTimezone = eventEndTimezone;
    }

    public Integer getSelfAttendeeStatus() {
        return selfAttendeeStatus;
    }

    public void setSelfAttendeeStatus(Integer selfAttendeeStatus) {
        this.selfAttendeeStatus = selfAttendeeStatus;
    }

//    public String           getMutators() {
//        return mutators;
//    }public void             setMutators(String mutators) {
//        this.mutators = mutators;
//    }

    public String getExDate() {
        return exDate;
    }

    public void setExDate(String exDate) {
        this.exDate = exDate;
    }

    public Boolean getHasExtendedProperties() {
        return hasExtendedProperties;
    }

    public void setHasExtendedProperties(Boolean hasExtendedProperties) {
        this.hasExtendedProperties = hasExtendedProperties;
    }

    public String getEventColorKey() {
        return eventColorKey;
    }

    public void setEventColorKey(String eventColorKey) {
        this.eventColorKey = eventColorKey;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getCalendarColorIndex() {
        return calendarColorIndex;
    }

    public void setCalendarColorIndex(String calendarColorIndex) {
        this.calendarColorIndex = calendarColorIndex;
    }

    public Integer getEventColor() {
        return eventColor;
    }

    public void setEventColor(Integer eventColor) {
        this.eventColor = eventColor;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public void setAvailability(Integer availability) {
        if(availability == Availability.AVAILABILITY_BUSY.getValue()){
            this.availability = Availability.AVAILABILITY_BUSY;
        }else if(availability == Availability.AVAILABILITY_FREE.getValue()){
            this.availability = Availability.AVAILABILITY_FREE;
        }else if(availability == Availability.AVAILABILITY_TENTATIVE.getValue()){
            this.availability = Availability.AVAILABILITY_TENTATIVE;
        }
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public String getOwnerAccount() {
        return ownerAccount;
    }

    public void setOwnerAccount(String ownerAccount) {
        this.ownerAccount = ownerAccount;
    }

    public Boolean getLastSynced() {
        return lastSynced;
    }

    public void setLastSynced(Boolean lastSynced) {
        this.lastSynced = lastSynced;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public EventAccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(EventAccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setAccessLevel(Integer accessLevel) {
        if(accessLevel == EventAccessLevel.ACCESS_CONFIDENTIAL.getValue()){
            this.accessLevel = EventAccessLevel.ACCESS_CONFIDENTIAL;
        }else if(accessLevel == EventAccessLevel.ACCESS_DEFAULT.getValue()){
            this.accessLevel = EventAccessLevel.ACCESS_DEFAULT;
        }else if(accessLevel == EventAccessLevel.ACCESS_PRIVATE.getValue()){
            this.accessLevel = EventAccessLevel.ACCESS_PRIVATE;
        }else if(accessLevel == EventAccessLevel.ACCESS_PUPLIC.getValue()){
            this.accessLevel = EventAccessLevel.ACCESS_PUPLIC;
        }
    }

    public Integer getMaxReminders() {
        return maxReminders;
    }

    public void setMaxReminders(Integer maxReminders) {
        this.maxReminders = maxReminders;
    }

    public Integer getDisplayColor() {
        return displayColor;
    }

    public void setDisplayColor(Integer displayColor) {
        this.displayColor = displayColor;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

    public void setEventStatus(Integer eventStatus) {
        if(eventStatus == EventStatus.STATUS_CANCELED.getValue()){
            this.eventStatus = EventStatus.STATUS_CANCELED;
        }else if(eventStatus == EventStatus.STATUS_CONFIRMED.getValue()){
            this.eventStatus = EventStatus.STATUS_CONFIRMED;
        }else if(eventStatus == EventStatus.STATUS_TENTATIVE.getValue()){
            this.eventStatus = EventStatus.STATUS_TENTATIVE;
        }
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getGuestsCanModify() {
        return guestsCanModify;
    }

    public void setGuestsCanModify(Boolean guestsCanModify) {
        this.guestsCanModify = guestsCanModify;
    }

    public String getCustomAppUri() {
        return customAppUri;
    }

    public void setCustomAppUri(String customAppUri) {
        this.customAppUri = customAppUri;
    }

    public CalendarAccessLevel getCalendarAccessLevel() {
        return calendarAccessLevel;
    }

    public void setCalendarAccessLevel(CalendarAccessLevel calendarAccessLevel) {
        this.calendarAccessLevel = calendarAccessLevel;
    }

    public void setCalendarAccessLevel(Integer calendarAccessLevel) {
        if(calendarAccessLevel == CalendarAccessLevel.CONTRIBUTOR.getValue()){
            this.calendarAccessLevel = CalendarAccessLevel.CONTRIBUTOR;
        }else if(calendarAccessLevel == CalendarAccessLevel.EDITOR.getValue()){
            this.calendarAccessLevel = CalendarAccessLevel.EDITOR;
        }else if(calendarAccessLevel == CalendarAccessLevel.FREEBUSY.getValue()){
            this.calendarAccessLevel = CalendarAccessLevel.FREEBUSY;
        }else if(calendarAccessLevel == CalendarAccessLevel.NONE.getValue()){
            this.calendarAccessLevel = CalendarAccessLevel.NONE;
        }else if(calendarAccessLevel == CalendarAccessLevel.OVERRIDE.getValue()){
            this.calendarAccessLevel = CalendarAccessLevel.OVERRIDE;
        }else if(calendarAccessLevel == CalendarAccessLevel.OWNER.getValue()){
            this.calendarAccessLevel = CalendarAccessLevel.OWNER;
        }else if(calendarAccessLevel == CalendarAccessLevel.READ.getValue()){
            this.calendarAccessLevel = CalendarAccessLevel.READ;
        }else if(calendarAccessLevel == CalendarAccessLevel.RESPOND.getValue()){
            this.calendarAccessLevel = CalendarAccessLevel.RESPOND;
        }else if(calendarAccessLevel == CalendarAccessLevel.ROOT.getValue()){
            this.calendarAccessLevel = CalendarAccessLevel.ROOT;
        }
    }

    public String getCalendarDisplayName() {
        return calendarDisplayName;
    }

    public void setCalendarDisplayName(String calendarDisplayName) {
        this.calendarDisplayName = calendarDisplayName;
    }

    public Boolean getGuestsCanInviteOthers() {
        return guestsCanInviteOthers;
    }

    public void setGuestsCanInviteOthers(Boolean guestsCanInviteOthers) {
        this.guestsCanInviteOthers = guestsCanInviteOthers;
    }

    public String getOriginalSyncId() {
        return originalSyncId;
    }

    public void setOriginalSyncId(String originalSyncId) {
        this.originalSyncId = originalSyncId;
    }

    public Boolean getCanModifyTimeZone() {
        return canModifyTimeZone;
    }

    public void setCanModifyTimeZone(Boolean canModifyTimeZone) {
        this.canModifyTimeZone = canModifyTimeZone;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getAllowedAttendeeTypes() {
        return allowedAttendeeTypes;
    }

    public void setAllowedAttendeeTypes(String allowedAttendeeTypes) {
        this.allowedAttendeeTypes = allowedAttendeeTypes;
    }

    public String getAllowedAvailability() {
        return allowedAvailability;
    }

    public void setAllowedAvailability(String allowedAvailability) {
        this.allowedAvailability = allowedAvailability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Integer calendarId) {
        this.calendarId = calendarId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Boolean getHasAlarm() {
        return hasAlarm;
    }

    public void setHasAlarm(Boolean hasAlarm) {
        this.hasAlarm = hasAlarm;
    }

    public String getIsOrganizer() {
        return isOrganizer;
    }

    public void setIsOrganizer(String isOrganizer) {
        this.isOrganizer = isOrganizer;
    }

    @Override
    public String toString() {

        String stringValue = "RRule: "+RRule+" \n"+
                "eventTimeZone: "+eventTimeZone+" \n"+
                "hasAttendeeData: "+hasAttendeeData+" \n"+
                "syncId: "+syncId+" \n"+
                "customAppPackage: "+customAppPackage+" \n"+
                "originalInstanceTime: "+originalInstanceTime+" \n"+
                "allowedReminders: "+allowedReminders+" \n"+
                "uid2445: "+uid2445+" \n"+
                "calendarTimezone: "+calendarTimezone+" \n"+
                "dirty: "+dirty+" \n"+
                "originalAllDay: "+originalAllDay+" \n"+
                "exrule: "+exrule+" \n"+
                "calendarColor: "+calendarColor+" \n"+
                "lastDate: "+lastDate+" \n"+
                "canOrganizerRespond: "+canOrganizerRespond+" \n"+
                "guestsCanSeeGuests: "+guestsCanSeeGuests+" \n"+
                "rDate: "+rDate+" \n"+
                "accountType: "+accountType+" \n"+
                "eventEndTimezone: "+eventEndTimezone+" \n"+
                "selfAttendeeStatus: "+selfAttendeeStatus+" \n"+
                "exDate: "+exDate+" \n"+
                "hasExtendedProperties: "+hasExtendedProperties+" \n"+
                "eventColorKey: "+eventColorKey+" \n"+
                "organizer: "+organizer+" \n"+
                "calendarColorIndex: "+calendarColorIndex+" \n"+
                "eventColor: "+eventColor+" \n"+
                "availability: "+availability+" \n"+
                "startDate: "+startDate+" \n"+
                "ownerAccount: "+ownerAccount+" \n"+
                "lastSynced: "+lastSynced+" \n"+
                "duration: "+duration+" \n"+
                "accessLevel: "+accessLevel+" \n"+
                "maxReminders: "+maxReminders+" \n"+
                "displayColor: "+displayColor+" \n"+
                "allDay: "+allDay+" \n"+
                "eventStatus: "+eventStatus+" \n"+
                "endDate: "+endDate+" \n"+
                "originalId: "+originalId+" \n"+
                "id: "+id+" \n"+
                "guestsCanModify: "+guestsCanModify+" \n"+
                "customAppUri: "+customAppUri+" \n"+
                "calendarAccessLevel: "+calendarAccessLevel+" \n"+
                "calendarDisplayName: "+calendarDisplayName+" \n"+
                "guestsCanInviteOthers: "+guestsCanInviteOthers+" \n"+
                "originalSyncId: "+originalSyncId+" \n"+
                "canModifyTimeZone: "+canModifyTimeZone+" \n"+
                "visible: "+visible+" \n"+
                "allowedAttendeeTypes: "+allowedAttendeeTypes+" \n"+
                "allowedAvailability: "+allowedAvailability+" \n"+
                "description: "+description+" \n"+
                "title: "+title+" \n"+
                "calendarId: "+calendarId+" \n"+
                "deleted: "+deleted+" \n"+
                "eventLocation: "+eventLocation+" \n"+
                "accountName: "+accountName+" \n"+
                "hasAlarm: "+hasAlarm+" \n"+
                "isOrganizer: "+isOrganizer+" \n";
        return stringValue;

}
}
