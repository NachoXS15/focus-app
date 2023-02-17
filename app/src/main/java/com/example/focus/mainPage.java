package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    //go
    public void goOptions (View view){
        Intent avanzarOptions = new Intent(this, optionsMenu.class);
        startActivity(avanzarOptions);
    }
}