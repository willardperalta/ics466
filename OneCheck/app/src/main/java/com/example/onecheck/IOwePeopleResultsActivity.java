package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class IOwePeopleResultsActivity extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;

    HashMap<String, String> nameAndPrices = new HashMap<>(); //stores the name and corresponding price
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> resultCosts;
    ArrayList<String> finalResults = new ArrayList<>();
    double evenlyDistributedTaxAndTip;
    Button doneButton;
    TextView dateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_owe_people_results);


        Intent listIntent = getIntent();
        nameAndPrices = (HashMap<String, String>) listIntent.getSerializableExtra("nameAndPrices");
        names = (ArrayList<String>) listIntent.getSerializableExtra("key");
        evenlyDistributedTaxAndTip = listIntent.getDoubleExtra("evenlyDistributedTaxAndTip", evenlyDistributedTaxAndTip);
        resultCosts = new ArrayList<>(names.size()); //initialize the costs array to be as big as the names array

        //set text to show what evenlyDistributedTaxAndTip is
        TextView textView = (TextView) findViewById(R.id.distributedtaxandtip);
        textView.setText("$" + String.format("%.2f", evenlyDistributedTaxAndTip));
        doneButton = (Button) findViewById(R.id.doneButton);

        //show current date and time
        dateTextView = (TextView) findViewById(R.id.date);
        SimpleDateFormat formatter= new SimpleDateFormat("MM/dd/yyyy 'at' hh:mm a z");
        Date date = new Date(System.currentTimeMillis());
        dateTextView.setText(formatter.format(date));

        //populate resultCosts array with prices from the hashmap
        for(int i = 0; i < names.size(); i++) {
            System.out.println(i);
            System.out.println(names.get(i));
            resultCosts.add(nameAndPrices.get(names.get(i))); //using add() method get the string for the price
        }



        //put together results in one array
        for(int i = 0; i < names.size(); i++) {
            finalResults.add(i, names.get(i) + ": $" + String.format("%.2f", Double.parseDouble(resultCosts.get(i))));
        }


        // Display name: $price
        RecyclerView recyclerViewNames = findViewById(R.id.resultsnames);
        recyclerViewNames.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, finalResults);
        recyclerViewNames.setAdapter(adapter);


        doneButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        launchMainActivity(view);
                    }
                });

    }


    //onclick method to go back to the previous activity and edit the prices
    public void goBackToPeopleAndItems(View view) {
        finish(); //this method just goes back to previous activity
    }

    public void launchMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
