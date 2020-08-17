package com.example.coursedetail.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import com.example.coursedetail.R;
import com.example.coursedetail.adapter.CourseListTitleSelectionAdapter;
import com.example.coursedetail.entity.OnUnDoubleClickListener;

import java.util.List;

public class CourseListSelectionFragment extends DialogFragment {
    private List<String> list;
    private int height;

    public CourseListSelectionFragment(List<String> list, int height) {
        this.list = list;
        this.height = height;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onStart() {
        super.onStart();

        Window window = getDialog() != null ? getDialog().getWindow() : null;

        WindowManager.LayoutParams params;

        if (window != null) {
            params = window.getAttributes();
            params.gravity = Gravity.TOP;
            params.x = 0;
            params.y = height;
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.dimAmount = 0;

            window.setAttributes(params);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setWindowAnimations(R.style.course_list_selection_animation);
        }
        else {
            exit();
        }
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getDialog() != null) {
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE); // 不显示标题栏
        }
        else {
            exit();
        }

        View dialogView = inflater.inflate(R.layout.fragment_course_list_selection, container, false);
        GridView gridView = dialogView.findViewById(R.id.gridivew_course_list_select_condition);
        gridView.setVerticalSpacing(32);
        TextView tvResetButton = dialogView.findViewById(R.id.tv_filter_reset_btn);
        TextView tvSureButton = dialogView.findViewById(R.id.tv_filter_sure_btn);
        final CourseListTitleSelectionAdapter courseListTitleSelectionAdapter = new CourseListTitleSelectionAdapter(getContext(), list);
        gridView.setAdapter(courseListTitleSelectionAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                courseListTitleSelectionAdapter.makeSelection(position);
                courseListTitleSelectionAdapter.notifyDataSetChanged();
            }
        });


        tvResetButton.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Toast.makeText(getContext(), "已经重置选项", Toast.LENGTH_SHORT).show();
            }
        });

        tvSureButton.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Toast.makeText(getContext(), "已经确定时间", Toast.LENGTH_SHORT).show();
            }
        });

        return dialogView;
    }

    private void exit() {
        CourseListSelectionFragment.this.dismiss();
    }
}
