package com.example.coursedetail.entity;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.fragment.ServiceDialogFragment;
import com.example.coursedetail.model.courseDetail.CourseDetail;
import com.example.coursedetail.model.courseDetail.CourseDetailService;
import com.example.coursedetail.model.courseDetail.ServicesList;
import com.example.coursedetail.R;

import java.util.ArrayList;
import java.util.List;

public class CourseDetailService2 extends RecyclerView.ViewHolder {
    private TextView tvServiceList2;
    private ConstraintLayout clService2;
    private  View itemView;

    public CourseDetailService2(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        tvServiceList2 = itemView.findViewById(R.id.tv_service_list2);
        clService2 = itemView.findViewById(R.id.cl_service2);
    }

    public void setData(CourseDetail courseDetail) {
       // String[] item3 = itemView.getContext().getResources().getStringArray(R.array.item3);

        List<ServicesList> servicesLists = courseDetail.getResult().getData().getServices().getList();
        final List<CourseDetailService> courseDetailServices = new ArrayList<>();
        for (ServicesList servicesList : servicesLists) {
            CourseDetailService courseDetailService = new CourseDetailService();
            courseDetailService.setName(servicesList.getName());
            courseDetailService.setContent(servicesList.getContent());
            courseDetailServices.add(courseDetailService);
        }
        int num = Math.min(servicesLists.size(), 4);

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (i == num - 1) {
                buffer.append(courseDetailServices.get(i).getName());
                break;
            }
            buffer.append(courseDetailServices.get(i).getName()).append("·");
        }

        tvServiceList2.setText(buffer.toString());

        clService2.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                ServiceDialogFragment serviceDialogFragment = new ServiceDialogFragment(courseDetailServices);
                serviceDialogFragment.show(((AppCompatActivity)itemView.getContext()).getSupportFragmentManager(), "");
            }
        });

    }
}
