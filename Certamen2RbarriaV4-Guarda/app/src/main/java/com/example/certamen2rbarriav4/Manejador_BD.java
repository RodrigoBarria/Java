//RODRIGO ALEJANDRO BARRÍA FIGUEROA 17.395.919-2
package com.example.certamen2rbarriav4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Manejador_BD extends SQLiteOpenHelper {
    public String Tablas;
    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "ALMANAQUE.sqlite";
    private static final String PLANTAS = "CREATE TABLE PLANTAS (" +
            "IDP INT PRIMARY KEY AUTOINCREMENT," +
            "CODP INT, " +
            "NOMBREP TEXT, " +
            "NOMBRECP TEXT, " +
            "USOS TEXT, " +
            "FOTOP BLOB)";
    private static final String CIENTIFICO = "CREATE TABLE CIENTIFICO (" +
            "ID INT PRIMARY KEY AUTOINCREMENT, " +
            "RUTC TEXT NOT NULL, " +
            "NOMBRES TEXT NOT NULL, " +
            "APELLIDOS TEXT NOT NULL, " +
            "SEXO TEXT NOT NULL)";
    private static final String RECOLECCION = "CREATE TABLE RECOLECCION (" +
            "IDR PRIMARY KEY AUTOINCREMENT," +
            "IDREC INT, " +
            "FECHAREG INT, " +
            "CODPR INT, " +
            "RUTCR INT, " +
            "COMENTARIO TEXT, " +
            "FOTOR BLOB, " +
            "LONGITUD REAL, " +
            "LATITUD REAL)";

    // Constructor BD
    public Manejador_BD(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    //Creación de Tablas BD
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PLANTAS);
        db.execSQL(CIENTIFICO);
        db.execSQL(RECOLECCION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Código
    }


    //--------------------------------METODO GRABAR REGISTRO PLANTA---------------------------------
    public boolean Guarda_ImagenP(int codp, String nombrep, String nombrecp, String usos, byte[] fotop) {
        boolean sw1 = true;
        SQLiteDatabase db = getWritableDatabase(); //ABRE BASE DE DATOS EN MODO ESCRITURA
        if (db != null) {//SI LA BASE EXISTE

            ContentValues valores = new ContentValues();
            valores.put("CODP", codp);
            valores.put("NOMBREP", nombrep);
            valores.put("NOMBRECP", nombrecp);
            valores.put("USOS", usos);
            valores.put("FOTOP", fotop);

            try {
                db.insert("PLANTAS", null, valores);
                db.close();
            } catch (Exception e) {
                db.close();
                sw1 = false;
            }
        } else {
            onCreate(db);
        }
        return sw1;
    }

    //---------------------------METODO PARA CONSULTAR UN REGISTRO PLANTA---------------------
    public Imagenplanta entrega_fotop(int Cod) {
        SQLiteDatabase db = getReadableDatabase();
        Imagenplanta datos = new Imagenplanta();
        try {

            Cursor c = db.rawQuery("SELECT * FROM IMAGENES WHERE COD=" + Cod + "", null);

            if (c.moveToFirst()) {

                //byte[] bytes = c.getBlob(c.getColumnIndex("IMAGEN"));
                datos = new Imagenplanta(c.getInt(0), c.getString(1), c.getBlob(2));
                this.close();
                c.close();
                return datos;
            } else {
                this.close();
                c.close();
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    //--------------------------------METODO GRABAR REGISTRO CIENTIFICO-----------------------------

    public boolean Guarda_Cientifico(String rutc, String nombres, String apellidos, String sexo) {
        boolean sw = true;
        SQLiteDatabase db = getWritableDatabase(); //ABRE BASE DE DATOS EN MODO ESCRITURA
        if (db != null) {//SI LA BASE EXISTE

            ContentValues valores2 = new ContentValues();
            valores2.put("RUTC", rutc);
            valores2.put("NOMBRES", nombres);
            valores2.put("APELLIDOS", apellidos);
            valores2.put("SEXO", sexo);

            try {
                db.insert("CIENTIFICO", null, valores2);
                db.close();
            } catch (Exception e) {
                db.close();
                sw = false;
            }
        } else {
            onCreate(db);
        }
        return sw;
    }

    //---------------------------METODO GRABAR REGISTRO RECOLECCION-----------------------------
    public boolean Guarda_ImagenR(int idr, String fechar, String CodPlantr, String rutr, String latitud, String longitud, String fotor) {
        boolean sw = true;
        SQLiteDatabase db = getWritableDatabase(); //ABRE BASE DE DATOS EN MODO ESCRITURA
        if (db != null) {//SI LA BASE EXISTE

            ContentValues valores3 = new ContentValues();
            valores3.put("IDR", idr);
            valores3.put("FECHAR", fechar);
            valores3.put("CODPLANTR", CodPlantr);
            valores3.put("RUTR", rutr);
            valores3.put("LATITUD", latitud);
            valores3.put("LONGTUD", longitud);
            valores3.put("FOTOR", fotor);

            try {
                db.insert("RECOLECCION", "FOTOR", valores3);
                db.close();
            } catch (Exception e) {
                db.close();
                sw = false;
            }
        } else {
            onCreate(db);
        }
        return sw;    //AQUÍ SE SIGUEN AGREGANDO MÉTODOS
    }

    //---------------------------METODO PARA CONSULTAR UN REGISTRO RECOLECCIÓN---------------------

    public Imagenrecoleccion entrega_fotor(int Cod) {
        SQLiteDatabase db = getReadableDatabase();
        Imagenrecoleccion datos = new Imagenrecoleccion();
        try {

            Cursor c = db.rawQuery("SELECT * FROM IMAGENES WHERE COD=" + Cod + "", null);

            if (c.moveToFirst()) {

                //byte[] bytes = c.getBlob(c.getColumnIndex("IMAGEN"));
                datos = new Imagenrecoleccion(c.getInt(0), c.getString(1), c.getBlob(2));
                this.close();
                c.close();
                return datos;
            } else {
                this.close();
                c.close();
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}