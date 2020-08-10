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

import org.w3c.dom.Text;

public class ExpandingUniverse extends AppCompatActivity {

    SharedPrefs sharedPref;
    private ImageButton backToMenu;
    private Button forces;
    private Button collisions;
    private Button gravitation;
    private Button relativity;
    private Button motion;
    private TextView uniEqs;

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
        uniEqs = findViewById(R.id.expandingEqs);

        uniEqs.setText(Html.fromHtml("f<sub>o</sub> = f<sub>s</sub>(<sup>v</sup>/<sub>v &#177; v<sub>s</sub></sub>) " +
                "<br><br>z = ( &lambda<sub>observed</sub> - &lambda<sub>rest</sub> ) / &lambda<sub>rest</sub> <br><br>z = <sup>v</sup>/<sub>c</sub> <br><br>" +
                "v = H<sub>o</sub>d"));

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
                startActivity(new Intent(ExpandingUniverse.this, ForcesEnergyPower.class));
            }
        });
        collisions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpandingUniverse.this, CollisionsExplosionsImpulse.class));
            }
        });
        gravitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpandingUniverse.this, Gravitation.class));
            }
        });
        relativity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpandingUniverse.this, SpecialRelativity.class));
            }
        });
    }
}