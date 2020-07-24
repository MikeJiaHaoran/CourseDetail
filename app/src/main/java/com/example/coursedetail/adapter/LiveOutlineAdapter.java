package com.example.coursedetail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.entity.LiveOutlineDetail1;
import com.example.coursedetail.entity.LiveOutlineDetail2;
import com.example.coursedetail.model.course.LiveSyllabus;
import com.example.coursedetail.R;

public class LiveOutlineAdapter extends RecyclerView.Adapter {

    private LiveSyllabus liveSyllabus;
    private int count;

    public LiveOutlineAdapter(LiveSyllabus liveSyllabus, int count) {
        this.liveSyllabus = liveSyllabus;
        this.count = count;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType < liveSyllabus.getList().size() - liveSyllabus.getCount()) {
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
            liveOutlineDetail1.setData(liveSyllabus.getList().get(position).getSerialNo(), liveSyllabus.getList().get(position).getScheduleName());
        }
        if (holder instanceof LiveOutlineDetail2) {
            LiveOutlineDetail2 liveOutlineDetail2 = (LiveOutlineDetail2) holder;
            liveOutlineDetail2.setData(liveSyllabus.getList().get(position).getSerialNo(), liveSyllabus.getList().get(position).getScheduleName(),
            liveSyllabus.getList().get(position).getScheduleTime());
        }

    }

    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return count;
    }
}
