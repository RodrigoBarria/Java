//RODRIGO ALEJANDRO BARRÍA FIGUEROA 17.395.919-2
package com.example.certamen2rbarriav4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {
    Fragment instrucciones;
    FragmentTransaction transaccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instrucciones = new Instrucciones();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mimenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.regCient) {
            Intent a = new Intent(this, Cientifico.class);
            startActivity(a);
        } else if (id == R.id.regPlant) {
            Intent b = new Intent(this, Planta.class);
            startActivity(b);
        } else if (id == R.id.regRec) {
            Intent c = new Intent(this, Recoleccion.class);
            startActivity(c);
        } else {
            finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }

    public void instrucciones(View view) {
        Instrucciones fragment = null;
        fragment = Instrucciones.newInstance("wena","wena");
        replaceFragment(fragment);
    }

    public void replaceFragment(Instrucciones fragment) {
        transaccion=getSupportFragmentManager().beginTransaction();
        transaccion.replace(R.id.frameInst,fragment);
        transaccion.addToBackStack(null);
        transaccion.commit();
    }
}

