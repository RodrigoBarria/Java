package com.example.certamen2rbarriav4;

public class Imagenrecoleccion {
    private int Cod1;
    private String Detalle1;
    private byte[] Foto1;

    public Imagenrecoleccion(){

    }

    public Imagenrecoleccion(int cod1, String Detalle1, byte[] Foto1) {
        Cod1 = cod1;
        this.Detalle1 = Detalle1;
        this.Foto1 = Foto1;
    }

    public int getCod2() {
        return Cod1;
    }

    public void setCod2(int cod) {
        Cod1 = cod;
    }

    public String getDetalle2() {
        return Detalle1;
    }

    public void setDetalle2(String detalle) {
        this.Detalle1 = detalle;
    }

    public byte[] getFoto2() {
        return Foto1;
    }

    public void setFoto2(byte[] foto) {
        this.Foto1 = foto;
    }
}