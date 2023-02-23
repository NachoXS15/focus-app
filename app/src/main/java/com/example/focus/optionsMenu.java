package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class optionsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
    }

    //go activities
    public void goCalendar(View view){
        Intent calendar = new Intent(this, calendarPage.class);
        startActivity(calendar);
    }
    public void goData(View view){
        Intent volver = new Intent(this, mainPage.class);
        startActivity(volver);
    }
    public void goSetting(View view){
        Intent config = new Intent(this, mainPage.class);
        startActivity(config);
    }


    public void goBack(View view){
         Intent volver = new Intent(this, mainPage.class);
         startActivity(volver);
    }
}