package com.okhttpclientdemo.networking.retrofit;

import com.okhttpclientdemo.models.User;
import com.okhttpclientdemo.models.UserList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String BASE_URL = "https://api.cryptonator.com/api/full/";

    @GET("{coin}-usd")
    Observable<User> getCoinData(@Path("coin") String coin);

    @GET("users/readuser.php")
    Call<UserList> getUserList();

}
