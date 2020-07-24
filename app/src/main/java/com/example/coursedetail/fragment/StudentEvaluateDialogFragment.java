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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import com.example.coursedetail.entity.OnUnDoubleClickListener;
import com.example.coursedetail.R;

public class StudentEvaluateDialogFragment extends DialogFragment {
    private String url;

    public StudentEvaluateDialogFragment(String url) {
        this.url = url;
    }

    @SuppressLint("RtlHardcoded")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onStart() {
        super.onStart();
        Window window = getDialog() != null ? getDialog().getWindow() : null;
        WindowManager.LayoutParams params;

        if (window != null) {
            params = window.getAttributes();
            params.gravity = Gravity.LEFT;
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.MATCH_PARENT;
            window.setAttributes(params);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setWindowAnimations(R.style.evaluate_animation);
        }
        else {
            exit();
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if (getDialog() != null) {
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE); // 不显示标题栏
        }
        else {
            exit();
        }

        View dialogView = inflater.inflate(R.layout.fragment_students_webview, container, false);
        ImageView imBackButton = dialogView.findViewById(R.id.im_Evaluate_Detail_Back);
        WebView web_viewStudentsEvaluate = dialogView.findViewById(R.id.wv_students_evaluate);
        web_viewStudentsEvaluate.loadUrl(url);
        web_viewStudentsEvaluate.getSettings().setUseWideViewPort(true);
        web_viewStudentsEvaluate.getSettings().setLoadWithOverviewMode(true);
        web_viewStudentsEvaluate.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        web_viewStudentsEvaluate.getSettings().setJavaScriptEnabled(true);
        web_viewStudentsEvaluate.getSettings().setDomStorageEnabled(true);

        imBackButton.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                exit();
            }
        });

        return dialogView;
    }

    private void exit() {
        StudentEvaluateDialogFragment.this.dismiss();
    }


}
