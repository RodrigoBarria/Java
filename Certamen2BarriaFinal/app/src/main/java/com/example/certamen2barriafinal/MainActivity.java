package com.example.certamen2barriafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button cientifico;
    Button planta;
    Button recoleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cientifico = findViewById(R.id.btnJumpCient);
        planta = findViewById(R.id.btnJumpPlant);
        recoleccion = findViewById(R.id.btnJumpRecol);
    }
    public void saltoCientifico(View view){
        Intent intent = new Intent(this, CientificoAct.class);
        startActivity(intent);
    }
    public void saltoPlanta(View view){
        Intent intent = new Intent(this, PlantasAct.class);
        startActivity(intent);
    }
    public void saltoRecoleccion(View view){
        Intent intent = new Intent(this, RecoleccionAct.class);
        startActivity(intent);
    }
}