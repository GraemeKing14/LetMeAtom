package com.example.layout_idea.ParticlesAndWaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

public class TheStandardModel extends AppCompatActivity {

    SharedPrefs sharedPref;
    private ImageButton goBack;
    private Button toFC;
    private Button toNR;
    private Button toInv;
    private Button toWPD;
    private Button toInt;
    private Button toSpec;
    private Button toRef;

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
        setContentView(R.layout.activity_the_standard_model);
        setUpUi();
    }

    public void setUpUi() {
        goBack = findViewById(R.id.returntoMenu);
        toFC = findViewById(R.id.toFC);
        toNR = findViewById(R.id.toNR);
        toInv = findViewById(R.id.toInv);
        toWPD = findViewById(R.id.toWPD);
        toInt = findViewById(R.id.toInt);
        toSpec = findViewById(R.id.toSpec);
        toRef = findViewById(R.id.toRef);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TheStandardModel.this, pawHome.class));
            }
        });
        toFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TheStandardModel.this, ForcesOnChargedParticles.class));
            }
        });
        toNR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TheStandardModel.this, NuclearReactions.class));
            }
        });
        toInv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TheStandardModel.this, InverseSquareLaw.class));
            }
        });
        toWPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TheStandardModel.this, WaveParticleDuality.class));
            }
        });
        toInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TheStandardModel.this, Interference.class));
            }
        });
        toSpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TheStandardModel.this, Spectra.class));
            }
        });
        toRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TheStandardModel.this, Refraction.class));
            }
        });
    }
}