package com.example.coursedetail.Entity;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.R;

public class StudentEvaulateMore extends RecyclerView.ViewHolder {

    public StudentEvaulateMore(@NonNull View itemView) {
        super(itemView);
        TextView tv_evaluate_more = itemView.findViewById(R.id.tv_evaluate_more);
    }
}
