package com.okhttpclientdemo.models;

import android.content.Context;

import com.okhttpclientdemo.Room.AppDatabase;
import com.okhttpclientdemo.Room.LocalUserDataSource;
import com.okhttpclientdemo.UserDataSource;
import com.okhttpclientdemo.ViewModelFactory;

public class Injection {

    public static UserDataSource provideUserDataSource(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        return new LocalUserDataSource(database.getPersonDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        UserDataSource dataSource = provideUserDataSource(context);
        return new ViewModelFactory(dataSource);
    }
}
