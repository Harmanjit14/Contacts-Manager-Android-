package com.example.easycontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
private Button new_contact,edit_contact;
private RecyclerView recyclerView;

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


    }
}
