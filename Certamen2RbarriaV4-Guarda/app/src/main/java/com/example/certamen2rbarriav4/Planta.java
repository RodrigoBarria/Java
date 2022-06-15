//RODRIGO ALEJANDRO BARRÍA FIGUEROA 17.395.919-2
package com.example.certamen2rbarriav4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class Planta extends AppCompatActivity implements View.OnLongClickListener {
    ImageView imgV1;
    Button btnCamara, btnGrabar, btnLimpiar;
    EditText tbxCodigo, tbxNombreP, tbxNombreCP, tbxUsos;
    Intent intent1;
    Bitmap bmp1;
    final int cons = 0;
    Manejador_BD MDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planta);
        init();
    }


    private void init(){
        Toast.makeText(this, "Inicializando...", Toast.LENGTH_SHORT).show();
        btnCamara = (Button) findViewById(R.id.btnFotoP);
        imgV1 = (ImageView) findViewById(R.id.imgPlanta);
        btnCamara.setOnLongClickListener(this);
        tbxCodigo = (EditText) findViewById(R.id.tbxCodigoP);
        tbxNombreP = (EditText) findViewById(R.id.tbxNombreP);
        tbxNombreCP = (EditText) findViewById(R.id.tbxNombreCP);
        tbxUsos = (EditText) findViewById(R.id.tbxUsos);
        btnGrabar = (Button) findViewById(R.id.btnGuardar);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        MDB = new Manejador_BD(this);
    }
    //------------------------------------------------
    protected void onActivityResult ( int requesCode, int resultCode, Intent data)
    {
        super.onActivityResult(requesCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Bundle ext = data.getExtras();
            bmp1 = (Bitmap) ext.get("data");
            imgV1.setImageBitmap(bmp1);
            Toast.makeText(this, "Capturando...", Toast.LENGTH_SHORT).show();
        }
    }
//-------------------------------------------------------

    public void Grabar (View v)
    {
        int obtid;
        String obtdet, obtdet1, obtdet2;
        boolean siGrabo;
        obtid = Integer.parseInt(tbxCodigo.getText().toString());
        obtdet = tbxNombreP.getText().toString();
        obtdet1 = tbxNombreCP.getText().toString();
        obtdet2 = tbxUsos.getText().toString();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp1.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        siGrabo = MDB.Guarda_ImagenP(obtid, obtdet, obtdet1, obtdet2, byteArray);
        if (siGrabo) {
            Toast.makeText(this, "Registro Guardado!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ERROR!", Toast.LENGTH_SHORT).show();
        }
    }
    //------------------------------------------------------

    @Override
    public boolean onLongClick(View view) {
        int codigo;
        codigo = view.getId();
        switch (codigo)
        {
            case R.id.btnFotoP:
            Toast.makeText(this, "Abriendo Cámara...", Toast.LENGTH_SHORT).show();
            intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);/*lanza actividad y espera resultado*/
            startActivityForResult(intent1, cons);// SE ESPERA RESULTADO
            break;
        }
        return false;
    }
}