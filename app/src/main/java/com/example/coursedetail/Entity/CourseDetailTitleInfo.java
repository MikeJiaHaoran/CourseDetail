package com.example.coursedetail.Entity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.coursedetail.R;

import java.util.List;

public class CourseDetailTitleInfo extends RecyclerView.ViewHolder {
    private TextView tvItem1Text1;
    private TextView tvItem1Text2;
    private TextView tvItem1Text3;
    private TextView tvItem1Money;
    private TextView tvItem1Num;
    private RatingBar rbDifficultStar;
    private TextView tvItem1Audition;

    public CourseDetailTitleInfo(@NonNull View itemView) {
        super(itemView);
        tvItem1Text1 = itemView.findViewById(R.id.tv_item1_text1);
        tvItem1Text2 = itemView.findViewById(R.id.tv_item1_text2);
        tvItem1Text3 = itemView.findViewById(R.id.tv_item1_text3);
        tvItem1Money = itemView.findViewById(R.id.tv_item1_money);
        tvItem1Num = itemView.findViewById(R.id.tv_item1_num);
        rbDifficultStar = itemView.findViewById(R.id.difficult_stars);
        tvItem1Audition = itemView.findViewById(R.id.tv_item1_audition);
    }

    public void setData(final Context context) {
        String[] item1 = context.getResources().getStringArray(R.array.item1);
        tvItem1Text1.setText(item1[0]);
        tvItem1Text2.setText(item1[1]);
        tvItem1Text3.setText(item1[2]);
        tvItem1Money.setText(String.format("%s%s", getYen(), item1[5]));
        tvItem1Num.setText(item1[4]);
        rbDifficultStar.setNumStars(Integer.parseInt(item1[3]));
        rbDifficultStar.setRating(Integer.parseInt(item1[3]));
        Drawable drawable = context.getResources().getDrawable(R.drawable.ic_course_card_audition_tag);
        drawable.setBounds(0,0,50,50);
        tvItem1Audition.setCompoundDrawables(drawable, null, null, null);
        tvItem1Audition.setOnClickListener(new View.OnClickListener() {
            ClickSleep clickSleep = new ClickSleep();
            @Override
            public void onClick(View view) {
                if (!clickSleep.isRuning()) {
                    Toast.makeText(context, "下面请收听XXX课程", Toast.LENGTH_SHORT).show();
                    clickSleep.runWithTime(500);
                }
            }
        });
    }

    private String getYen(){
        return String.valueOf(Html.fromHtml("&yen"));
    }
}
