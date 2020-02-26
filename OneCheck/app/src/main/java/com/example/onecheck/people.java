package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class People extends AppCompatActivity{

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);



        // data to populate the RecyclerView with
        ArrayList<String> names = new ArrayList<>();
        names.add("Thomas");
        names.add("Michelle");
        names.add("Greg");
        names.add("Fred");
        names.add("Lisa");
        names.add("Lisa");
        names.add("Lisa");
        names.add("Lisa");


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.people);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, names);
        recyclerView.setAdapter(adapter);
    }



    public void launchPeopleAndItemsActivity(View view) {
        Intent intent = new Intent(this, PeopleAndItems.class);
        startActivity(intent);
    }

    public void launchListViewActivity(View view) {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }
}
