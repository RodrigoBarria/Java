package com.example.certamen2rbarriav4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cientifico extends AppCompatActivity {
    Button btnGrabar2, btnLimpiar2;
    EditText tbxNombres, tbxApellidos, tbxRut;
    RadioGroup rgrpSexoC;
    ;/*final para definir constantes*/
    Manejador_BD MDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cientifico);
        init();
    }
    private void init() {
        Toast.makeText(this, "INICIALIZANDO", Toast.LENGTH_LONG).show();
        tbxRut = (EditText) findViewById(R.id.tbxCodigoP);
        tbxNombres = (EditText) findViewById(R.id.tbxNombres);
        tbxApellidos = (EditText) findViewById(R.id.tbxNombreCP);
        btnGrabar2 = (Button) findViewById(R.id.btnGuardarc);
        btnLimpiar2 = (Button) findViewById(R.id.btnLimpiarc);
        MDB = new Manejador_BD(this);
    }

    public void Grabarc (View v)
    {
        int obtid3;
        String obtdet10, obtdet11, obtdet12;
        boolean siGrabo;
        obtid3 = Integer.parseInt(tbxRut.getText().toString());
        obtdet10 = tbxNombres.getText().toString();
        obtdet11 = tbxApellidos.getText().toString();
        obtdet12 = rgrpSexoC.toString();

        siGrabo = MDB.Guarda_Cientifico(obtid3, obtdet10, obtdet11, obtdet12);
        if (siGrabo) {
            Toast.makeText(this, "GRABO", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "NO GRABO", Toast.LENGTH_LONG).show();
        }
     }
}
