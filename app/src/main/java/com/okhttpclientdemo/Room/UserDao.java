package com.okhttpclientdemo.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.okhttpclientdemo.models.User;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface UserDao {

    /**
     * Get the user from the table. Since for simplicity we only have one user in the database,
     * this query gets all users from the table, but limits the result to just the 1st user.
     *
     * @return the user from the table
     */
    @Query("SELECT * FROM User LIMIT 1")
    Flowable<User> getUser();

    /**
     * Insert a user in the database. If the user already exists, replace it.
     *
     * @param user the user to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    /**
     * Delete all users.
     */
    @Query("DELETE FROM User")
    void deleteAllUsers();
}
