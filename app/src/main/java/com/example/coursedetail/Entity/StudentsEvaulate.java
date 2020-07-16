package com.example.coursedetail.Entity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.R;
import com.google.android.flexbox.FlexboxLayout;

public class StudentsEvaulate extends RecyclerView.ViewHolder {
    private TextView tv_evaluate_title;
    private TextView tv_evaluate_percent;
    private FlexboxLayout fl_evaluate_detail;

    public StudentsEvaulate(@NonNull View itemView) {
        super(itemView);
        tv_evaluate_title = itemView.findViewById(R.id.tv_evaluate_title);
        tv_evaluate_percent = itemView.findViewById(R.id.tv_evaluate_percent);
        fl_evaluate_detail = itemView.findViewById(R.id.fl_evaluate_detail);
    }

    @SuppressLint("ResourceAsColor")
    public void setData(final Context context) {
        String[] content = context.getResources().getStringArray(R.array.item_students);
        tv_evaluate_title.setText(content[0]);
        tv_evaluate_percent.setText(content[1]);

        for (int i = 2; i < content.length; i++) {
            TextView textView = new TextView(context);
            textView.setGravity(Gravity.CENTER);
            textView.setText(content[i]);
            textView.setTextSize(12);
            textView.setTextColor(R.color.greyword);
            textView.setBackgroundResource(R.drawable.bg_teacher_detail_evaluation_lable);
            fl_evaluate_detail.addView(textView);
            FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) textView.getLayoutParams();
            lp.setMargins(24, 24, 0,0);
            textView.setLayoutParams(lp);
        }
    }
}
