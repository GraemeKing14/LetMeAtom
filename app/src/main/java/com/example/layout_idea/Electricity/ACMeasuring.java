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

import org.w3c.dom.Text;

public class ACMeasuring extends AppCompatActivity {

    SharedPrefs sharedPref;
    private Button toCurrent;
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
        setContentView(R.layout.activity_a_c_measuring);
        setUpUi();
    }

    public void setUpUi() {
        toCurrent = findViewById(R.id.toCur);
        toCapa = findViewById(R.id.toCap);
        toSemi = findViewById(R.id.toSemi);
        toSources = findViewById(R.id.toSource);
        goBack = findViewById(R.id.returntoMenu);
        keyEq = findViewById(R.id.equationsAC);

        keyEq.setText(Html.fromHtml("<br>V<sub>rms</sub> = <sup>V<sub>peak</sub></sup> / <sub>&#8730;2</sub>" +
                "<br><br><br>I<sub>rms</sub> = <sup>I<sub>peak</sub></sup> / <sub>&#8730;2</sub> <br><br>" +
                "T = <sup>1</sup>/<sub>f</sub>"));

        toCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ACMeasuring.this, Current.class));
            }
        });
        toCapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ACMeasuring.this, Capacitors.class));
            }
        });
        toSemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ACMeasuring.this, SemiConductors.class));
            }
        });
        toSources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ACMeasuring.this, ElecSources.class));
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ACMeasuring.this, ElecHome.class));
            }
        });
    }
}