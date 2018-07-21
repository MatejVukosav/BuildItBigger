package com.vuki.data;

import com.vuki.data.models.Joke;

public class JokeProvider {

    public Joke provideJoke(){
        return new Joke("Two mouses and a single cat!");
    }
}
