package com.example.coursedetail.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.coursedetail.Entity.ItemDetail1;
import com.example.coursedetail.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    private Context context;
    private List<Integer> data = new ArrayList<>();
    private List<Integer> images1 = new ArrayList<>();

    public RVAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        Integer [] array = {R.array.item1};
        Integer [] image1 = {R.drawable.zhaoyang, R.drawable.icon_teacher_detail_back_per, R.drawable.coursedetails_share_icon_gray};
        Collections.addAll(data, array);
        Collections.addAll(images1, image1);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = inflater.inflate(R.layout.item_detail1, parent, false);

        return new ItemDetail1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemDetail1 detail1 = (ItemDetail1) holder;

        Glide.with(context).load(images1.get(0)).into(detail1.imTitleImage);
        Glide.with(context).load(images1.get(1)).into(detail1.imBackButton);
        Glide.with(context).load(images1.get(2)).into(detail1.imShareButton);
        String[] item1 = context.getResources().getStringArray(R.array.item1);
        detail1.tvItem1Text1.setText(item1[0]);
        detail1.tvItem1Text2.setText(item1[1]);
        detail1.tvItem1Text3.setText(item1[2]);
        detail1.tvItem1Money.setText(String.format("%s%s", getYen(), item1[5]));
        detail1.tvItem1Num.setText(item1[4]);
        detail1.rbDifficultStar.setNumStars(Integer.parseInt(item1[3]));
        detail1.rbDifficultStar.setRating(Integer.parseInt(item1[3]));
        Drawable drawable = context.getResources().getDrawable(R.drawable.ic_course_card_audition_tag);
        drawable.setBounds(0,0,50,50);
        detail1.tvItem1Audition.setCompoundDrawables(drawable, null, null, null);
        String[] item2 = context.getResources().getStringArray(R.array.item2);
        detail1.tvServiceList1.setText(item2[1]);
        detail1.tvServiceList1.setBackgroundResource(R.drawable.shape_corners_service_list);
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

        detail1.tvServiceList2.setText(buffer.toString());

        detail1.imBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "已经返回首页", Toast.LENGTH_SHORT).show();
            }
        });

        detail1.imShareButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(context, "已经分享至微信", Toast.LENGTH_SHORT).show();
            }
        });

        detail1.tvItem1Audition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "下面请收听XXX课程", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getYen(){
        return String.valueOf(Html.fromHtml("&yen"));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
