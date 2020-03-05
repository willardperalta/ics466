package com.example.onecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class TaxAndTip extends AppCompatActivity {

    float tax;
    float tip;
    ArrayList<String> items = new ArrayList<>();
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

        tax = (float)taxEdit.getInputType();
        tip = (float)tipEdit.getInputType();

        /* Get the items ArrayList using an intent method */
        Intent listIntent = getIntent();
        items = (ArrayList<String>) listIntent.getSerializableExtra("key");
    }

    public void launchItemsActivity(View view) {
        Intent intent = new Intent(this, Items.class);
        intent.putExtra("key", items);
        startActivity(intent);
    }
}
