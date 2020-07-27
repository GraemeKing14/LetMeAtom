package com.example.layout_idea.OurDynamicUniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.layout_idea.HomePage;
import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

public class oduHome extends AppCompatActivity {

    SharedPrefs sharedPref;
    private Button motion;
    private Button forces;
    private Button collisions;
    private Button gravitation;
    private Button relativity;
    private Button universe;
    private Button back;

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
        setContentView(R.layout.activity_odu_home);
        setUpUi();
    }

    public void setUpUi() {
        motion = findViewById(R.id.motionButton);
        forces = findViewById(R.id.forcesButton);
        collisions = findViewById(R.id.colButton);
        gravitation = findViewById(R.id.gravButton);
        relativity = findViewById(R.id.relButton);
        universe = findViewById(R.id.uniButton);
        back = findViewById(R.id.backButton);
        motion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(oduHome.this, Motion.class));
            }
        });
        forces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(oduHome.this, ForcesEnergyPower.class));
            }
        });
        collisions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(oduHome.this, CollisionsExplosionsImpulse.class));
            }
        });
        gravitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(oduHome.this, Gravitation.class));
            }
        });
        relativity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(oduHome.this, SpecialRelativity.class));
            }
        });
        universe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(oduHome.this, ExpandingUniverse.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(oduHome.this, HomePage.class));
            }
        });
    }
}