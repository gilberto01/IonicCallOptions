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
    private static final String TAG = "CallOptions";

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
      super.initialize(cordova, webView);
  
      Log.d(TAG, "Inicializando CallOptions");
    }
  
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
      if(action.equals("CallOptions")) {
        // An example of returning data back to the web layer
         String phrase = args.getString(0);
        // Echo back the first argument      
        final PluginResult result = new PluginResult(PluginResult.Status.OK, "Hola todo el..."+phrase);
        callbackContext.sendPluginResult(result);
      }
      return true;
    }
}
