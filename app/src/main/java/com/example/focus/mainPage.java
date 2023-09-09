package com.example.focus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.focus.entities.Items;

import java.util.ArrayList;

public class mainPage extends AppCompatActivity {

    RecyclerView listItem;
    ArrayList<Items> itemsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        /*
        listItem = findViewById(R.id.listItem);
        listItem.setLayoutManager(new LinearLayoutManager(this));

        DbItems dbItems = new DbItems(mainPage.this);
        itemsArrayList = new ArrayList<>();

        listItemAdapter adapter = new listItemAdapter((dbItems.showItems()));
        listItem.setAdapter(adapter);
         */
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