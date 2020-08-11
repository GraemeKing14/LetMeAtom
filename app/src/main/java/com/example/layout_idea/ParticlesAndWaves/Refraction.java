package com.example.layout_idea.ParticlesAndWaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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
    private TextView keyEq;

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
        keyEq = findViewById(R.id.equationsRef);

        keyEq.setText(Html.fromHtml("<br> n = <sup>sin&theta<sub>1</sub></sup>/<sub>sin&theta<sub>2</sub></sub> <br><br>" +
                "<sup>sin&theta<sub>1</sub></sup>/<sub>sin&theta<sub>2</sub></sub> =  <sup>&lambda<sub>1</sub></sup>/<sub>&lambda<sub>2</sub></sub> =  " +
                "<sup>v<sub>1</sub></sup>/<sub>v<sub>2</sub></sub> <br><br>v = f&lambda <br><br> sin&theta<sub>c</sub> = " +
                "<sup>1</sup>/<sub>n</sub>"));

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