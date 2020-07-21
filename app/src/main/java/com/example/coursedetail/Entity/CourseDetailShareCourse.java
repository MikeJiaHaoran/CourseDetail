package com.example.coursedetail.Entity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.coursedetail.R;

public class CourseDetailShareCourse extends RecyclerView.ViewHolder {

    private ImageView imShareDetail;
    private TextView tvShareDetail;
    private ConstraintLayout clShareDetail;
    private View itemView;

    public CourseDetailShareCourse(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        imShareDetail = itemView.findViewById(R.id.im_share_detail);
        tvShareDetail = itemView.findViewById(R.id.tv_share_detail);
        clShareDetail = itemView.findViewById(R.id.cl_share_detail);
    }

    public void setData(Integer image, String text) {

        Glide.with(itemView.getContext()).load(image).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(imShareDetail);
        tvShareDetail.setText(text);
        clShareDetail.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Toast.makeText(itemView.getContext(), "已经分享成功", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
