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

public class Current extends AppCompatActivity {

    SharedPrefs sharedPref;
    private Button toAC;
    private Button toCapa;
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
        setContentView(R.layout.activity_current);
        setUpUi();
    }

    public void setUpUi() {
        toAC = findViewById(R.id.toAC);
        toCapa = findViewById(R.id.toCap);
        toSemi = findViewById(R.id.toSemi);
        toSources = findViewById(R.id.toSource);
        goBack = findViewById(R.id.returntoMenu);
        keyEq = findViewById(R.id.equationsCur);

        keyEq.setText(Html.fromHtml("<br>V = IR <br><br>P = IV = I<sup>2</sup>R = <sup>V<sup>2</sup></sup> / <sub>R</sub> <br><br><br>" +
                "R<sub>T</sub> = R<sub>1</sub> + R<sub>2</sub> + <sub>.....</sub> <br><br><br>" +
                "<sup>1</sup>/<sub>R<sub>T</sub></sub> = <sup>1</sup>/<sub>R<sub>1</sub></sub> + <sup>1</sup>/<sub>R<sub>2</sub></sub> + <sub>.....</sub>" +
                "<br><br><br>V<sub>1</sub> = ( <sup>R<sub>1</sub></sup> / <sub>R<sub>1</sub> + R<sub>2</sub></sub> ) V<sub>s</sub> <br><br><br>" +
                "<sup>V<sub>1</sub></sup>/<sub>V<sub>2</sub></sub> = <sup>R<sub>1</sub></sup>/<sub>R<sub>2</sub></sub>"));

        toAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Current.this, ACMeasuring.class));
            }
        });
        toCapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Current.this, Capacitors.class));
            }
        });
        toSemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Current.this, SemiConductors.class));
            }
        });
        toSources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Current.this, ElecSources.class));
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Current.this, ElecHome.class));
            }
        });
    }
}