package com.menil.jahulk.model;

/**
 * Created by Menil V. on 22.1.2016 at com.menil.jahulk.model.
 */
public class MuscleGroup {

    private String name;
    private String imageLink;

    public MuscleGroup(String name, String imageLink) {
        this.name = name;
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public MuscleGroup setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageLink() {
        return imageLink;
    }

    public MuscleGroup setImageLink(String imageLink) {
        this.imageLink = imageLink;
        return this;
    }

}
