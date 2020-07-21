package com.example.coursedetail.Entity;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Adapter.LiveOutlineAdapter;
import com.example.coursedetail.Fragment.LiveOutlineFragment;
import com.example.coursedetail.Fragment.ShareCourseFragment;
import com.example.coursedetail.R;

public class CourseDetailLiveOutline extends RecyclerView.ViewHolder {

    private RecyclerView recycler_viewLiveOutline;
    private TextView tvLiveOutlineMore;
    private View itemView;

    public CourseDetailLiveOutline(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        recycler_viewLiveOutline = itemView.findViewById(R.id.recycler_view_live_outline);
        tvLiveOutlineMore = itemView.findViewById(R.id.tv_live_outline_more);
    }

    public void setData() {
        String[] content1 = itemView.getContext().getResources().getStringArray(R.array.item_live_outline_detail);
        String[] content2 = itemView.getContext().getResources().getStringArray(R.array.item_live_outline);
        tvLiveOutlineMore.setText(String.format("查看全部%s次课", content1[0]));

        LiveOutlineAdapter liveOutlineAdapter = new LiveOutlineAdapter(content2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
        recycler_viewLiveOutline.setLayoutManager(layoutManager);
        recycler_viewLiveOutline.setAdapter(liveOutlineAdapter);

        tvLiveOutlineMore.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                LiveOutlineFragment liveOutlineFragment = new LiveOutlineFragment(itemView.getContext().getResources().getStringArray(R.array.item_live_outline_detail));
                liveOutlineFragment.show(((AppCompatActivity) itemView.getContext()).getSupportFragmentManager(),"");
            }
        });
    }
}
