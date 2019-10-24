package com.example.lienardr_projet.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Insert
    void insert(User user);

    @Insert
    long[] insertAll(User... user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);
}
