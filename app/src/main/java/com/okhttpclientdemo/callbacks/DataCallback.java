package com.okhttpclientdemo.callbacks;

import com.okhttpclientdemo.models.User;

import java.util.List;

public interface DataCallback {

    void dataAdded();
    void errorAdded();
    void loadUserData(List<User> userList);
}
