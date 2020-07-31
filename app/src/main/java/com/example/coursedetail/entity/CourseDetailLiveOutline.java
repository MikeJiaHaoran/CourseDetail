package com.example.coursedetail.entity;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.adapter.LiveOutlineAdapter;
import com.example.coursedetail.fragment.LiveOutlineFragment;
import com.example.coursedetail.model.courseDetail.CourseDetail;
import com.example.coursedetail.model.courseDetail.LiveSyllabus;
import com.example.coursedetail.R;

public class CourseDetailLiveOutline extends RecyclerView.ViewHolder {

    private RecyclerView recycler_viewLiveOutline;
    private TextView tvLiveOutlineMore;
    private TextView tvCourseDetailLiveOutline;
    private View itemView;

    public CourseDetailLiveOutline(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        recycler_viewLiveOutline = itemView.findViewById(R.id.recycler_view_live_outline);
        tvLiveOutlineMore = itemView.findViewById(R.id.tv_live_outline_more);
        tvCourseDetailLiveOutline = itemView.findViewById(R.id.tv_course_detail_live_outline);
    }

    public void setData(CourseDetail courseDetail) {
        //String[] content1 = itemView.getContext().getResources().getStringArray(R.array.item_live_outline_detail);
        //String[] content2 = itemView.getContext().getResources().getStringArray(R.array.item_live_outline);
        final LiveSyllabus liveSyllabus = courseDetail.getResult().getData().getLiveSyllabus();
        tvCourseDetailLiveOutline.setText(liveSyllabus.getName());
        tvLiveOutlineMore.setText(String.format("查看全部%s次课", liveSyllabus.getCount()));

        LiveOutlineAdapter liveOutlineAdapter = new LiveOutlineAdapter(liveSyllabus, 3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
        recycler_viewLiveOutline.setLayoutManager(layoutManager);
        recycler_viewLiveOutline.setAdapter(liveOutlineAdapter);

        tvLiveOutlineMore.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                LiveOutlineFragment liveOutlineFragment = new LiveOutlineFragment(liveSyllabus);
                liveOutlineFragment.show(((AppCompatActivity) itemView.getContext()).getSupportFragmentManager(),"");
            }
        });
    }
}
