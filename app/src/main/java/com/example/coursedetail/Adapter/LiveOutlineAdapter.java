package com.example.coursedetail.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Entity.LiveOutlineDetail1;
import com.example.coursedetail.Entity.LiveOutlineDetail2;
import com.example.coursedetail.R;

public class LiveOutlineAdapter extends RecyclerView.Adapter {

    private String[] content;

    public LiveOutlineAdapter(String[] content) {
        this.content = content;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType < 2) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_live_outline_detail1, parent, false);
            return new LiveOutlineDetail1(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_live_outline_detail2, parent, false);

            return new LiveOutlineDetail2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof LiveOutlineDetail1) {
            LiveOutlineDetail1 liveOutlineDetail1 = (LiveOutlineDetail1) holder;
            liveOutlineDetail1.setData(content[position * 2 + 1], content[position * 2 + 2]);
        }
        if (holder instanceof LiveOutlineDetail2) {
            LiveOutlineDetail2 liveOutlineDetail2 = (LiveOutlineDetail2) holder;
            liveOutlineDetail2.setData(content[4 + (position - 2) * 3 + 1], content[4 + (position - 2) * 3 + 2], content[4 + (position - 2) * 3 + 3]);
        }

    }

    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return Integer.parseInt(content[0]);
    }
}
