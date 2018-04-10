package com.example.guenther.android_180227_gps_location2_gw;

import android.Manifest;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName(); // Tag für Log.i
    Button btnGetLoc; // Datenfeld für Button
    TextView textView; // Datenfeld zur Anzeige GPS-Daten

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetLoc = (Button) findViewById(R.id.btnGetLoc);
        textView = findViewById(R.id.textView);



        //Schritt 4 - Anfordern Berechtigungen (Requests permissions to be granted to this application)
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 4711);


        //Schritt 5 - onClickListener für Button
        btnGetLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPSTracker gpsTracker = new GPSTracker(getApplicationContext());
                Location location = gpsTracker.getLocation();

                if (location != null) {
                    double latitude = location.getLatitude(); // Get the latitude, in degrees.
                    double longitude = location.getLongitude(); // Get the longitude, in degrees.
                    double altitude = location.getAltitude(); // Get the altitude if available, in meters above the WGS 84 reference ellipsoid.
                    double timestamp = location.getTime(); // Return the UTC time of this fix, in milliseconds since January 1, 1970.
                    float speed = location.getSpeed(); // Get the speed if it is available, in meters/second over ground.
                    float bearing = location.getBearing(); // Get the bearing (Peilung nach Norden), in degrees.

                    textView.setText("Breitengrad: " + latitude +
                            "\nLängengrad: " + longitude +
                            "\nHöhe: " + altitude +
                            "\nZeitstempel unix:" + timestamp +
                            "\nSpeed in m/s: " + speed +
                            "\nPeilung in Grad: " + bearing
                    );
                    //Toast.makeText(getApplicationContext(), "Breitengrad: " + latitude + "\n Längengrad: " + longitude, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "location ist null!!", Toast.LENGTH_LONG);
                }
            }
        });
    }

    public static void onLocationChanged() {
        Log.i(TAG, "test Position geändert!");
    }

    public static void onProviderDisabled() {
        Log.i(TAG, "test Provider diabled");
    }

    public static void onProviderEnabled() {
        Log.i(TAG, "test Provider enabled");
    }

}
