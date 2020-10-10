package cordova.plugin.calloptions;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
            callbackContext.success(number);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
