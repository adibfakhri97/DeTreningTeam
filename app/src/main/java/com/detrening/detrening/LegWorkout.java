package com.detrening.detrening;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LegWorkout extends AppCompatActivity {

    private RecyclerView recyclerLeg;
    private List<methodWorkout> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg_workout);
        setTitle("Leg Workout");

        recyclerLeg = (RecyclerView) findViewById(R.id.recyclerLeg);

        int gridCol = getResources().getInteger(R.integer.grid_column_count);

        recyclerLeg.setLayoutManager(new GridLayoutManager(this, gridCol));
        recyclerLeg.setHasFixedSize(true);

        list = new ArrayList<>();

        list.add(new methodWorkout(1, "Gerakan 1", R.drawable.giphy, ""));
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
        recyclerLeg.setAdapter(adapter);
    }
}
