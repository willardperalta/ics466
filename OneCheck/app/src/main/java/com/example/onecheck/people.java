package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class People extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);


    }


    public void launchPeopleAndItemsActivity(View view) {
        Intent intent = new Intent(this, PeopleAndItems.class);
        startActivity(intent);
    }
}
