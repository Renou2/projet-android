package com.example.lienardr_projet.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity
public class Question {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "intitule")
    private String intitule;


    @ColumnInfo(name = "themeExo")
    private String themeExo;

    @ColumnInfo(name = "bonneRep")
    private String bonneRep;

    @ColumnInfo(name = "mauvaiseRep1")
    private String mauvaiseRep1;

    @ColumnInfo (name = "mauvaiseRep2")
    private  String mauvaiseRep2;



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() { return getIntitule(); }
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }


    public String getIntitule() {
        return intitule;
    }


    public String getBonneRep() {
        return bonneRep;
    }

    public void setBonneRep(String bonneRep) {
        this.bonneRep = bonneRep;
    }

    public String getMauvaiseRep1() {
        return mauvaiseRep1;
    }

    public void setMauvaiseRep1(String mauvaiseRep1) {
        this.mauvaiseRep1 = mauvaiseRep1;
    }

    public String getMauvaiseRep2() {
        return mauvaiseRep2;
    }

    public void setMauvaiseRep2(String mauvaiseRep2) {
        this.mauvaiseRep2 = mauvaiseRep2;
    }

    public String getThemeExo() {
        return themeExo;
    }

    public void setThemeExo(String themeExo) {
        this.themeExo = themeExo;
    }
}
