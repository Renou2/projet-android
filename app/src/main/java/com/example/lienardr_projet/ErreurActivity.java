package com.example.lienardr_projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.TextView;

public class ErreurActivity extends AppCompatActivity {
    public static final String ERROR_KEY = "ERROR_key";
    public static final String ORIGIN = "origine";
    String origine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreur);

        int nber = getIntent().getIntExtra(ERROR_KEY, 0);
        origine = getIntent().getStringExtra(ORIGIN);



        TextView tv = findViewById(R.id.erreur_nberreurs);
        tv.setText(getResources().getString(R.string.erreur_nberreurs) + Integer.toString(nber));
    }
    public void CORRIGER(View view) {
        Intent intent = new Intent();
        if(origine.equals("multiplication")){
            intent = new Intent(this, TableMultiplication.class);
        }else if(origine.equals("libre")){
            intent = new Intent(this, CalculLibreActivity.class);
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void CHANGETABLE(View view) {
        Intent intent = new Intent();
        if(origine.equals("multiplication")){
            intent = new Intent(this, ChoixTableMultiplication.class);
        }else if(origine.equals("libre")){
            intent = new Intent(this, ChoixCalculLibre.class);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}
