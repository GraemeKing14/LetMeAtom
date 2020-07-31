package com.example.layout_idea.Examination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

public class examDifficulty extends AppCompatActivity {

    SharedPrefs sharedPref;
    private Button easy;
    private Button medium;
    private Button hard;

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
        setContentView(R.layout.activity_exam_difficulty);
        setUpUi();
    }

    public void setUpUi() {
        easy = findViewById(R.id.easyButton);
        medium = findViewById(R.id.mediumButton);
        hard = findViewById(R.id.hardButton);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(examDifficulty.this, EasyQuiz.class));
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(examDifficulty.this, MediumQuiz.class));
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(examDifficulty.this, HardQuiz.class));
            }
        });


    }
}