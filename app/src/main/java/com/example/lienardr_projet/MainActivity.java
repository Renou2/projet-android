package com.example.lienardr_projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {
    NumberPicker number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void RedirectExoTable(View view) {
        Intent intent = new Intent(MainActivity.this, ChoixTableMultiplication.class);
        startActivity(intent);
    }

    public void RedirectCalculsLibres(View view) {
        Intent intent = new Intent(this, ChoixCalculLibre.class);
        startActivity(intent);
    }

    public void RedirectChoixQCM(View view) {
        Intent intent = new Intent(this, ChoixQCM.class);
        startActivity(intent);
    }
}
