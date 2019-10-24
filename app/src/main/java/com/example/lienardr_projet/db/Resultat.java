package com.example.lienardr_projet.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity
        (foreignKeys = {@ForeignKey(entity = User.class,
                parentColumns = "id",
                childColumns = "idEleve",
                onDelete = CASCADE),
                @ForeignKey(entity = Exercice.class,
                parentColumns = "idExercice",
                childColumns = "idExercice",
                onDelete = CASCADE)})

public class Resultat {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "idEleve")

    private int idEleve;

    @ColumnInfo(name = "idExercice")
    private int idExercice;

    @ColumnInfo(name = "resultat")
    private int resultat;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public int getIdExercice() {
        return idExercice;
    }

    public int getResultat() {
        return resultat;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    public void setIdExercice(int idExercice) {


    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
}


