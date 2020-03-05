package com.example.onecheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Items extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;
    ArrayList<String> items = new ArrayList<>();
    ArrayList<Float> cost = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        /* Get the items ArrayList using an intent method */
        Intent listIntent = getIntent();
        items = (ArrayList<String>) listIntent.getSerializableExtra("key");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.itemsView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }

    public void launchPeopleActivity(View view) {
        Intent intent = new Intent(this, People.class);
        startActivity(intent);
    }
}
