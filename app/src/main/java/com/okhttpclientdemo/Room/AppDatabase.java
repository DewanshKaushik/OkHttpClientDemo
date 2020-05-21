package com.okhttpclientdemo.Room;

@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao getPersonDao();
}
