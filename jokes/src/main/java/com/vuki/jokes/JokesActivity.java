package com.vuki.jokes;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.vuki.jokes.databinding.ActivityJokesBinding;

public class JokesActivity extends AppCompatActivity {

    public static String EXTRA_JOKE = "joke";
    public ActivityJokesBinding binding;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        binding = DataBindingUtil.setContentView( this, R.layout.activity_jokes );

        String joke = getIntent().getStringExtra( EXTRA_JOKE );
        if ( joke != null && !TextUtils.isEmpty( joke.trim() ) ) {
            //there is new joke
            binding.txtJoke.setText( joke );
        }
    }
}
