package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class People extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String[] myDataset = new String[] {"bob", "michelle", "jake"};
        String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
                "WebOS","Ubuntu","Windows7","Max OS X"};

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

    }


    public void launchPeopleAndItemsActivity(View view) {
        Intent intent = new Intent(this, PeopleAndItems.class);
        startActivity(intent);
    }
}
