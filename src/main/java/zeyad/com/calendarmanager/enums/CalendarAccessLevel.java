package zeyad.com.calendarmanager.enums;

import android.provider.CalendarContract.Calendars;

/**
 * Created by Zeyad Assem on 5/7/2017.
 */

public enum CalendarAccessLevel {
    NONE(Calendars.CAL_ACCESS_NONE), /** Cannot access the calendar */
    FREEBUSY(Calendars.CAL_ACCESS_FREEBUSY), /** Can only see free/busy information about the calendar */
    READ(Calendars.CAL_ACCESS_READ), /** Can read all event details */
    RESPOND(Calendars.CAL_ACCESS_RESPOND), /** Can reply yes/no/maybe to an event */
    OVERRIDE(Calendars.CAL_ACCESS_OVERRIDE),  /** not used */
    CONTRIBUTOR(Calendars.CAL_ACCESS_CONTRIBUTOR), /** Full access to modify the calendar, but not the access control settings*/
    EDITOR(Calendars.CAL_ACCESS_EDITOR), /** Full access to modify the calendar, but not the access control settings */
    OWNER(Calendars.CAL_ACCESS_OWNER),  /** Full access to the calendar */
    ROOT (Calendars.CAL_ACCESS_ROOT);/** Domain admin */

    private Integer value;
    public Integer getValue() {
        return value;
    }
    private CalendarAccessLevel(Integer value) {
        this.value = value;
    }
}
