package com.detrening.detrening;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ArmWorkout extends AppCompatActivity {
    private RecyclerView recyclerArm;
    private List<methodWorkout> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_workout);
        setTitle("Arm Workout");

        recyclerArm = (RecyclerView) findViewById(R.id.recyclerArm);



        int gridCol = getResources().getInteger(R.integer.grid_column_count);

        recyclerArm.setLayoutManager(new GridLayoutManager(this, gridCol));
        recyclerArm.setHasFixedSize(true);

        list = new ArrayList<>();

        list.add(new methodWorkout(1, "Gerakan 1", R.drawable.giphy, "Gerakan ini dilakukan dengan duduk di atas matras olahraga atau karpet. Anda bisa duduk dengan punggung sedikit condong ke belakang dan kaki terangkat sekitar 10 cm dari lantai, sehingga menyerupai bentuk huruf V. Lalu, satukan kedua tangan dan ketuk lantai di sebelah kanan tubuh Anda. Masih dalam posisi yang sama, putar perut lalu ketukkan genggaman tangan ke lantai di sebelah kiri tubuh. Ulangi kedua posisi sampai waktu 20 detik berakhir, lalu istirahat selama 10 detik sebelum melanjutkan ke gerakan workout sebelumnya. Kalau masih sulit untuk menyeimbangkan badan, boleh kok melakukan gerakan dengan perlahan, asalkan posisi tubuh tetap membentuk huruf V."));
        list.add(new methodWorkout(2, "Gerakan 2", R.drawable.giphy, ""));
        list.add(new methodWorkout(3, "Gerakan 3", R.drawable.giphy, ""));
        list.add(new methodWorkout(4, "Gerakan 4", R.drawable.giphy, ""));
        list.add(new methodWorkout(5, "Gerakan 5", R.drawable.giphy, ""));
        list.add(new methodWorkout(6, "Gerakan 6", R.drawable.giphy, ""));
        list.add(new methodWorkout(7, "Gerakan 7", R.drawable.giphy, ""));
        list.add(new methodWorkout(8, "Gerakan 8", R.drawable.giphy, ""));
        list.add(new methodWorkout(9, "Gerakan 9", R.drawable.giphy, ""));
        list.add(new methodWorkout(10, "Gerakan 10", R.drawable.giphy, ""));


        adapterWorkout adapter = new adapterWorkout(this, list);
        recyclerArm.setAdapter(adapter);
    }
}
