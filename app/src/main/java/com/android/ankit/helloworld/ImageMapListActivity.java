package com.android.ankit.helloworld;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Arrays;

public class ImageMapListActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_map_list);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.imageMap);
        mapFragment.getMapAsync(this);


        // Create the adapter to convert the array to views
        MarkerAdapter adapter = new MarkerAdapter(this, LIST_LOCATIONS);
        // Attach the adapter to a ListView
        listView = (ListView) findViewById(R.id.locationList);
        listView.setAdapter(adapter);

        /*listView = (ListView)findViewById(R.id.locationList);
        ArrayAdapter<MapMarker> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, LIST_LOCATIONS);
        listView.setAdapter(adapter); */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MapMarker marker = LIST_LOCATIONS[position];
                mMap.animateCamera(CameraUpdateFactory.newLatLng(marker.location), 2000, null);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for (MapMarker m : LIST_LOCATIONS) {
            mMap.addMarker(new MarkerOptions()
                    .position(m.location)
                    .title(m.name)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
            );
        }
    }

    private static final MapMarker[] LIST_LOCATIONS = new MapMarker[]
    {
            new MapMarker("Cape Town", new LatLng(-33.920455, 18.466941)),
            new MapMarker("Beijing", new LatLng(39.937795, 116.387224)),
            new MapMarker("Bern", new LatLng(46.948020, 7.448206)),
            new MapMarker("Breda", new LatLng(51.589256, 4.774396)),
            new MapMarker("Brussels", new LatLng(50.854509, 4.376678)),
            new MapMarker("Copenhagen", new LatLng(55.679423, 12.577114)),
            new MapMarker("Hannover", new LatLng(52.372026, 9.735672)),
            new MapMarker("Helsinki", new LatLng(60.169653, 24.939480)),
            new MapMarker("Hong Kong", new LatLng(22.325862, 114.165532)),
            new MapMarker("Istanbul", new LatLng(41.034435, 28.977556)),
            new MapMarker("Johannesburg", new LatLng(-26.202886, 28.039753)),
            new MapMarker("Lisbon", new LatLng(38.707163, -9.135517)),
            new MapMarker("London", new LatLng(51.500208, -0.126729)),
            new MapMarker("Madrid", new LatLng(40.420006, -3.709924)),
            new MapMarker("Mexico City", new LatLng(19.427050, -99.127571)),
            new MapMarker("Moscow", new LatLng(55.750449, 37.621136)),
            new MapMarker("New York", new LatLng(40.750580, -73.993584)),
            new MapMarker("Oslo", new LatLng(59.910761, 10.749092)),
            new MapMarker("Paris", new LatLng(48.859972, 2.340260)),
            new MapMarker("Prague", new LatLng(50.087811, 14.420460)),
            new MapMarker("Rio de Janeiro", new LatLng(-22.90187, -43.232437)),
            new MapMarker("Rome", new LatLng(41.889998, 12.500162)),
            new MapMarker("Sao Paolo", new LatLng(-22.863878, -43.244097)),
            new MapMarker("Seoul", new LatLng(37.560908, 126.987705)),
            new MapMarker("Stockholm", new LatLng(59.330650, 18.067360)),
            new MapMarker("Sydney", new LatLng(-33.873651, 151.2068896)),
            new MapMarker("Taipei", new LatLng(25.022112, 121.478019)),
            new MapMarker("Tokyo", new LatLng(35.670267, 139.769955)),
            new MapMarker("Tulsa Oklahoma", new LatLng(36.149777, -95.993398)),
            new MapMarker("Vaduz", new LatLng(47.141076, 9.521482)),
            new MapMarker("Vienna", new LatLng(48.209206, 16.372778)),
            new MapMarker("Warsaw", new LatLng(52.235474, 21.004057)),
            new MapMarker("Wellington", new LatLng(-41.286480, 174.776217)),
            new MapMarker("Winnipeg", new LatLng(49.875832, -97.150726))
    };
}
