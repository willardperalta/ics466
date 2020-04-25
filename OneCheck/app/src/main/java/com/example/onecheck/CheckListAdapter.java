package com.example.onecheck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CheckListAdapter extends RecyclerView.Adapter<CheckListAdapter.CheckViewHolder> {

    private final LayoutInflater mInflator;
    private List<Check> mChecks;

    CheckListAdapter(Context context) {
        mInflator = LayoutInflater.from(context);
    }

    @Override
    public CheckViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
        View itemView = mInflator.inflate(R.layout.recyclerview_row, parent, false);
        return new CheckViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CheckViewHolder holder, int position) {
        if (mChecks != null) {
            Check current = mChecks.get(position);
            holder.checkItemView.setText(current.getName());
        } else {
            holder.checkItemView.setText("No Check");
        }
    }

    void setChecks (List<Check> checks) {
        mChecks = checks;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mChecks != null)
            return mChecks.size();
        else return 0;
    }

    class CheckViewHolder extends RecyclerView.ViewHolder {
        private final TextView checkItemView;

        private CheckViewHolder(View itemView) {
            super(itemView);
            checkItemView = itemView.findViewById(R.id.textView);
        }
    }
}
