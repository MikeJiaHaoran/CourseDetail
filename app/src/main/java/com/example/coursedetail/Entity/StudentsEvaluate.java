package com.example.coursedetail.Entity;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.R;
import com.google.android.flexbox.FlexboxLayout;

public class StudentsEvaluate extends RecyclerView.ViewHolder {
    private TextView tvEvaluateTitle;
    private TextView tvEvaluatePercent;
    private FlexboxLayout flex_box_layoutEvaluateDetail;
    private View itemView;

    public StudentsEvaluate(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        tvEvaluateTitle = itemView.findViewById(R.id.tv_evaluate_title);
        tvEvaluatePercent = itemView.findViewById(R.id.tv_evaluate_percent);
        flex_box_layoutEvaluateDetail = itemView.findViewById(R.id.fl_evaluate_detail);
    }

    @SuppressLint("ResourceAsColor")
    public void setData() {
        String[] content = itemView.getContext().getResources().getStringArray(R.array.item_students);
        tvEvaluateTitle.setText(content[0]);
        tvEvaluatePercent.setText(content[1]);

        for (int i = 2; i < content.length; i++) {
            TextView textView = new TextView(itemView.getContext());
            textView.setGravity(Gravity.CENTER);
            textView.setText(content[i]);
            textView.setTextSize(12);
            textView.setTextColor(R.color.greyword);
            textView.setBackgroundResource(R.drawable.bg_teacher_detail_evaluation_lable);
            flex_box_layoutEvaluateDetail.addView(textView);
            FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) textView.getLayoutParams();
            lp.setMargins(24, 24, 0,0);
            textView.setLayoutParams(lp);
        }
    }
}
