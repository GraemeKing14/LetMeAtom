package com.example.layout_idea.OurDynamicUniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

public class ForcesEnergyPower extends AppCompatActivity {

    SharedPrefs sharedPref;
    private ImageButton backToMenu;
    private Button motion;
    private Button collisions;
    private Button gravitation;
    private Button relativity;
    private Button universe;

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
        setContentView(R.layout.activity_forces_energy_power);
        setUpUi();
    }

    public void setUpUi() {
        backToMenu = findViewById(R.id.returntoMenu);
        motion = findViewById(R.id.toMotion);
        collisions = findViewById(R.id.toCollisons);
        gravitation = findViewById(R.id.toGravitation);
        relativity = findViewById(R.id.toRelativity);
        universe = findViewById(R.id.toUniverse);

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForcesEnergyPower.this, oduHome.class));
            }
        });
        motion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (ForcesEnergyPower.this, Motion.class));
            }
        });
        collisions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForcesEnergyPower.this, CollisionsExplosionsImpulse.class));
            }
        });
        gravitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForcesEnergyPower.this, Gravitation.class));
            }
        });
        relativity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForcesEnergyPower.this, SpecialRelativity.class));
            }
        });
        universe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForcesEnergyPower.this, ExpandingUniverse.class));
            }
        });
    }
}