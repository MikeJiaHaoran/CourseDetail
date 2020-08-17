package com.example.coursedetail.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Interface.APIService;
import com.example.coursedetail.R;
import com.example.coursedetail.adapter.CoursesListAdapter;
import com.example.coursedetail.entity.OnUnDoubleClickListener;
import com.example.coursedetail.fragment.CourseListSelectionFragment;
import com.example.coursedetail.model.courseslist.CoursesList;
import com.example.coursedetail.model.courseslist.JsonResultCourses;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CourseListActivity extends AppCompatActivity {

    private final static String URL = "https://mall.xueersi.com/app/";
    private final static String COOKIE = "tal_token=tal173YC67P2SAww-pdGN4Krcr08zQVNJJy_VsrOPQQMD-xF3-uiWh6HSM23-okxagbEMG-4aG-Nf-9p2gmCnxb3pSDVShjUZCxojDbzrTtBmU3WLCKChuBlzuTamSuf0B7r476yPhoZqd8RhoaMYIIdZR3MhWUUrto8vwyjSZiA-9g9oeaClFohCM_wxnxMuuUM9wSSJqjrGhyOXCDYWY8QaRQ-sHWuUzkCe_U0AhLmn7V5k_KNZbH34uUCazlLOO93g-XEXIHCm7u5XGl1GWVU262B00bFCQInX5SLqg8RfGYLRMN";
    private static final int COMPLETED = 1;
    private RecyclerView recycler_viewCoursesList;
    private ConstraintLayout clTitleLayout;
    private TextView tvFilterFilter1;
    private TextView tvFilterFilter2;
    private TextView tvFilterFilter3;
    private TextView tvFilterFilter4;
    //private TextView textView;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == COMPLETED) {
                Gson gson = new Gson();
                JsonResultCourses jsonResultCourses = gson.fromJson((String) msg.obj, JsonResultCourses.class);
                setAdapter(jsonResultCourses);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        init();
        getJsonMessage();
    }
    public void init() {
        recycler_viewCoursesList = findViewById(R.id.rv_courses_list);
        clTitleLayout = findViewById(R.id.cl_course_list_title);
        tvFilterFilter1 = findViewById(R.id.tv_filter_filter);
        tvFilterFilter2 = findViewById(R.id.tv_filter_filter1);
        tvFilterFilter3 = findViewById(R.id.tv_filter_filter2);
        tvFilterFilter4 = findViewById(R.id.tv_filter_filter3);

        final List<String> list1 = new ArrayList<>();
        list1.add("全部");
        list1.add("周五");
        list1.add("周六");
        list1.add("周日");

        final List<String> list2 = new ArrayList<>();
        list2.add("周一");
        list2.add("周二");
        list2.add("周三");
        list2.add("周四");

        tvFilterFilter1.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                showDialogFragment(list1);
            }
        });

        tvFilterFilter2.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                showDialogFragment(list1);
            }
        });

        tvFilterFilter3.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                showDialogFragment(list1);
            }
        });

        tvFilterFilter4.setOnClickListener(new OnUnDoubleClickListener() {
            @Override
            public void onUnDoubleClick(View v) {
                showDialogFragment(list2);
            }
        });
    }

    private void getJsonMessage(){

        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        //获取Call对象
        Call<ResponseBody> call = apiService.post(COOKIE,"-835", "android", "1", "80401", "8");

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
                    else {
                        Log.e("onResponse: ", "It is null message");
                    }


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

    public void setAdapter(JsonResultCourses jsonResultCourses) {

        List<CoursesList> coursesLists = jsonResultCourses.getResult().getData().getCourseList();
        CoursesListAdapter adapter = new CoursesListAdapter(coursesLists);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler_viewCoursesList.setLayoutManager(linearLayoutManager);
        recycler_viewCoursesList.setAdapter(adapter);
    }

    public void showDialogFragment(List<String> list) {
        CourseListSelectionFragment courseListSelectionFragment = new CourseListSelectionFragment(list, clTitleLayout.getHeight());
        courseListSelectionFragment.show(getSupportFragmentManager(), "");
    }

}