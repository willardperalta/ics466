package com.example.onecheck;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class TaxAndTip extends AppCompatActivity {

    String tax;
    String tip;
    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> cost = new ArrayList<>();
    Button confirmButton;
    EditText taxEdit;
    EditText tipEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_and_tip);

        confirmButton = (Button) findViewById(R.id.confirm);
        taxEdit = (EditText) findViewById(R.id.taxEdit);
        tipEdit = (EditText) findViewById(R.id.tipEdit);

        confirmButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        tax = taxEdit.getText().toString();
                        tip = tipEdit.getText().toString();

                        // Tell User that tax and tip was added
                        Context context = getApplicationContext();
                        CharSequence text = "Tax and Tip Added";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.setGravity(Gravity.TOP|Gravity.LEFT, 500, 1500);
                        toast.show();
                    }
                });

        /* Get the items and cost ArrayList using an intent method */
        Intent listIntent = getIntent();
        items = (ArrayList<String>) listIntent.getSerializableExtra("item");
        cost = (ArrayList<String>) listIntent.getSerializableExtra("cost");

        //TextView textView = (TextView) findViewById(R.id.totalValue);
        //textView.setText(Double.toString(cost.get(0)));
    }

    public void launchItemsActivity(View view) {
        Intent intent = new Intent(this, Items.class);
        intent.putExtra("item", items);
        intent.putExtra("cost", cost);
        intent.putExtra("tax", tax);
        intent.putExtra("tip", tip);
        startActivity(intent);
    }
}
