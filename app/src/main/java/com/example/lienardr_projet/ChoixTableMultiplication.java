package com.example.lienardr_projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class ChoixTableMultiplication extends AppCompatActivity {
    NumberPicker number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_table_multiplication);
        number = findViewById(R.id.numberpicker);
        number.setMaxValue(10);
        number.setMinValue(0);
    }

    public void ValiderChoixTable(View view) {
        Intent intent = new Intent(this, TableMultiplication.class);
        intent.putExtra(TableMultiplication.TABLE_KEY, number.getValue());
        startActivity(intent);
    }
}
