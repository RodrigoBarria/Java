package com.example.certamen2barriafinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BarriaDB extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS="AlmanaqueDePlantas.sqlite";

    public BarriaDB(Context context){
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Cientifico_table" + "(_rut INT PRIMARY KEY, nombre TEXT, apellido TEXT, sexo TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE Plantas_table" +  "(_idplanta INT PRIMARY KEY, nombre_p TEXT, nombre_cientifico_planta TEXT, foto BLOB, uso_p TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE Recoleccion_table" + "(_id INT PRIMARY KEY, fecha TEXT, _idplanta INT, _rut INT, comment TEXT, foto_lugar BLOB, localizacion TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



    // Manejadores Cientifico
    public boolean agregaCientifico(int rut, String nombre, String apellido, String sexo){
        boolean sw1 = true;
        SQLiteDatabase db= getWritableDatabase();

        if(db!=null){
            ContentValues valores = new ContentValues();
            valores.put("_rut",rut);
            valores.put("nombre",nombre);
            valores.put("apellido",apellido);
            valores.put("sexo",sexo);

            try{
                db.insert("Cientifico_table",null,valores);
                db.close();
            }catch (Exception e){
                db.close();
                sw1=false;
            }

        }else {
            sw1=false;

            this.onCreate(db);
        }

        return sw1;
    }
    public ArrayList<Cientifico> getListaDeCientificos(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Cientifico_table ORDER by nombre DESC",null);
        ArrayList <Cientifico> lista = new ArrayList<Cientifico>();
        try{

            while(c.moveToNext()) {
                Cientifico datos = new Cientifico(c.getInt(0), c.getString(1), c.getString(2), c.getString(3));
                lista.add(datos);

            }
            c.close();
            return lista;
        }catch (Exception e){
            return null;
        }
    }

    public Cientifico getCientifico(int rut){
        SQLiteDatabase db = getReadableDatabase();
        Cientifico datos= new Cientifico();
        try{
            Cursor c = db.rawQuery("SELECT * FROM Cientifico_table WHERE nombre='"+rut+"'",null);
            if(c.moveToFirst()){

                datos = new Cientifico(c.getInt(0),c.getString(1),c.getString(2), c.getString(3));
                this.close();
                c.close();
                return datos;
            }else{
                this.close();
                c.close();
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }
    public boolean actualizaCientifico(int rut, String nombre, String apellido, String sexo){
        boolean sw1 = true;
        SQLiteDatabase db= getWritableDatabase();

        if(db!=null){
            ContentValues valores = new ContentValues();

            valores.put("nombre",nombre);
            valores.put("apellido",apellido);
            valores.put("sexo",sexo);

            try{
                String[] args= new String[]{String.valueOf(rut)};
                db.update("Cientifico_table",valores,"_rut=?",args);
                db.close();
            }catch (Exception e){
                db.close();
                sw1=false;
            }

        }else {
            sw1=false;
        }

        return sw1;
    }
    public boolean  eliminaCientifico(int rut){

        boolean sw1 = true;
        SQLiteDatabase db= getWritableDatabase();

        if(db!=null){


            try{
                String[] args= new String[]{String.valueOf(rut)};
                db.delete("Cientifico_table","_rut=?",args);
                db.close();
            }catch (Exception e){
                db.close();
                sw1=false;
            }

        }else {
            sw1=false;
        }

        return sw1;
    }

    // Manejadores Plantas
    public boolean agregaPlantas(int idplanta, String nombre_p, String nombre_cientifico_planta, byte[] foto, String uso_p){
        boolean sw1 = true;
        SQLiteDatabase db= getWritableDatabase();

        if(db!=null){
            ContentValues valores = new ContentValues();
            valores.put("_idplanta", idplanta);
            valores.put("nombre_p", nombre_p);
            valores.put("nombre_cientifico_planta",nombre_cientifico_planta);
            valores.put("foto",foto);
            valores.put("uso_p",uso_p);

            try{
                db.insert("Plantas_table",null,valores);
                db.close();
            }catch (Exception e){
                db.close();
                sw1=false;
            }

        }else {
            onCreate(db);
        }

        return sw1;
    }
    public Plantas getPlantas(String nom){
        SQLiteDatabase db = getReadableDatabase();
        Plantas datos= new Plantas();
        try{
            Cursor c = db.rawQuery("SELECT * FROM PlantasBalboa WHERE nombre_p="+nom+"",null);
            if(c.moveToFirst()){
                //byte[] bytes = c.getBlob(c.getColumnIndex("IMAGEN"));
                datos = new Plantas(c.getInt(0),c.getString(1),c.getString(2), c.getBlob(3),c.getString(4));
                this.close();
                c.close();
                return datos;
            }else{
                this.close();
                c.close();
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }
    public boolean actualizaPlantas(int idplanta, String nombre_p, String nombre_cientifico_planta, byte[] foto, String uso_p){
        boolean sw1 = true;
        SQLiteDatabase db= getWritableDatabase();

        if(db!=null){
            ContentValues valores = new ContentValues();
            valores.put("_idplanta", idplanta);
            valores.put("nombre_p", nombre_p);
            valores.put("nombre_cientifico_planta",nombre_cientifico_planta);
            valores.put("foto",foto);
            valores.put("uso_p",uso_p);

            try{
                String[] args= new String[]{String.valueOf(idplanta)};
                db.update("Plantas_table",valores,"_id_planta=?",args);
                db.close();
            }catch (Exception e){
                db.close();
                sw1=false;
            }

        }else {
            sw1=false;
        }

        return sw1;
    }
    public boolean eliminaPlantas(int idplanta){

        boolean sw1 = true;
        SQLiteDatabase db= getWritableDatabase();

        if(db!=null){


            try{
                String[] args= new String[]{String.valueOf(idplanta)};
                db.delete("Plantas_table","_idplanta=?",args);
                db.close();
            }catch (Exception e){
                db.close();
                sw1=false;
            }

        }else {
            sw1=false;
        }

        return sw1;
    }

    // Manejadores Recoleccion
    public boolean agregaRecoleccion(int id,String fecha, int idplanta, int rut, String comentario, byte[] foto_lugar, String localizacion){
        boolean sw1 = true;
        SQLiteDatabase db= getWritableDatabase();

        if(db!=null){
            ContentValues valores = new ContentValues();
            valores.put("_id", id);
            valores.put("fecha", fecha);
            valores.put("_idplanta", idplanta);
            valores.put("_rut",rut);
            valores.put("foto_lugar",foto_lugar);
            valores.put("comentario",comentario);
            valores.put("localizacion",localizacion);

            try{
                db.insert("Recoleccion_table",null,valores);
                db.close();
            }catch (Exception e){
                db.close();
                sw1=false;
            }

        }else {
            onCreate(db);
        }

        return sw1;
    }
    public Recoleccion getRecoleccion(int id){
        SQLiteDatabase db = getReadableDatabase();
        Recoleccion datos= new Recoleccion();
        try{

            Cursor c = db.rawQuery("SELECT * FROM Recoleccion_table WHERE _id="+String.valueOf(id)+"",null);
            if(c.moveToFirst()){
                //byte[] bytes = c.getBlob(c.getColumnIndex("IMAGEN"));
                datos = new Recoleccion(c.getInt(0),c.getString(1),c.getInt(2), c.getInt(3),c.getString(4), c.getBlob(5),c.getString(6) );
                this.close();
                c.close();
                return datos;
            }else{
                this.close();
                c.close();
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }
    public boolean actualizaRecoleccion(int id,String fecha, int idplanta, int rut, String comentario, byte[] foto_lugar, String localizacion){
        boolean sw1 = true;
        SQLiteDatabase db= getWritableDatabase();

        if(db!=null){
            ContentValues valores = new ContentValues();
            valores.put("_id", id);
            valores.put("fecha", fecha);
            valores.put("_idplanta", idplanta);
            valores.put("_rut",rut);
            valores.put("foto_lugar",foto_lugar);
            valores.put("comentario",comentario);
            valores.put("localizacion",localizacion);
            try{
                String[] args= new String[]{String.valueOf(id)};
                db.update("Recoleccion_table",valores,"_id=?",args);
                db.close();
            }catch (Exception e){
                db.close();
                sw1=false;
            }

        }else {
            sw1=false;
        }

        return sw1;
    }
    public boolean eliminaRecoleccion(int id){

        boolean sw1 = true;
        SQLiteDatabase db= getWritableDatabase();

        if(db!=null){


            try{
                String[] args= new String[]{String.valueOf(id)};
                db.delete("Recoleccion_table","_id=?",args);
                db.close();
            }catch (Exception e){
                db.close();
                sw1=false;
            }

        }else {
            sw1=false;
        }

        return sw1;
    }

}
