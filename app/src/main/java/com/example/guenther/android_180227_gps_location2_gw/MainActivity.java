package com.example.guenther.android_180227_gps_location2_gw;

import android.Manifest;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnGetLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetLoc = (Button) findViewById(R.id.btnGetLoc);

        //Schritt 6
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},4711);

        //Schritt5
        btnGetLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                GPSTracker gpsTracker = new GPSTracker(getApplicationContext());
                Location location = gpsTracker.getLocation();
                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    Toast.makeText(getApplicationContext(), "Breitengrad: " + latitude + "\n Längengrad: " + longitude, Toast.LENGTH_LONG);
                }
            }
        });
    }
}
