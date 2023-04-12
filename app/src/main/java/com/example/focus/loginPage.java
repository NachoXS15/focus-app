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
import com.google.firebase.auth.FirebaseUser;

public class loginPage extends AppCompatActivity {
    private FirebaseAuth mAuth;
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
        mAuth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signInWithEmailAndPassword(user.getText().toString(), pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent goMenu = new Intent(loginPage.this, mainPage.class);
                            startActivity(goMenu);
                            Toast.makeText(loginPage.this, "Sesión iniciada", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(loginPage.this, "Error!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
    public void goCreate(View view){
        Intent create = new Intent(this, createUser.class);
        startActivity(create);
    }
    public void goRecover(View view){
        Intent recover = new Intent(this, recoverPassword.class);
        startActivity(recover);
    }
}



