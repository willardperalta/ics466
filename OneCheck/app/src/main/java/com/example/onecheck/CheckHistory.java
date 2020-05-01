package com.example.onecheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CheckHistory extends AppCompatActivity {
    private CheckViewModel mcheckViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_history);

        /*
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final CheckListAdapter adapter = new CheckListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mcheckViewModel = new ViewModelProvider(this, null).get(CheckViewModel.class);


        mcheckViewModel.getAllChecks().observe(this, new Observer<List<Check>>() {
            @Override
            public void onChanged(List<Check> checks) {
                //adapter.setChecks(checks);
            }
        });
        */


    }

    public void launchMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void launchPeopleOweMeActivity(View view) {
        Intent intent = new Intent(this, PeopleOweMeActivity.class);
        startActivity(intent);
    }

    public void launchPeopleOweMe2Activity(View view) {
        Intent intent = new Intent(this, PeopleOweMe2Activity.class);
        startActivity(intent);
    }

    public void launchIOwePeopleActivity(View view) {
        Intent intent = new Intent(this, IOwePeopleActivity.class);
        startActivity(intent);
    }
}
