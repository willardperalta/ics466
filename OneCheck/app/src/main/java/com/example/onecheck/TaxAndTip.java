package com.example.onecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class TaxAndTip extends AppCompatActivity {

    double tax;
    double tip;
    ArrayList<String> items = new ArrayList<>();
    ArrayList<Double> cost = new ArrayList<>();
    Button totalButton;
    EditText taxEdit;
    EditText tipEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_and_tip);

        totalButton = (Button) findViewById(R.id.total);
        taxEdit = (EditText) findViewById(R.id.taxEdit);
        tipEdit = (EditText) findViewById(R.id.tipEdit);

        tax = (double) taxEdit.getInputType();
        tax = (double) taxEdit.getInputType();
        tip = (double) tipEdit.getInputType();

        /* Get the items and cost ArrayList using an intent method */
        Intent listIntent = getIntent();
        items = (ArrayList<String>) listIntent.getSerializableExtra("key");
        cost = (ArrayList<Double>) listIntent.getSerializableExtra("key2");

        //TextView textView = (TextView) findViewById(R.id.totalValue);
        //textView.setText(Double.toString(cost.get(0)));
    }

    public void launchItemsActivity(View view) {
        Intent intent = new Intent(this, Items.class);
        intent.putExtra("key", items);
        intent.putExtra("key2", items);
        intent.putExtra("tax", tax);
        intent.putExtra("tip", tip);
        startActivity(intent);
    }
}
