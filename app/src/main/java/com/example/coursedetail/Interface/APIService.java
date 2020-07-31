package com.example.coursedetail.Interface;

import okhttp3.Cookie;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("news/{version}")
    Call<ResponseBody> get(@Path("version") String version);

    @FormUrlEncoded
    @POST("Course/detail")
    Call<ResponseBody> post(@Header("Cookie") String Cookie, @Field("courseId") String courseId, @Field("systemName") String systemName,
                            @Field("appVersionNumber") String versionNumber);


    @FormUrlEncoded
    @POST("courses/list")
    Call<ResponseBody> post(@Header("Cookie") String Cookie, @Field("subjectId") String subjectId, @Field("systemName") String systemName,
                            @Field("location") String location, @Field("appVersionNumber") String appVersionNumber, @Field("device") String device);
}
