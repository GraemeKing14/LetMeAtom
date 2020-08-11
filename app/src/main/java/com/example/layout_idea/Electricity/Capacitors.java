package com.example.layout_idea.Electricity;

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

public class Capacitors extends AppCompatActivity {

    SharedPrefs sharedPref;
    private Button toAC;
    private Button toCur;
    private Button toSemi;
    private Button toSources;
    private ImageButton goBack;
    private TextView keyEq;

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
        setContentView(R.layout.activity_capacitors);
        setUpUi();
    }

    public void setUpUi() {
        toAC = findViewById(R.id.toAC);
        toCur = findViewById(R.id.toCur);
        toSemi = findViewById(R.id.toSemi);
        toSources = findViewById(R.id.toSource);
        goBack = findViewById(R.id.returntoMenu);
        keyEq = findViewById(R.id.equationsCap);

        keyEq.setText(Html.fromHtml("<br>C = <sup>Q</sup>/<sub>V</sub> <br><br>" +
                "Q = It <br><br>" +
                "E = <sup>1</sup>/<sub>2</sub>QV = <sup>1</sup>/<sub>2</sub>CV<sup>2</sup> = <sup>1</sup>/<sub>2</sub><sup>Q<sup>2</sup></sup>/<sub>C<sub>"));

        toAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Capacitors.this, ACMeasuring.class));
            }
        });
        toCur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Capacitors.this, Current.class));
            }
        });
        toSemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Capacitors.this, SemiConductors.class));
            }
        });
        toSources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Capacitors.this, ElecSources.class));
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Capacitors.this, ElecHome.class));
            }
        });
    }
}