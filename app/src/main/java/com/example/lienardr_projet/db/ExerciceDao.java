package com.example.lienardr_projet.db;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ExerciceDao {

    @Query("SELECT * FROM Exercice")
    List<Exercice> getAll();

    @Insert
    void insert(Exercice exercice);

    @Insert
    long[] insertAll(Exercice... exercice);

    @Delete
    void delete(Exercice exercice);

    @Update
    void update(Exercice exercice);
}
