package com.example.layout_idea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    private Button ODU;
    private Button PAW;
    private Button Elec;
    private Button Quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        setUpUi();
    }

    public void setUpUi() {
        ODU = findViewById(R.id.odu);
        PAW = findViewById(R.id.paw);
        Elec = findViewById(R.id.elec);
        Quiz = findViewById(R.id.test);
    }
}