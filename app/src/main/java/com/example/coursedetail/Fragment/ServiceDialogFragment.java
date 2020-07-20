package com.example.coursedetail.Fragment;

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
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Adapter.CourseServiceDetailAdapter;
import com.example.coursedetail.Entity.OnUnDoubleClickListener;
import com.example.coursedetail.R;

public class ServiceDialogFragment extends DialogFragment {
    private String[] content;

      public ServiceDialogFragment(String[] content) {
          this.content = content;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onStart() {
        super.onStart();

        Window window = getDialog() != null ? getDialog().getWindow() : null;
        WindowManager.LayoutParams params;

        if (window != null) {
            params = window.getAttributes();
            params.gravity = Gravity.BOTTOM;
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = Integer.parseInt(content[0]) > 4 ? 1600 : 800;
            window.setAttributes(params);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setWindowAnimations(R.style.dialog_animation);
        }
        else {
            exit();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getDialog() != null) {
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE); // 不显示标题栏
        }
        else {
            exit();
        }

        View dialogView = inflater.inflate(R.layout.service_detail, container, false);
        ImageView CourseServiceBack = dialogView.findViewById(R.id.im_Course_Service_Back);
        CourseServiceBack.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                exit();
            }
        });
        RecyclerView recycler_viewServiceDialog = dialogView.findViewById(R.id.rv_Course_Service_Detail);
        recycler_viewServiceDialog.setBackgroundResource(R.drawable.shape_corners_dialog_service);
        CourseServiceDetailAdapter courseServiceDetailAdapter = new CourseServiceDetailAdapter(content);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler_viewServiceDialog.setLayoutManager(layoutManager);
        recycler_viewServiceDialog.setAdapter(courseServiceDetailAdapter);

        return dialogView;
    }

    private void exit() {
        ServiceDialogFragment.this.dismiss();
    }


}
