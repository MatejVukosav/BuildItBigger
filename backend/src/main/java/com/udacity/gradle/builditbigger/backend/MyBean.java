package com.udacity.gradle.builditbigger.backend;

import com.vuki.data.models.Joke;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private Joke myData;

    public Joke getData() {
        return myData;
    }

    public void setData(Joke data) {
        myData = data;
    }
}