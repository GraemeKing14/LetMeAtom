package com.example.layout_idea.ParticlesAndWaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.layout_idea.HomePage;
import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

public class pawHome extends AppCompatActivity {

    SharedPrefs sharedPref;
    private Button forcesParticlesButton;
    private Button standardModelButton;
    private Button nuclearButton;
    private Button inverseButton;
    private Button wpdButton;
    private Button interferenceButton;
    private Button spectraButton;
    private Button refractionButton;
    private Button backButton;


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
        setContentView(R.layout.activity_paw_home);
        setUpUi();
    }

    public void setUpUi() {
        forcesParticlesButton = findViewById(R.id.chargeButton);
        standardModelButton = findViewById(R.id.smButton);
        nuclearButton = findViewById(R.id.nucButton);
        inverseButton = findViewById(R.id.invButton);
        wpdButton = findViewById(R.id.waveButton);
        interferenceButton = findViewById(R.id.intButton);
        spectraButton = findViewById(R.id.specButton);
        refractionButton = findViewById(R.id.refButton);
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pawHome.this, HomePage.class));
            }
        });
        standardModelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pawHome.this, TheStandardModel.class));
            }
        });
        nuclearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pawHome.this, NuclearReactions.class));
            }
        });
        inverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pawHome.this, InverseSquareLaw.class));
            }
        });
        wpdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pawHome.this, WaveParticleDuality.class));
            }
        });
        interferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pawHome.this, Interference.class));
            }
        });
        spectraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pawHome.this, Spectra.class));
            }
        });
        forcesParticlesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pawHome.this, ForcesOnChargedParticles.class));
            }
        });
        refractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pawHome.this, Refraction.class));
            }
        });


    }
}