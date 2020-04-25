package com.example.onecheck;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CheckHistory extends AppCompatActivity {
    private CheckViewModel mcheckViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_history);

       RecyclerView recyclerView = findViewById(R.id.recyclerView);
       final CheckListAdapter adapter = new CheckListAdapter(this);
       recyclerView.setAdapter(adapter);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
