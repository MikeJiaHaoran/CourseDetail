package com.example.coursedetail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.R;
import com.example.coursedetail.entity.CourseListNoMore;
import com.example.coursedetail.entity.CoursesListTeacherInformation;
import com.example.coursedetail.model.courseslist.CoursesList;

import java.util.List;

public class CoursesListAdapter extends RecyclerView.Adapter {

    private List<CoursesList> coursesListList;

    public CoursesListAdapter(List<CoursesList> coursesListList) {
        this.coursesListList = coursesListList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType >= 0 && viewType < coursesListList.size()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_courses_list_info, parent, false);
            return new CoursesListTeacherInformation(view);
        }
        else if (viewType == coursesListList.size()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_no_more, parent, false);
            return new CourseListNoMore(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CoursesListTeacherInformation) {
            CoursesListTeacherInformation coursesListTeacherInformation = (CoursesListTeacherInformation) holder;
            coursesListTeacherInformation.setData(coursesListList.get(position));
        }

    }

    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return coursesListList.size() + 1;
    }
}
