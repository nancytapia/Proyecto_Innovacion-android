package com.money.keepsafe.keepsafemoney.Vistas_Actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.money.keepsafe.keepsafemoney.R;

public class ActividadesOne_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades_one_);
        showToolbar("Parcial 1",false);
    }
    private void showToolbar(String title, boolean upButton) {

        android.support.v7.widget.Toolbar toolbar= (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);

    }

    public void goActividadesFirst(View view) {

        Toast.makeText(this, "Actividades", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,FrameOne_Actividades.class);
        startActivity(intent);
    }
}
