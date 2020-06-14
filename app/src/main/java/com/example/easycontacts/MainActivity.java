package com.example.easycontacts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
private Button new_contact,edit_contact;
private RecyclerView recyclerView;
private AlertDialog.Builder builder;
private AlertDialog dialog;
private Button add_name,add_contact, popup_add_but;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_view);
        sql_database db = new sql_database(this);
        new_contact = findViewById(R.id.add);
        edit_contact = findViewById(R.id.edit);
        recyclerView = findViewById(R.id.r_view);
        recyclerView.setAdapter(new RecyclerAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        new_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func_add();
            }
        });
    }

    void func_add()
    {
        builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.new_contact_intent,null);
        builder.setView(view);
        dialog = builder.create();
        dialog.show();
    }
}
