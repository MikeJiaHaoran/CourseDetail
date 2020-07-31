package com.example.coursedetail.entity;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.fragment.StudentEvaluateDialogFragment;
import com.example.coursedetail.model.courseDetail.CourseDetail;
import com.example.coursedetail.model.courseDetail.Evaluation;
import com.example.coursedetail.R;
import com.google.gson.Gson;

public class CourseDetailStudentEvaluateMore extends RecyclerView.ViewHolder {

    private ConstraintLayout clStudentMore;

    public CourseDetailStudentEvaluateMore(@NonNull final View itemView, final CourseDetail courseDetail) {
        super(itemView);
        clStudentMore = itemView.findViewById(R.id.cl_student_more);
        clStudentMore.setOnClickListener(new OnUnDoubleClickListener() {
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
