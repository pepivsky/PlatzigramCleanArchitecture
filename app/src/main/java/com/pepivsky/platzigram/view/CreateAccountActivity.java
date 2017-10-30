package com.pepivsky.platzigram.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.pepivsky.platzigram.R;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        //Método que recibe dos parámetros para el titulo de toolbar y para activar ell boton de regreso
        showToolbar(getResources().getString(R.string.toolbar_titulo_crearcuenta),true);


    }
//Método para mostrar la toolbar
    public void showToolbar(String titulo, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); //Dos primeras lineas obligatorias para toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titulo); //Titulo de Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton); //Boton de regreso



    }
}
