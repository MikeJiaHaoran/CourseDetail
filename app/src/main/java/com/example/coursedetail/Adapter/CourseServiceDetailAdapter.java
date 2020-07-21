package com.example.coursedetail.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Entity.CourseDetailServiceDetail;
import com.example.coursedetail.R;

public class CourseServiceDetailAdapter extends RecyclerView.Adapter {
    private String[] content;
    public CourseServiceDetailAdapter(String[] content) {
        this.content = content;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_service_detail, parent, false);

        return new CourseDetailServiceDetail(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CourseDetailServiceDetail courseDetailServiceDetail = (CourseDetailServiceDetail) holder;
        courseDetailServiceDetail.setData(content, position);
    }

    @Override
    public int getItemCount() {
        return Integer.parseInt(content[0]);
    }
}
