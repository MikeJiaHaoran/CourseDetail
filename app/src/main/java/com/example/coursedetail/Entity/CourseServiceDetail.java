package com.example.coursedetail.Entity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.R;

public class CourseServiceDetail extends RecyclerView.ViewHolder {
    public TextView CourseServiceDetailTitle;
    public TextView CourseServiceDetailContent;

    public CourseServiceDetail(@NonNull View itemView) {
        super(itemView);

        CourseServiceDetailTitle = itemView.findViewById(R.id.tv_Course_Service_Detail_Title);
        CourseServiceDetailContent = itemView.findViewById(R.id.tv_Course_Service_Detail_Content);
    }
}
