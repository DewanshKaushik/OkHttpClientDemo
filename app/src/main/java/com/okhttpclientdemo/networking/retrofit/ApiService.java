package com.okhttpclientdemo.networking.retrofit;

public interface ApiService {
    @GET("/data")
    Call<ResponseClass> fetchData(@Body JsonObject jsonObject);



}
