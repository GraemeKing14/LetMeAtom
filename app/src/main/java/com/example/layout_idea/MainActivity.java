package com.example.layout_idea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button LogIn;
    private TextView newUser;
    private DatabaseHelper db;
    SharedPrefs sharedPref;
    private Switch dmSwitch;
    private String user;
    private String pwd;

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
        setContentView(R.layout.activity_main);
        setUpUi();
        db = new DatabaseHelper(this);

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Registration.class));
            }
        });

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = username.getText().toString();
                pwd = password.getText().toString();
                Boolean res = db.checkUser(user, pwd);
                if (res) {
                    startActivity(new Intent(MainActivity.this, HomePage.class));
                    Toast.makeText(MainActivity.this, "Welcome " + user, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dmSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sharedPref.setNightMode(true);
                    restartApp();
                }
                else {
                    sharedPref.setNightMode(false);
                    restartApp();
                }
            }
        });
    }

    public void setUpUi() {
        /** A Method to set up the user interface. Also adds functionality to dark mode switch. **/
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        LogIn = findViewById(R.id.LogIn);
        newUser = findViewById(R.id.newUser);
        dmSwitch = findViewById(R.id.dmSwitch);
        if (sharedPref.loadNightMode()==true) {
            dmSwitch.setChecked(true);
        }
    }

    public void restartApp() {
        /** A method to restart the application. **/
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

}
