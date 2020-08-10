package com.example.layout_idea.OurDynamicUniverse;

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

public class SpecialRelativity extends AppCompatActivity {

    SharedPrefs sharedPref;
    private ImageButton backToMenu;
    private Button forces;
    private Button collisions;
    private Button gravitation;
    private Button motion;
    private Button universe;
    private TextView equationsRel;

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
        setContentView(R.layout.activity_special_relativity);
        setUpUi();
    }

    public void setUpUi() {
        backToMenu = findViewById(R.id.returntoMenu);
        motion = findViewById(R.id.toMotion);
        forces = findViewById(R.id.toForces);
        collisions = findViewById(R.id.toCollisons);
        gravitation = findViewById(R.id.toGravitation);
        universe = findViewById(R.id.toUniverse);
        equationsRel = findViewById(R.id.relEquations);

        equationsRel.setText(Html.fromHtml("<br>t' = t / &#8730(1-(<sup>v</sup>/<sub>c</sub>)<sup>2</sup> <br><br>l' = l / &#8730(1-(<sup>v</sup>/<sub>c</sub>)<sup>2</sup>"));

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SpecialRelativity.this, oduHome.class));
            }
        });
        motion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (SpecialRelativity.this, Motion.class));
            }
        });
        forces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SpecialRelativity.this, ForcesEnergyPower.class));
            }
        });
        collisions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SpecialRelativity.this, CollisionsExplosionsImpulse.class));
            }
        });
        gravitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SpecialRelativity.this, Gravitation.class));
            }
        });
        universe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SpecialRelativity.this, ExpandingUniverse.class));
            }
        });
    }
}