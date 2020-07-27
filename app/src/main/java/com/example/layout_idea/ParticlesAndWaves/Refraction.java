package com.example.layout_idea.ParticlesAndWaves;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

public class Refraction extends AppCompatActivity {

    SharedPrefs sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPref = new SharedPrefs(this);
        if(sharedPref.loadNightMode()==true) {
            setTheme(R.style.DarkTheme);
        }
        else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refraction);
    }
}