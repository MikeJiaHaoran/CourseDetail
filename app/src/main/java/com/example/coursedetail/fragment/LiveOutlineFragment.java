package com.example.coursedetail.fragment;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.adapter.LiveOutlineAdapter;
import com.example.coursedetail.entity.OnUnDoubleClickListener;
import com.example.coursedetail.model.courseDetail.LiveSyllabus;
import com.example.coursedetail.R;

public class LiveOutlineFragment extends DialogFragment {

    private LiveSyllabus liveSyllabus;

    public LiveOutlineFragment(LiveSyllabus liveSyllabus) {
        this.liveSyllabus = liveSyllabus;
    }

    public void onStart() {
        super.onStart();


        Window window = getDialog() != null ? getDialog().getWindow() : null;
        WindowManager.LayoutParams params;

        if (window != null) {
            params = window.getAttributes();
            params.gravity = Gravity.END;
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.MATCH_PARENT;
            window.setAttributes(params);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            window.setWindowAnimations(R.style.live_outline_animation);
        }
        else {
            exit();
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getDialog() != null) {
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE); // 不显示标题栏
        }
        else {
            exit();
        }

        View outlineDialogView = inflater.inflate(R.layout.fragment_live_outline_course_detail, container, false);
        TextView tvLiveOutlineCourseDetailTitle = outlineDialogView.findViewById(R.id.tv_live_outline_course_detail_title);
        tvLiveOutlineCourseDetailTitle.setText(liveSyllabus.getName());
        RecyclerView recycler_viewLiveOutlineCourseDetail = outlineDialogView.findViewById(R.id.recycler_view_live_outline_course_detail);
        ImageView ivLiveOutlineBackButton = outlineDialogView.findViewById(R.id.iv_live_outline_course_detail_back_button);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler_viewLiveOutlineCourseDetail.setLayoutManager(layoutManager);
        LiveOutlineAdapter liveOutlineAdapter = new LiveOutlineAdapter(liveSyllabus, liveSyllabus.getList().get(0).getList().size());
        recycler_viewLiveOutlineCourseDetail.setAdapter(liveOutlineAdapter);

        ivLiveOutlineBackButton.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                exit();
            }
        });

        return outlineDialogView;

    }

    private void exit() {
        LiveOutlineFragment.this.dismiss();
    }
}
