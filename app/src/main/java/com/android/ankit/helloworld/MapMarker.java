package com.android.ankit.helloworld;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Ankit on 04/22/2017.
 */

public class MapMarker {


    public final String name;

    public final LatLng location;

    MapMarker(String name, LatLng location) {
        this.name = name;
        this.location = location;
    }
}
