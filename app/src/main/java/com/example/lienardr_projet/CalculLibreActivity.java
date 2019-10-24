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

import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

public class CalculLibreActivity extends AppCompatActivity {
    ExerciceMaths exoCourant;
    public static final String OPERAND = "operand";
    public static final String OPERATOR = "Additions";
    public static final String NEGATIVE = "Negative";
    int operand;
    boolean moins;
    String operateur;
    ArrayList<EditText> texts;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul_libre);
        operand =  getIntent().getIntExtra(OPERAND, 10);
        operateur =  getIntent().getStringExtra(OPERATOR);
        moins = getIntent().getBooleanExtra(NEGATIVE, false);
        exoCourant = new ExerciceMaths();
        exoCourant.setNegativAuthorized(moins);
        exoCourant.setOperand(operand);
        exoCourant.setOperateur(operateur);
        exoCourant.setListesOperands();
        exoCourant.setReponsesLibres();
        texts = new ArrayList<>();
        layout = findViewById(R.id.layout);


        for(int i =0; i < 10; i++){

            LinearLayout lay = new LinearLayout(this);
            lay.setOrientation(HORIZONTAL);
            TextView tv = new TextView(this);
            if(exoCourant.getOperands1().get(i) <0){
                tv.setText("("+String.valueOf(exoCourant.getOperands1().get(i))+")"+exoCourant.getRealOperator());
            }else{
                tv.setText(String.valueOf(exoCourant.getOperands1().get(i))+exoCourant.getRealOperator());
            }

            if (exoCourant.getOperands2().get(i) < 0){
                tv.setText(tv.getText()+"("+String.valueOf(exoCourant.getOperands2().get(i))+") =");
            }else{
                tv.setText(tv.getText()+String.valueOf(exoCourant.getOperands2().get(i))+" =");
            }
            EditText edit = new EditText(this);
            edit.setId(i);
            edit.setInputType(InputType.TYPE_CLASS_NUMBER);
            texts.add(edit);
            lay.addView(tv);
            lay.addView(edit);
            layout.addView(lay, i);
        }
    }

    public void ValiderCalculLibre(View view) {
        ArrayList<Integer> resultats = new ArrayList<>();
        for(EditText et : texts){
            resultats.add(Integer.parseInt(et.getText().toString()));
        }
        int nbErreurs = exoCourant.verifReponses(resultats);
        if(nbErreurs !=0){
            Intent intent = new Intent(this, ErreurActivity.class);
            intent.putExtra(ErreurActivity.ERROR_KEY, nbErreurs);
            intent.putExtra(ErreurActivity.ORIGIN, "libre");
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, FelicitationActivity.class);
            intent.putExtra(ErreurActivity.ORIGIN, "libre");
            startActivity(intent);
        }
    }
}
