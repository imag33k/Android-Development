package com.android.ankit.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ankit on 04/22/2017.
 */

public class MarkerAdapter extends ArrayAdapter<MapMarker> {
    public MarkerAdapter(Context context, MapMarker[] markers) {
        super(context, 0, markers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MapMarker marker = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_marker_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.markerCity);
        // Populate the data into the template view using the data object
        tvName.setText(marker.name);
        // Return the completed view to render on screen
        return convertView;
    }
}
