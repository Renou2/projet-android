package com.example.lienardr_projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lienardr_projet.db.ExerciceMaths;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

public class TableMultiplication extends AppCompatActivity {
    public static final String TABLE_KEY = "table_key";
    private LinearLayout layout;
    private ArrayList<EditText> texts;
    private ExerciceMaths exerciceCourant;
    int table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication);
        layout = findViewById(R.id.layout);
        table = getIntent().getIntExtra(TABLE_KEY, 0);
        exerciceCourant = new ExerciceMaths();
        texts = new ArrayList<>();
        exerciceCourant.setReponsesTables(table);
        for(int i =1; i <= 10; i++){

            LinearLayout lay = new LinearLayout(this);
            lay.setOrientation(HORIZONTAL);
            TextView tv = new TextView(this);
            tv.setText(String.valueOf(i)+" x "+String.valueOf(table)+"=");
            EditText edit = new EditText(this);
            edit.setId(i);
            edit.setInputType(InputType.TYPE_CLASS_NUMBER);
            texts.add(edit);
            lay.addView(tv);
            lay.addView(edit);
            layout.addView(lay, i);
        }
    }

    public void ValiderResultats(View view) {
        ArrayList<Integer> resultats = new ArrayList<>();
        for(EditText et : texts){
            resultats.add(Integer.parseInt(et.getText().toString()));
        }
        int nbErreurs = exerciceCourant.verifReponses(resultats);
        if(nbErreurs !=0){
            Intent intent = new Intent(this, ErreurActivity.class);
            intent.putExtra(ErreurActivity.ERROR_KEY, nbErreurs);
            intent.putExtra(ErreurActivity.ORIGIN, "multiplication");
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, FelicitationActivity.class);
            intent.putExtra(ErreurActivity.ORIGIN, "multiplication");
            startActivity(intent);
        }
    }
}
