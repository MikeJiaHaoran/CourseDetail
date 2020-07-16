package com.example.coursedetail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Adapter.CSDAdapter;
import com.example.coursedetail.Adapter.RVAdapter;
import com.example.coursedetail.Entity.ClickSleep;
import com.example.coursedetail.Fragment.ServiceActivityWindow;
import com.example.coursedetail.Fragment.ServiceDialogFragment;
import com.example.coursedetail.Fragment.StudentEvaluateDialogFragment;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView tvService;
    private TextView tvShoppingCart;
    private TextView tvJoinShoppingCart;
    private TextView tvRegister;
    private PopupWindow popupWindow;
    private View contentView;
    private ClickSleep clickSleep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        init();
        setAdapter();

        Drawable dService = getResources().getDrawable(R.drawable.coursedetails_customerservice_icon);
        dService.setBounds(0, 0, 80, 80);
        tvService.setCompoundDrawables(null, dService, null, null);

        Drawable dShoppingCart = getResources().getDrawable(R.drawable.coursedetails_shoppingcart_icon_normal);
        dShoppingCart.setBounds(0, 0, 80, 80);
        tvShoppingCart.setCompoundDrawables(null, dShoppingCart, null, null);

        clickSleep = new ClickSleep();
        tvService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!clickSleep.isRuning()) {
                    Toast.makeText(MainActivity.this, "已经联系客服", Toast.LENGTH_SHORT).show();
                    clickSleep.runWithTime(500);
                }

            }
        });

        tvShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!clickSleep.isRuning()) {
                    Toast.makeText(MainActivity.this, "已经加入购物车", Toast.LENGTH_SHORT).show();
                    clickSleep.runWithTime(500);
                }

            }
        });

        tvJoinShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!clickSleep.isRuning()) {
                    Toast.makeText(MainActivity.this, "加入购物车", Toast.LENGTH_SHORT).show();
                    clickSleep.runWithTime(500);
                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!clickSleep.isRuning()) {
                    Toast.makeText(MainActivity.this, "已经报名成功", Toast.LENGTH_SHORT).show();
                    clickSleep.runWithTime(500);
                }
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();

        WebView mWebView = findViewById(R.id.wv_Course_Detail);
        if (mWebView != null) {

            mWebView.loadDataWithBaseURL(null,"","text/html","utf-8",null);
            mWebView.stopLoading();


            ViewGroup parent = (ViewGroup) mWebView.getParent();
            if (parent != null) {
                parent.removeView(mWebView);
            }
            mWebView.clearHistory();
            mWebView.destroy();
            mWebView=null;
        }

    }

    public void init() {
        recyclerView = findViewById(R.id.rv_main_page);
        tvService = findViewById(R.id.tv_service);
        tvShoppingCart = findViewById(R.id.tv_shoppingCart);
        tvJoinShoppingCart = findViewById(R.id.tv_shopping_cart_join);
        tvRegister = findViewById(R.id.tv_register);
    }

    public void setAdapter() {
        RVAdapter adapter = new RVAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void onClick(View v) {
        String[] content;
       /* Bundle bundle = new Bundle();*/
        if (v.getId() == R.id.cl_service1) {
            /** popupwindow 弹窗逻辑*/
           // showPopwindow1();
           // openPopWindow();

            /** dialogfragment 弹窗逻辑*/
            content = getResources().getStringArray(R.array.item2);
            ServiceDialogFragment serviceDialogFragment = new ServiceDialogFragment(this, content);
            serviceDialogFragment.show(getSupportFragmentManager(), "");
        }
        if (v.getId() == R.id.cl_service2) {
           // showPopwindow2();
           // openPopWindow();
            content = getResources().getStringArray(R.array.item3);
            ServiceDialogFragment serviceDialogFragment = new ServiceDialogFragment(this, content);
            serviceDialogFragment.show(getSupportFragmentManager(), "");
        }

        if (v.getId() == R.id.cl_student_evaluate || v.getId() == R.id.cl_students_evaluate || v.getId() == R.id.cl_student_more) {
            content = getResources().getStringArray(R.array.item_evaluate_more);
            StudentEvaluateDialogFragment studentEvaluateDialogFragment = new StudentEvaluateDialogFragment(this, content);
            studentEvaluateDialogFragment.show(getSupportFragmentManager(), "");
        }

        /** activity 弹窗逻辑*/
      /*  bundle.putStringArray("ItemInfo", content);
        Intent intent = new Intent(MainActivity.this, ServiceActivityWindow.class);
        intent.putExtras(bundle);
        startActivity(intent);*/
    }

    public void showPopwindow2() {
        setPopupWindow(1600);
        String[] content = getResources().getStringArray(R.array.item3);
        setLayouot(content);
    }

    public void showPopwindow1() {
        setPopupWindow(800);
        String[] content = getResources().getStringArray(R.array.item2);
        setLayouot(content);
    }

    public void openPopWindow() {
        //从底部显示
        popupWindow.showAtLocation(contentView, Gravity.BOTTOM, 0, 0);
    }

    @SuppressLint("ResourceAsColor")
    public void setPopupWindow(int height) {
        contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.service_detail, null);
        popupWindow =  new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                height);
        popupWindow.setFocusable(true);// 取得焦点
        //注意  要是点击外部空白处弹框消息  那么必须给弹框设置一个背景色  不然是不起作用的
        popupWindow.setBackgroundDrawable(new ColorDrawable(R.color.white));
        //点击外部消失
        popupWindow.setOutsideTouchable(true);
        //设置可以点击
        popupWindow.setTouchable(true);
        //进入退出的动画，指定刚才定义的style
        popupWindow.setAnimationStyle(R.style.dialog_animation);
    }

    public void setLayouot(String[] content) {
        ImageView im_Course_Service_Back = contentView.findViewById(R.id.im_Course_Service_Back);
        RecyclerView recyclerView = contentView.findViewById(R.id.rv_Course_Service_Detail);
        CSDAdapter csdAdapter = new CSDAdapter(content, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(csdAdapter);
        clickSleep = new ClickSleep();
        im_Course_Service_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!clickSleep.isRuning()) {
                    popupWindow.dismiss();
                    clickSleep.runWithTime(500);
                }
            }
        });
    }
}
