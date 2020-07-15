package com.example.coursedetail.Entity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.R;

public class CourseDetailWebview extends RecyclerView.ViewHolder {
    private WebView wv_Course_Detail;

    public CourseDetailWebview(@NonNull View itemView) {
        super(itemView);
        wv_Course_Detail = itemView.findViewById(R.id.wv_Course_Detail);
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void setData(final Context context) {
        String[] content = context.getResources().getStringArray(R.array.course_detail_webview);
        wv_Course_Detail.loadUrl(content[0]);
        wv_Course_Detail.getSettings().setLoadWithOverviewMode(true);
        wv_Course_Detail.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        wv_Course_Detail.getSettings().setJavaScriptEnabled(true);
        wv_Course_Detail.getSettings().setDomStorageEnabled(true);
    }
}
