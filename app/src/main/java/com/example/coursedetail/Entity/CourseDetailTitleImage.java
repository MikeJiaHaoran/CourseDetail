package com.example.coursedetail.Entity;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.coursedetail.R;

import java.util.List;

public class CourseDetailTitleImage extends RecyclerView.ViewHolder {
    private ImageView imTitleImage;
    private ImageView imBackButton;
    private ImageView imShareButton;

    public CourseDetailTitleImage(@NonNull View itemView) {
        super(itemView);
        imTitleImage = itemView.findViewById(R.id.iv_title_image);
        imBackButton = itemView.findViewById(R.id.iv_back_button);
        imShareButton = itemView.findViewById(R.id.iv_share_button);
    }

    public void setData(final Context context, List<Integer> images1) {
        Glide.with(context).load(images1.get(0)).into(imTitleImage);
        Glide.with(context).load(images1.get(1)).into(imBackButton);
        Glide.with(context).load(images1.get(2)).into(imShareButton);

        final ClickSleep clickSleep = new ClickSleep();
        imBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!clickSleep.isRuning()) {
                    Toast.makeText(context, "已经返回首页", Toast.LENGTH_SHORT).show();
                }
                clickSleep.runWithTime(500);
            }
        });

        imShareButton.setOnClickListener(new View.OnClickListener(){
            final ClickSleep clickSleep = new ClickSleep();
            @Override
            public void onClick(View view) {
                if (!clickSleep.isRuning()) {
                    Toast.makeText(context, "已经分享至微信", Toast.LENGTH_SHORT).show();
                    clickSleep.runWithTime(500);
                }
            }
        });
    }
}
