package com.example.lienardr_projet.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface ResultatDao {
    @Query("SELECT * FROM Resultat")
    List<Resultat> getAll();

    @Insert
    void insert(Resultat resultat);

    @Insert
    long[] insertAll(Resultat... resultat);

    @Delete
    void delete(Resultat resultat);

    @Update
    void update(Resultat resultat);
}
