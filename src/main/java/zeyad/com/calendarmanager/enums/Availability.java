package zeyad.com.calendarmanager.enums;

import android.provider.CalendarContract.Events;

/**
 * Created by Zeyad Assem on 6/7/2017.
 */

public enum Availability {
    AVAILABILITY_BUSY(Events.AVAILABILITY_BUSY),
    AVAILABILITY_FREE(Events.AVAILABILITY_FREE),
    AVAILABILITY_TENTATIVE(Events.AVAILABILITY_TENTATIVE);


    private Integer value;
    public Integer getValue() {
        return value;
    }
    Availability(Integer value) {
        this.value = value;
    }
}
