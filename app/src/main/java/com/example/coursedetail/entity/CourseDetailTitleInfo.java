package com.example.coursedetail.entity;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.model.course.CourseDetail;
import com.example.coursedetail.R;

public class CourseDetailTitleInfo extends RecyclerView.ViewHolder {
    private TextView tvItem1Text1;
    private TextView tvItem1Text2;
    private TextView tvItem1Text3;
    private TextView tvItem1Money;
    private TextView tvItem1Num;
    private RatingBar rating_barDifficultStar;
    private TextView tvItem1Audition;
    private View itemView;

    public CourseDetailTitleInfo(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        tvItem1Text1 = itemView.findViewById(R.id.tv_item1_text1);
        tvItem1Text2 = itemView.findViewById(R.id.tv_item1_text2);
        tvItem1Text3 = itemView.findViewById(R.id.tv_item1_text3);
        tvItem1Money = itemView.findViewById(R.id.tv_item1_money);
        tvItem1Num = itemView.findViewById(R.id.tv_item1_num);
        rating_barDifficultStar = itemView.findViewById(R.id.difficult_stars);
        tvItem1Audition = itemView.findViewById(R.id.tv_item1_audition);
    }

    public void setData(CourseDetail courseDetail) {
       // final String[] item1 = itemView.getContext().getResources().getStringArray(R.array.item1);
        //subtitle
        tvItem1Text1.setText(courseDetail.getResult().getData().getSubtitle());
        //courseName
        tvItem1Text2.setText(courseDetail.getResult().getData().getCourseName());
        //schoolTimeName
        tvItem1Text3.setText(courseDetail.getResult().getData().getSchoolTimeName());
        //price/resale
        tvItem1Money.setText(String.format("%s%s", getYen(), courseDetail.getResult().getData().getPrice().getResale()));
        //class/numDesc
        tvItem1Num.setText(courseDetail.getResult().getData().getCourseClass().getNumDesc());
        //difficulty/alias
        rating_barDifficultStar.setNumStars(Integer.parseInt(courseDetail.getResult().getData().getDifficulty().getAlias()));
        rating_barDifficultStar.setRating(Integer.parseInt(courseDetail.getResult().getData().getDifficulty().getAlias()));
        Drawable drawable = itemView.getContext().getResources().getDrawable(R.drawable.ic_course_card_audition_tag);
        drawable.setBounds(0,0,50,50);
        tvItem1Audition.setCompoundDrawables(drawable, null, null, null);
        tvItem1Audition.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Toast.makeText(itemView.getContext(), "下面请收听XXX课程", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getYen(){
        return String.valueOf(Html.fromHtml("&yen"));
    }
}
