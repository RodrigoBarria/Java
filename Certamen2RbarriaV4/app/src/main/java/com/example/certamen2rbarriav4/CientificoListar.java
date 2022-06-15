//RODRIGO ALEJANDRO BARRÍA FIGUEROA 17.395.919-2
package com.example.certamen2rbarriav4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CientificoListar extends AppCompatActivity {

    private int Rut;
    private String Nombres;
    private String Apellidos;
    private String Sexo;

        public CientificoListar() {

        }

    public int getRut() {
        return Rut;
    }

    public void setRut(int rut) {
        Rut = rut;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public CientificoListar(int Rut, String Nombres, String Apellidos, String Sexo) {
            Rut = Rut;
            Nombres = Nombres;
            Apellidos = Apellidos;
            Sexo = Sexo;
        }



    }