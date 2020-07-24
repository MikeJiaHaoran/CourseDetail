package com.example.coursedetail.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coursedetail.Interface.APIService;
import com.example.coursedetail.R;
import com.google.android.flexbox.FlexboxLayout;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkActivity extends AppCompatActivity {

    //public static final String URL = "https://news-at.zhihu.com/api/3/";
    private final static String URL = "https://mall.xueersi.com/app/";
    private final static String COOKIE = "tal_token=tal173SPUw2zzHP-9wzSaqj" +
                                        "SgN5nZJKqQ623Um6cNqE5Y0WrfK9rBkpYOGlDMM0J1qJrEeljxjPyCePQt3" +
                                        "M1loxmEBweD2wlpEAmM2jZyRoZ5l-HMG4vgWYOAjIxUH2UeFvAwtmh5FQ16KfPbYjeGnFs" +
                                        "iOpZK7EJRqwZ_OpGj2hJaZrkceahUO1Fv2RvA7UKP155j3gYwA9eXEArQmZMWwDipGTWgL8sl4vipy" +
                                        "-BjRrSD0RL3342SiDTu8Yjp5jg3JJCXZbg-WEmDQpFyedXANBOpdfzVv-xI-vG3l1wJ35rGO-N3-c; X-Requ" +
                                        "est-Id=9ca3a42e1dae17e1bd7fe49fb68e2e0e";
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
                            Log.e("onResponse: ", responseData);


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
        TextView tvLatestNews = new TextView(this);
        tvLatestNews.setGravity(Gravity.CENTER);
        tvLatestNews.setText(jsonData);
        flexboxLayout.addView(tvLatestNews);
      /*  Log.i("Json Data:", jsonData);
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
        }*/

    }
}
