package com.example.coursedetail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.entity.CourseDetailServiceDetail;
import com.example.coursedetail.model.course.CourseDetailService;
import com.example.coursedetail.R;

import java.util.List;

public class CourseServiceDetailAdapter extends RecyclerView.Adapter {
    private List<CourseDetailService> courseDetailServices;
    public CourseServiceDetailAdapter(List<CourseDetailService> courseDetailServices) {
        this.courseDetailServices = courseDetailServices;
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
        courseDetailServiceDetail.setData(courseDetailServices.get(position).getName(), courseDetailServices.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return courseDetailServices.size();
    }
}
