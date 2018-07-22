package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ProgressBar;

import com.vuki.data.models.Joke;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskUnitTest {

    public AsyncTaskUnitTest() {
    }

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>( MainActivity.class );

    @Test
    public void asyncTaskShouldReturnJoke() throws ExecutionException, InterruptedException {
        EndpointAsyncTask asyncTask = new EndpointAsyncTask();

        Joke joke = asyncTask.execute(new ProgressBar( rule.getActivity() )).get();

        Assert.assertNotNull( joke );
        Assert.assertNotNull( joke.getText() );
        Assert.assertNotSame( joke.getText().trim(), "" );
    }
}