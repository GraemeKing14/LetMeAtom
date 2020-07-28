package com.example.layout_idea.Electricity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

public class SemiConductors extends AppCompatActivity {

    SharedPrefs sharedPref;
    private Button toAC;
    private Button toCur;
    private Button toCap;
    private Button toSources;
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
        setContentView(R.layout.activity_semi_conductors);
        setUpUi();
    }

    public void setUpUi() {
        toAC = findViewById(R.id.toAC);
        toCur = findViewById(R.id.toCur);
        toCap = findViewById(R.id.toCap);
        toSources = findViewById(R.id.toSource);
        goBack = findViewById(R.id.returntoMenu);

        toAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SemiConductors.this, ACMeasuring.class));
            }
        });
        toCur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SemiConductors.this, Current.class));
            }
        });
        toCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SemiConductors.this, Capacitors.class));
            }
        });
        toSources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SemiConductors.this, ElecSources.class));
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SemiConductors.this, ElecHome.class));
            }
        });
    }
}