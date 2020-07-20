package com.example.coursedetail.Entity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.R;

public class CourseServiceDetail extends RecyclerView.ViewHolder {
    private TextView tvCourseServiceDetailTitle;
    private TextView tvCourseServiceDetailContent;

    public CourseServiceDetail(@NonNull View itemView) {
        super(itemView);

        tvCourseServiceDetailTitle = itemView.findViewById(R.id.tv_Course_Service_Detail_Title);
        tvCourseServiceDetailContent = itemView.findViewById(R.id.tv_Course_Service_Detail_Content);
    }

    public void setData(String[] content, int position) {
        tvCourseServiceDetailTitle.setText(content[position * 2 + 1]);
        tvCourseServiceDetailContent.setText(content[position * 2 + 2]);
    }
}
