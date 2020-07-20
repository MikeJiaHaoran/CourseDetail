package com.example.coursedetail.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Entity.CourseServiceDetail;
import com.example.coursedetail.R;

public class CourseServiceDetailAdapter extends RecyclerView.Adapter {
    private String[] content;
    public CourseServiceDetailAdapter(String[] content) {
        this.content = content;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_detail_recyclerview, parent, false);

        return new CourseServiceDetail(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CourseServiceDetail courseServiceDetail = (CourseServiceDetail) holder;
        courseServiceDetail.setData(content, position);
    }

    @Override
    public int getItemCount() {
        return Integer.parseInt(content[0]);
    }
}
