package com.example.coursedetail.entity;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.fragment.StudentEvaluateDialogFragment;
import com.example.coursedetail.model.coursedetail.CourseDetail;
import com.example.coursedetail.model.coursedetail.EvaluateTag;
import com.example.coursedetail.model.coursedetail.Evaluation;
import com.example.coursedetail.R;
import com.google.android.flexbox.FlexboxLayout;
import com.google.gson.Gson;

import java.util.List;

public class CourseDetailStudentsEvaluate extends RecyclerView.ViewHolder {
    private TextView tvEvaluateTitle;
    private TextView tvEvaluatePercent;
    private FlexboxLayout flex_box_layoutEvaluateDetail;
    private ConstraintLayout clStudentsEvaluate;
    private boolean flag;
    private View itemView;

    public CourseDetailStudentsEvaluate(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        tvEvaluateTitle = itemView.findViewById(R.id.tv_evaluate_title);
        tvEvaluatePercent = itemView.findViewById(R.id.tv_evaluate_percent);
        flex_box_layoutEvaluateDetail = itemView.findViewById(R.id.fl_evaluate_detail);
        clStudentsEvaluate = itemView.findViewById(R.id.cl_students_evaluate);
        flag = false;
    }

    @SuppressLint("ResourceAsColor")
    public void setData(final CourseDetail courseDetail) {
        if (!flag) {
            //String[] content = itemView.getContext().getResources().getStringArray(R.array.item_students);
            Gson gson = new Gson();
           // Log.e("evaluate data", courseDetail.getResult().getData().getEvaluation().toString());
            Evaluation evaluation = gson.fromJson(new Gson().toJson(courseDetail.getResult().getData().getEvaluation()), Evaluation.class);
            List<EvaluateTag> evaluateTagList = evaluation.getEvaluateTag();
            tvEvaluateTitle.setText(evaluation.getTitle());
            tvEvaluatePercent.setText(evaluation.getEvaluationRate());

            for (int i = 0; i < evaluateTagList.size(); i++) {
                TextView textView = new TextView(itemView.getContext());
                textView.setGravity(Gravity.CENTER);
                textView.setText(evaluateTagList.get(i).getName());
                textView.setTextSize(12);
                textView.setTextColor(R.color.greyword);
                textView.setBackgroundResource(R.drawable.bg_teacher_detail_evaluation_lable);
                flex_box_layoutEvaluateDetail.addView(textView);
                FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) textView.getLayoutParams();
                lp.setMargins(24, 24, 0,0);
                textView.setLayoutParams(lp);
            }
            flag = true;
        }

        clStudentsEvaluate.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Gson gson = new Gson();
                Evaluation evaluation = gson.fromJson(new Gson().toJson(courseDetail.getResult().getData().getEvaluation()), Evaluation.class);
                StudentEvaluateDialogFragment studentEvaluateDialogFragment = new StudentEvaluateDialogFragment(evaluation.getMoreEvaluation());
                studentEvaluateDialogFragment.show(((AppCompatActivity)itemView.getContext()).getSupportFragmentManager(), "");
            }
        });

    }
}
