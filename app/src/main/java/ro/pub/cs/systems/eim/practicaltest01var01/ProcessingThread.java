package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by radusqrt on 3/29/18.
 */

public class ProcessingThread extends Thread {

    private Context context;

    public ProcessingThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sendMessage();
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction("MESAJ_BROADCAST");
        intent.putExtra("TIME", Calendar.getInstance().getTime().toString());
        Log.d("TIME", Calendar.getInstance().getTime().toString());
        context.sendBroadcast(intent);
    }
}

