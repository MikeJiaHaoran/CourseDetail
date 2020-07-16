package com.example.coursedetail.Entity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.coursedetail.R;
import com.google.android.flexbox.FlexboxLayout;

public class StudentEvaulate extends RecyclerView.ViewHolder {
    private ImageView im_student;
    private TextView tv_student_name;
    private TextView tv_evaluate_date;
    private TextView tv_evaluate_result;
    private FlexboxLayout fl_student_evaluate;
    private TextView tv_evaluate_content;

    public StudentEvaulate(@NonNull View itemView) {
        super(itemView);
        im_student = itemView.findViewById(R.id.im_student);
        tv_student_name = itemView.findViewById(R.id.tv_student_name);
        tv_evaluate_date = itemView.findViewById(R.id.tv_evaluate_date);
        tv_evaluate_result = itemView.findViewById(R.id.tv_evaluate_result);
        fl_student_evaluate = itemView.findViewById(R.id.fl_student_evaluate);
        tv_evaluate_content = itemView.findViewById(R.id.tv_evaluate_content);
    }

    @SuppressLint("ResourceAsColor")
    public void setData(final Context context) {
        String[] content = context.getResources().getStringArray(R.array.item_student_detail);
        Glide.with(context).load(content[0]).into(im_student);
        tv_student_name.setText(content[1]);
        tv_evaluate_date.setText(content[2]);
        tv_evaluate_result.setText(content[3]);
        tv_evaluate_content.setText(content[4]);

        for (int i = 5; i < content.length; i++) {
            TextView textView = new TextView(context);
            textView.setGravity(Gravity.CENTER);
            textView.setText(content[i]);
            textView.setTextSize(12);
            textView.setTextColor(R.color.greyword);
            textView.setBackgroundResource(R.drawable.bg_teacher_detail_evaluation_lable);
            fl_student_evaluate.addView(textView);
            FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) textView.getLayoutParams();
            lp.setMargins(24, 24, 0,0);
            textView.setLayoutParams(lp);
        }
    }
}
