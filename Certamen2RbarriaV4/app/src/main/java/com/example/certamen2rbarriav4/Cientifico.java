//RODRIGO ALEJANDRO BARRÍA FIGUEROA 17.395.919-2
package com.example.certamen2rbarriav4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cientifico extends AppCompatActivity {
    Button btnGrabar2, btnLimpiar2, btnActualizarC, btnModificarC;
    EditText tbxNombres, tbxApellidos, tbxRut;
    RadioGroup rgrpSexoC;
    ListView lvCientificos;
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
        tbxRut = (EditText) findViewById(R.id.tbxRut);
        tbxNombres = (EditText) findViewById(R.id.tbxNombres);
        tbxApellidos = (EditText) findViewById(R.id.tbxApellidos);
        btnGrabar2 = (Button) findViewById(R.id.btnGuardarc);
        btnLimpiar2 = (Button) findViewById(R.id.btnLimpiarc);
        rgrpSexoC = (RadioGroup) findViewById(R.id.rgrpSexoC);
        MDB = new Manejador_BD(this);
    }

    public void Grabarc (View v)
    {
        //int obtid3;
        String obtdet10;
        String obtdet11;
        String obtdet12;
        String obtdet13;
        boolean siGrabo;
        obtdet10 = tbxRut.getText().toString();
        obtdet11 = tbxNombres.getText().toString();
        obtdet12 = tbxApellidos.getText().toString();
        obtdet13 = rgrpSexoC.toString();

        siGrabo = MDB.Guarda_Cientifico(obtdet10, obtdet11, obtdet12, obtdet13);
        if (siGrabo) {
            Toast.makeText(this, "GRABO", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "NO GRABO", Toast.LENGTH_LONG).show();
        }
     }
}
