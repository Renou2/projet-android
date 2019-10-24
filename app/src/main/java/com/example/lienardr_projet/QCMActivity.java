package com.example.lienardr_projet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lienardr_projet.db.DatabaseClient;

public class QCMActivity extends AppCompatActivity {
    public static final String THEME = "theme";
    private DatabaseClient mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qcm);
        mDb = DatabaseClient.getInstance(getApplicationContext());
    }
}
