package com.menil.jahulk.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Menil V. on 22.1.2016 at com.menil.jahulk.model.
 */
@DatabaseTable
public class ExerciseModel {

    @DatabaseField
    private String image;
    @DatabaseField (id = true)
    private String name;
    @DatabaseField
    private Integer sets;
    @DatabaseField
    private Integer reps;
    @DatabaseField
    private Float weight;
    @DatabaseField
    private Long time; //in miliseconds
    @DatabaseField(columnName = "group")
    private MuscleGroup group;

    public ExerciseModel(){

    }

    public MuscleGroup getGroup() {
        return group;
    }

    public ExerciseModel setGroup(MuscleGroup group) {
        this.group = group;
        return this;
    }

    public ExerciseModel(String name, MuscleGroup muscleGroup){
        this.name=name;
        this.group=muscleGroup;
    }

    public String getImage() {
        return image;
    }

    public ExerciseModel setImage(String image) {
        this.image = image;
        return this;
    }

    public String getName() {
        return name;
    }

    public ExerciseModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSets() {
        return sets;
    }

    public ExerciseModel setSets(Integer sets) {
        this.sets = sets;
        return this;
    }

    public Integer getReps() {
        return reps;
    }

    public ExerciseModel setReps(Integer reps) {
        this.reps = reps;
        return this;
    }

    public Float getWeight() {
        return weight;
    }

    public ExerciseModel setWeight(Float weight) {
        this.weight = weight;
        return this;
    }

    public Long getTime() {
        return time;
    }

    public ExerciseModel setTime(Long time) {
        this.time = time;
        return this;
    }
}
