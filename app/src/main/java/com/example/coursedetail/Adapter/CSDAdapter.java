package com.example.coursedetail.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Entity.CourseServiceDetail;
import com.example.coursedetail.R;

public class CSDAdapter extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    private String[] content;
    public CSDAdapter(String[] content, Context context) {
        this.content = content;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.service_detail_recyclerview, parent, false);

        return new CourseServiceDetail(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CourseServiceDetail courseServiceDetail = (CourseServiceDetail) holder;
        courseServiceDetail.CourseServiceDetailTitle.setText(content[position * 2 + 1]);
        courseServiceDetail.CourseServiceDetailContent.setText(content[position * 2 + 2]);
    }

    @Override
    public int getItemCount() {
        return Integer.parseInt(content[0]);
    }
}
