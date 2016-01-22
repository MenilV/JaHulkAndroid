package com.menil.jahulk.bus;

import com.menil.jahulk.model.ExerciseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Menil V. on 22.1.2016 at com.menil.jahulk.bus.
 */
public class ExerciseGroupEvent {

    private List exerciseModelArrayList;
    public ExerciseGroupEvent(List<ExerciseModel> exerciseModelArrayList){
        this.exerciseModelArrayList=new ArrayList<>(exerciseModelArrayList);
    }

    public List<ExerciseModel> getExerciseModelArrayList() {
        return exerciseModelArrayList;
    }

    public ExerciseGroupEvent setExerciseModelArrayList(ArrayList<ExerciseModel> exerciseModelArrayList) {
        this.exerciseModelArrayList = exerciseModelArrayList;
        return this;
    }
}
