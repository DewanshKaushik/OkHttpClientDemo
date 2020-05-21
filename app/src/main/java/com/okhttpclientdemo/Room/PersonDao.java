package com.okhttpclientdemo.Room;

@Dao
public interface PersonDao {
    // Adds a person to the database
    @Insert
    void insert(Person person);

    // Removes a person from the database
    @Delete
    void delete(Person person);

    // Gets all people in the database
    @Query("SELECT * FROM "+Person.TABLE_NAME)
    List<Person> getAllPeople();
}
