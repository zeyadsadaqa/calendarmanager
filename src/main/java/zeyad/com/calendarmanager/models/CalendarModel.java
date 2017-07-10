package zeyad.com.calendarmanager.models;

import android.database.Cursor;

/**
 * Created by Zeyad Assem on 6/7/2017.
 */

public class CalendarModel {

    private Integer syncEvents;
    private String ownerAccount;
    private Integer maxReminders;
    private Boolean canPartiallyUpdate;
    private Integer syncId;
    private Integer id;
    private String allowedReminders;
    private String calendarTimezone;
    private Integer calendarAccessLevel;
    private String displayName;
    private Long dirty;
    private Integer calendarColor;
    private Boolean canOrganizerRespond;
    private Boolean visible;
    private Boolean canModifyTimezone;
    private String accountType;
    private String allowedAttendees;
    private String calendarLocation;
    private String calendarColorKey;
    private String allowedAvailability;
    private String name;
    private Boolean deleted;
    private String accountName;

    public Integer getSyncEvents() {
        return syncEvents;
    }

    public void setSyncEvents(Integer syncEvents) {
        this.syncEvents = syncEvents;
    }

    public String getOwnerAccount() {
        return ownerAccount;
    }

    public void setOwnerAccount(String ownerAccount) {
        this.ownerAccount = ownerAccount;
    }

    public Integer getMaxReminders() {
        return maxReminders;
    }

    public void setMaxReminders(Integer maxReminders) {
        this.maxReminders = maxReminders;
    }

    public Boolean getCanPartiallyUpdate() {
        return canPartiallyUpdate;
    }

    public void setCanPartiallyUpdate(Boolean canPartiallyUpdate) {
        this.canPartiallyUpdate = canPartiallyUpdate;
    }

    public Integer getSyncId() {
        return syncId;
    }

    public void setSyncId(Integer syncId) {
        this.syncId = syncId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAllowedReminders() {
        return allowedReminders;
    }

    public void setAllowedReminders(String allowedReminders) {
        this.allowedReminders = allowedReminders;
    }

    public String getCalendarTimezone() {
        return calendarTimezone;
    }

    public void setCalendarTimezone(String calendarTimezone) {
        this.calendarTimezone = calendarTimezone;
    }

    public Integer getCalendarAccessLevel() {
        return calendarAccessLevel;
    }

    public void setCalendarAccessLevel(Integer calendarAccessLevel) {
        this.calendarAccessLevel = calendarAccessLevel;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getDirty() {
        return dirty;
    }

    public void setDirty(Long dirty) {
        this.dirty = dirty;
    }

    public Integer getCalendarColor() {
        return calendarColor;
    }

    public void setCalendarColor(Integer calendarColor) {
        this.calendarColor = calendarColor;
    }

    public Boolean getCanOrganizerRespond() {
        return canOrganizerRespond;
    }

    public void setCanOrganizerRespond(Boolean canOrganizerRespond) {
        this.canOrganizerRespond = canOrganizerRespond;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getCanModifyTimezone() {
        return canModifyTimezone;
    }

    public void setCanModifyTimezone(Boolean canModifyTimezone) {
        this.canModifyTimezone = canModifyTimezone;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAllowedAttendees() {
        return allowedAttendees;
    }

    public void setAllowedAttendees(String allowedAttendees) {
        this.allowedAttendees = allowedAttendees;
    }

    public String getCalendarLocation() {
        return calendarLocation;
    }

    public void setCalendarLocation(String calendarLocation) {
        this.calendarLocation = calendarLocation;
    }

    public String getCalendarColorKey() {
        return calendarColorKey;
    }

    public void setCalendarColorKey(String calendarColorKey) {
        this.calendarColorKey = calendarColorKey;
    }

    public String getAllowedAvailability() {
        return allowedAvailability;
    }

    public void setAllowedAvailability(String allowedAvailability) {
        this.allowedAvailability = allowedAvailability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        String modelStringRepresentation = "syncEvents: "+getSyncEvents()+"\n"
                +  "ownerAccount: "+ ownerAccount+ "\n"
                +  "maxReminders: "+ maxReminders+ "\n"
                +  "canPartiallyUpdate: "+ canPartiallyUpdate+ "\n"
                +  "syncId: "+ syncId+ "\n"
                +  "id: "+ id+ "\n"
                +  "allowedReminders: "+ allowedReminders+ "\n"
                +  "calendarTimezone: "+ calendarTimezone+ "\n"
                +  "calendarAccessLevel: "+ calendarAccessLevel+ "\n"
                +  "displayName: "+ displayName+ "\n"
                +  "dirty: "+ dirty+ "\n"
                +  "calendarColor: "+ calendarColor+ "\n"
                +  "dirty: "+ dirty+ "\n"
                +  "canOrganizerRespond: "+ canOrganizerRespond+ "\n"
                +  "visible: "+ visible+ "\n"
                +  "canModifyTimezone: "+ canModifyTimezone+ "\n"
                +  "accountType: "+ accountType+ "\n"
                +  "allowedAttendees: "+ allowedAttendees+ "\n"
                +  "calendarLocation: "+ calendarLocation+ "\n"
                +  "calendarColorKey: "+ calendarColorKey+ "\n"
                +  "allowedAvailability: "+ allowedAvailability+ "\n"
                +  "name: "+ name+ "\n"
                +  "deleted: "+ deleted+ "\n"
                +  "accountName: "+ accountName+ "\n";

        return modelStringRepresentation;
    }
}
