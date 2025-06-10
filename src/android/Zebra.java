package com.mycompany.zebra;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import org.apache.cordova.CallbackContext;

public class ZebraReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    String data = intent.getStringExtra("com.symbol.datawedge.data_string");
    if (data != null) {
      Log.d("ZebraReceiver", "Scanned: " + data);

      // You can store in SharedPreferences or call JS
      Intent i = new Intent("com.mycompany.ZEBRA_SCAN_RESULT");
      i.putExtra("scan_result", data);
      context.sendBroadcast(i);  // Re-broadcast for Cordova JS to catch
    }
  }
}