package com.example.peter.workcomplain.Utils;


import com.example.peter.workcomplain.retrofit.ApiService;
import com.example.peter.workcomplain.retrofit.RetrofitClient;

public class ApiUtils {
    private ApiUtils() {}

    public static ApiService getApiService(){
        return RetrofitClient.getClient().create(ApiService.class);
    }
}
