package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginPage extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        user = findViewById(R.id.userText);
        pass = findViewById(R.id.passText);
        button = findViewById(R.id.buttonLogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().equals("pantojaignacio123") && pass.getText().toString().equals("nacho123")) {
                    Intent avanzar = new Intent (loginPage.this, mainPage.class);
                    startActivity(avanzar);
                } else {
                    Toast.makeText(loginPage.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}
