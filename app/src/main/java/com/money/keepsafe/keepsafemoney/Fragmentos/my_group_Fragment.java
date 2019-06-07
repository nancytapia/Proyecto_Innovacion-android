package com.money.keepsafe.keepsafemoney.Fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.money.keepsafe.keepsafemoney.R;
import com.money.keepsafe.keepsafemoney.Vistas_Actividades.Actividades_Activity;

import java.util.Calendar;


public class my_group_Fragment extends Fragment {


    View vista;
    TextView Carrera;
    public my_group_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final Fragment[] miFragment = {null};
        final boolean[] fragmentSeleccionado = {false};
        vista=inflater.inflate(R.layout.fragment_my_group_, container, false);
        Carrera=(TextView)vista.findViewById(R.id.carrer);

        Carrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Actividades_Activity.class);
                startActivity(intent);

            }
        });
        // Inflate the layout for this fragment
        return vista;
    }

}
