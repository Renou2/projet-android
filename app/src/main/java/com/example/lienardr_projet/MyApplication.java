package com.example.lienardr_projet;

import android.app.Application;

import com.example.lienardr_projet.db.User;

public class MyApplication extends Application {
    private User UtilisateurCourant;

    public User getUtilisateurCourant() {
        return UtilisateurCourant;
    }

    public void setUtilisateurCourant(User utilisateurCourant) {
        UtilisateurCourant = utilisateurCourant;
    }
}
