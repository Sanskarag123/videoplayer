package com.newp.new_ui;


import android.annotation.SuppressLint;

import android.app.SharedElementCallback;



import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;




public class MainActivity extends AppCompatActivity {
    VideoView vid;
    MediaController m1;
    Button clk;
    SensorManager sensorManager;
    Sensor sensor;
    String s;
    EditText et;

    @Override
    public void setEnterSharedElementCallback(SharedElementCallback callback) {

    }

    TextView txtNumber;


    @SuppressLint({"WrongViewCast", "ServiceCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clk = (Button) findViewById(R.id.button);
        vid = (VideoView) findViewById(R.id.videoView);
        m1 = new MediaController(this);
        sensorManager=(SensorManager)getSystemService(SEARCH_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        txtNumber=(TextView)findViewById(R.id.textView);
        sensorManager.registerListener((SensorEventListener) this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

        et=(EditText)findViewById(R.id.editText);
       String m;
        m = ""+et;
        shake(m);



    }

    private  char shake(String et) {
        String s1;
        s1 = "android.resource://com.newp.new_ui/"+R.raw.ok;
        Uri u=Uri.parse(s1);
        vid.setVideoURI(u);
        vid.setMediaController(m1);

        if(s!=et) {
            vid.start();
        }

        return 0;

    }

    public SensorManager getSensorManager() {
        return sensorManager;
    }

    public void setSensorManager(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
    }

    public void  onSensorChanged(SensorEvent event)
    {

         s=""+event.values[0];
         txtNumber.setText(s);



    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void playvideo (View V)
    {
        String s1;
        s1 = "android.resource://com.newp.new_ui/"+R.raw.ok;
        Uri u=Uri.parse(s1);
        vid.setVideoURI(u);
        vid.setMediaController(m1);

        m1.setAnchorView(vid);



        vid.start();
    }


}
