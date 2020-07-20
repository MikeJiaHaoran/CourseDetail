package com.example.coursedetail.Entity;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.coursedetail.Fragment.ShareCourseFragment;
import com.example.coursedetail.R;

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

    public void setData( List<Integer> images1) {
        Glide.with(itemView.getContext()).load(images1.get(0)).into(imTitleImage);
        Glide.with(itemView.getContext()).load(images1.get(1)).into(imBackButton);
        Glide.with(itemView.getContext()).load(images1.get(2)).into(imShareButton);

        imBackButton.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Toast.makeText(itemView.getContext(), "已经返回首页", Toast.LENGTH_SHORT).show();
            }
        });

        imShareButton.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                ShareCourseFragment shareCourseFragment = new ShareCourseFragment();
                shareCourseFragment.show(((AppCompatActivity) itemView.getContext()).getSupportFragmentManager(),"");
                //Toast.makeText(itemView.getContext(), "已经分享至微信", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
