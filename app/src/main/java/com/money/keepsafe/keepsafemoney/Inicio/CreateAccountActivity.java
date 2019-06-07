package com.money.keepsafe.keepsafemoney.Inicio;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.money.keepsafe.keepsafemoney.Conexion_basedatos.ConnectionClass;
import com.money.keepsafe.keepsafemoney.LoginActivity;
import com.money.keepsafe.keepsafemoney.Perfil.PerfilActivity;
import com.money.keepsafe.keepsafemoney.R;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Calendar;

public class CreateAccountActivity extends AppCompatActivity {



       private RadioGroup tipo_usuario;
       private  EditText nombre,contraseña,fec_nac,conf_contraseña,Apellido_P,Apellidp_M;
       private ProgressDialog progressDialog;
       private ConnectionClass connectionClass;
       String type_user="";
    private static  final String TAG="CreateAccountActivity";
    private DatePickerDialog.OnDateSetListener DatesetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_title_createaccount),true);
        //Controladores


        //Editext
        nombre=(EditText) findViewById(R.id.name);
        contraseña=(EditText) findViewById(R.id.password_create_account);
        conf_contraseña=(EditText) findViewById(R.id.confirmpassword);
        fec_nac=(EditText) findViewById(R.id.fechaNac);
        Apellido_P=(EditText) findViewById(R.id.App);
        Apellidp_M=(EditText) findViewById(R.id.Apm);


        DatesetListener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month+1;

                Log.d(TAG,"onDateSet: mm/dd/yyyy" +month+ "/" +day+ "/" +year);

                String date = day + "/" +month+ "/" +year;

                fec_nac.setText(date);
            }
        };

        //Conexxion y progress
        connectionClass = new ConnectionClass();
        progressDialog = new ProgressDialog(this);

    }

    private void showToolbar(String title, boolean upButton) {

        android.support.v7.widget.Toolbar toolbar= (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);

    }

    public void goDate(View view) {
        Calendar cal= Calendar.getInstance();

        int year  = cal.get(Calendar.YEAR);
        int month  = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                CreateAccountActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                DatesetListener,
                year,month,day);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    public void goRegister(View view) {

        if(contraseña.getText().toString().equals(conf_contraseña.getText().toString())){
            Doregister doregister = new Doregister();
            doregister.execute("");


        }else{
            Toast.makeText(this, "La contraseña no coinciden", Toast.LENGTH_SHORT).show();
        }

    }

    public class Doregister extends AsyncTask<String,String,String> {

        public void Limpiar_Campos(){
            nombre.setText("");
            contraseña.setText("");
            conf_contraseña.setText("");
            fec_nac.setText("");
            Apellidp_M.setText("");
            Apellido_P.setText("");
        }

        String Name=nombre.getText().toString();
        String Contraseña=contraseña.getText().toString();
        String Fecha=fec_nac.getText().toString();
        String App=Apellido_P.getText().toString();
        String Apm=Apellidp_M.getText().toString();
        String z="";
        boolean isSuccess=false;

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            if(Name.trim().equals("")||Contraseña.trim().equals("")||Fecha.trim().equals("") ||App.trim().equals("")||Apm.trim().equals("")||App.trim().equals(""))
                z = "Please enter all fields....";
            else {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Please check your internet connection";
                    } else {

                        String query="insert into "+type_user+" values('"+Name+"','"+App+"','"+Apm+"','"+Fecha+"','"+Contraseña+"')";

                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(query);

                        z = "Register successfull";
                        isSuccess=true;

                    }
                }
                catch (Exception ex) {
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
                startActivity(new Intent(CreateAccountActivity.this, LoginActivity.class));

            }
            progressDialog.hide();
            Limpiar_Campos();
        }


    }
}
