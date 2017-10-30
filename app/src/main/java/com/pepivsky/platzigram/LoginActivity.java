package com.pepivsky.platzigram;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pepivsky.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void irCrearCuenta (View v){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }

    public void irLogin (View v){
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);

    }

    //Método para mandar a platzi.com al clickear en el logo
    public void goWeb(View view){
        /*Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.setData(Uri.parse("https://platzi.com/")); //Manda a la dirección
        startActivity(intent);*/
        Uri uri = Uri.parse("https://platzi.com/"); //Manda a la dirección
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
