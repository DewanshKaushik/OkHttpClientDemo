package com.okhttpclientdemo.Room;

@Entity(tableName = Person.TABLE_NAME)
public class Person {
    public static final String TABLE_NAME = "person";
    String name;
    @PrimaryKey(autoGenerate = true)
    public int id;
}
