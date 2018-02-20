package com.example.sarahbrazauskas.bakequizgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Handler setDelay;       //Handler
    Runnable startDelay;    //Runnable for handler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //declare and initialize media player
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.melsuebake2);

        setDelay = new Handler();

        //initialize button and set on click listener
        Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // play sound when clicked
                mp.start();

                //Use handler to delay Game Activity launch until after sound effect finishes
                startDelay = new Runnable() {
                    @Override
                    public void run(){
                        Intent play = new Intent(MainActivity.this, GameActivity.class);
                        startActivity(play);
                    }
                };

                setDelay.postDelayed(startDelay, 3000);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // displays the SettingsActivity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent preferencesIntent = new Intent(this, SettingsActivity.class);
        startActivity(preferencesIntent);
        return super.onOptionsItemSelected(item);
    }
}