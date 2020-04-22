package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.DecimalFormat;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class CombinedActivity extends AppCompatActivity {

    //From AddItems
    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> cost = new ArrayList<>();
    Button addButton;
    EditText itemEdit;
    EditText costEdit;

    //From Tax and Tip
    String tax, tip;
    Button confirmButton;
    EditText taxEdit;
    RadioGroup radioGroup;
    RadioButton radioButton;

    //from Items
    double total;
    String totalText;
    MyRecyclerViewAdapter adapter;
    ArrayList<String> combinedCostAndItems = new ArrayList<>();
    private static DecimalFormat df2 = new DecimalFormat("#.00");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combined);


        /*




        //initialization from additems
        addButton = (Button) findViewById(R.id.addItem);
        itemEdit = (EditText) findViewById(R.id.itemName);
        costEdit = (EditText) findViewById(R.id.itemCost);
        //initialization from taxandtip
        confirmButton = (Button) findViewById(R.id.confirm);
        taxEdit = (EditText) findViewById(R.id.taxEdit);
        radioGroup = findViewById(R.id.radioGroup);

        //add price button onclick listener
        addButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        String itemInputString = itemEdit.getText().toString();
                        String costInput = costEdit.getText().toString();

                        items.add(itemInputString);
                        cost.add(costInput);

                        // Tell User that an item was added
                        Context context = getApplicationContext();
                        CharSequence text = "Item Added";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.setGravity(Gravity.TOP|Gravity.LEFT, 500, 1500);
                        toast.show();

                    }
                });

        //confrim tax and tip button listener
        confirmButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        int radioId = radioGroup.getCheckedRadioButtonId();

                        radioButton = findViewById(radioId);

                        tax = taxEdit.getText().toString();
                        tip = radioButton.getText().toString();

                        // Tell User that tax and tip was added
                        Context context = getApplicationContext();
                        CharSequence text = "Tax and Tip Added";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.setGravity(Gravity.TOP|Gravity.LEFT, 500, 1500);
                        toast.show();
                    }
                });



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
*/
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
        intent.putExtra("tax", tax);
        intent.putExtra("tip", tip);
        startActivity(intent);
    }
}
