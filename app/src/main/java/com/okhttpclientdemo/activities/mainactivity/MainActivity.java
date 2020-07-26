package com.okhttpclientdemo.activities.mainactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.okhttpclientdemo.R;
import com.okhttpclientdemo.Room.DataManager;
import com.okhttpclientdemo.activities.BaseActivity;
import com.okhttpclientdemo.adapter.MyAdapter;
import com.okhttpclientdemo.callbacks.DataCallback;
import com.okhttpclientdemo.databinding.ActivityMainBinding;
import com.okhttpclientdemo.models.User;
import com.okhttpclientdemo.networking.VolleyDemo;
import com.okhttpclientdemo.networking.retrofit.ApiService;
import com.okhttpclientdemo.networking.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import co.gofynd.gravityview.GravityView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

//  https://github.com/Karumi/Dexter
public class MainActivity extends BaseActivity {

    TextView textView;
    GravityView gravityView;
    ActivityMainBinding activityMainBinding;
    public DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        adView = activityMainBinding.adView;

        textView = findViewById(R.id.textview);
        dataManager = new DataManager(this);

        getUserName();
        setAdapter();
        dataManager.loadData(new DataCallback() {
            @Override
            public void dataAdded() {
                Log.e("dataAdded", "dataAdded");
            }

            @Override
            public void errorAdded() {
                Log.e("errorAdded", "errorAdded");
            }

            @Override
            public void loadUserData(List<User> userList) {
                Log.e("loadUserData", userList.toString());
            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                new VolleyDemo().getDAtafromVolley(MainActivity.this);
            }

        }).start();

        callApifromRxJava();
        setGravityView();
       // showBanner();
        showNativeAds();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // showInterstitial();
            }
        }, 3000);
    }


    private void setGravityView() {
        gravityView = GravityView.getInstance(this)
                .setImage(activityMainBinding.bg, R.mipmap.girl)
                .center();
    }

    private void setAdapter() {
        activityMainBinding.recyclerview.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        activityMainBinding.recyclerview.setLayoutManager(layoutManager);
        MyAdapter mAdapter = new MyAdapter(getArrayList(), this);
        activityMainBinding.recyclerview.setAdapter(mAdapter);
    }

    private ArrayList<String> getArrayList() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            strings.add("HI " + i);
        }
        return strings;
    }

    @SuppressLint("CheckResult")
    private void callApifromRxJava() {
        ApiService cryptocurrencyService = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);

        Observable<User> cryptoObservable = cryptocurrencyService.getCoinData("btc");
        cryptoObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);


        //d We use the RxJava operator merge to do two retrofit calls one after the other.

        Observable<User> btcObservable = cryptocurrencyService.getCoinData("btc");

        Observable<User> ethObservable = cryptocurrencyService.getCoinData("eth");

        Observable.merge(btcObservable, ethObservable)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);


        //d Transforming the Response
        //d  To transform the POJO response we can do the following:


/*        Observable<List<User>> btcObservable2 = cryptocurrencyService.getCoinData("btc")
                .map(result -> Observable.fromIterable(result.getId()))
                .flatMap(x -> x).filter(y -> {
                    y = "btc";
                    return true;
                }).toList().toObservable();

        Observable<List<Crypto.Market>> ethObservable2 = cryptocurrencyService.getCoinData("eth")
                .map(result -> Observable.fromIterable(result.ticker.markets))
                .flatMap(x -> x).filter(y -> {
                    y.coinName = "eth";
                    return true;
                }).toList().toObservable();

        Observable.merge(btcObservable, ethObservable)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);*/
    }

    private void handleError(Throwable throwable) {
        throwable.printStackTrace();
    }

    private void handleResults(User user) {
        Log.e("handleResults", user.toString());
    }


    public void getUserName() {
        dataManager.addData("hi", "hi", new DataCallback() {
            @Override
            public void dataAdded() {
                Log.e("dataAdded", "dataAdded");
            }

            @Override
            public void errorAdded() {
                Log.e("errorAdded", "errorAdded");
            }

            @Override
            public void loadUserData(List<User> userList) {
                Log.e("loadUserData", userList.toString());
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (gravityView.deviceSupported())
            gravityView.registerListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (gravityView.deviceSupported())
            gravityView.unRegisterListener();
    }
}
