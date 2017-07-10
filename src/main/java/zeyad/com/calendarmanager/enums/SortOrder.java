package zeyad.com.calendarmanager.enums;

/**
 * Created by Zeyad Assem on 6/7/2017.
 */

public enum SortOrder {
    ASC("ASC"),
    DESC("DESC");

    private String value;
    public String getValue(){
        return value;
    }
    private SortOrder(String value){
        this.value = value;
    }
}
