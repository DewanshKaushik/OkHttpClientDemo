package com.okhttpclientdemo.Room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;

import androidx.room.Room;

import com.okhttpclientdemo.App;
import com.okhttpclientdemo.callbacks.DataCallback;
import com.okhttpclientdemo.models.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DataManager {

    private Context context;
    private AppDatabase appDatabase;

    public DataManager(Context context) {
        this.context = context;
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "Sample.db").build();
    }

    public void addData(final String firstName, final String lastname, final DataCallback dataCallback) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                User user = new User(firstName, lastname);
                appDatabase.getPersonDao().insertUser(user);

            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {


            }

            @Override
            public void onComplete() {
                dataCallback.dataAdded();
            }

            @Override
            public void onError(Throwable e) {
                dataCallback.errorAdded();
            }
        });

    }

    @SuppressLint("CheckResult")
    public void loadData(final DataCallback dataCallback) {
        appDatabase.getPersonDao().getUser().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<User>>() {
                    @SuppressLint("CheckResult")
                    @Override
                    public void accept(List<User> user) throws Exception {
                        dataCallback.loadUserData(user);
                    }
                });


    }

}















