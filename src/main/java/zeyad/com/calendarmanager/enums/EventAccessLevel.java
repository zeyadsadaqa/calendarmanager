package zeyad.com.calendarmanager.enums;

import android.provider.CalendarContract;

/**
 * Created by Zeyad Assem on 6/7/2017.
 */

public enum EventAccessLevel {
    ACCESS_PUPLIC(3),
    ACCESS_PRIVATE(2),
    ACCESS_CONFIDENTIAL(1),
    ACCESS_DEFAULT(0);



    private Integer value;
    public Integer getValue() {
        return value;
    }
    private EventAccessLevel(Integer value) {
        this.value = value;
    }
}
