package com.money.keepsafe.keepsafemoney.Fragmentos;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.money.keepsafe.keepsafemoney.LoginActivity;
import com.money.keepsafe.keepsafemoney.Menu_Grupos.Grupos_Activity;
import com.money.keepsafe.keepsafemoney.R;

import java.util.Random;

public class Create_Group_ragment extends Fragment {

    public Create_Group_ragment() {
        // Required empty public constructor
    }


   private Button btn_crear;
   private EditText txt1,txt2,txt3;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View vista = inflater.inflate(R.layout.fragment_create__group_ragment, container, false);

      btn_crear=vista.findViewById(R.id.botn_crear);
      txt1=vista.findViewById(R.id.namegroup);
      txt2=vista.findViewById(R.id.matter);
      txt3=vista.findViewById(R.id.description);

    btn_crear.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getContext(), "Grupo Creado", Toast.LENGTH_SHORT).show();

            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            int codigo;
            Random codigoaleatorio = new Random();
            codigo=codigoaleatorio.nextInt(5000);

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setCancelable(false);
            builder.setTitle("Codigo del grupo");
            builder.setMessage("201633072");
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                   

                }
            });
            builder.create().show();
        }
    });
      return  vista;
    }

}
