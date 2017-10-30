package com.pepivsky.platzigram.view;

import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.View;

import com.pepivsky.platzigram.R;

public class PictureDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);

        showToolbar("", true);//texto en toolbar y habilitar boton de subir

        // código de transición de entrada
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(Color.TRANSPARENT);  //Barra transparente
            getWindow().setEnterTransition(new Fade());
        }
    }

    //Método para controlar y mostrar la toolbar en una actividad
    public void showToolbar(String titulo, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); //Dos primeras lineas obligatorias para toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titulo); //Titulo de Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton); //Boton de regreso
        //Casteo de collapsingToolbar
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collpasingToolbar);



    }
}
