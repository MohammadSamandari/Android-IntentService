package com.example.android.restful.services;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MyService extends IntentService {
    //Intent services recieve objects passed to as an intent.
    // this happens automatically when the service starts up and it receives an intent object as
    // an argument.
    //we have to register the servie in the application manifest.
    //android:exported="false": in the manifest by setting this value
    //to false we mean that this service can only be accessed through this app and not
    // other apps.
    // a service has a special life cycle. like an activity it has oncreate and ondestroy methods.
    //to cominucate with an intent service back to the interface we can use broadcast messages
    //
    public static final String TAG="MyService";
    public static final String MY_SERVICE_MESSAGE="My service message";
    public static final String MY_SERVICE_PAYLOAD="My service payload";
    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Uri uri=intent.getData();
        Log.i(TAG,"onHandleIntent: "+uri.toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent messageIntent=new Intent(MY_SERVICE_MESSAGE);
        messageIntent.putExtra(MY_SERVICE_PAYLOAD,"Service all done");
        LocalBroadcastManager manager=
                LocalBroadcastManager.getInstance(getApplicationContext());
        manager.sendBroadcast(messageIntent);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
