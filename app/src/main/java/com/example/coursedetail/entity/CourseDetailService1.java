package com.example.coursedetail.entity;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.fragment.ServiceDialogFragment;
import com.example.coursedetail.model.coursedetail.ActivitiesList;
import com.example.coursedetail.model.coursedetail.CourseDetail;
import com.example.coursedetail.model.coursedetail.CourseDetailService;
import com.example.coursedetail.R;

import java.util.ArrayList;
import java.util.List;

public class CourseDetailService1 extends RecyclerView.ViewHolder {
    private TextView tvServiceList1;
    private  View itemView;
    private ConstraintLayout clService1;

    public CourseDetailService1(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        tvServiceList1 = itemView.findViewById(R.id.tv_service_list1);
        clService1 = itemView.findViewById(R.id.cl_service1);
    }

    public void setData(CourseDetail courseDetail) {
        //String[] item2 = itemView.getContext().getResources().getStringArray(R.array.item2);
        final List<ActivitiesList> activitiesLists = courseDetail.getResult().getData().getActivities().getList();
        final List<CourseDetailService> courseDetailServices = new ArrayList<>();

        for (ActivitiesList activitiesList : activitiesLists) {
            CourseDetailService courseDetailService = new CourseDetailService();
            courseDetailService.setName(activitiesList.getName());
            courseDetailService.setContent(activitiesList.getContent());
            courseDetailServices.add(courseDetailService);
        }

        SpannableStringBuilder span = new SpannableStringBuilder();
        for (CourseDetailService courseDetailService : courseDetailServices) {
            span.append(courseDetailService.getName());
            span.setSpan(R.drawable.shape_corners_service_list, span.length() - courseDetailService.getName().length(), span.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            span.append(" ");
        }

        tvServiceList1.setText(span.toString());
        //tvServiceList1.setBackgroundResource(R.drawable.shape_corners_service_list);

        clService1.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                ServiceDialogFragment serviceDialogFragment = new ServiceDialogFragment(courseDetailServices);
                serviceDialogFragment.show(((AppCompatActivity)itemView.getContext()).getSupportFragmentManager(), "");
            }
        });

    }
}
