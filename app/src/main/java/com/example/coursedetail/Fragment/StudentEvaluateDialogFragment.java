package com.example.coursedetail.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
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

import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import com.example.coursedetail.R;

import java.util.Objects;

public class StudentEvaluateDialogFragment extends DialogFragment {
    private Context context;
    private String[] content;

    public StudentEvaluateDialogFragment(Context context, String[] content) {
        this.context = context;
        this.content = content;
    }

    @SuppressLint("RtlHardcoded")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onStart() {
        super.onStart();

        Window window = Objects.requireNonNull(getDialog()).getWindow();
        assert window != null;
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.LEFT;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
        window.setWindowAnimations(R.style.evaluate_animation);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Objects.requireNonNull(getDialog()).requestWindowFeature(Window.FEATURE_NO_TITLE); // 不显示标题栏
        View dialogView = inflater.inflate(R.layout.item_students_webview, container, false);
        ImageView im_back = dialogView.findViewById(R.id.im_Evaluate_Detail_Back);
        WebView wv_students_evaluate = dialogView.findViewById(R.id.wv_students_evaluate);
        wv_students_evaluate.loadUrl(content[1]);
        wv_students_evaluate.getSettings().setUseWideViewPort(true);
        wv_students_evaluate.getSettings().setLoadWithOverviewMode(true);
        wv_students_evaluate.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        wv_students_evaluate.getSettings().setJavaScriptEnabled(true);
        wv_students_evaluate.getSettings().setDomStorageEnabled(true);

        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentEvaluateDialogFragment.this.dismiss();
            }
        });

        return dialogView;
    }


}
