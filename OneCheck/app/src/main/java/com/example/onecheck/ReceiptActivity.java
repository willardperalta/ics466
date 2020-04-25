package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
    }


    public void launchCombinedActivity(View view) {
        Intent intent = new Intent(this, CombinedActivity.class);
        startActivity(intent);
    }
}
