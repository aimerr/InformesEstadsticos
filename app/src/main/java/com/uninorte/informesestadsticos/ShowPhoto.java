package com.uninorte.informesestadsticos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ShowPhoto extends AppCompatActivity {

    private Integer photo;
    ImageView photoImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photo);


        photoImagen=(ImageView)findViewById(R.id.imageView2);
        Intent intent = getIntent();
        intent.getStringExtra("photoInteger");
        photo=Integer.parseInt(intent.getStringExtra("photoInteger"));
        photoImagen.setImageResource(photo);

        PhotoViewAttacher photoViewAttacher =new PhotoViewAttacher(photoImagen);
        photoViewAttacher.update();
    }
}
