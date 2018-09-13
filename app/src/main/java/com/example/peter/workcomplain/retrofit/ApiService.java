package com.example.peter.workcomplain.retrofit;

import com.example.peter.workcomplain.retrofit.model.ComplainModel;
import com.example.peter.workcomplain.retrofit.model.ComplainReportResponse;
import com.example.peter.workcomplain.retrofit.model.ComplainResponseModel;
import com.example.peter.workcomplain.retrofit.model.LoginDataResponse;
import com.example.peter.workcomplain.retrofit.model.LoginResponse;
import com.example.peter.workcomplain.retrofit.model.NotificationResponse;
import com.example.peter.workcomplain.retrofit.model.ReportModel;
import com.example.peter.workcomplain.retrofit.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("Retrofit/complainLogin.php")
    @FormUrlEncoded
    Call<LoginDataResponse> getLoginResponse(@Field("username") String username,
                                             @Field("password") String password);

    @POST("Retrofit/giggs_register.php")
    Call<LoginResponse> registerUser(@Body UserModel userModel);

    @POST("Retrofit/workpostComplain.php")
    Call<LoginResponse>postComplain(@Body ComplainModel complainModel);

    @POST("Retrofit/getWorkComplainList.php")
    @FormUrlEncoded
    Call<List<ComplainResponseModel>>getComplain(@Field("user")String email);

    @POST("Retrofit/getComplainReport.php")
    @FormUrlEncoded
    Call<ComplainReportResponse> getReport(@Field("user") String user);

    @POST("Retrofit/getNotifications.php")
    @FormUrlEncoded
    Call <List<NotificationResponse>> getNoticationsReport(@Field("user") String user);

}
