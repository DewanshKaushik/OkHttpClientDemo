package com.okhttpclientdemo;

import android.app.Application;

import androidx.room.Room;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.androidnetworking.AndroidNetworking;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.okhttpclientdemo.Room.AppDatabase;
import com.okhttpclientdemo.Room.Person;

import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;

public class App extends Application {


    public RequestQueue requestQueue;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        requestQueue = Volley.newRequestQueue(getApplicationContext());


        AndroidNetworking.initialize(getApplicationContext());

        // Adding an Network Interceptor for Debugging purpose :
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        AndroidNetworking.initialize(getApplicationContext(), okHttpClient);


        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                // insert into the database
                Person person = new Person();
                person.name = "Idorenyin Obong";
            }
        });
    }


    public static App getInstance() {
        return instance;
    }


}
