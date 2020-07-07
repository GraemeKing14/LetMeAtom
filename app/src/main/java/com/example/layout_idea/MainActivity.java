package com.example.layout_idea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button LogIn;
    private TextView newUser;
    private DatabaseHelper db;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                String user = username.getText().toString();
                String pwd = password.getText().toString();
                Boolean res = db.checkUser(user, pwd);
                if (res) {
                    startActivity(new Intent(MainActivity.this, HomePage.class));
                    Toast.makeText(MainActivity.this, "Welcome " + user, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setUpUi() {
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        LogIn = findViewById(R.id.LogIn);
        newUser = findViewById(R.id.newUser);
    }
}