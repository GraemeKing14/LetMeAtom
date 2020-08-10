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

public class Motion extends AppCompatActivity {

    SharedPrefs sharedPref;
    private ImageButton backToMenu;
    private Button forces;
    private Button collisions;
    private Button gravitation;
    private Button relativity;
    private Button universe;
    private TextView eq;

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
        setContentView(R.layout.activity_motion);
        setUpUi();
    }

    public void setUpUi() {
        backToMenu = findViewById(R.id.returntoMenu);
        forces = findViewById(R.id.toForces);
        collisions = findViewById(R.id.toCollisons);
        gravitation = findViewById(R.id.toGravitation);
        relativity = findViewById(R.id.toRelativity);
        universe = findViewById(R.id.toUniverse);
        eq = findViewById(R.id.eqsOfMotionText);

        eq.setText(Html.fromHtml("<br><br>s = vt <br><br><br>v = u + at <br><br>" +
                "s = ut + <sup>1</sup>/<sub>2</sub> at<sup>2<sup> <br><br> v<sup>2</sup> = u<sup>2</sup> + 2as <br><br>" +
                "s = <sup>1</sup>/<sub>2</sub> (u + v)t "));

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (Motion.this, oduHome.class));
            }
        });
        forces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (Motion.this, ForcesEnergyPower.class));
            }
        });
        collisions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Motion.this, CollisionsExplosionsImpulse.class));
            }
        });
        gravitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Motion.this, Gravitation.class));
            }
        });
        relativity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Motion.this, SpecialRelativity.class));
            }
        });
        universe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Motion.this, ExpandingUniverse.class));
            }
        });
    }
}