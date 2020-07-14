package com.example.coursedetail.Entity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.R;

public class ItemDetail1 extends RecyclerView.ViewHolder {
    public ImageView imTitleImage;
    public ImageView imBackButton;
    public ImageView imShareButton;
    public TextView tvItem1Text1;
    public TextView tvItem1Text2;
    public TextView tvItem1Text3;
    public TextView tvItem1Money;
    public TextView tvItem1Num;
    public RatingBar rbDifficultStar;
    public TextView tvItem1Audition;
    public TextView tvServiceList1;
    public TextView tvServiceList2;

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
}
