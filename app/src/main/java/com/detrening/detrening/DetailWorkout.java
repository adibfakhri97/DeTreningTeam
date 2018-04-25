package com.detrening.detrening;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pl.droidsonroids.gif.GifImageView;

public class DetailWorkout extends AppCompatActivity {
    TextView judul, deskripsi;
    GifImageView gifGerakan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_workout);
        setTitle("Detail Workout");

        judul = (TextView) findViewById(R.id.detailJudul);
        deskripsi = (TextView) findViewById(R.id.detailDeskripsi);
        gifGerakan = (GifImageView) findViewById(R.id.detailGif);

        Intent i = getIntent();
 //       String url= i.getStringExtra("gambar");

        int gifger = getIntent().getIntExtra("gambar", 1);
      //  gifGerakan.setImageDrawable(getResources().getDrawable(gifger));
        Glide.with(this).load(gifger).into(gifGerakan);
        judul.setText(getIntent().getStringExtra("nama"));
        deskripsi.setText(getIntent().getStringExtra("deskripsi"));
    }
}
