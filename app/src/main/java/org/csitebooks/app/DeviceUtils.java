package org.csitebooks.app;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * Created by abc on 02-12-2015.
 */
public class DeviceUtils {


    /**
     * method is used for hiding keyboard.
     *
     * @param activity context
     */
    public static void hideKeyboard(Activity activity) {
        View v = activity.getWindow().getCurrentFocus();
        if (v != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }


    /**
     * method is used for checking internet connection.
     *
     * @param context Context
     * @return boolean true for internet available false for not
     */
    public static boolean checkNetworkState(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean result = (connectivityManager.getActiveNetworkInfo() != null && connectivityManager
                .getActiveNetworkInfo().isConnected());

        return result;
    }


    /**
     * method is used for showing toast.
     *
     * @param activity context and String message to show
     */
    public static void showToast(Activity activity,String message) {

        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();

    }
}
