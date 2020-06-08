package com.okhttpclientdemo.Room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Person.TABLE_NAME)
public class Person {
    public static final String TABLE_NAME = "person";
    public String name;
    @PrimaryKey(autoGenerate = true)
    public int id;
}
