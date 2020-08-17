package com.example.coursedetail.entity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.coursedetail.activity.CourseListActivity;
import com.example.coursedetail.fragment.ShareCourseFragment;
import com.example.coursedetail.R;
import com.example.coursedetail.model.coursedetail.GroupOnCourseInfo;

import java.util.List;

public class CourseDetailTitleImage extends RecyclerView.ViewHolder {
    private ImageView imTitleImage;
    private  View itemView;

    public CourseDetailTitleImage(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        imTitleImage = itemView.findViewById(R.id.iv_title_image);
    }

    public void setData(List<Integer> images1, GroupOnCourseInfo groupOnCourseInfo) {

        if (groupOnCourseInfo != null) {
            Glide.with(itemView.getContext()).load(groupOnCourseInfo.getImgInfos().get(0)).into(imTitleImage);
        }
        else {
            Glide.with(itemView.getContext()).load(images1.get(0)).into(imTitleImage);
        }
    }
}
