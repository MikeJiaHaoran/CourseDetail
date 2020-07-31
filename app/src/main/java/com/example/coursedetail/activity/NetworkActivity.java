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

    private final static String URL = "https://mall.xueersi.com/app/";
    private final static String COOKIE = "tal_token=tal173SPUw2zzHP-9wzSaqj" +
                                        "SgN5nZJKqQ623Um6cNqE5Y0WrfK9rBkpYOGlDMM0J1qJrEeljxjPyCePQt3" +
                                        "M1loxmEBweD2wlpEAmM2jZyRoZ5l-HMG4vgWYOAjIxUH2UeFvAwtmh5FQ16KfPbYjeGnFs" +
                                        "iOpZK7EJRqwZ_OpGj2hJaZrkceahUO1Fv2RvA7UKP155j3gYwA9eXEArQmZMWwDipGTWgL8sl4vipy" +
                                        "-BjRrSD0RL3342SiDTu8Yjp5jg3JJCXZbg-WEmDQpFyedXANBOpdfzVv-xI-vG3l1wJ35rGO-N3-c; X-Requ" +
                                        "est-Id=9ca3a42e1dae17e1bd7fe49fb68e2e0e";

    private final static String COOKIE1 = "tal_token=tal173YC67P2SAww-pdGN4Krcr08zQVNJJ" +
                                            "y_VsrOPQQMD-xF3-uiWh6HSM23-okxagbEMG-4aG-Nf-9p2gmCnxb3pSDVShjUZCxojDbzrTtBmU3WLCKChuBlzuTamSuf0" +
                                            "B7r476yPhoZqd8RhoaMYIIdZR3MhWUUrto8vwyjSZiA-9g9oeaClFohCM_wxnxMuuUM9wSSJqjrGhyOXCDYWY8QaRQ-sHWuUzkCe_U0" +
                                            "AhLmn7V5k_KNZbH34uUCazlLOO93g-XEXIHCm7u5XGl1GWVU262B00bFCQInX5SLqg8RfGYLRMN";
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

                //创建Retrofit
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService apiService = retrofit.create(APIService.class);
                //获取Call对象
                Call<ResponseBody> call = apiService.post(COOKIE1,"-835", "android", "1", "80401", "8");

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

    @SuppressLint("ResourceAsColor")
    public void showJsonData(String jsonData) {
        TextView tvLatestNews = new TextView(this);
        tvLatestNews.setGravity(Gravity.CENTER);
        tvLatestNews.setText(jsonData);
        flexboxLayout.addView(tvLatestNews);
    }
}
