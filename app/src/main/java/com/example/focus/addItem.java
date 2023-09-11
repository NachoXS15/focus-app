package com.example.focus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class addItem extends AppCompatActivity {

    EditText titleText, descText, dateText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);



        FloatingActionButton add = findViewById(R.id.addButton);
        titleText =  findViewById(R.id.titleText);
        descText =  findViewById(R.id.descText);
        dateText =  findViewById(R.id.dateText);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = titleText.getText().toString();
                String desc = descText.getText().toString();
                String date = dateText.getText().toString();

                if(title.isEmpty() || desc.isEmpty() || date.isEmpty()){
                    Toast.makeText(addItem.this, "Datos faltantes", Toast.LENGTH_SHORT).show();

                }else{
                    addItemsFS(title, desc, date);
                }
                /*
                 DbItems dbItems = new DbItems(addItem.this);
                long id = dbItems.addItems(title.getText().toString(), desc.getText().toString(), date.getText().toString());

                if (id > 0){
                    Toast.makeText(addItem.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    cleanSlot();
                }else{
                    Toast.makeText(addItem.this, "REGISTRO fallido", Toast.LENGTH_LONG).show();
                }

                 */
            }
        });
    }

    private void addItemsFS (String title, String desc, String date){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> task = new HashMap<>();
        task.put("Titulo", title);
        task.put("Descripcion", desc);
        task.put("Fecha", date);
        db.collection("Tasks").add(task).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(addItem.this, "Datos guardados en db", Toast.LENGTH_SHORT).show();
                Log.d("ID: ", documentReference.getId());
                Intent volverMenu = new Intent (addItem.this, mainPage.class);
                startActivity(volverMenu);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(addItem.this, "Fallo al enviar datos", Toast.LENGTH_SHORT).show();
                Log.d("problem: ", String.valueOf(e));
            }
        });
    }

    //clear edittext

    public void clearAll(View view){
        FloatingActionButton clear = findViewById(R.id.clearText);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleText.setText("");
                descText.setText("");
                dateText.setText("");
            }
        });
    }

    public void goBackMain(View view){

    }

}