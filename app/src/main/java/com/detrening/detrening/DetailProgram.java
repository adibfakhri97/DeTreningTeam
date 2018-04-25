package com.detrening.detrening;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class DetailProgram extends AppCompatActivity {
    private GifImageView gifImageView;
    private TextView judul, deskripsi;
    private Button mButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_program);

        gifImageView = (GifImageView) findViewById(R.id.detailGif);
        judul = (TextView) findViewById(R.id.judulProgram);
        deskripsi = (TextView) findViewById(R.id.deskripsiProgram);
        mButton = (Button) findViewById(R.id.skipProg);


        randomProgram();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomProgram();
            }
        });



    }

    public void randomProgram(){
        shuffleProg();
//        Glide.with(this).load(arrayProg[2]).into(gifImageView);
        judul.setText(arrayProg[2].getNamaGerakan());
        deskripsi.setText(arrayProg[2].getDeskripsiGerakan());
        //       int hai = p2.getmGif();
    }

    methodProgram p1 = new methodProgram(R.drawable.prog, "Program 1", "Lakukan Program 1 ini dengan cara");
    methodProgram p2 = new methodProgram(R.drawable.prog, "Program 2", "Lakukan Program 2 ini dengan cara");
    methodProgram p3 = new methodProgram(R.drawable.prog, "Program 3", "Lakukan Program 3 ini dengan cara");
    methodProgram p4 = new methodProgram(R.drawable.prog, "Program 4", "Lakukan Program 4 ini dengan cara");
    methodProgram p5 = new methodProgram(R.drawable.prog, "Program 5", "Lakukan Program 5 ini dengan cara");
    methodProgram p6 = new methodProgram(R.drawable.prog, "Program 6", "Lakukan Program 6 ini dengan cara");
    methodProgram p7 = new methodProgram(R.drawable.prog, "Program 7", "Lakukan Program 7 ini dengan cara");
    methodProgram p8 = new methodProgram(R.drawable.prog, "Program 8", "Lakukan Program 8 ini dengan cara");
    methodProgram p9 = new methodProgram(R.drawable.prog, "Program 9", "Lakukan Program 9 ini dengan cara");
    methodProgram p10 = new methodProgram(R.drawable.prog, "Program 10", "Lakukan Program 10 ini dengan cara");
    methodProgram p11 = new methodProgram(R.drawable.prog, "Program 11", "Lakukan Program 11 ini dengan cara");
    methodProgram p12 = new methodProgram(R.drawable.prog, "Program 12", "Lakukan Program 12 ini dengan cara");

    methodProgram [] arrayProg = new methodProgram[]{
            p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12
    };

    public void shuffleProg(){
        Collections.shuffle(Arrays.asList(arrayProg));

    }



}
