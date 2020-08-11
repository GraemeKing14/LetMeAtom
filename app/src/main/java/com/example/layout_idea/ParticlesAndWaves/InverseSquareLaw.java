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

public class InverseSquareLaw extends AppCompatActivity {

    SharedPrefs sharedPref;
    private ImageButton goBack;
    private Button toSM;
    private Button toNR;
    private Button toFC;
    private Button toWPD;
    private Button toInt;
    private Button toSpec;
    private Button toRef;
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
        setContentView(R.layout.activity_inverse_square_law);
        setUpUi();
    }

    public void setUpUi() {
        goBack = findViewById(R.id.returntoMenu);
        toFC = findViewById(R.id.toFC);
        toSM = findViewById(R.id.toSM);
        toNR = findViewById(R.id.toNR);
        toWPD = findViewById(R.id.toWPD);
        toInt = findViewById(R.id.toInt);
        toSpec = findViewById(R.id.toSpec);
        toRef = findViewById(R.id.toRef);
        keyEq = findViewById(R.id.equationsInv);

        keyEq.setText(Html.fromHtml("<br>I = <sup>P</sup>/<sub>A</sub> <br><br>I = <sup>k</sup>/<sub>d<sup>2</sup></sub> <br><br>" +
                "I<sub>1</sub>d<sub>1</sub><sup>2</sup> = I<sub>2</sub>d<sub>2</sub><sup>2</sup> <br><br><br>" +
                "Where I is irradiance, P is power, d1 and d2 are distances from a point source of light, k is coulombs law constant and A is area."));

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InverseSquareLaw.this, pawHome.class));
            }
        });
        toFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InverseSquareLaw.this, ForcesOnChargedParticles.class));
            }
        });
        toSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InverseSquareLaw.this, TheStandardModel.class));
            }
        });
        toNR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InverseSquareLaw.this, NuclearReactions.class));
            }
        });
        toWPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InverseSquareLaw.this, WaveParticleDuality.class));
            }
        });
        toInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InverseSquareLaw.this, Interference.class));
            }
        });
        toSpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InverseSquareLaw.this, Spectra.class));
            }
        });
        toRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InverseSquareLaw.this, Refraction.class));
            }
        });
    }
}