package com.okhttpclientdemo.activities.mainactivity;



import androidx.lifecycle.ViewModel;

import com.okhttpclientdemo.UserDataSource;
import com.okhttpclientdemo.models.User;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class UserViewModel extends ViewModel {

    private final UserDataSource mDataSource;

    private User mUser;

    public UserViewModel(UserDataSource dataSource) {
        mDataSource = dataSource;
    }

    /**
     * Get the user name of the user.
     *
     * @return a {@link Flowable} that will emit every time the user name has been updated.
     */
    public void getUserName() {


    }

    /**
     * Update the user name.
     *
     * @param userName the new user name
     * @return a {@link Completable} that completes when the user name is updated
     */
    public void updateUserName(final String userName) {
        // if there's no user, create a new user.
        // if we already have a user, then, since the user object is immutable,
        // create a new user, with the id of the previous user and the updated user name.
        mUser = mUser == null
                ? new User(userName)
                : new User(mUser.getId(), userName);
    }
}
