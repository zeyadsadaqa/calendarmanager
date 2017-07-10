package zeyad.com.calendarmanager.enums;

/**
 * Created by Zeyad Assem on 6/7/2017.
 */

public enum EventStatus {
    STATUS_CANCELED(2),
    STATUS_CONFIRMED(1),
    STATUS_TENTATIVE(0);


    private Integer value;
    public Integer getValue() {
        return value;
    }
    private EventStatus(Integer value) {
        this.value = value;
    }
}
