package com.example.lienardr_projet.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Exercice {

        @PrimaryKey(autoGenerate = true)
        private int idExercice;

        @ColumnInfo(name = "nom")
        private String nom;


        @ColumnInfo(name = "aide")
        private String aide;

        @ColumnInfo(name = "desc")
        private String desc;




        public String getNom() {
            return nom;
        }
        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getAide() { return aide; }
        public void setAide(String aide) { this.aide = aide; }

        public String getDesc() { return desc; }
        public void setDesc(String desc) { this.desc = desc; }


        public int getIdExercice() {
                return idExercice;
        }

        public void setIdExercice(int idExercice) {
                this.idExercice = idExercice;
        }
}

