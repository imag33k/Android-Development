package com.android.ankit.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnViewImages;
    Button btnViewImagesOnMap;
    Button btnViewImagesOnMapWithList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnViewImages = (Button)findViewById(R.id.btnViewImages);
        btnViewImages.setOnClickListener(this);

        btnViewImagesOnMap = (Button)findViewById(R.id.btnViewImagesOnMap);
        btnViewImagesOnMap.setOnClickListener(this);

        btnViewImagesOnMapWithList = (Button)findViewById(R.id.btnViewImagesOnMapWithList);
        btnViewImagesOnMapWithList.setOnClickListener(this);
    }

    private void btnViewImagesClick()
    {
        startActivity(new Intent("android.intent.action.VIEWIMAGES"));
    }

    private void btnViewImagesOnMapClick()
    {
        startActivity(new Intent("android.intent.action.VIEWIMAGESONMAP"));
    }

    private void btnViewImagesOnMapWithListClick()
    {
        startActivity(new Intent("android.intent.action.IMAGEMAPLIST"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnViewImages:
                btnViewImagesClick();
                break;
            case R.id.btnViewImagesOnMap:
                btnViewImagesOnMapClick();
                break;
            case R.id.btnViewImagesOnMapWithList:
                btnViewImagesOnMapWithListClick();
                break;
        }
    }
}
