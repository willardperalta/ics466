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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        // data to populate the RecyclerView with
        ArrayList<String> results = new ArrayList<>();
        results.add("Thomas: $22");
        results.add("Michelle: $14");
        results.add("Greg: $12");
        results.add("Fred: $32");
        results.add("Lisa: $22");
        results.add("Lisa: $22");
        results.add("Lisa: $22");
        results.add("Lisa: $22");



        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.results);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, results);
        recyclerView.setAdapter(adapter);
    }
}
