package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.vuki.data.models.Joke;
import com.vuki.jokes.JokesActivity;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ViewDataBinding binding;
    ProgressBar progressBar;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        binding = DataBindingUtil.setContentView( this, R.layout.activity_main );

        progressBar = findViewById( R.id.progress_bar );
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if ( id == R.id.action_settings ) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    public void tellJoke( View view ) {
        progressBar.setVisibility( View.VISIBLE );
        EndpointAsyncTask endpointsAsyncTask = new EndpointAsyncTask( progressBar );
        try {
            Joke joke = endpointsAsyncTask.execute().get();
            Intent intent = new Intent( this, JokesActivity.class );
            intent.putExtra( JokesActivity.EXTRA_JOKE, joke.getText() );
            startActivity( intent );
        } catch ( InterruptedException | ExecutionException e ) {
            e.printStackTrace();
        }
    }

}
