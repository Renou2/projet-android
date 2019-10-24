package com.example.lienardr_projet.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface QuestionDao {

    @Query("SELECT * FROM Question")
    List<User> getAll();

    @Insert
    void insert(Question question);

    @Insert
    long[] insertAll(Question... question);

    @Delete
    void delete(Question question);

    @Update
    void update(Question question);
}
