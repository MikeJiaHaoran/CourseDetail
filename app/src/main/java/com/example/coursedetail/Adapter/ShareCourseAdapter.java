package com.example.coursedetail.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Entity.ShareCourse;
import com.example.coursedetail.R;

public class ShareCourseAdapter extends RecyclerView.Adapter {

    private String[] content = {"微信好友", "微信朋友圈", "QQ好友", "QQ控件","复制链接"};
    private Integer[] image = {R.drawable.ic_share_course_detail_wechat, R.drawable.ic_share_course_detail_wechatgroup, R.drawable.ic_share_course_detail_qq,
    R.drawable.ic_share_course_detail_qqshare, R.drawable.ic_share_course_detail_download};

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item_share_detail, parent, false);

        return new ShareCourse(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ShareCourse shareCourse = (ShareCourse) holder;
        shareCourse.setData(image[position], content[position]);

    }

    @Override
    public int getItemCount() {
        return content.length;
    }
}
