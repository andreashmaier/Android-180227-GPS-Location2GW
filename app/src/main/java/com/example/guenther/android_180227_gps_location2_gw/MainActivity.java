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
        super.onCreate(savedInstanceState); //extending the existing parent class' method
        setContentView(R.layout.activity_main);
        btnGetLoc = (Button) findViewById(R.id.btnGetLoc);
        textView = findViewById(R.id.textView);


        //Schritt 4 - Anfordern Berechtigungen (Requests permissions to be granted to this application)

        
        //Schritt 5 - onClickListener für Button

    }

    public static void onLocationChanged() {
        Log.i(TAG, "test Position geändert!");
    }

    public static void onProviderDisabled() {
        Log.i(TAG, "test Provider disabled");
    }

    public static void onProviderEnabled() {
        Log.i(TAG, "test Provider enabled");
    }

}
