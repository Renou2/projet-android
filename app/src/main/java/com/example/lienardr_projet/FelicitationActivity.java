package com.example.lienardr_projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FelicitationActivity extends AppCompatActivity {
    public static final String ORIGIN = "origine";
    String origine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitation);
        origine = getIntent().getStringExtra(ORIGIN);
    }
    public void choixTable(View view) {
        Intent intent = new Intent();
        if(origine.equals("multiplication")){
            intent = new Intent(this, ChoixTableMultiplication.class);
        }else if(origine.equals("libre")){
            intent = new Intent(this, ChoixCalculLibre.class);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void choixExo(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}
