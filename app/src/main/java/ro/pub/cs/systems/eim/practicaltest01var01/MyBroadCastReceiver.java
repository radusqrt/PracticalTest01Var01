package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by radusqrt on 3/29/18.
 */

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String data = null;
        Log.d("TIME", action.toString());
        if ("MESAJ_BROADCAST".equals(action)) {
            data = intent.getStringExtra("TIME");
            Log.d("TIME", data);
        }
    }
}
