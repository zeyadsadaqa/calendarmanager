package zeyad.com.calendarmanager;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;

/**
 * @author Zeyad Assem
 * Created by Zeyad Assem on 23/03/16.
 */
public class CalendarPermissionWrapper {

    /**
     * @param context
     * @return true if the application granted to access the calendar.
     * @return false if the application can't granted to access calendar.
     */
    public static boolean checkCalendarPermission(Context context) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }else{
            return true;
        }
    }

    /**
     * @param context
     * This method requested the calendar permission.
     * It used when the OS is higher than 23, because of the new permission model.
     */
    public static void requestCalendarPermission(final Context context){
        // Should we show an explanation?
        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_CONTACTS)) {
            Log.i("permission", "shouldShowRequestPermissionRationale");

            new Thread(new Runnable() {
                public void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Calendar permission is required to add the event in your calendar")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    directPermissionRequest(context);
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }).start();

        } else {
            directPermissionRequest(context);
        }
    }

    private static void directPermissionRequest(Context context){
        // No explanation needed, we can request the permission.
        ActivityCompat.requestPermissions((Activity) context,
                new String[]{Manifest.permission.READ_CALENDAR},
                CalendarConstants.MY_PERMISSIONS_REQUEST_READ_CALENDAR);

        // MY_PERMISSIONS_REQUEST_READ_CALENDAR is an
        // app-defined int constant. The callback method gets the
        // result of the request.
        //The callback method will be in the activity calling this method.
    }

//    public interface OnPostRequest{
//        void onPostRequest(int index);
//    }

}
