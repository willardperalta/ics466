package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Results extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;

    HashMap<String, String> nameAndPrices = new HashMap<>();
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> resultCosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        Intent listIntent = getIntent();
        nameAndPrices = (HashMap<String, String>) listIntent.getSerializableExtra("nameAndPrices");
        names = (ArrayList<String>) listIntent.getSerializableExtra("key");
        //resultCosts = (ArrayList<String>) listIntent.getSerializableExtra("resultCosts");
        resultCosts = new ArrayList<>(names.size()); //initialize the costs array to be as big as the names array


        //populate resultCosts array with prices from the hashmap
        for(int i = 0; i < names.size(); i++) {
            System.out.println(i);
            System.out.println(names.get(i));
            resultCosts.add(nameAndPrices.get(names.get(i))); //using add() method
            //nameAndPrices.get(names.get(i))
            //resultCosts.set(i, "i");
        }


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



    public void goBackToPeopleAndItems(View view) {
        Intent intent = new Intent(this, PeopleAndItems.class);
        startActivity(intent);
    }

}
