package com.example.layout_idea;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.layout_idea.Electricity.ElecHome;
import com.example.layout_idea.Examination.examDifficulty;
import com.example.layout_idea.OurDynamicUniverse.oduHome;
import com.example.layout_idea.ParticlesAndWaves.pawHome;

public class HomePage extends AppCompatActivity {

    private Button ODU;
    private Button PAW;
    private Button Elec;
    private Button Quiz;
    private Button LogOut;
    SharedPrefs sharedPref;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
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
        setContentView(R.layout.activity_home_page);
        setUpUi();

    }

    /** A Method to set up the user interface. **/
    public void setUpUi() {
        ODU = findViewById(R.id.odu);
        PAW = findViewById(R.id.paw);
        Elec = findViewById(R.id.elec);
        Quiz = findViewById(R.id.test);
        LogOut = findViewById(R.id.logOut);

        Elec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, ElecHome.class));
            }
        });

        PAW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, pawHome.class));
            }
        });

        ODU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, oduHome.class));
            }
        });

        Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, examDifficulty.class));
            }
        });
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, MainActivity.class));
                Toast.makeText(HomePage.this, "You have successfully logged out!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}