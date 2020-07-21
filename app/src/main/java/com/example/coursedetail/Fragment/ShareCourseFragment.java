package com.example.coursedetail.Fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Adapter.ShareCourseAdapter;
import com.example.coursedetail.Entity.OnUnDoubleClickListener;
import com.example.coursedetail.R;

public class ShareCourseFragment extends DialogFragment {

    private String[] content;

    public void onStart() {
        super.onStart();

        Window window = getDialog() != null ? getDialog().getWindow() : null;
        WindowManager.LayoutParams params;

        if (window != null) {
            params = window.getAttributes();
            params.gravity = Gravity.BOTTOM;
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = 700;
            window.setAttributes(params);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setWindowAnimations(R.style.dialog_animation);
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

        View shareDialogView = inflater.inflate(R.layout.dialog_share_course, container, false);
        RecyclerView recycler_viewShareDialog = shareDialogView.findViewById(R.id.recycler_view_share_course_dialog);
        TextView tvShareServiceBack = shareDialogView.findViewById(R.id.tv_share_service_back);
        recycler_viewShareDialog.setBackgroundResource(R.drawable.shape_corners_dialog_service);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recycler_viewShareDialog.setLayoutManager(gridLayoutManager);
        ShareCourseAdapter shareCourseAdapter = new ShareCourseAdapter();
        recycler_viewShareDialog.setAdapter(shareCourseAdapter);

        tvShareServiceBack.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                exit();
            }
        });

        return shareDialogView;

    }

    private void exit() {
        ShareCourseFragment.this.dismiss();
    }
}
