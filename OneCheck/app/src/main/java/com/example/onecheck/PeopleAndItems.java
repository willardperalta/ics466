package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PeopleAndItems extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;

    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_and_items);

        /* Get the names ArrayList using an intent method */
        Intent listIntent = getIntent();
        names = (ArrayList<String>) listIntent.getSerializableExtra("key");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.people);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, names);
        recyclerView.setAdapter(adapter);


        // data to populate the RecyclerView with

        items.add("fries");
        items.add("fries");
        items.add("fries");
        items.add("fries");
        items.add("fries");
        items.add("burger");
        items.add("burger");
        items.add("burger");
        items.add("burger");
        items.add("burger");
        // set up the RecyclerView
        RecyclerView recyclerViewItems = findViewById(R.id.items);
        recyclerViewItems.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, items);
        recyclerViewItems.setAdapter(adapter);

    }

    public void launchResultsActivity(View view) {
        Intent intent = new Intent(this, Results.class);
        startActivity(intent);
    }
}
