package com.example.onecheck;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class People extends AppCompatActivity{

    MyRecyclerViewAdapter adapter;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> cost = new ArrayList<>();
    Button mButton;
    EditText mEdit;
    String tax, tip;
    double taxAndTipAmounts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);


        mButton = (Button)findViewById(R.id.addName);
        mEdit   = (EditText)findViewById(R.id.nameInput);

        //Get stuff from previous Combined activity
        Intent listIntent = getIntent();
        items = (ArrayList<String>) listIntent.getSerializableExtra("item");
        cost = (ArrayList<String>) listIntent.getSerializableExtra("cost");
        tax = listIntent.getStringExtra("tax");
        tip = listIntent.getStringExtra("tip");
        taxAndTipAmounts = listIntent.getDoubleExtra("taxandtipamounts", taxAndTipAmounts);


        mButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {

                        if (TextUtils.isEmpty(mEdit.getText().toString())){
                            Toast.makeText(People.this, "Empty field not allowed",
                                    Toast.LENGTH_SHORT).show();
                        }

                        else {
                            String nameInputString = mEdit.getText().toString();
                            int insertIndex = names.size();

                            names.add(nameInputString);
                            adapter.notifyItemInserted(insertIndex);

                            //cleanup
                            mEdit.setText("");
                            closeKeyBoard();
                        }
                    }
                });




        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.people);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, names);
        recyclerView.setAdapter(adapter);
    }

    private void closeKeyBoard(){
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void launchPeopleAndItemsActivity(View view) {
        Intent intent = new Intent(this, PeopleAndItems.class);
        /* putExtra adds extra data to the intent, "key" can be anything you choose */
        intent.putExtra("key", names);
        intent.putExtra("item", items);
        intent.putExtra("cost", cost);
        intent.putExtra("tax", tax);
        intent.putExtra("tip", tip);
        intent.putExtra("taxandtipamounts", taxAndTipAmounts);
        intent.putExtra("namesListSize", names.size());
        startActivity(intent);
    }

    public void launchListViewActivity(View view) {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }



}
