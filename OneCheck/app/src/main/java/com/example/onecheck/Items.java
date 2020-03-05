package com.example.onecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Items extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;
    ArrayList<String> items = new ArrayList<>();
    ArrayList<Integer> cost = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
    }

    public void launchPeopleActivity(View view) {
        Intent intent = new Intent(this, People.class);
        startActivity(intent);
    }
}
