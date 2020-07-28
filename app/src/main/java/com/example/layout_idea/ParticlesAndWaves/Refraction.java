package com.example.layout_idea.ParticlesAndWaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

public class Refraction extends AppCompatActivity {

    SharedPrefs sharedPref;
    private ImageButton goBack;
    private Button toSM;
    private Button toNR;
    private Button toInv;
    private Button toWPD;
    private Button toInt;
    private Button toSpec;
    private Button toFC;

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
        setUpUi();
    }

    public void setUpUi() {
        goBack = findViewById(R.id.returntoMenu);
        toFC = findViewById(R.id.toFC);
        toSM = findViewById(R.id.toSM);
        toNR = findViewById(R.id.toNR);
        toInv = findViewById(R.id.toInv);
        toWPD = findViewById(R.id.toWPD);
        toInt = findViewById(R.id.toInt);
        toSpec = findViewById(R.id.toSpec);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Refraction.this, pawHome.class));
            }
        });
        toFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Refraction.this, ForcesOnChargedParticles.class));
            }
        });
        toSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Refraction.this, TheStandardModel.class));
            }
        });
        toNR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Refraction.this, NuclearReactions.class));
            }
        });
        toInv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Refraction.this, InverseSquareLaw.class));
            }
        });
        toWPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Refraction.this, WaveParticleDuality.class));
            }
        });
        toInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Refraction.this, Interference.class));
            }
        });
        toSpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Refraction.this, Spectra.class));
            }
        });
    }
}