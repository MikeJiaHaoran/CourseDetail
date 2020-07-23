package com.example.coursedetail.Entity;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.coursedetail.R;
import com.google.android.flexbox.FlexboxLayout;

public class CourseDetailOneStudentEvaluate extends RecyclerView.ViewHolder {
    private ImageView imStudent;
    private TextView tvStudentName;
    private TextView tvEvaluateDate;
    private TextView tvEvaluateResult;
    private FlexboxLayout flex_box_layoutStudentEvaluate;
    private TextView tvEvaluateContent;
    private boolean flag;

    private View itemView;

    public CourseDetailOneStudentEvaluate(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        imStudent = itemView.findViewById(R.id.im_student);
        tvStudentName = itemView.findViewById(R.id.tv_student_name);
        tvEvaluateDate = itemView.findViewById(R.id.tv_evaluate_date);
        tvEvaluateResult = itemView.findViewById(R.id.tv_evaluate_result);
        flex_box_layoutStudentEvaluate = itemView.findViewById(R.id.fl_student_evaluate);
        tvEvaluateContent = itemView.findViewById(R.id.tv_evaluate_content);
        flag = false;
    }

    @SuppressLint("ResourceAsColor")
    public void setData() {
        if (!flag) {
            String[] content = itemView.getContext().getResources().getStringArray(R.array.item_student_detail);
            Glide.with(itemView.getContext()).load(content[0]).into(imStudent);
            tvStudentName.setText(content[1]);
            tvEvaluateDate.setText(content[2]);
            tvEvaluateResult.setText(content[3]);
            tvEvaluateContent.setText(content[4]);

            for (int i = 5; i < content.length; i++) {
                TextView tvEvaluateWord = new TextView(itemView.getContext());
                tvEvaluateWord.setGravity(Gravity.CENTER);
                tvEvaluateWord.setText(content[i]);
                tvEvaluateWord.setTextSize(12);
                tvEvaluateWord.setTextColor(R.color.greyword);
                tvEvaluateWord.setBackgroundResource(R.drawable.bg_teacher_detail_evaluation_lable);
                flex_box_layoutStudentEvaluate.addView(tvEvaluateWord);
                FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) tvEvaluateWord.getLayoutParams();
                lp.setMargins(24, 24, 0,0);
                tvEvaluateWord.setLayoutParams(lp);
            }
            flag = true;
        }

    }
}
