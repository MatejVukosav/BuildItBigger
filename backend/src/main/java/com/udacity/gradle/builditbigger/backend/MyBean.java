package com.udacity.gradle.builditbigger.backend;

import com.vuki.data.models.Joke;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private Joke joke;
    private String data;

    public void setJoke( Joke data ) {
        joke = data;
    }

    public void setData( String data ) {
        this.data = data;
    }

    public Joke getJoke() {
        return joke;
    }

    public String getData() {
        return data;
    }
}