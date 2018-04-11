package com.example.guenther.android_180227_gps_location2_gw;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;





public class GPSTracker implements LocationListener {

    Context context;

    public GPSTracker(Context context) {
        this.context = context;
    }


    public Location getLocation() {

        //Schritt 1 - Berechtigungen überprüfen (Determine whether you have been granted a particular permission)


        //Schritt 2 - LocationManager erstellen


        //Schritt 3 - Prüfen ob GPS am Geräte aktiviert und Location Object erstellen

    }

    @Override
    public void onLocationChanged(Location location) {
        MainActivity.onLocationChanged();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {
        MainActivity.onProviderEnabled();
    }

    @Override
    public void onProviderDisabled(String s) {
        MainActivity.onProviderDisabled();
    }


}
