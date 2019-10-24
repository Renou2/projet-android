package com.example.lienardr_projet.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {User.class, Exercice.class, Question.class, Resultat.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    public abstract UserDao userDao();
    public abstract ExerciceDao exerciceDao();
    public abstract QuestionDao questionDao();
    public abstract ResultatDao resultatDao();
}
