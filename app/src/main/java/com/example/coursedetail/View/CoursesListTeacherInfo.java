package com.example.coursedetail.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.coursedetail.R;

public class CoursesListTeacherInfo extends ConstraintLayout {

    private ImageView ivTeacher;
    private TextView tvTeacherTitle;
    private TextView tvTeacherName;
    private Context context;

    public CoursesListTeacherInfo(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_courses_list_teacher_info, this);
        ivTeacher = findViewById(R.id.iv_teacher);
        tvTeacherTitle = findViewById(R.id.tv_teacher_title);
        tvTeacherName = findViewById(R.id.tv_teacher_name);
        this.context = context;
    }

    public void setImage(String url) {
        ivTeacher.setBackgroundResource(R.drawable.shape_circle_background_teacher_image);
        Glide.with(context).load(url).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(ivTeacher);
    }

    public void setTeacherTitle(String text) {
        this.tvTeacherTitle.setText(text);
    }

    public void setTeacherName(String text) {
        this.tvTeacherName.setText(text);
    }
}
