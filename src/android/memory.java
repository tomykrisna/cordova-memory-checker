package cordova.plugin.memorychecker;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class memory extends CordovaPlugin {
    public CallbackContext context;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getMemoryInfo")) {
            this.context = callbackContext;
            Log.d("coolMethod in", action);
            String message = args.getString(0);
            this.getMemoryInfo(message, callbackContext);
            return true;
        }
        return false;
    }

    private void getMemoryInfo(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager) this.cordova.getContext().getSystemService(Context.ACTIVITY_SERVICE);
            activityManager.getMemoryInfo(memoryInfo);
            Runtime runtime = Runtime.getRuntime();
            JSONObject student1 = new JSONObject();
            try {
                student1.put("availMem", memoryInfo.availMem);
                student1.put("total_memory", memoryInfo.totalMem);
                student1.put("runtime_max_memory", runtime.maxMemory());
                student1.put("runtime_total_memory", runtime.totalMemory());
                student1.put("runtime_free_memory", runtime.freeMemory());

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            callbackContext.success(student1);

        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }


    }
}
