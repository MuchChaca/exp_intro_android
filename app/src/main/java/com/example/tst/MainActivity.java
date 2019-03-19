package com.example.tst;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tst.models.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    ArrayAdapter<Client> adapter;

    private SensorManager sensorManager;

    private Sensor mLight;

    private Sensor mTemp;

    static final float LUX_THRESHOLD = 2000f;
    static final float TEMP_THRESHOLD = 28f;

    static float temperature = 0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        Log.d("CXT", "onCreate");


        adapter = new ArrayAdapter<Client>(this, android.R.layout.simple_list_item_1, Client.clients);
        ListView lv = (ListView) findViewById(R.id.lv_clients);
        lv.setAdapter(adapter);

//        lv.setAdapter(adapter);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        mTemp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_test);
////        Toolbar toolbar = findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
////
////        FloatingActionButton fab = findViewById(R.id.fab);
////        fab.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
////            }
////        });
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    protected void onStart() {
        Client c1 = new Client("fn1", "ln1");
        Client c2 = new Client("fn2", "ln2");

        Client.clients.add(c1);
        Client.clients.add(c2);

//        adapter.addAll(Client.clients);
        Log.d("CXT", "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("CXT", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("CXT", "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("CXT", "onPause");
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onRestart() {
        Log.d("CXT", "onRestart");
        super.onRestart();
    }

    public void onAdd(View view) {
        EditText tv_fn = (EditText) findViewById(R.id.et_firstName);
        String fn = tv_fn.getText().toString();

        String ln = ((EditText) findViewById(R.id.et_lastName)).getText().toString();

        Client client = new Client(ln, fn);

//        Client.clients.add(client);

        adapter.add(client);

        Log.d("FRM1", Client.clients.toString());

        Toast.makeText(MainActivity.this, "Client created !", Toast.LENGTH_LONG).show();
    }

    public void onSendTo(View view) {
        EditText tv_fn = (EditText) findViewById(R.id.et_firstName);
        String fn = tv_fn.getText().toString();

        String ln = ((EditText) findViewById(R.id.et_lastName)).getText().toString();

        Client client = new Client(ln, fn);

        Uri uri = Uri.parse("smsto:+262334455");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", client.toString());
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, mTemp, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onRevealSensors(View view) {
//        // To identify the sensors that are on a device you first need to get a reference to
//        // the sensor service. To do this, you create an instance of the SensorManager class by
//        // calling the getSystemService() method and passing in the SENSOR_SERVICE argument
//        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        // Get a list of every sensor on a device by calling the getSensorList() method and using the TYPE_ALL constant.
//        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
//
//        // if do no work, activate from File > Project Structure > app > Souce & Target compatibility >= 1.8
//        deviceSensors.forEach( s -> Log.d("CPTRS", s.toString()) );
//
//        Sensor acceleroMeter = (Sensor) sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//
//
//
//        Log.d("CPTRS CNT", acceleroMeter.toString());
//        Intent i;
//        i = new Intent(this, SensorActivity.class);
//        startActivity(i);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch(event.sensor.getType()) {
            case Sensor.TYPE_LIGHT:
                // The light sensor returns a single value.
                // Many sensors return 3 values, one for each axis.
                float lux = event.values[0];
                // Do something with this sensor value.
                Log.d("CCC", Float.toString(lux));
                Intent i;
                if(lux < LUX_THRESHOLD) {
                    i = new Intent(this, SensorActivity.class);
                    startActivity(i);
                }
                break;
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                if(event.values[0] > TEMP_THRESHOLD && temperature != event.values[0]) {
                    temperature = event.values[0];
                    Toast.makeText(this, "It's too hot !", Toast.LENGTH_SHORT).show();
                }
                Log.d("TTT", Float.toString(event.values[0]));
                break;
            default:
                //
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }
}
