package com.example.coursedetail.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coursedetail.entity.OnUnDoubleClickListener;
import com.example.coursedetail.R;

public class HomeActivity extends AppCompatActivity {

    private TextView tvHomeCourseDetail;
    private TextView tvHomeNetwork;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        init();

        tvHomeCourseDetail.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CourseDetailActivity.class);
                startActivity(intent);
            }
        });

        tvHomeNetwork.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NetworkActivity.class);
                startActivity(intent);
            }
        });

    }

    public void init() {
        tvHomeCourseDetail = findViewById(R.id.tv_home_course_detail);
        tvHomeNetwork = findViewById(R.id.tv_home_network);
    }
}
