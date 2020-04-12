package com.example.onecheck;

import android.view.View;

public class RecycleRowOnClick implements MyRecyclerViewAdapter2.ItemClickListener {
    public void onItemClick(View view, int position) {
        System.out.println("RECYCLERVIEW POSITION: " + position);
    }

}
