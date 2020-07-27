package com.example.layout_idea.OurDynamicUniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

public class CollisionsExplosionsImpulse extends AppCompatActivity {

    SharedPrefs sharedPref;
    private ImageButton backToMenu;
    private Button forces;
    private Button motion;
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
        setContentView(R.layout.activity_collisions_explosions_impulse);
        setUpUi();
    }

    public void setUpUi() {
        backToMenu = findViewById(R.id.returntoMenu);
        motion = findViewById(R.id.toMotion);
        forces = findViewById(R.id.toForces);
        gravitation = findViewById(R.id.toGravitation);
        relativity = findViewById(R.id.toRelativity);
        universe = findViewById(R.id.toUniverse);

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CollisionsExplosionsImpulse.this, oduHome.class));
            }
        });
        motion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (CollisionsExplosionsImpulse.this, Motion.class));
            }
        });
        forces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CollisionsExplosionsImpulse.this, ForcesEnergyPower.class));
            }
        });
        gravitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CollisionsExplosionsImpulse.this, Gravitation.class));
            }
        });
        relativity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CollisionsExplosionsImpulse.this, SpecialRelativity.class));
            }
        });
        universe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CollisionsExplosionsImpulse.this, ExpandingUniverse.class));
            }
        });
    }
}