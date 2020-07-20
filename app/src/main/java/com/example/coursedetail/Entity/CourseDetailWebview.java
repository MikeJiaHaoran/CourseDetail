package com.example.coursedetail.Entity;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.coursedetail.R;

public class CourseDetailWebview extends RecyclerView.ViewHolder {
    private WebView web_viewCourseDetail;
    private View itemView;

    public CourseDetailWebview(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        web_viewCourseDetail = itemView.findViewById(R.id.wv_Course_Detail);
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void setData() {
        String[] content = itemView.getContext().getResources().getStringArray(R.array.course_detail_webview);
        web_viewCourseDetail.loadUrl(content[0]);
        web_viewCourseDetail.getSettings().setLoadWithOverviewMode(true);
        web_viewCourseDetail.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        web_viewCourseDetail.getSettings().setJavaScriptEnabled(true);
        web_viewCourseDetail.getSettings().setDomStorageEnabled(true);
    }
}
