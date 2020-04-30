package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PeopleOweMeActivity extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;

    HashMap<String, String> nameAndPrices = new HashMap<>(); //stores the name and corresponding price
    ArrayList<String> finalResults = new ArrayList<>();
    double evenlyDistributedTaxAndTip;
    Button doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_owe_me);

        //set text to show what evenlyDistributedTaxAndTip is
        TextView textView = (TextView) findViewById(R.id.distributedtaxandtip);
        evenlyDistributedTaxAndTip = 3.22;
        textView.setText("$" + String.format("%.2f", evenlyDistributedTaxAndTip));
        doneButton = (Button) findViewById(R.id.doneButton);

        //example data
        finalResults.add("John: $13.99");
        finalResults.add("Amy: $19.22");
        finalResults.add("Jonathan: $4.76");
        finalResults.add("Adam: $21.21");
        finalResults.add("Samantha: $19.32");
        finalResults.add("Jake: $23.12");

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
                        finish();
                    }
                });

    }

    public void launchMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
