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

public class ItemDetail1 extends RecyclerView.ViewHolder {
    private ImageView imTitleImage;
    private ImageView imBackButton;
    private ImageView imShareButton;
    private TextView tvItem1Text1;
    private TextView tvItem1Text2;
    private TextView tvItem1Text3;
    private TextView tvItem1Money;
    private TextView tvItem1Num;
    private RatingBar rbDifficultStar;
    private TextView tvItem1Audition;
    private TextView tvServiceList1;
    private TextView tvServiceList2;

    public ItemDetail1(@NonNull View itemView) {
        super(itemView);

        imTitleImage = itemView.findViewById(R.id.iv_title_image);
        imBackButton = itemView.findViewById(R.id.iv_back_button);
        imShareButton = itemView.findViewById(R.id.iv_share_button);
        tvItem1Text1 = itemView.findViewById(R.id.tv_item1_text1);
        tvItem1Text2 = itemView.findViewById(R.id.tv_item1_text2);
        tvItem1Text3 = itemView.findViewById(R.id.tv_item1_text3);
        tvItem1Money = itemView.findViewById(R.id.tv_item1_money);
        tvItem1Num = itemView.findViewById(R.id.tv_item1_num);
        rbDifficultStar = itemView.findViewById(R.id.difficult_stars);
        tvItem1Audition = itemView.findViewById(R.id.tv_item1_audition);
        tvServiceList1 = itemView.findViewById(R.id.tv_service_list1);
        tvServiceList2 = itemView.findViewById(R.id.tv_service_list2);

    }

    public void setData(final Context context, List<Integer> images1) {
        Glide.with(context).load(images1.get(0)).into(imTitleImage);
        Glide.with(context).load(images1.get(1)).into(imBackButton);
        Glide.with(context).load(images1.get(2)).into(imShareButton);
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
        String[] item2 = context.getResources().getStringArray(R.array.item2);
        tvServiceList1.setText(item2[1]);
        tvServiceList1.setBackgroundResource(R.drawable.shape_corners_service_list);
        String[] item3 = context.getResources().getStringArray(R.array.item3);

        int num;
        if (Integer.parseInt(item3[0]) > 4) {
            num = 4;
        }
        else {
            num = Integer.parseInt(item3[0]);
        }

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (i == num - 1) {
                buffer.append(item3[2 * i + 1]);
                break;
            }
            buffer.append(item3[2 * i + 1]).append("·");
        }

        tvServiceList2.setText(buffer.toString());

        imBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "已经返回首页", Toast.LENGTH_SHORT).show();
            }
        });

        imShareButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(context, "已经分享至微信", Toast.LENGTH_SHORT).show();
            }
        });

        tvItem1Audition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "下面请收听XXX课程", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getYen(){
        return String.valueOf(Html.fromHtml("&yen"));
    }
}
