package com.menil.jahulk.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Menil V. on 22.1.2016 at com.menil.jahulk.model.
 */
@DatabaseTable
public class MuscleGroup {

    @DatabaseField (id = true)
    private String name;
    @DatabaseField
    private String imageLink;

    public MuscleGroup() {
    }

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
