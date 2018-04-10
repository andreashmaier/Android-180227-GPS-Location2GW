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

/**
 * Created by guenther on 27.02.18.
 */

public class GPSTracker implements LocationListener {

    Context context;

    public GPSTracker(Context context) {
        this.context = context;
    }


    public Location getLocation() {

        //Schritt 1 - Berechtigungen überprüfen (Determine whether you have been granted a particular permission)
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "Berechtigung nicht erteilt", Toast.LENGTH_SHORT).show();
        }


        //Schritt 2 - LocationManager erstellen
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);


        //Schritt 3 - Prüfen ob GPS am Geräte aktiviert und Location Object erstellen
        boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (isGPSEnabled) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 10, this);
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return location;

        } else {
            Toast.makeText(context, "Bitte GPS aktivieren", Toast.LENGTH_LONG).show();
        }
        return null;
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
