package com.example.coursedetail.entity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.coursedetail.activity.CourseListActivity;
import com.example.coursedetail.fragment.ShareCourseFragment;
import com.example.coursedetail.R;
import com.example.coursedetail.model.courseDetail.CourseDetail;
import com.example.coursedetail.model.courseDetail.GroupOnCourseInfo;

import java.util.List;

public class CourseDetailTitleImage extends RecyclerView.ViewHolder {
    private ImageView imTitleImage;
    private ImageView imBackButton;
    private ImageView imShareButton;
    private  View itemView;

    public CourseDetailTitleImage(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        imTitleImage = itemView.findViewById(R.id.iv_title_image);
        imBackButton = itemView.findViewById(R.id.iv_back_button);
        imShareButton = itemView.findViewById(R.id.iv_share_button);
    }

    public void setData(List<Integer> images1, GroupOnCourseInfo groupOnCourseInfo) {

        if (groupOnCourseInfo != null) {
            Glide.with(itemView.getContext()).load(groupOnCourseInfo.getImgInfos().get(0)).into(imTitleImage);
        }
        else {
            Glide.with(itemView.getContext()).load(images1.get(0)).into(imTitleImage);
        }
        Glide.with(itemView.getContext()).load(images1.get(1)).into(imBackButton);
        Glide.with(itemView.getContext()).load(images1.get(2)).into(imShareButton);

        imBackButton.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Intent intent = new Intent(itemView.getContext(), CourseListActivity.class);
                itemView.getContext().startActivity(intent);
            }
        });

        imShareButton.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                ShareCourseFragment shareCourseFragment = new ShareCourseFragment();
                shareCourseFragment.show(((AppCompatActivity) itemView.getContext()).getSupportFragmentManager(),"");
            }
        });
    }
}
