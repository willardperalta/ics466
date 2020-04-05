package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchHistoryActivity(View view) {
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }


    public void launchAddItemActivity(View view) {
        Intent intent = new Intent(this, AddItems.class);
        startActivity(intent);
    }
}
