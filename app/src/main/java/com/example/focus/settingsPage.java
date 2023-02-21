package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class settingsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
    }

    public class user {
        String username;
        String matricula;
        String mail;

        public user (String username, String matricula, String mail){
            this.username = username;
            this.matricula = matricula;
            this.mail = mail;
        }

        user Patricio = new user ("Patricio Pedersoli", "EPM500", "patricioperdersoli@gmail.com");
    }
}