package com.example.focus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class recoverPassword extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);
        mAuth = FirebaseAuth.getInstance();

        EditText emailText;
        Button btnRecover;
        emailText = findViewById(R.id.emailRecover);
        btnRecover = findViewById(R.id.btnRecover);

        btnRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.sendPasswordResetEmail(emailText.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(recoverPassword.this, "exito", Toast.LENGTH_SHORT).show();
                            Intent goBack = new Intent(recoverPassword.this, loginPage.class);
                            startActivity(goBack);
                        }else{
                            Toast.makeText(recoverPassword.this, "fallido", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}