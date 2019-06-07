package com.money.keepsafe.keepsafemoney.Vistas_Actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.money.keepsafe.keepsafemoney.R;

public class ActividadestresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividadestres);
        showToolbar("Parcial 3",false);
    }
    private void showToolbar(String title, boolean upButton) {

        android.support.v7.widget.Toolbar toolbar= (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);

    }
}
