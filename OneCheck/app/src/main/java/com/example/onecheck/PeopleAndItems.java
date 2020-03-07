package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PeopleAndItems extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;

    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> items = new ArrayList<>();
    HashMap<String, Integer> results = new HashMap<>();
    Button mButton;
    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_and_items);

        /* Get the names ArrayList using an intent method */
        Intent listIntent = getIntent();
        names = (ArrayList<String>) listIntent.getSerializableExtra("key");
        items = (ArrayList<String>) listIntent.getSerializableExtra("item");


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.people);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, names);
        recyclerView.setAdapter(adapter);


        // set up the RecyclerView
        RecyclerView recyclerViewItems = findViewById(R.id.items);
        recyclerViewItems.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, items);
        recyclerViewItems.setAdapter(adapter);


        results.put("Thomas", 22);
        results.put("Michelle", 14);
        results.put("Greg", 12);
        results.put("Fred", 32);
        results.put("Lisa", 22);


    }

    public void launchResultsActivity(View view) {
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("key", names);
        startActivity(intent);
    }
}
