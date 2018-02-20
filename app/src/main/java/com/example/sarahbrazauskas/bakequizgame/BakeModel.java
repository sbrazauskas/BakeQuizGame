package com.example.sarahbrazauskas.bakequizgame;

/**
 * Created by Sarah Brazauskas on 2/20/2018.
 */

public class BakeModel {

    String name;
    int image;

    public BakeModel(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

}
