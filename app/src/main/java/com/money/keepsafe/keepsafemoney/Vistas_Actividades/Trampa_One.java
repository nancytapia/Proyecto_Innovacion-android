package com.money.keepsafe.keepsafemoney.Vistas_Actividades;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.money.keepsafe.keepsafemoney.R;

public class Trampa_One extends AppCompatActivity {
TextView txt;
LinearLayout lolo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trampa__one);
        txt=(TextView)findViewById(R.id.desactivada);
        lolo=(LinearLayout)findViewById(R.id.layo2);
        showToolbar(getResources().getString(R.string.toolbar_title_profile),true);
    }
    private void showToolbar(String title, boolean upButton) {

        android.support.v7.widget.Toolbar toolbar= (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);

    }
    public void goActivadas(View view) {

        txt.setText("Activada");
        int co =getResources().getColor(R.color.sobra_card2);
        lolo.setBackgroundColor(co);
    }
}
