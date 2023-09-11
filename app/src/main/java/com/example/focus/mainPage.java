package com.example.focus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.focus.adapters.listItemAdapter;
import com.example.focus.entities.Items;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class mainPage extends AppCompatActivity {

    RecyclerView listItemRecycler;
    listItemAdapter mAdapter;
    FirebaseFirestore mFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        mFirestore = FirebaseFirestore.getInstance();
        listItemRecycler = findViewById(R.id.listItem);
        listItemRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirestore.collection("Tasks");

        FirestoreRecyclerOptions <Items> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Items>().setQuery(query, Items.class).build();

        mAdapter = new listItemAdapter(firestoreRecyclerOptions, this);
        mAdapter.notifyDataSetChanged();
        listItemRecycler.setAdapter(mAdapter);
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

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }
}