package com.example.lienardr_projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ChoixQCM extends AppCompatActivity {
    RadioGroup rg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_qcm);
        rg1 = findViewById(R.id.qcm_rg1);
    }

    public void RedirectQCM(View view) {
        String theme =  "";
        int radioButtonId = rg1.getCheckedRadioButtonId();
        if( radioButtonId != -1 ) {
            RadioButton radioButton = (RadioButton) rg1.findViewById(radioButtonId);
            if( radioButton != null ) {
                theme = radioButton.getText().toString();
            }
        }
        if(theme != ""){
            Intent intent = new Intent(this, QCMActivity.class);
            intent.putExtra(QCMActivity.THEME, theme);
            startActivity(intent);
        }
    }
}
