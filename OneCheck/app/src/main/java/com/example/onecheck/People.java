package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class People extends AppCompatActivity{

    MyRecyclerViewAdapter adapter;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> cost = new ArrayList<>();
    Button mButton;
    EditText mEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);


        mButton = (Button)findViewById(R.id.addName);
        mEdit   = (EditText)findViewById(R.id.nameInput);

        Intent listIntent = getIntent();
        items = (ArrayList<String>) listIntent.getSerializableExtra("item");
        cost = (ArrayList<String>) listIntent.getSerializableExtra("cost");

        mButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        String nameInputString = mEdit.getText().toString();
                        int insertIndex = names.size();

                        names.add(nameInputString);
                        adapter.notifyItemInserted(insertIndex);
                    }
                });

        // data to populate the RecyclerView with



        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.people);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, names);
        recyclerView.setAdapter(adapter);
    }



    public void launchPeopleAndItemsActivity(View view) {
        Intent intent = new Intent(this, PeopleAndItems.class);
        /* putExtra adds extra data to the intent, "key" can be anything you choose */
        intent.putExtra("key", names);
        intent.putExtra("item", items);
        intent.putExtra("cost", cost);
        startActivity(intent);
    }

    public void launchListViewActivity(View view) {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }



}
