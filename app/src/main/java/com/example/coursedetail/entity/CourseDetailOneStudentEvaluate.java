package com.example.coursedetail.entity;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.coursedetail.fragment.StudentEvaluateDialogFragment;
import com.example.coursedetail.model.course.CourseDetail;
import com.example.coursedetail.model.course.Evaluation;
import com.example.coursedetail.model.course.EvaluationList;
import com.example.coursedetail.R;
import com.google.android.flexbox.FlexboxLayout;

public class CourseDetailOneStudentEvaluate extends RecyclerView.ViewHolder {
    private ImageView imStudent;
    private TextView tvStudentName;
    private TextView tvEvaluateDate;
    private FlexboxLayout flex_box_layoutStudentEvaluate;
    private TextView tvEvaluateContent;
    private ConstraintLayout clStudentEvaluate;
    private boolean flag;

    private View itemView;

    public CourseDetailOneStudentEvaluate(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        imStudent = itemView.findViewById(R.id.im_student);
        tvStudentName = itemView.findViewById(R.id.tv_student_name);
        tvEvaluateDate = itemView.findViewById(R.id.tv_evaluate_date);
        flex_box_layoutStudentEvaluate = itemView.findViewById(R.id.fl_student_evaluate);
        tvEvaluateContent = itemView.findViewById(R.id.tv_evaluate_content);
        clStudentEvaluate = itemView.findViewById(R.id.cl_student_evaluate);
        flag = false;
    }

    @SuppressLint("ResourceAsColor")
    public void setData(final CourseDetail courseDetail) {
        if (!flag) {
            //String[] content = itemView.getContext().getResources().getStringArray(R.array.item_student_detail);
            EvaluationList evaluationList = courseDetail.getResult().getData().getEvaluation().getList().get(0);
            Glide.with(itemView.getContext()).load(evaluationList.getAvatar()).into(imStudent);
            tvStudentName.setText(evaluationList.getName());
            tvEvaluateDate.setText(evaluationList.getTime());
            tvEvaluateContent.setText(evaluationList.getContent());

            for (int i = 0; i < evaluationList.getEvaluateTag().size(); i++) {
                TextView tvEvaluateWord = new TextView(itemView.getContext());
                tvEvaluateWord.setGravity(Gravity.CENTER);
                tvEvaluateWord.setText(evaluationList.getEvaluateTag().get(i).getName());
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


        clStudentEvaluate.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Evaluation evaluation = courseDetail.getResult().getData().getEvaluation();
                StudentEvaluateDialogFragment studentEvaluateDialogFragment = new StudentEvaluateDialogFragment(evaluation.getMoreEvaluation());
                studentEvaluateDialogFragment.show(((AppCompatActivity)itemView.getContext()).getSupportFragmentManager(), "");
            }
        });

    }
}
