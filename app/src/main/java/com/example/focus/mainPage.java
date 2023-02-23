package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.focus.adapters.listItemAdapter;
import com.example.focus.db.DbItems;
import com.example.focus.entities.Items;
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

    RecyclerView listItem;
    ArrayList<Items> itemsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        listItem = findViewById(R.id.listItem);
        listItem.setLayoutManager(new LinearLayoutManager(this));

        DbItems dbItems = new DbItems(mainPage.this);
        itemsArrayList = new ArrayList<>();

        listItemAdapter adapter = new listItemAdapter((dbItems.showItems()));
        listItem.setAdapter(adapter);
    }

    //move through activities
    public void goOptions (View view){
        Intent avanzarOptions = new Intent(this, optionsMenu.class);
        startActivity(avanzarOptions);
    }
    //go to addItem
    public void addItem (View view){
        Intent avanzarAdd = new Intent(this, addItem.class);
        startActivity(avanzarAdd);
    }
}