package com.example.coursedetail.Entity;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.R;

public class CourseDetailService1 extends RecyclerView.ViewHolder {
    private TextView tvServiceList1;

    public CourseDetailService1(@NonNull View itemView) {
        super(itemView);
        tvServiceList1 = itemView.findViewById(R.id.tv_service_list1);
    }

    public void setData(final Context context) {
        String[] item2 = context.getResources().getStringArray(R.array.item2);
        tvServiceList1.setText(item2[1]);
        tvServiceList1.setBackgroundResource(R.drawable.shape_corners_service_list);
    }
}