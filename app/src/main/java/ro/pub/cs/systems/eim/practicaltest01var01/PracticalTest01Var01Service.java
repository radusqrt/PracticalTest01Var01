package ro.pub.cs.systems.eim.practicaltest01var01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class PracticalTest01Var01Service extends Service {
    public PracticalTest01Var01Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("[SERVICE]", "onBind() method was invoked");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("[SERVICE]", "onUnbind() method was invoked");
        return true;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d("[SERVICE]", "onRebind() method was invoked");
    }

    @Override
    public void onDestroy() {
        Log.d("[SERVICE]", "onDestroy() method was invoked");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("[SERVICE]", "onStartCommand() method was invoked");
        Thread processingThread = new ProcessingThread(getApplicationContext());
        processingThread.start();
        return START_REDELIVER_INTENT;
    }
}
