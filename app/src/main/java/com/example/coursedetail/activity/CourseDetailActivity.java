package com.example.coursedetail.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.coursedetail.adapter.CourseDetailAdapter;
import com.example.coursedetail.entity.OnUnDoubleClickListener;
import com.example.coursedetail.Interface.APIService;
import com.example.coursedetail.fragment.ShareCourseFragment;
import com.example.coursedetail.model.coursedetail.CourseDetail;
import com.example.coursedetail.R;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CourseDetailActivity extends AppCompatActivity {
    private final static String URL = "https://mall.xueersi.com/app/";
    private final static String IDENTIFIERFORCLIENT = "a0894e21-507c-4690-94ff-85cfe2bf181f";
    private RecyclerView recycler_viewCourseDetail;
    private TextView tvService;
    private TextView tvShoppingCart;
    private TextView tvJoinShoppingCart;
    private TextView tvRegister;
    private PopupWindow popUpWindow;
    private View contentView;
    private static final int COMPLETED = 1;
    private String courseId;
    private ImageView imBackButton;
    private ImageView imShareButton;
    private ConstraintLayout clCourseDetailTitleSlide;
    private TextView tvCourseDetailTitleWord;
    private TextView tvCourseDetailCourse;
    private TextView tvCourseDetailOutline;
    private TextView tvCourseDetailDetail;
    private TextView tvCourseDetailEvaluate;
    private ImageView imCourseDetailLocation1;
    private ImageView imCourseDetailLocation2;
    private ImageView imCourseDetailLocation3;
    private ImageView imCourseDetailLocation4;


    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == COMPLETED) {
                Gson gson = new Gson();
                Log.e("TAG", courseId );
                CourseDetail courseDetail = gson.fromJson((String) msg.obj, CourseDetail.class);
                Log.e("jsonlist", "handleMessage: " + courseDetail.getResult().getData().getLiveSyllabus().getList().toString());
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

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        init();
        if (bundle != null) {
            getJsonMessage(bundle.getString("courseId"));
        }
        else {
            Log.e("Error", "The course ID is null!");
        }
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

        clCourseDetailTitleSlide.bringToFront();
        imBackButton.bringToFront();
        imShareButton.bringToFront();
        Glide.with(this).load(R.drawable.icon_teacher_detail_back_per).into(imBackButton);
        Glide.with(this).load(R.drawable.coursedetails_share_icon_gray).into(imShareButton);

        imBackButton.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                Intent intent = new Intent(CourseDetailActivity.this, CourseListActivity.class);
                startActivity(intent);
            }
        });

        imShareButton.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                ShareCourseFragment shareCourseFragment = new ShareCourseFragment();
                shareCourseFragment.show(getSupportFragmentManager(),"");
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
        imBackButton = findViewById(R.id.iv_back_button);
        imShareButton = findViewById(R.id.iv_share_button);
        clCourseDetailTitleSlide = findViewById(R.id.cl_course_detail_title_slide);
        tvCourseDetailTitleWord = findViewById(R.id.tv_course_detail_title_word);
        tvCourseDetailCourse = findViewById(R.id.tv_course_detail_course);
        tvCourseDetailOutline = findViewById(R.id.tv_course_detail_outline);
        tvCourseDetailDetail = findViewById(R.id.tv_course_detail_detail);
        tvCourseDetailEvaluate = findViewById(R.id.tv_course_detail_evaluate);
        imCourseDetailLocation1 = findViewById(R.id.im_course_detail_location1);
        imCourseDetailLocation2 = findViewById(R.id.im_course_detail_location2);
        imCourseDetailLocation3 = findViewById(R.id.im_course_detail_location3);
        imCourseDetailLocation4 = findViewById(R.id.im_course_detail_location4);
        setSystemBarAlpha(0);
    }

    public void setAdapter(CourseDetail courseDetail) {
        CourseDetailAdapter adapter = new CourseDetailAdapter(courseDetail);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler_viewCourseDetail.setLayoutManager(layoutManager);
        recycler_viewCourseDetail.setAdapter(adapter);

        tvCourseDetailTitleWord.setText(courseDetail.getResult().getData().getCourseName());
        if ((courseDetail.getResult().getData().getEvaluation()) instanceof List) {
            tvCourseDetailEvaluate.setVisibility(View.GONE);
        }

        //滑动监听事件
        final CourseDetail finalCourseDetail = courseDetail;
        RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int alpha = recycler_viewCourseDetail.computeVerticalScrollOffset();
                int firstVisionItem = layoutManager.findFirstVisibleItemPosition();
                if (firstVisionItem < 4) {
                    setLocationPicture(View.VISIBLE, View.GONE, View.GONE, View.GONE);
                }
                else if (firstVisionItem == 7) {
                    setLocationPicture(View.GONE, View.GONE, View.VISIBLE, View.GONE);
                }
                else if (firstVisionItem == 8) {
                    setLocationPicture(View.GONE, View.GONE, View.GONE, View.VISIBLE);

                }
                else {
                    if (!((finalCourseDetail.getResult().getData().getEvaluation()) instanceof List)) {
                        setLocationPicture(View.GONE, View.VISIBLE, View.GONE, View.GONE);
                    }
                }
                setSystemBarAlpha(alpha);
            }
        };
        recycler_viewCourseDetail.addOnScrollListener(mOnScrollListener);

    }

    /**
     * 设置标题栏背景透明度
     * @param alpha 透明度
     */
    @SuppressLint("Range")
    private void setSystemBarAlpha(int alpha) {
        if (alpha >= 225) {
            alpha = 255;
        }
        clCourseDetailTitleSlide.setAlpha(alpha);
//        tvCourseDetailTitleWord.getBackground().setAlpha(alpha);
//        tvCourseDetailCourse.getBackground().setAlpha(alpha);
//        tvCourseDetailOutline.getBackground().setAlpha(alpha);
//        tvCourseDetailDetail.getBackground().setAlpha(alpha);
    }

    private void setLocationPicture(int location1, int location2, int location3, int location4) {
        imCourseDetailLocation1.setVisibility(location1);
        imCourseDetailLocation2.setVisibility(location2);
        imCourseDetailLocation3.setVisibility(location3);
        imCourseDetailLocation4.setVisibility(location4);
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

    private void getJsonMessage(String courseId){
                //创建Retrofit
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService apiService = retrofit.create(APIService.class);
                //获取Call对象
                Call<ResponseBody> call = apiService.post(IDENTIFIERFORCLIENT, courseId, "android","80701");
                this.courseId = courseId;

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
