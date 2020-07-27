package com.example.layout_idea.Electricity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.layout_idea.HomePage;
import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

public class ElecHome extends AppCompatActivity {

    SharedPrefs sharedPref;
    private Button acButton;
    private Button capaButton;
    private Button currentButton;
    private Button scButton;
    private Button sourcesButton;
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
        setContentView(R.layout.activity_elec_home);
        setUpUi();
    }

    public void setUpUi() {
        acButton = findViewById(R.id.acButton);
        capaButton = findViewById(R.id.capButton);
        currentButton = findViewById(R.id.currentButton);
        scButton = findViewById(R.id.semiButton);
        sourcesButton = findViewById(R.id.sourcesButton);
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElecHome.this, HomePage.class));
            }
        });
        acButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElecHome.this, ACMeasuring.class));
            }
        });
        capaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElecHome.this, Capacitors.class));
            }
        });
        currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElecHome.this, Current.class));
            }
        });
        scButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElecHome.this, SemiConductors.class));
            }
        });
        sourcesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElecHome.this, ElecSources.class));
            }
        });
    }
}