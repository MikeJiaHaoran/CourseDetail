package com.example.coursedetail.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coursedetail.Interface.APIService;
import com.example.coursedetail.Model.LatestNews;
import com.example.coursedetail.Model.Stories;
import com.example.coursedetail.Model.TopStories;
import com.example.coursedetail.R;
import com.example.coursedetail.Utils.OkHttpUtils;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkActivity extends AppCompatActivity {

    public static final String URL = "https://news-at.zhihu.com/api/3/";
    private static final int COMPLETED = 1;
    private FlexboxLayout flexboxLayout;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == COMPLETED) {
                showJsonData((String) msg.obj);
            }
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_network);
        init();
        getJsonMessage();
    }

    public void init() {
        flexboxLayout = findViewById(R.id.fl_latest_news);
    }

    private void getJsonMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                //创建Retrfit
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService apiService = retrofit.create(APIService.class);
                //获取Call对象
                Call<ResponseBody> call = apiService.get("latest");

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


                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                        Log.e("onFailure", t.toString());
                    }
                });

              /*  OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(URL)
                        .get()
                        .build();*/
               /* try{
                    Response response = client.newCall(request).execute();
                    String responseData = null;
                    if (response.body() != null) {
                        responseData = response.body().string();
                        Message message = new Message();
                        message.what = COMPLETED;
                        message.obj = responseData;
                        handler.sendMessage(message);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }*/
            }
        }).start();

    }

    @SuppressLint("ResourceAsColor")
    public void showJsonData(String jsonData) {
        Log.i("Json Data:", jsonData);
        Gson gson = new Gson();
        LatestNews latestNews = gson.fromJson(jsonData, LatestNews.class);
        Log.i("date", latestNews.getDate());
        List<Stories> stories = latestNews.getStories();
        List<TopStories> topStories = latestNews.getTopStories();

        for (Stories story : stories) {
            Log.i("stories", story.getImage_hue());
        }

        for (TopStories topStory : topStories) {
            Log.i("topStories", topStory.getImage_hue());
        }

        TextView tvLatestNews = new TextView(this);
        tvLatestNews.setGravity(Gravity.CENTER);
        tvLatestNews.setText(latestNews.getDate());
        tvLatestNews.setTextSize(12);
        tvLatestNews.setTextColor(R.color.greyword);
        tvLatestNews.setBackgroundResource(R.drawable.bg_teacher_detail_evaluation_lable);
        flexboxLayout.addView(tvLatestNews);
        FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) tvLatestNews.getLayoutParams();
        lp.setMargins(24, 24, 0,0);
        tvLatestNews.setLayoutParams(lp);

        for (int i = 0; i < stories.size(); i++) {
            tvLatestNews = new TextView(this);
            tvLatestNews.setGravity(Gravity.CENTER);
            tvLatestNews.setText(stories.get(i).getHint());
            tvLatestNews.setTextSize(12);
            tvLatestNews.setTextColor(R.color.greyword);
            tvLatestNews.setBackgroundResource(R.drawable.bg_teacher_detail_evaluation_lable);
            flexboxLayout.addView(tvLatestNews);
            lp = (FlexboxLayout.LayoutParams) tvLatestNews.getLayoutParams();
            lp.setMargins(24, 24, 0,0);
            tvLatestNews.setLayoutParams(lp);
        }

        for (int i = 0; i < topStories.size(); i++) {
            tvLatestNews = new TextView(this);
            tvLatestNews.setGravity(Gravity.CENTER);
            tvLatestNews.setText(topStories.get(i).getHint());
            tvLatestNews.setTextSize(12);
            tvLatestNews.setTextColor(R.color.greyword);
            tvLatestNews.setBackgroundResource(R.drawable.bg_teacher_detail_evaluation_lable);
            flexboxLayout.addView(tvLatestNews);
            lp = (FlexboxLayout.LayoutParams) tvLatestNews.getLayoutParams();
            lp.setMargins(24, 24, 0,0);
            tvLatestNews.setLayoutParams(lp);
        }

    }
}
