package com.example.peter.workcomplain.retrofit;

import com.example.peter.workcomplain.retrofit.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @POST("Retrofit/complainLogin.php")
    @FormUrlEncoded
    Call<LoginResponse> getLoginResponse(@Field("username") String username,
                                         @Field("password") String password);

}
