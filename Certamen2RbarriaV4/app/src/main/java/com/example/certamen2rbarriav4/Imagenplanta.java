//RODRIGO ALEJANDRO BARRÍA FIGUEROA 17.395.919-2
package com.example.certamen2rbarriav4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Imagenplanta {
    private int Cod;
    private String Detalle;
    private byte[] Foto;

    public Imagenplanta() {

    }

    public Imagenplanta(int cod, String Detalle, byte[] Foto) {
        Cod = cod;
        this.Detalle = Detalle;
        this.Foto = Foto;
    }


    public int getCod() {
        return Cod;
    }

    public void setCod(int cod) {
        Cod = cod;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String detalle) {
        this.Detalle = detalle;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] foto) {
        this.Foto = foto;
    }
    }