package com.example.onecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddItems extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;
    ArrayList<String> items = new ArrayList<>();
    ArrayList<Float> cost = new ArrayList<>();
    Button addButton;
    EditText itemEdit;
    EditText costEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        addButton = (Button) findViewById(R.id.addItem);
        itemEdit = (EditText) findViewById(R.id.itemName);
        costEdit = (EditText) findViewById(R.id.itemCost);

        addButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        String itemInputString = itemEdit.getText().toString();
                        float costInput = (float)costEdit.getInputType();

                        items.add(itemInputString);
                        cost.add(costInput);
                    }
                });
    }

    public void launchTaxAndTipActivity(View view) {
        Intent intent = new Intent(this, TaxAndTip.class);
        startActivity(intent);
    }
}
