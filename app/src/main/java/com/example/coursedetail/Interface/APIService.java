package com.example.coursedetail.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {
    @GET("news/{version}")
    Call<ResponseBody> get(@Path("version") String version);
}
