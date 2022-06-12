package com.example.certamen2barriafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class CientificoAct extends AppCompatActivity {
    Fragment cientificoAgrega, cientificoLista;
    FragmentTransaction transaccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cientifico);
        cientificoAgrega = new CientificoAgrega();
        cientificoLista = new CientificoLista();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView, cientificoLista).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.item_agregaCientifico) {
            transaccion = getSupportFragmentManager().beginTransaction();
            transaccion.replace(R.id.fragmentContainerView, cientificoAgrega);
            transaccion.addToBackStack(null);
            transaccion.commit();
        }
        return true;
    }

}