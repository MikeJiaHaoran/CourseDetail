package com.example.coursedetail.Entity;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.R;

public class CourseDetailService2 extends RecyclerView.ViewHolder {
    private TextView tvServiceList2;

    public CourseDetailService2(@NonNull View itemView) {
        super(itemView);
        tvServiceList2 = itemView.findViewById(R.id.tv_service_list2);
    }

    public void setData(final Context context) {
        String[] item3 = context.getResources().getStringArray(R.array.item3);

        int num;
        if (Integer.parseInt(item3[0]) > 4) {
            num = 4;
        }
        else {
            num = Integer.parseInt(item3[0]);
        }

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (i == num - 1) {
                buffer.append(item3[2 * i + 1]);
                break;
            }
            buffer.append(item3[2 * i + 1]).append("·");
        }

        tvServiceList2.setText(buffer.toString());
    }
}
