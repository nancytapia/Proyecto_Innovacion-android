package com.money.keepsafe.keepsafemoney;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.money.keepsafe.keepsafemoney.Conexion_basedatos.ConnectionClass;
import com.money.keepsafe.keepsafemoney.Inicio.CreateAccountActivity;
import com.money.keepsafe.keepsafemoney.Perfil.PerfilActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {

  ProgressDialog progressDialog;
  ConnectionClass connectionClass;

  EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.password);
        connectionClass = new ConnectionClass();
        progressDialog = new ProgressDialog(this);
    }

    public void goPerfil(View view) {

        Dologin dologin=new Dologin();
        dologin.execute();
    }

    public void goCreateAccount(View view) {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }

    private class Dologin extends AsyncTask<String,String,String> {


        String namestr=user.getText().toString();
        String passstr=pass.getText().toString();
        String z="";
        boolean isSuccess=false;
        String nom,ape_p,ape_m,fec,cont;


        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Loading...");
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            if(namestr.trim().equals("") || passstr.trim().equals(""))
                z = "Please enter all fields....";
            else {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Please check your internet connection";
                    } else {

                        String query=" select * from docente where nombre='"+namestr+"' and contraseña='"+passstr+"'";
                        Statement stmt = con.createStatement();
                         stmt.executeUpdate(query);
                        ResultSet rs=stmt.executeQuery(query);

                        while (rs.next())

                        { nom= rs.getString(1);
                            ape_p=rs.getString(2);
                            ape_m=rs.getString(3);;
                            fec=rs.getString(4);
                            cont=rs.getString(5);


                            if(nom.equals(namestr)&& cont.equals(passstr)) {
                                isSuccess=true;
                                z = "Login successfull";

                            } else
                                isSuccess=false;
                        }

                    }
                } catch (Exception ex) {
                    isSuccess = false;
                    z = "Exceptions"+ex;
                }
            }
            return z;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getBaseContext(),""+z,Toast.LENGTH_LONG).show();

            if(isSuccess) {

                Intent intent=new Intent(LoginActivity.this,PerfilActivity.class);
                intent.putExtra("nombre","Nombre:"+nom+" "+ape_p+" "+ape_m);
                intent.putExtra("fecha","Fecha Nac:"+fec);
                intent.putExtra("contraseña","contraseña:"+cont);
                startActivity(intent);
            }
            progressDialog.hide();
        }
    }


}
