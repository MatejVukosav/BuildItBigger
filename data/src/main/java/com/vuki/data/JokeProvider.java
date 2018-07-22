package com.vuki.data;

import com.vuki.data.models.Joke;

public class JokeProvider {

    public Joke provideJoke(){
        return new Joke("In order to understand recursion you must first understand recursion.");
    }
}
