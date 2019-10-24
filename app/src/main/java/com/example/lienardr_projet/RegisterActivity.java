package com.example.lienardr_projet;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lienardr_projet.db.DatabaseClient;
import com.example.lienardr_projet.db.User;

public class RegisterActivity extends AppCompatActivity {
    EditText etprenom;
    EditText etnom;
    private DatabaseClient mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDb = DatabaseClient.getInstance(getApplicationContext());
        setContentView(R.layout.activity_register);
        etprenom = findViewById(R.id.register_prenom);
        etnom = findViewById(R.id.register_nom);
    }


    public void saveUser(View view) {

        // Récupérer les informations contenues dans les vues
        final String sNom = etnom.getText().toString().trim();
        final String sPrenom = etprenom.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        if (sNom.isEmpty()) {
            etnom.setError("Name required");
            etnom.requestFocus();
            return;
        }

        if (sPrenom.isEmpty()) {
            etprenom.setError("Prenom required");
            etprenom.requestFocus();
            return;
        }
        /**
         * Création d'une classe asynchrone pour sauvegarder la tache donnée par l'utilisateur
         */
        class SaveUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {

                // creating a task
                User user = new User();
                user.setNom(sNom);
                user.setPrenom(sPrenom);

                // adding to database
                mDb.getAppDatabase()
                        .userDao()
                        .insert(user);

                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }
        SaveUser su = new SaveUser();
        su.execute();
    }
}