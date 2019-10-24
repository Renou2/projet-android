package com.example.lienardr_projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

public class ChoixCalculLibre extends AppCompatActivity {
    RadioGroup rg1;
    RadioGroup rg2;
    ToggleButton btnMoins;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_calcul_libre);
        rg1 = findViewById(R.id.ccl_rg);
        rg2 = findViewById(R.id.ccl_rg2);
        btnMoins = findViewById(R.id.ccl_b_moins);
    }


    public void RedirectExerciceLibre(View view) {
        boolean moins = btnMoins.isChecked();
        int operand = 0;
        int radioButtonId = rg1.getCheckedRadioButtonId();
        if( radioButtonId != -1 ) {
            RadioButton radioButton = (RadioButton) rg1.findViewById(radioButtonId);
            if( radioButton != null ) {
                operand = Integer.parseInt(radioButton.getText().toString());
            }
        }
        String operateur =  "";
        radioButtonId = rg2.getCheckedRadioButtonId();
        if( radioButtonId != -1 ) {
            RadioButton radioButton = (RadioButton) rg2.findViewById(radioButtonId);
            if( radioButton != null ) {
                operateur = radioButton.getText().toString();
            }
        }

        if(operand != 0 && operateur != ""){
            Intent intent = new Intent(this, CalculLibreActivity.class);
            intent.putExtra(CalculLibreActivity.OPERATOR, operateur);
            intent.putExtra(CalculLibreActivity.OPERAND, operand);
            intent.putExtra(CalculLibreActivity.NEGATIVE, moins);
            startActivity(intent);
        }
    }
}
