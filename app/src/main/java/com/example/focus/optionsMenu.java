package com.example.focus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class optionsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
    }

    //go activities
    public void goStart(View view) {
        Intent start = new Intent(this, MainActivity.class);
        startActivity(start);
    }

    public void goCalendar(View view){
        Intent calendar = new Intent(this, calendarPage.class);
        startActivity(calendar);
    }
    public void goSetting(View view){
        Intent config = new Intent(this, settingsPage.class);
        startActivity(config);
    }

    public void goBack(View view){
         Intent volver = new Intent(this, mainPage.class);
         startActivity(volver);
    }
}