package com.menil.jahulk.bus;

import com.menil.jahulk.model.MuscleGroup;

import java.util.ArrayList;

/**
 * Created by irvin on 1/22/16 project JaHulkAndroid.
 */
public class MuscleGroupEvent {
    private ArrayList<MuscleGroup> muscleGroups = new ArrayList<>();

    public MuscleGroupEvent(ArrayList<MuscleGroup> muscleGroups) {
        this.muscleGroups = muscleGroups;
    }

    public ArrayList<MuscleGroup> getMuscleGroups() {
        return muscleGroups;
    }

    public MuscleGroupEvent setMuscleGroups(ArrayList<MuscleGroup> muscleGroups) {
        this.muscleGroups = muscleGroups;
        return this;
    }
}
