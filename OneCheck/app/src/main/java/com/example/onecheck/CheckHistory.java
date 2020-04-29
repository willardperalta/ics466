package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CheckHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_history);
    }

    public void launchMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void launchPeopleOweMeActivity(View view) {
        Intent intent = new Intent(this, PeopleOweMeActivity.class);
        startActivity(intent);
    }

    public void launchIOwePeopleActivity(View view) {
        Intent intent = new Intent(this, IOwePeopleActivity.class);
        startActivity(intent);
    }
}
