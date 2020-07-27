package com.example.layout_idea.OurDynamicUniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

public class ExpandingUniverse extends AppCompatActivity {

    SharedPrefs sharedPref;
    private ImageButton backToMenu;
    private Button forces;
    private Button collisions;
    private Button gravitation;
    private Button relativity;
    private Button motion;

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
        setContentView(R.layout.activity_expanding_universe);
        setUpUi();
    }

    public void setUpUi() {
        backToMenu = findViewById(R.id.returntoMenu);
        motion = findViewById(R.id.toMotion);
        forces = findViewById(R.id.toForces);
        collisions = findViewById(R.id.toCollisons);
        gravitation = findViewById(R.id.toGravitation);
        relativity = findViewById(R.id.toRelativity);

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpandingUniverse.this, oduHome.class));
            }
        });
        motion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (ExpandingUniverse.this, Motion.class));
            }
        });
        forces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpandingUniverse.this, CollisionsExplosionsImpulse.class));
            }
        });
        collisions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpandingUniverse.this, Gravitation.class));
            }
        });
        gravitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpandingUniverse.this, SpecialRelativity.class));
            }
        });
        relativity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpandingUniverse.this, ExpandingUniverse.class));
            }
        });
    }
}