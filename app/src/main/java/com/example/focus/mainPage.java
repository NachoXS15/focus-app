package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class mainPage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    //move through activities
    public void goOptions (View view){
        Intent avanzarOptions = new Intent(this, optionsMenu.class);
        startActivity(avanzarOptions);
    }

    public void addItem (View view){
        Intent avanzarAñadir = new Intent(this, addItem.class);
        startActivity(avanzarAñadir);
    }
}