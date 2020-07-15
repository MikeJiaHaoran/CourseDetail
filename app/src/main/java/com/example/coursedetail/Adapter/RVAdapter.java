package com.example.coursedetail.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Entity.CourseDetailWebview;
import com.example.coursedetail.Entity.ItemDetail1;
import com.example.coursedetail.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter {
    private static final int TYPE_ITEM1 = 0;
    private static final int TYPE_WEBVIEW = 1;
    private LayoutInflater inflater;
    private Context context;
    private List<Integer> data = new ArrayList<>();
    private List<Integer> images1 = new ArrayList<>();

    public RVAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        Integer [] array = {R.array.item1, R.array.course_detail_webview};
        Integer [] image1 = {R.drawable.zhaoyang, R.drawable.icon_teacher_detail_back_per, R.drawable.coursedetails_share_icon_gray};
        Collections.addAll(data, array);
        Collections.addAll(images1, image1);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM1) {
            View view = inflater.inflate(R.layout.item_detail1, parent, false);

            return new ItemDetail1(view);
        }
        else {
            View view = inflater.inflate(R.layout.item_webview, parent, false);

            return new CourseDetailWebview(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemDetail1) {
            ItemDetail1 detail1 = (ItemDetail1) holder;
            detail1.setData(context, images1);
        }

        if (holder instanceof CourseDetailWebview) {
            CourseDetailWebview courseDetailWebview = (CourseDetailWebview) holder;
            courseDetailWebview.setData(context);
        }

    }

    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
