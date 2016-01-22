package com.menil.jahulk.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.menil.jahulk.R;
import com.menil.jahulk.adapter.MuscleGroupAdapter;
import com.menil.jahulk.model.MuscleGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Menil V. on 22.1.2016 at com.menil.jahulk.activity.
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    protected void initUI() {
        recyclerView = (RecyclerView) findViewById(R.id.exercise_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        List<MuscleGroup> muscleGroupList = new ArrayList<>(6);
        muscleGroupList.add(new MuscleGroup("Chest", "http://i.huffpost.com/gen/1228268/images/o-CHEST-EXERCISE-facebook.jpg"));
        muscleGroupList.add(new MuscleGroup("Back", "http://i.huffpost.com/gen/1228268/images/o-CHEST-EXERCISE-facebook.jpg"));
        muscleGroupList.add(new MuscleGroup("Shoulders", "http://i.huffpost.com/gen/1228268/images/o-CHEST-EXERCISE-facebook.jpg"));
        muscleGroupList.add(new MuscleGroup("Arms", "http://i.huffpost.com/gen/1228268/images/o-CHEST-EXERCISE-facebook.jpg"));
        muscleGroupList.add(new MuscleGroup("Legs", "http://i.huffpost.com/gen/1228268/images/o-CHEST-EXERCISE-facebook.jpg"));
        muscleGroupList.add(new MuscleGroup("Cardio", "http://i.huffpost.com/gen/1228268/images/o-CHEST-EXERCISE-facebook.jpg"));
        MuscleGroupAdapter adapter = new MuscleGroupAdapter(this, muscleGroupList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
