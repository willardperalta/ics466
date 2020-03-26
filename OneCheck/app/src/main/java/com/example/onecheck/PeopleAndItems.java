package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PeopleAndItems extends AppCompatActivity {

    MyRecyclerViewAdapter adapter; //used to display default row
    MyRecyclerViewAdapter2 adapter2; //customized from first adapter to include a button in each row
    EditText addPrice; //text field to manually add a price to a peson

    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> cost = new ArrayList<>();
    ArrayList<String> itemsAndCost = new ArrayList<>(); //Item: cost
    ArrayList<String> resultCosts = new ArrayList<>(); //arraylist to store what each perosn owes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_and_items);


        /* Get the names, items, cost ArrayList using an intent method */
        Intent listIntent = getIntent();
        names = (ArrayList<String>) listIntent.getSerializableExtra("key");
        items = (ArrayList<String>) listIntent.getSerializableExtra("item");
        cost = (ArrayList<String>) listIntent.getSerializableExtra("cost");


        //create another array that has both the items and price as one string for each entry
        for (int i = 0; i < items.size(); i++) {
            itemsAndCost.add(items.get(i) + ": $" + cost.get(i));
        }


        // set up the RecyclerView for names
        RecyclerView recyclerView = findViewById(R.id.people);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter2 = new MyRecyclerViewAdapter2(this, names);
        recyclerView.setAdapter(adapter2);


        // set up the RecyclerView for items
        RecyclerView recyclerViewItems = findViewById(R.id.itemsAndCost);
        recyclerViewItems.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, itemsAndCost);
        recyclerViewItems.setAdapter(adapter);


        addPrice = (EditText) findViewById(R.id.addPrice); //editText View to add price to specific person
        resultCosts.add(0, "0"); //initialize first entry with "0" for testing purposes


    }

    public void launchResultsActivity(View view) {
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("key", names); //send the names list to the results activity
        intent.putExtra("resultCosts", resultCosts); //send the resultCosts list to the results activity
        startActivity(intent);
    }

    public void addItemToPerson() {
        //add the string in resultCosts plus what was in the addPrice editText view
        String result = addTwoNumberString(resultCosts.get(0), (addPrice.getText().toString()));
        resultCosts.add(0, result);
    }

    public String addTwoNumberString(String first, String second) {
        //convert string to double so can add them together, then put back to string to add back to arraylist
        String result = Double.toString((Double.parseDouble(first) + Double.parseDouble(second)));
        //format the result to two decimal places
        return String.format("%.2f", result);
    }

}
