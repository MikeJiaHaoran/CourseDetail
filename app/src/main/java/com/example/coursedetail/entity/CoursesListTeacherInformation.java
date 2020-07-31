package com.example.coursedetail.entity;

import android.content.Intent;
import android.graphics.Paint;
import android.media.Rating;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.R;
import com.example.coursedetail.View.CoursesListTeacherInfo;
import com.example.coursedetail.activity.CourseDetailActivity;
import com.example.coursedetail.activity.CourseListActivity;
import com.example.coursedetail.model.coursesList.CoursesList;

import org.w3c.dom.Text;

public class CoursesListTeacherInformation extends RecyclerView.ViewHolder {

    private TextView tvCoursesName;
    private TextView tvSchoolTimeName;
    private TextView tvCoursesDifficult;
    private RatingBar difficultStars;
    private CoursesListTeacherInfo viewTeacherInfo;
    private CoursesListTeacherInfo viewAssistTeacherInfo;
    private CoursesListTeacherInfo viewForeignTeacherInfo;
    private TextView tvDescNum;
    private TextView tvResaleMoney;
    private TextView tvOriginalSaleMoney;
    private ConstraintLayout clCourseListInfo;
    private View itemView;

    public CoursesListTeacherInformation(@NonNull View itemView) {
        super(itemView);
        tvCoursesName = itemView.findViewById(R.id.tv_courses_name);
        tvSchoolTimeName = itemView.findViewById(R.id.tv_school_time_name);
        tvCoursesDifficult = itemView.findViewById(R.id.tv_courses_difficult);
        difficultStars = itemView.findViewById(R.id.difficult_stars);
        viewTeacherInfo = itemView.findViewById(R.id.view_teacher_info);
        viewAssistTeacherInfo = itemView.findViewById(R.id.view_assist_teacher_info);
        viewForeignTeacherInfo = itemView.findViewById(R.id.view_foreign_teacher_info);
        tvDescNum = itemView.findViewById(R.id.tv_desc_nums);
        tvResaleMoney = itemView.findViewById(R.id.tv_resale_money);
        tvOriginalSaleMoney = itemView.findViewById(R.id.tv_original_sale_money);
        clCourseListInfo = itemView.findViewById(R.id.cl_course_list_info);
        this.itemView = itemView;
    }

    public void setData(final CoursesList coursesList) {

        tvCoursesName.setText(coursesList.getCourseName());

        tvSchoolTimeName.setText(coursesList.getSchoolTimeName());

        tvCoursesDifficult.setText(coursesList.getDifficulty().getTitle());

        difficultStars.setNumStars(Integer.parseInt(coursesList.getDifficulty().getAlias()));
        difficultStars.setRating(Integer.parseInt(coursesList.getDifficulty().getAlias()));

        if (coursesList.getChineseTeacher() != null && coursesList.getChineseTeacher().size() > 0) {
            viewTeacherInfo.setImage(coursesList.getChineseTeacher().get(0).getAvatars().get(0));
            viewTeacherInfo.setTeacherTitle(coursesList.getChineseTeacher().get(0).getTypeName());
            viewTeacherInfo.setTeacherName(coursesList.getChineseTeacher().get(0).getName());
        }

        if (coursesList.getClassCourses().getCounselor() != null) {
            viewAssistTeacherInfo.setImage(coursesList.getClassCourses().getCounselor().getAvatars().get(0));
            viewAssistTeacherInfo.setTeacherTitle(coursesList.getClassCourses().getCounselor().getTypeName());
            viewAssistTeacherInfo.setTeacherName(coursesList.getClassCourses().getCounselor().getName());
        }

        if (coursesList.getForeignTeacher() != null && coursesList.getForeignTeacher().size() > 0) {
            viewForeignTeacherInfo.setImage(coursesList.getForeignTeacher().get(0).getAvatars().get(0));
            viewForeignTeacherInfo.setTeacherTitle(coursesList.getForeignTeacher().get(0).getTypeName());
            viewForeignTeacherInfo.setTeacherName(coursesList.getForeignTeacher().get(0).getName());
        }

        tvDescNum.setText(String.format("距停售剩两天 · %s", coursesList.getClassCourses().getNumDesc()));

        tvResaleMoney.setText(String.format("%s%s%s", coursesList.getPrice().getPrefix(), coursesList.getPrice().getResale(), coursesList.getPrice().getSuffix()));

        if (!coursesList.getPrice().getResale().equals(coursesList.getPrice().getOriginPrice())) {
            tvOriginalSaleMoney.setText(String.format("%s%s%s", coursesList.getPrice().getPrefix(), coursesList.getPrice().getOriginPrice(), coursesList.getPrice().getSuffix()));
            tvOriginalSaleMoney.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
        }

        clCourseListInfo.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Intent intent = new Intent(itemView.getContext(), CourseDetailActivity.class);
                intent.putExtra("courseId", coursesList.getCourseId());
                itemView.getContext().startActivity(intent);
            }
        });

    }
}
