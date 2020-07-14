package com.example.coursedetail.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Adapter.CSDAdapter;
import com.example.coursedetail.R;

import java.util.Objects;

@SuppressLint("Registered")
public class ServiceActivityWindow extends Activity implements View.OnClickListener {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.service_detail);

        Bundle bundle = getIntent().getExtras();
        String[] content = Objects.requireNonNull(bundle).getStringArray("ItemInfo");
        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window .getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        assert content != null;
        lp.height = Integer.parseInt(content[0]) > 4 ? 1600 : 800;
        lp.gravity = Gravity.BOTTOM;//设置对话框底部显示

        window .setAttributes(lp);
        ImageView im_Course_Service_Back = findViewById(R.id.im_Course_Service_Back);
        RecyclerView recyclerView = findViewById(R.id.rv_Course_Service_Detail);
        CSDAdapter csdAdapter = new CSDAdapter(content, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(csdAdapter);
        im_Course_Service_Back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.im_Course_Service_Back) {
            finish();
        }
    }
}
