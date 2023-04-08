package com.example.focus;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class createUser extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        EditText email, pass;
        Button btnCreate;

        email = findViewById(R.id.emailCreate);
        pass = findViewById(R.id.passwordCreate);
        btnCreate = findViewById(R.id.buttonCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent goLogin = new Intent (createUser.this, loginPage.class);
                            startActivity(goLogin);
                            Toast.makeText(createUser.this, "Usuario creado!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(createUser.this, "", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}