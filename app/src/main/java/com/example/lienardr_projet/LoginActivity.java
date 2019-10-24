package com.example.lienardr_projet;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import com.example.lienardr_projet.Adapters.UsersAdapter;
import com.example.lienardr_projet.db.DatabaseClient;
import com.example.lienardr_projet.db.User;


public class LoginActivity extends AppCompatActivity {
    //
    private static final int REQUEST_CODE_ADD = 0;

    // DATA
    private DatabaseClient mDb;
    private UsersAdapter adapter;

    // VIEW
    private Button buttonAdd;
    private ListView listUser;

    MyApplication myapp;
    public LoginActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myapp = new MyApplication();

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        listUser = findViewById(R.id.userlist);
        buttonAdd = findViewById(R.id.login_add_button);

        // Lier l'adapter au listView
        adapter = new UsersAdapter(this, new ArrayList<User>());
        listUser.setAdapter(adapter);



        // EXEMPLE : Ajouter un événement click à la listView
        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                User user = adapter.getItem(position);
                myapp.setUtilisateurCourant(user);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);

            }
        });

        // EXEMPLE : Ajouter un événement long click à la listView
        listUser.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                // Récupération de la tâche cliquée à l'aide de l'adapter
                User user = adapter.getItem(position);

                // Message
                Toast.makeText(LoginActivity.this, "LongClick : " + user.getPrenom(), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        // Mise à jour des taches
        getUsers();
    }

    private void getUsers() {

        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> taskList = mDb.getAppDatabase()
                        .userDao()
                        .getAll();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);

                // Mettre à jour l'adapter avec la liste de users
                adapter.clear();
                adapter.addAll(users);

                // Now, notify the adapter of the change in source
                adapter.notifyDataSetChanged();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        // Création d'un objet de type GetTasks et execution de la demande asynchrone
        GetUsers gt = new GetUsers();
        gt.execute();
    }

    public void RedirectRegisterActivity(View view) {

        Intent intent = new Intent(this, RegisterActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK) {

            // Mise à jour des taches
            getUsers();
        }
    }
}
