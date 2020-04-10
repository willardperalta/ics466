package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PeopleAndItems extends AppCompatActivity {

    MyRecyclerViewAdapter adapter; //used to display default row

    MyRecyclerViewAdapter2 adapter2; //customized from first adapter to include a button in each row
    EditText addPrice;
    EditText addPosition;


    //Button addPriceButton = (Button) findViewById(R.id.debugbutton);
    //EditText addPrice = (EditText) findViewById(R.id.test);   //text field to manually add a price to a person

    HashMap<String, String> nameAndPrices;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> cost = new ArrayList<>();
    ArrayList<String> itemsAndCost = new ArrayList<>(); //Item: cost
    //ArrayList<String> resultCosts = new ArrayList<>(); //arraylist to store what each perosn owes
    int namesListSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_and_items);


        /* Get the names, items, cost ArrayList using an intent method */
        Intent listIntent = getIntent();
        names = (ArrayList<String>) listIntent.getSerializableExtra("key");
        items = (ArrayList<String>) listIntent.getSerializableExtra("item");
        cost = (ArrayList<String>) listIntent.getSerializableExtra("cost");
        namesListSize = listIntent.getIntExtra("namesListSize", namesListSize);

        System.out.println("namesListSize: " + namesListSize);

        // create hashmap with size of list of names
        nameAndPrices = new HashMap<>(namesListSize);

        //populate the hashmap with all names from names arraylist
        for(int i = 0; i < namesListSize; i++) {
            nameAndPrices.put(names.get(i), "0");
            System.out.println(names.get(i) + ": " + nameAndPrices.get(names.get(i)));
        }

        addPrice = (EditText) findViewById(R.id.amount);
        addPosition = (EditText) findViewById(R.id.position);

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


    }

    public void launchResultsActivity(View view) {
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("key", names); //send the names list to the results activity
        //intent.putExtra("resultCosts", resultCosts); //send the resultCosts list to the results activity
        intent.putExtra("nameAndPrices", nameAndPrices); //send the hashmap of names and prices
        startActivity(intent);
    }

    public void addItemToPerson(View view) {
        //add the string in resultCosts plus what was in the addPrice editText view
        String position = addPosition.getText().toString(); //uncomment this
        String price = addPrice.getText().toString();  //uncomment this

        //String title = ((TextView) recyclerView.findViewHolderForAdapterPosition(position).itemView.findViewById(R.id.nameOfPerson)).getText().toString();

        System.out.println("I was clicked.");

        //using the recyclerview row
        //String position = addPosition.getText().toString();
        //String price = addPrice.getText().toString();

        nameAndPrices.put(position, price);  //uncomment this

        /*
        if(position == "0") {
            resultCosts.set(Integer.parseInt(position), addTwoNumberString(resultCosts.get(0), addPrice.getText().toString()));
        } else {
            resultCosts.add(Integer.parseInt(position), addTwoNumberString(resultCosts.get(0), addPrice.getText().toString()));
        }
        */


    }

    public String addTwoNumberString(String first, String second) {
        //convert string to double so can add them together, then put back to string to add back to arraylist
        //format the result to two decimal places
        return String.format("%.2f", (Double.parseDouble(first) + Double.parseDouble(second)));
    }

}
