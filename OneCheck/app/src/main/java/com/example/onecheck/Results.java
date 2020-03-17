package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Results extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;

    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> resultCosts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        Intent listIntent = getIntent();
        names = (ArrayList<String>) listIntent.getSerializableExtra("key");
        resultCosts = (ArrayList<String>) listIntent.getSerializableExtra("resultCosts");



        // set up the RecyclerView
        RecyclerView recyclerViewNames = findViewById(R.id.resultsnames);
        recyclerViewNames.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, names);
        recyclerViewNames.setAdapter(adapter);

        // set up the RecyclerView
        RecyclerView recyclerViewCosts = findViewById(R.id.resultscosts);
        recyclerViewCosts.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, resultCosts);
        recyclerViewCosts.setAdapter(adapter);
    }
}
