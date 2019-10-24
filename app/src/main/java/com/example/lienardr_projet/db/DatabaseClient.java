package com.example.lienardr_projet.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

public class DatabaseClient {

    // Instance unique permettant de faire le lien avec la base de données
    private static DatabaseClient instance;

    // Objet représentant la base de données de votre application
    private AppDatabase appDatabase;

    // Constructeur
    private DatabaseClient(final Context context) {

        // Créer l'objet représentant la base de données de votre application
        // à l'aide du "Room database builder"
        // MyToDos est le nom de la base de données
        //appDatabase = Room.databaseBuilder(context, AppDatabase.class, "MyToDos").build();

        // Ajout de la méthode addCallback permettant de populate (remplir) la base de données à sa création
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "EcoleDesLoustics").addCallback(roomDatabaseCallback).build();
    }

    // Méthode statique
    // Retourne l'instance de l'objet DatabaseClient
    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    // Retourne l'objet représentant la base de données de votre application
    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    // Objet permettant de populate (remplir) la base de données à sa création
    RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {

        // Called when the database is created for the first time.
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            db.execSQL("INSERT INTO user (nom, prenom) VALUES(\"KEMPLAIRE\", \"LEOOOOOOOOOOO\");");
            db.execSQL("INSERT INTO user (nom, prenom) VALUES(\"DUTTO\", \"DRIIIIIIIIIIIISS\");");

            db.execSQL("INSERT INTO question (intitule, themeExo, bonneRep, mauvaiseRep1, mauvaiseRep2) VALUES(\"On a transféré au Panthéon, en novembre 2002, les cendres de : \", \"Littérature\", \"Alexandre Dumas\", \"Victor Hugo\", \"George Sand\");");
            db.execSQL("INSERT INTO question (intitule, themeExo, bonneRep, mauvaiseRep1, mauvaiseRep2) VALUES(\" Georges Simenon est né : \", \"Littérature\", \"A Liège\", \"A Paris\", \"A Lausanne\");");
            db.execSQL("INSERT INTO question (intitule, themeExo, bonneRep, mauvaiseRep1, mauvaiseRep2) VALUES(\" Amélie Nothomb n’a pas écrit : \", \"Littérature\", \"Truismes\", \"Hygiènes de l'assassin\", \"Stupeur et tremblements\");");
            db.execSQL("INSERT INTO question (intitule, themeExo, bonneRep, mauvaiseRep1, mauvaiseRep2) VALUES(\" Dans l’Iliade et l'Odyssée, combien de temps Ulysse reste-t-il éloigné de son royaume d'Ithaque et de sa femme Pénélope ? \", \"Littérature\", \"20 ans\", \"10 ans\", \"30 ans\");");
            db.execSQL("INSERT INTO question (intitule, themeExo, bonneRep, mauvaiseRep1, mauvaiseRep2) VALUES(\" Qui a écrit les romans Cent ans de solitude et L'amour au temps du choléra ? \", \"Littérature\", \"Gabriel Garcia Marquez\", \"Isabel Allende\", \"Mario Vargas Losa\");");
        }
    };
}
