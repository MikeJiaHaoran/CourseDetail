package com.example.coursedetail.entity;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.R;

public class CourseDetailServiceDetail extends RecyclerView.ViewHolder {
    private TextView tvCourseServiceDetailTitle;
    private TextView tvCourseServiceDetailContent;

    public CourseDetailServiceDetail(@NonNull View itemView) {
        super(itemView);

        tvCourseServiceDetailTitle = itemView.findViewById(R.id.tv_Course_Service_Detail_Title);
        tvCourseServiceDetailContent = itemView.findViewById(R.id.tv_Course_Service_Detail_Content);
    }

    public void setData(String name, String content) {
        tvCourseServiceDetailTitle.setText(name);
        tvCourseServiceDetailContent.setText(content);
       // Log.e("name", name );
       // Log.e("content", content );
    }
}
