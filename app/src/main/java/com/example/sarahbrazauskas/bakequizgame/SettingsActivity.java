package com.example.sarahbrazauskas.bakequizgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    //declare radio group and radio buttons
    private RadioGroup radioGroup_soundFX;
    private RadioButton radioButton_sfxOn, radioButton_sfxOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Connect buttons to buttons in layout
        radioGroup_soundFX = (RadioGroup)findViewById(R.id.setting_rg_sfx);
        radioButton_sfxOn = (RadioButton)findViewById(R.id.setting_rb_sfx_on);
        radioButton_sfxOff = (RadioButton)findViewById(R.id.setting_rb_sfx_off);

        //programmatic handler for sound off button
        radioGroup_soundFX.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {

                        RadioButton selectedButton = (RadioButton)findViewById(i);
                        if(selectedButton.getId()==R.id.setting_rb_sfx_off){
                            Toast.makeText(getApplicationContext(), "Sound Off", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    //xml handler for radio button sound On
    public void onSFXRadioButtonClick(View view) {

        Toast.makeText(getApplicationContext(), "Sound On", Toast.LENGTH_SHORT).show();

    }
}
