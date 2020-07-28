package com.example.layout_idea.Electricity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

public class ElecSources extends AppCompatActivity {

    SharedPrefs sharedPref;
    private Button toAC;
    private Button toCur;
    private Button toCap;
    private Button toSemi;
    private ImageButton goBack;

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
        setContentView(R.layout.activity_elec_sources);
        setUpUi();
    }
    public void setUpUi() {
        toAC = findViewById(R.id.toAC);
        toCur = findViewById(R.id.toCur);
        toCap = findViewById(R.id.toCap);
        toSemi = findViewById(R.id.toSemi);
        goBack = findViewById(R.id.returntoMenu);

        toAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElecSources.this, ACMeasuring.class));
            }
        });
        toCur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElecSources.this, Current.class));
            }
        });
        toCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElecSources.this, Capacitors.class));
            }
        });
        toSemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElecSources.this, SemiConductors.class));
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElecSources.this, ElecHome.class));
            }
        });
    }

}