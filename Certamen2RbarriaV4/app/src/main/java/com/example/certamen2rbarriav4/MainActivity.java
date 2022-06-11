//RODRIGO ALEJANDRO BARRÍA FIGUEROA 17.395.919-2
package com.example.certamen2rbarriav4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mimenu, menu);
        return true;
        }

        public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.regCient) {
            Intent a = new Intent(this, Cientifico.class);
            startActivity(a);
            }

        else if (id == R.id.regPlant) {
            Intent b = new Intent(this, Planta.class);
            startActivity(b);
            }

        else if (id == R.id.regRec) {
            Intent c = new Intent(this, Recoleccion.class);
            startActivity(c);
            }

        else {
            finishAffinity();
            }
        return super.onOptionsItemSelected(item);
    }

    public void onViewCreated(View view) {
            class Instrucciones extends Fragment{
            Button btnComoUsar;
            private MainActivity myContext;
            @Override
            public void onAttach(@NonNull Context context) {
                myContext = (MainActivity) context;
                super.onAttach(context);
            }
            public Instrucciones(){

            }
            @Override
            public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
                super.onViewCreated(view, savedInstanceState);
                btnComoUsar = (Button) view.findViewById(R.id.btnComoUsar);
                btnComoUsar.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent btnComoUsar = new Intent(MainActivity.this, Instrucciones.class);
                        startActivity(btnComoUsar);
                    }
                }
                );}

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                // Inflate the layout for this fragment
                return inflater.inflate(R.layout.activity_main, container, false);
            }
            public void setBtnComoUsar(Button btnComoUsar) {
                this.btnComoUsar = btnComoUsar;
            }
        }
    }


    }

