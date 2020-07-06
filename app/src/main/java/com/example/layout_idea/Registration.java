package com.example.layout_idea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    private EditText username, password;
    private Button register;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setUpUi();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                long val = db.addUser(user, pwd);
                if (val > 0 && !user.isEmpty() && !pwd.isEmpty()) {
                    startActivity(new Intent(Registration.this, MainActivity.class));
                    Toast.makeText(Registration.this, "You have registered", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Registration.this, "Registration Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void setUpUi() {
        username = findViewById(R.id.enterNameReg);
        password = findViewById(R.id.passwordReg);
        register = findViewById(R.id.register);
        db = new DatabaseHelper(this);
    }

}