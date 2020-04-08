package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Items extends AppCompatActivity {

    String tax;
    String tip;
    double total;
    String totalText;
    MyRecyclerViewAdapter adapter;
    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> cost = new ArrayList<>();
    ArrayList<String> combinedCostAndItems = new ArrayList<>();
    private static DecimalFormat df2 = new DecimalFormat("#.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        /* Get the items and cost ArrayList and the tax and tip using an intent method */
        Intent listIntent = getIntent();
        items = (ArrayList<String>) listIntent.getSerializableExtra("item");
        cost = (ArrayList<String>) listIntent.getSerializableExtra("cost");
        tax = listIntent.getStringExtra("tax");
        tip = listIntent.getStringExtra("tip");

        for(int i = 0; i < items.size(); i++) {
            combinedCostAndItems.add(i, items.get(i) + ": $" + cost.get(i));
        }

        // set up the RecyclerView for items
        RecyclerView recyclerViewItems = findViewById(R.id.itemsView);
        recyclerViewItems.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, combinedCostAndItems);
        recyclerViewItems.setAdapter(adapter);

        //calculate and displays total
        total = getTotal(tax, tip, cost);
        totalText = df2.format(total);
        TextView textView = (TextView) findViewById(R.id.totalValue);
        textView.setText(totalText);
    }

    public double getTotal(String tax, String tip, ArrayList<String> costItems)
    {
        double taxNum = Double.parseDouble(tax);
        double tipNum = Double.parseDouble(tip);
        double thisTotal = 0;

        for (int i = 0; i < costItems.size(); i++) {
            thisTotal += Double.parseDouble(costItems.get(i));
        }

        taxNum = taxNum / 100;
        tipNum = tipNum / 100;
        thisTotal *= (1 + taxNum);
        thisTotal *= (1 + tipNum);

        return thisTotal;
    }

    public void launchPeopleActivity(View view) {
        Intent intent = new Intent(this, People.class);
        intent.putExtra("item", items);
        intent.putExtra("cost", cost);
        startActivity(intent);
    }
}
