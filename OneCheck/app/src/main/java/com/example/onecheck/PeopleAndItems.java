package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PeopleAndItems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_and_items);
    }

    public void launchResultsActivity(View view) {
        Intent intent = new Intent(this, Results.class);
        startActivity(intent);
    }
}
