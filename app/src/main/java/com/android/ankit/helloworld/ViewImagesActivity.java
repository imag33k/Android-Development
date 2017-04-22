package com.android.ankit.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import java.io.File;
import java.util.ArrayList;

public class ViewImagesActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Uri> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_images);

        list = imageReader(Environment.getExternalStorageDirectory());

        gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new GridAdapter());

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent fullScreenIntent = new Intent(view.getContext(), ViewImage.class);
                fullScreenIntent.putExtra("img", list.get(position));
                startActivity(fullScreenIntent);
            }
        });

    }

    private ArrayList<Uri> imageReader(File root) {
        ArrayList<Uri> aList = new ArrayList<>();

        File[] files = root.listFiles();
        if(files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    aList.addAll(imageReader(files[i]));
                } else if (files[i].getName().endsWith(".jpg")) {
                    aList.add(Uri.fromFile(files[i]));

                    Log.d("URI", Uri.fromFile(files[i]).toString());
                }
            }
        }

        return aList;
    }

    private class GridAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.activity_single_image_view, parent, false);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewSmall);
            imageView.setImageURI((Uri) getItem(position));
            return convertView;
        }
    }
}
