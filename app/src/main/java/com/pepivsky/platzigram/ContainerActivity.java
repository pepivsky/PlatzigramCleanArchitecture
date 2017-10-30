package com.pepivsky.platzigram;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import com.pepivsky.platzigram.fragment.HomeFragment;
import com.pepivsky.platzigram.fragment.ProfileFragment;
import com.pepivsky.platzigram.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        setInitialFragment();

        BottomNavigationView bottomNavigationView  = (BottomNavigationView) findViewById(R.id.bottomBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              switch (item.getItemId()){

                  case R.id.homeItem:
                      //Los tres fragments se mostrarán en el contenedor y serán reemplazados
                      HomeFragment homeFragment = new HomeFragment();//Instancia que hace referencia a nuestra clase y layout HomeFragment
                      getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment)
                              //Transición al cambiar el fragment
                              .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                              .addToBackStack(null).commit();
                      break;

                  case R.id.profileItem:
                      ProfileFragment profileFragment = new ProfileFragment();
                      getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment)
                              //Transición al cambiar el fragment
                              .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                              .addToBackStack(null).commit();
                      break;

                  case R.id.searchItem:
                      SearchFragment searchFragment = new SearchFragment();
                      getSupportFragmentManager().beginTransaction().replace(R.id.container,searchFragment)
                              //Transición al cambiar el fragment
                              .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                              .addToBackStack(null).commit();
                      break;
              }
              return true;

            }
        });

    }

    //Método para seleccionar el fragment inicial que se muestra
    private void setInitialFragment() {
        HomeFragment homeFragment = new HomeFragment();//Instancia que hace referencia a nuestra clase y layout HomeFragment
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment)
                //Transición al cambiar el fragment
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null).commit();
    }


}
