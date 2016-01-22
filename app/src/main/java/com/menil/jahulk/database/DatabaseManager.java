package com.menil.jahulk.database;

import android.content.Context;

import com.menil.jahulk.bus.ExerciseGroupEvent;
import com.menil.jahulk.bus.MuscleGroupEvent;
import com.menil.jahulk.bus.SuccessEvent;
import com.menil.jahulk.bus.error.ErrorEvent;
import com.menil.jahulk.model.ExerciseModel;
import com.menil.jahulk.model.MuscleGroup;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by irvin on 1/22/16 project JaHulkAndroid.
 */
public class DatabaseManager {

    private DatabaseHelper databaseHelper;

    public DatabaseManager(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public void saveAllGroups(final ArrayList<MuscleGroup> groups) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (MuscleGroup mg : groups) {
                        databaseHelper.getMuscleGroupDao().createOrUpdate(mg);
                    }
                    EventBus.getDefault().post(new SuccessEvent("successfully saved to db"));
                } catch (SQLException e) {
                    EventBus.getDefault().post(new ErrorEvent(e.getMessage()));
                }
            }
        }).start();
    }

    public void saveAllExercises(final ArrayList<ExerciseModel> exerciseModels) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (ExerciseModel em : exerciseModels) {
                        databaseHelper.getExerciseModelDao().createOrUpdate(em);
                    }
                    EventBus.getDefault().post(new SuccessEvent("successfully saved to db"));
                } catch (SQLException e) {
                    EventBus.getDefault().post(new ErrorEvent(e.getMessage()));
                }
            }
        }).start();
    }

    public void getAllGroups() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    List<MuscleGroup> groupList = databaseHelper.getMuscleGroupDao().queryForAll();
                    EventBus.getDefault().post(new MuscleGroupEvent(new ArrayList<>(groupList)));
                } catch (SQLException e) {
                    e.printStackTrace();
                    EventBus.getDefault().post(new ErrorEvent(e.getMessage()));
                }
            }
        }).start();
    }

    public void getExerciseByGroup(final MuscleGroup mg) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    List<ExerciseModel> exerciseModels = databaseHelper.getExerciseModelDao().queryBuilder().where().eq("group", mg.getName()).query();
                    EventBus.getDefault().post(new ExerciseGroupEvent(exerciseModels));
                } catch (SQLException e) {
                    e.printStackTrace();
                    EventBus.getDefault().post(new ErrorEvent(e.getMessage()));
                }
            }
        }).start();
    }
}
