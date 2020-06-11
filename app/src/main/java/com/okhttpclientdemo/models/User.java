package com.okhttpclientdemo.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "User")
public class User {
    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }


    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private String id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ColumnInfo(name = "userName")
    private String userName;

    @Ignore
    public User(String userName) {
        userName = userName;
    }

    public User(@NonNull String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

}
