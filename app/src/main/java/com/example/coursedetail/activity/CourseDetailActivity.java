package com.example.coursedetail.activity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.adapter.CourseDetailAdapter;
import com.example.coursedetail.entity.OnUnDoubleClickListener;
import com.example.coursedetail.Interface.APIService;
import com.example.coursedetail.model.course.CourseDetail;
import com.example.coursedetail.R;
import com.google.gson.Gson;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CourseDetailActivity extends AppCompatActivity {
    private final static String URL = "https://mall.xueersi.com/app/";
    private final static String COOKIE = "tal_token=tal173SPUw2zzHP-9wzSaqj" +
                                        "SgN5nZJKqQ623Um6cNqE5Y0WrfK9rBkpYOGlDMM0J1qJrEeljxjPyCePQt3" +
                                        "M1loxmEBweD2wlpEAmM2jZyRoZ5l-HMG4vgWYOAjIxUH2UeFvAwtmh5FQ16KfPbYjeGnFs" +
                                        "iOpZK7EJRqwZ_OpGj2hJaZrkceahUO1Fv2RvA7UKP155j3gYwA9eXEArQmZMWwDipGTWgL8sl4vipy" +
                                        "-BjRrSD0RL3342SiDTu8Yjp5jg3JJCXZbg-WEmDQpFyedXANBOpdfzVv-xI-vG3l1wJ35rGO-N3-c; X-Requ" +
                                        "est-Id=9ca3a42e1dae17e1bd7fe49fb68e2e0e";
    private RecyclerView recycler_viewCourseDetail;
    private TextView tvService;
    private TextView tvShoppingCart;
    private TextView tvJoinShoppingCart;
    private TextView tvRegister;
    private PopupWindow popUpWindow;
    private View contentView;
    private static final int COMPLETED = 1;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == COMPLETED) {
                Gson gson = new Gson();
                CourseDetail courseDetail = gson.fromJson((String) msg.obj, CourseDetail.class);
                setAdapter(courseDetail);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_course_detail);
        init();
        getJsonMessage();
       // setAdapter();

        Drawable dService = getResources().getDrawable(R.drawable.coursedetails_customerservice_icon);
        dService.setBounds(0, 0, 80, 80);
        tvService.setCompoundDrawables(null, dService, null, null);

        Drawable dShoppingCart = getResources().getDrawable(R.drawable.coursedetails_shoppingcart_icon_normal);
        dShoppingCart.setBounds(0, 0, 80, 80);
        tvShoppingCart.setCompoundDrawables(null, dShoppingCart, null, null);

        tvService.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Toast.makeText(CourseDetailActivity.this, "已经联系客服", Toast.LENGTH_SHORT).show();
            }
        });

        tvShoppingCart.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Toast.makeText(CourseDetailActivity.this, "已经加入购物车", Toast.LENGTH_SHORT).show();
            }
        });

        tvJoinShoppingCart.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Toast.makeText(CourseDetailActivity.this, "加入购物车", Toast.LENGTH_SHORT).show();
            }
        });

        tvRegister.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Toast.makeText(CourseDetailActivity.this, "已经报名成功", Toast.LENGTH_SHORT).show();
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
        }

    }

    public void init() {
        recycler_viewCourseDetail = findViewById(R.id.rv_main_page);
        tvService = findViewById(R.id.tv_service);
        tvShoppingCart = findViewById(R.id.tv_shoppingCart);
        tvJoinShoppingCart = findViewById(R.id.tv_shopping_cart_join);
        tvRegister = findViewById(R.id.tv_register);
    }

    public void setAdapter(CourseDetail courseDetail) {
        CourseDetailAdapter adapter = new CourseDetailAdapter(courseDetail);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler_viewCourseDetail.setLayoutManager(layoutManager);
        recycler_viewCourseDetail.setAdapter(adapter);
    }

    public void onClick(View v) {
        String[] content;
       /* Bundle bundle = new Bundle();*/
      /*  if (v.getId() == R.id.cl_service1) {
            /** popupwindow 弹窗逻辑*/
           // showPopwindow1();
           // openPopWindow();

            /** dialogfragment 弹窗逻辑*/
       /*     content = getResources().getStringArray(R.array.item2);
            ServiceDialogFragment serviceDialogFragment = new ServiceDialogFragment(content);
            serviceDialogFragment.show(getSupportFragmentManager(), "");
        }
        if (v.getId() == R.id.cl_service2) {
           // showPopwindow2();
           // openPopWindow();
            content = getResources().getStringArray(R.array.item3);
            ServiceDialogFragment serviceDialogFragment = new ServiceDialogFragment(content);
            serviceDialogFragment.show(getSupportFragmentManager(), "");
        }*/

      /*  if (v.getId() == R.id.cl_student_evaluate || v.getId() == R.id.cl_students_evaluate || v.getId() == R.id.cl_student_more) {
            content = getResources().getStringArray(R.array.item_evaluate_more);
            StudentEvaluateDialogFragment studentEvaluateDialogFragment = new StudentEvaluateDialogFragment(content);
            studentEvaluateDialogFragment.show(getSupportFragmentManager(), "");
        }*/

        /** activity 弹窗逻辑*/
      /*  bundle.putStringArray("ItemInfo", content);
        Intent intent = new Intent(MainActivity.this, ServiceActivityWindow.class);
        intent.putExtras(bundle);
        startActivity(intent);*/
    }

    private void getJsonMessage(){
                //创建Retrofit
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService apiService = retrofit.create(APIService.class);
                //获取Call对象
                Call<ResponseBody> call = apiService.post(COOKIE,"84153", "android");

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                        try{
                            String responseData = null;
                            if (response.body() != null) {
                                responseData = response.body().string();
                                Message message = new Message();
                                message.what = COMPLETED;
                                message.obj = responseData;
                                handler.sendMessage(message);
                            }
                            //Toast.makeText(NetworkActivity.this, responseData, Toast.LENGTH_SHORT).show();
                            //Log.e("onResponse: ", responseData);


                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                        Log.e("onFailure", t.toString());
                    }
                });
    }

  /*  public void showJsonData(String jsonData) {
        Gson gson = new Gson();
        CourseDetail courseDetail = gson.fromJson(jsonData, CourseDetail.class);
        Log.e("showJsonData", courseDetail.getResult().getData().getCourseName());
    }

    public void showPopwindow2() {
        setPopupWindow(1600);
        String[] content = getResources().getStringArray(R.array.item3);
        setLayout(content);
    }

    public void showPopwindow1() {
        setPopupWindow(800);
        String[] content = getResources().getStringArray(R.array.item2);
        setLayout(content);
    }

    public void openPopWindow() {
        //从底部显示
        popUpWindow.showAtLocation(contentView, Gravity.BOTTOM, 0, 0);
    }*/

  /*  @SuppressLint({"ResourceAsColor", "InflateParams"})
    public void setPopupWindow(int height) {
        contentView = LayoutInflater.from(CourseDetailActivity.this).inflate(R.layout.fragment_service_detail, null);
        popUpWindow =  new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                height);
        popUpWindow.setFocusable(true);// 取得焦点
        //注意  要是点击外部空白处弹框消息  那么必须给弹框设置一个背景色  不然是不起作用的
        popUpWindow.setBackgroundDrawable(new ColorDrawable(R.color.white));
        //点击外部消失
        popUpWindow.setOutsideTouchable(true);
        //设置可以点击
        popUpWindow.setTouchable(true);
        //进入退出的动画，指定刚才定义的style
        popUpWindow.setAnimationStyle(R.style.dialog_animation);
    }*/

   /* public void setLayout(String[] content) {
        ImageView im_Course_Service_Back = contentView.findViewById(R.id.im_Course_Service_Back);
        RecyclerView recyclerView = contentView.findViewById(R.id.rv_Course_Service_Detail);
        CourseServiceDetailAdapter courseServiceDetailAdapter = new CourseServiceDetailAdapter(content);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(courseServiceDetailAdapter);
        im_Course_Service_Back.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                popUpWindow.dismiss();
            }
        });
    }*/
}
