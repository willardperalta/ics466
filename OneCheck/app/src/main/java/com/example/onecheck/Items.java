package com.example.onecheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Items extends AppCompatActivity {

    double tax;
    double tip;
    double total;
    String totalText;
    MyRecyclerViewAdapter adapter;
    ArrayList<String> items = new ArrayList<>();
    ArrayList<Double> cost = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        /* Get the items and cost ArrayList and the tax and tip using an intent method */
        Intent listIntent = getIntent();
        items = (ArrayList<String>) listIntent.getSerializableExtra("key");
        cost = (ArrayList<Double>) listIntent.getSerializableExtra("key2");


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.itemsView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, items);
        recyclerView.setAdapter(adapter);

        //total = getTotal(tax, tip, cost);

        //displays total
        totalText = Double.toString(total);
        TextView textView = (TextView) findViewById(R.id.totalValue);
        textView.setText(totalText);
    }

    public double getTotal(double tax, double tip, ArrayList<Double> costItems)
    {
        double thisTotal = 0;

        for (int i = 0; i < costItems.size(); i++) {
            thisTotal += costItems.get(i);
        }

        //tax = tax / 100;
        //tip = tip / 100;
        //thisTotal *= (1 + tax);
        //thisTotal *= (1 + tip);

        return thisTotal;
    }

    public void launchPeopleActivity(View view) {
        Intent intent = new Intent(this, People.class);
        startActivity(intent);
    }
}
