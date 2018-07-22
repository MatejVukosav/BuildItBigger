package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.vuki.data.models.Joke;

import java.io.IOException;

/**
 * Created by mvukosav
 */
class EndpointsAsyncTask extends AsyncTask<Void, Void, Joke> {
    private static MyApi myApiService = null;

    @Override
    protected Joke doInBackground( Void... params ) {
        if ( myApiService == null ) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder( AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null )
                    // - turn off compression when running against local devappserver
                    .setRootUrl( "http://" + App.SERVER_URL_ADDRESS + "/_ah/api/" )
                    .setGoogleClientRequestInitializer( new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize( AbstractGoogleClientRequest<?> abstractGoogleClientRequest ) {
                            abstractGoogleClientRequest.setDisableGZipContent( true );
                        }
                    } );
            myApiService = builder.build();
        }
        try {
            return new Joke( myApiService.joke().execute().getJoke().getText() );
        } catch ( IOException e ) {
            e.printStackTrace();
            return null;
        }
    }

}