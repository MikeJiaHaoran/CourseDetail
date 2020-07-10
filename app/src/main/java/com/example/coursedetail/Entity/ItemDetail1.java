package com.example.coursedetail.Entity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    public ItemDetail1(@NonNull View itemView) {
        super(itemView);
    }
}
