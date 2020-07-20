package com.example.coursedetail.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Entity.CourseDetailService1;
import com.example.coursedetail.Entity.CourseDetailService2;
import com.example.coursedetail.Entity.CourseDetailTitleImage;
import com.example.coursedetail.Entity.CourseDetailWebview;
import com.example.coursedetail.Entity.CourseDetailTitleInfo;
import com.example.coursedetail.Entity.StudentEvaluate;
import com.example.coursedetail.Entity.StudentEvaluateMore;
import com.example.coursedetail.Entity.StudentsEvaluate;
import com.example.coursedetail.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseDetailAdapter extends RecyclerView.Adapter {
    private static final int TYPE_IMAGE = 0;
    private static final int TYPE_INFO = 1;
    private static final int TYPE_SERVICE1 = 2;
    private static final int TYPE_SERVICE2 = 3;
    private static final int TYPE_Students = 4;
    private static final int TYPE_Student = 5;
    private static final int TYPE_More = 6;
    private static final int TYPE_WEB = 7;
    private List<Integer> data = new ArrayList<>();
    private List<Integer> images1 = new ArrayList<>();

    public CourseDetailAdapter() {
        Integer [] array = {R.array.title_image,R.array.item1, R.array.item2, R.array.item3, R.array.item_students, R.array.item_student_detail, R.array.item_evaluate_more, R.array.course_detail_webview};
        Integer [] image1 = {R.drawable.zhaoyang, R.drawable.icon_teacher_detail_back_per, R.drawable.coursedetails_share_icon_gray};
        Collections.addAll(data, array);
        Collections.addAll(images1, image1);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_IMAGE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);

            return new CourseDetailTitleImage(view);
        }
        else if (viewType == TYPE_INFO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info, parent, false);

            return new CourseDetailTitleInfo(view);
        }
        else if (viewType == TYPE_SERVICE1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service1, parent, false);

            return new CourseDetailService1(view);
        }
        else if (viewType == TYPE_SERVICE2) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service2, parent, false);

            return new CourseDetailService2(view);
        }
        else if (viewType == TYPE_WEB) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_webview, parent, false);

            return new CourseDetailWebview(view);
        }
        else if (viewType == TYPE_Students) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_students_evaluate, parent, false);

            return new StudentsEvaluate(view);
        }
        else if (viewType == TYPE_Student) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_evaluate, parent, false);

            return new StudentEvaluate(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_evaluate_more, parent, false);

            return new StudentEvaluateMore(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CourseDetailTitleImage) {
            CourseDetailTitleImage courseDetailTitleImage = (CourseDetailTitleImage) holder;
            courseDetailTitleImage.setData(images1);
        }

        if (holder instanceof CourseDetailTitleInfo) {
            CourseDetailTitleInfo courseDetailTitleInfo = (CourseDetailTitleInfo) holder;
            courseDetailTitleInfo.setData();
        }

        if (holder instanceof CourseDetailService1) {
            CourseDetailService1 courseDetailService1 = (CourseDetailService1) holder;
            courseDetailService1.setData();
        }

        if (holder instanceof CourseDetailService2) {
            CourseDetailService2 courseDetailService2 = (CourseDetailService2) holder;
            courseDetailService2.setData();
        }

        if (holder instanceof CourseDetailWebview) {
            CourseDetailWebview courseDetailWebview = (CourseDetailWebview) holder;
            courseDetailWebview.setData();
        }

        if (holder instanceof StudentsEvaluate) {
            StudentsEvaluate studentsEvaluate = (StudentsEvaluate) holder;
            studentsEvaluate.setData();
        }

        if (holder instanceof StudentEvaluate) {
            StudentEvaluate studentEvaluate = (StudentEvaluate) holder;
            studentEvaluate.setData();
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