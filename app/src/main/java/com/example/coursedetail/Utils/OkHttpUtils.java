package com.example.coursedetail.Utils;


import java.io.IOException;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {

    private static OkHttpUtils okHttpUtils = null;



    public static OkHttpUtils getInstance() {

        if (okHttpUtils == null) {

            synchronized (OkHttpUtils.class) {

                if (okHttpUtils == null) {

                    okHttpUtils = new OkHttpUtils();

                }
            }
        }

        return okHttpUtils;

    }

    //get方法

    public String doGet(String url) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()

                .url(url)

                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            String responseData = null;
            if (response.body() != null) {
                responseData = response.body().string();
            }

            return responseData;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



    //doPost方法

    public void doPost(String url, Map<String, String> params, Callback callback) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        FormBody.Builder builder = new FormBody.Builder();

        for (String key : params.keySet()) {

            builder.add(key, params.get(key));

        }

        FormBody formBody = builder.build();

        Request request = new Request.Builder()

                .post(formBody)

                .url(url)

                .build();

        okHttpClient.newCall(request).enqueue(callback);
    }





}

