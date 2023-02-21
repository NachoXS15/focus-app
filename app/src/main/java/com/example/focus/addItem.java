package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.focus.db.DbItems;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addItem extends AppCompatActivity {

    EditText title, desc, date; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        FloatingActionButton add = findViewById(R.id.addButton);
        title =  findViewById(R.id.titleText);
        desc =  findViewById(R.id.descText);
        date =  findViewById(R.id.dateText);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbItems dbItems = new DbItems(addItem.this);
                long id = dbItems.addItems(title.getText().toString(), desc.getText().toString(), date.getText().toString());
                if (id > 0){
                    Toast.makeText(addItem.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    cleanSlot();
                }else{
                    Toast.makeText(addItem.this, "REGISTRO fallido", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void goBackMain(View view){
        Intent volverMenu = new Intent (this, mainPage.class);
        startActivity(volverMenu);
    }

    private void cleanSlot(){
        title.setText("");
        desc.setText("");
        date.setText("");
    }

}