package cordova.plugin.calloptions;

import android.annotation.SuppressLint;
import android.telephony.TelephonyManager;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import android.telephony.TelephonyManager;
import static android.content.Context.TELEPHONY_SERVICE;

/**
 * This class echoes a string called from JavaScript.
 */
public class CallOptions extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("CheckNumber")) {
            String number = args.getString(0);
            this.CheckNumber(number, callbackContext);
            return true;
        }
        return false;
    }

    private void CheckNumber(String number, CallbackContext callbackContext) {
        if (number != null && number.length() > 0) {

            try{
                TelephonyManager tm = (TelephonyManager) cordova.getActivity().getSystemService(TELEPHONY_SERVICE);
                @SuppressLint("SoonBlockedPrivateApi") Method m1 = tm.getClass().getDeclaredMethod("getITelephony");
                m1.setAccessible(true);
                Object iTelephony = m1.invoke(tm);
                Method hangUpMethod = iTelephony.getClass().getDeclaredMethod("endCall");
                hangUpMethod.invoke(iTelephony);
                callbackContext.success(number);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
