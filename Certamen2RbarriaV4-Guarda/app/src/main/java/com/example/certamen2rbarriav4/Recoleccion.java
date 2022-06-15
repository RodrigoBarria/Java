//RODRIGO ALEJANDRO BARRÍA FIGUEROA 17.395.919-2
package com.example.certamen2rbarriav4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

        public class Recoleccion extends AppCompatActivity implements View.OnLongClickListener{
                ImageView imgV2;
                Button btnFotor, btnEditarr, btnLimpiarr, btnGuardarr, btnVolverr;
                EditText tbxIdr, tbxFechar, tbxCodPlantr, tbxRutr, tbxLatitud, tbxLongitud, tbxComentarior;
                Intent intent2;
                Bitmap bmp2;
                final int cons = 0;
                ;/*final para definir constantes*/
                Manejador_BD MDB;

                @Override
                protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_recoleccion);
                        init();
                }

        private void init(){
                Toast.makeText(this, "Inicializando...", Toast.LENGTH_LONG).show();
                btnFotor = (Button) findViewById(R.id.btnFotor);
                btnEditarr = (Button) findViewById(R.id.btnEditarr);
                btnLimpiarr = (Button) findViewById(R.id.btnLimpiarr);
                btnGuardarr = (Button) findViewById(R.id.btnGuardarr);
                btnVolverr = (Button) findViewById(R.id.btnVolverr);
                imgV2 = (ImageView) findViewById(R.id.imgV2);
                btnFotor.setOnLongClickListener(this);
                tbxIdr = (EditText) findViewById(R.id.tbxIdr);
                tbxFechar = (EditText) findViewById(R.id.tbxFechar);
                tbxCodPlantr = (EditText) findViewById(R.id.tbxCodPlantr);
                tbxRutr = (EditText) findViewById(R.id.tbxRutr);
                tbxLatitud = (EditText) findViewById(R.id.tbxLatitud);
                tbxLongitud = (EditText) findViewById(R.id.tbxLongitud);
                tbxComentarior = (EditText) findViewById(R.id.tbxComentarior);
                MDB = new Manejador_BD(this);
        }
                //------------------------------------------------
                protected void onActivityResult ( int requesCode, int resultCode, Intent data)
                {
                        super.onActivityResult(requesCode, resultCode, data);
                        if (resultCode == Activity.RESULT_OK) {
                                Bundle ext = data.getExtras();
                                bmp2 = (Bitmap) ext.get("data");
                                imgV2.setImageBitmap(bmp2);
                                Toast.makeText(this, "Capturando...", Toast.LENGTH_SHORT).show();
                        }
                }
                //-------------------------------------------------------
                public void Grabar1 (View v)
                {
                        int obtid1;
                        String obtdet4, obtdet5, obtdet6, obtdet7, obtdet8, obtdet9;
                        boolean siGrabo1;
                        obtid1 = Integer.parseInt(tbxIdr.getText().toString());
                        obtdet4 = tbxFechar.getText().toString();
                        obtdet5 = tbxCodPlantr.getText().toString();
                        obtdet6 = tbxRutr.getText().toString();
                        obtdet7 = tbxLatitud.getText().toString();
                        obtdet8 = tbxLongitud.getText().toString();
                        obtdet9 = tbxComentarior.getText().toString();

                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        bmp2.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        byte[] byteArray2 = stream.toByteArray();

                        siGrabo1 = MDB.Guarda_ImagenR(obtid1, obtdet4, obtdet5, obtdet6, obtdet7, obtdet8, obtdet9);
                        if (siGrabo1) {
                                Toast.makeText(this, "Registro Guardado!", Toast.LENGTH_SHORT).show();
                        } else {
                                Toast.makeText(this, "ERROR!", Toast.LENGTH_SHORT).show();
                        }

                }
                //------------------------------------------------------
                @Override
                public boolean onLongClick(View view) {
                                int codigo;
                                codigo= view.getId();
                                switch (codigo)
                                {
                                        case R.id.btnFotor:
                                                Toast.makeText(this,"Abriendo Cámara...",Toast.LENGTH_SHORT).show();
                                                intent2=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);/*lanza actividad y espera resultado*/
                                                startActivityForResult(intent2, cons);// SE ESPERA RESULTADO
                                                break;
                                }
                                return false;
                        }
                }