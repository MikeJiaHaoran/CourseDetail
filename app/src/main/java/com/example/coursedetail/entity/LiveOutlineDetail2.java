package com.example.coursedetail.entity;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.coursedetail.R;

public class LiveOutlineDetail2 extends RecyclerView.ViewHolder {

    private TextView tvLiveOutlineTitle2;
    private TextView tvLiveOutlineCourseName2;
    private TextView tvLiveOutlineCourseDate2;

    public LiveOutlineDetail2(@NonNull View itemView) {
        super(itemView);
        tvLiveOutlineTitle2 = itemView.findViewById(R.id.tv_live_outline_title2);
        tvLiveOutlineCourseName2 = itemView.findViewById(R.id.tv_live_outline_course_name2);
        tvLiveOutlineCourseDate2 = itemView.findViewById(R.id.tv_live_outline_course_date2);
    }

    public void setData(String title, String name, String date) {
        tvLiveOutlineTitle2.setText(title);
        tvLiveOutlineCourseName2.setText(name);
        tvLiveOutlineCourseDate2.setText(date);
    }

}
