package com.menil.jahulk.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.menil.jahulk.R;
import com.menil.jahulk.Singleton;
import com.menil.jahulk.adapter.ExerciseAdapter;
import com.menil.jahulk.bus.ExerciseGroupEvent;
import com.menil.jahulk.bus.error.ErrorEvent;
import com.menil.jahulk.model.MuscleGroup;

import de.greenrobot.event.EventBus;

public class ExcersiceActivity extends AppCompatActivity {

    private RecyclerView exerciseRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EventBus.getDefault().register(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initUi();


    }

    private void initUi() {
        exerciseRecyclerView = (RecyclerView) findViewById(R.id.excercise_recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        exerciseRecyclerView.setLayoutManager(layoutManager);
    }

    public void onEvent(ErrorEvent error) {

    }

    public void onEvent(MuscleGroup mg) {
        Singleton.getDbManager().getExerciseByGroup(mg);
    }

    public void onEventMainThread(ExerciseGroupEvent exerciseGroupEvent){
        ExerciseAdapter adapter = new ExerciseAdapter(this, exerciseGroupEvent.getExerciseModelArrayList());
        exerciseRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
