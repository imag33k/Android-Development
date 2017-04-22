package com.android.ankit.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class ViewImage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        Intent intent = getIntent();
        Uri imageUri = (Uri) intent.getExtras().get("img");
        ImageView imageView = (ImageView) findViewById(R.id.imageViewOriginal);

        imageView.setLayoutParams( new RelativeLayout.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));

        imageView.setImageURI(imageUri);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        try
        {
            ExifInterface exif = new ExifInterface(imageUri.getPath());
            TextView textView = (TextView) findViewById(R.id.textView2);
            textView.setText("Lat: " + exif.getAttribute(ExifInterface.TAG_GPS_LATITUDE) +
                                " Long: " + exif.getAttribute(ExifInterface.TAG_GPS_LONGITUDE));
        }catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error!" + e.getMessage(),Toast.LENGTH_LONG).show();
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error!" + e.getMessage(),Toast.LENGTH_LONG).show();
        }
}
}
