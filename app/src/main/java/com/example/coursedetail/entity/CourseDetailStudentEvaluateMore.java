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

public class CourseDetailStudentEvaluateMore extends RecyclerView.ViewHolder {

    private ConstraintLayout clStudentMore;

    public CourseDetailStudentEvaluateMore(@NonNull final View itemView, final CourseDetail courseDetail) {
        super(itemView);
        clStudentMore = itemView.findViewById(R.id.cl_student_more);
        clStudentMore.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Evaluation evaluation = courseDetail.getResult().getData().getEvaluation();
                StudentEvaluateDialogFragment studentEvaluateDialogFragment = new StudentEvaluateDialogFragment(evaluation.getMoreEvaluation());
                studentEvaluateDialogFragment.show(((AppCompatActivity)itemView.getContext()).getSupportFragmentManager(), "");
            }
        });
    }
}
