package com.example.guenther.android_180227_gps_location2_gw;

import android.Manifest;
import android.location.Location;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//Schritt 0
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    Button btnGetLoc;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetLoc = (Button) findViewById(R.id.btnGetLoc);
        textView = findViewById(R.id.textView);
        //Ende Schritt 0


        //Schritt 6
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},4711);

        //Schritt 5
        btnGetLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Button gedrückt!!!");
                GPSTracker gpsTracker = new GPSTracker(getApplicationContext());
                Location location = gpsTracker.getLocation();

                int format_degrees = location.FORMAT_DEGREES;
                int format_minutes = location.FORMAT_MINUTES;
                int format_seconds = location.FORMAT_SECONDS;

                /*Log.i(TAG, "format_degrees " + ((Integer) format_degrees).toString());
                Log.i(TAG, "format_degrees " + ((Integer) format_minutes).toString());
                Log.i(TAG, "format_degrees " + ((Integer) format_seconds).toString());*/


                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    double altitude = location.getAltitude();
                    double timestamp = location.getTime();
                    float speed = location.getSpeed();
                    float bearing = location.getBearing();
                    String provider = location.getProvider();

                    textView.setText("Breitengrad: " + latitude + "\n Längengrad: " + longitude + "\n Höhe: " + altitude + "\n Zeitstempel:" + timestamp);
                    Toast.makeText(getApplicationContext(), "Breitengrad: " + latitude + "\n Längengrad: " + longitude, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "location ist null!!", Toast.LENGTH_LONG);

                }
                Log.i(TAG, "fertig");

            }
        });
    }
}
