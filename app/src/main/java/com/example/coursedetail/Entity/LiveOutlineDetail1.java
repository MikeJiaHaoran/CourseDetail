package com.example.coursedetail.Entity;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.R;

public class LiveOutlineDetail1 extends RecyclerView.ViewHolder {

    private TextView tvLiveOutlineTitle1;
    private TextView tvLiveOutlineCourseName1;

    public LiveOutlineDetail1(@NonNull View itemView) {
        super(itemView);
        tvLiveOutlineTitle1 = itemView.findViewById(R.id.tv_live_outline_title1);
        tvLiveOutlineCourseName1 = itemView.findViewById(R.id.tv_live_outline_course_name1);
    }

    public void setData(String title, String name) {
        tvLiveOutlineTitle1.setText(title);
        tvLiveOutlineCourseName1.setText(name);
    }

}
