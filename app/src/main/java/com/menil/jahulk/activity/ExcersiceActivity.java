package com.menil.jahulk.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.menil.jahulk.R;
import com.menil.jahulk.bus.MuscleGroupEvent;
import com.menil.jahulk.model.MuscleGroup;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

public class ExcersiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MuscleGroup muscleGroup = EventBus.getDefault().getStickyEvent(MuscleGroup.class);
        if (muscleGroup != null) {
            EventBus.getDefault().removeStickyEvent(MuscleGroup.class);
        }

        ArrayList<MuscleGroup> muscleGroups = EventBus.getDefault().getStickyEvent(MuscleGroupEvent.class).getMuscleGroups();
        if (muscleGroups != null) {
            EventBus.getDefault().removeAllStickyEvents();
        }

    }

}
