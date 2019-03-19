package com.example.tst.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class LightService extends IntentService implements SensorEventListener {

    public static float lux = 0;

    public static SensorManager sensorManager;
    public static Sensor mLight;

    @Override
    protected void onHandleIntent(Intent workIntent) {
        // Gets data from the incoming Intent
//        String dataString = workIntent.getDataString();
//        ..
        // Do work here, based on the contents of dataString
//        ...
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    public LightService(String name) {
        super(name);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        LightService.lux = event.values[0];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // nothing
    }

//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//
////        return super.onStartCommand(intent, flags, startId);
//    }
}