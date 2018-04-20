package com.detrening.detrening;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

        judul.setText(getIntent().getStringExtra("nama"));
        deskripsi.setText(getIntent().getStringExtra("deskripsi"));
    }
}
