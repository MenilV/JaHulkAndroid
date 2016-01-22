package com.menil.jahulk.model;

/**
 * Created by Menil V. on 22.1.2016 at com.menil.jahulk.model.
 */
public class ExerciseModel {

    private String image;
    private String name;
    private Integer sets;
    private Integer reps;
    private Float weight;
    private Long time; //in miliseconds

    public ExerciseModel(){

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
