package com.vuki.data.models;

import java.io.Serializable;

/**
 * Created by mvukosav
 */
public class Joke implements Serializable {

    private String text;

    public Joke( String text ) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
