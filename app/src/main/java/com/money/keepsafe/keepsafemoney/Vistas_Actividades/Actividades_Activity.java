package com.money.keepsafe.keepsafemoney.Vistas_Actividades;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.money.keepsafe.keepsafemoney.Menu_Grupos.Grupos_Activity;
import com.money.keepsafe.keepsafemoney.R;

public class Actividades_Activity extends AppCompatActivity {
private Button One;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades_);
        showToolbar("Grupo",false);


        }

    private void showToolbar(String title, boolean upButton) {

        android.support.v7.widget.Toolbar toolbar= (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);

    }

   public void goParcialOne(View view) {
       Intent intent= new Intent(this, ActividadesOne_Activity.class);
       startActivity(intent);

    }

    public void goParcialtwo(View view) {
        Intent intent= new Intent(this, ActividadesTwo_Activity.class);
        startActivity(intent);
    }

    public void goParcialthree(View view) {
        Intent intent= new Intent(this, ActividadestresActivity.class);
        startActivity(intent);
    }

    public void gosalir(View view) {

    }

    public void facebookIntent(View view){
        String url = "https:/www.facebook.com/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
    public void TwitterIntent(View view){
        String url = "https://www.twitter.com/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
    public void googleIntent(View view){
        String url = "https://www.plus.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
}
