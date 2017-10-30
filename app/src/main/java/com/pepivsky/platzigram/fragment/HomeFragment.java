package com.pepivsky.platzigram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pepivsky.platzigram.R;
import com.pepivsky.platzigram.adapterR.PictureAdapterRecyclerView;
import com.pepivsky.platzigram.modelR.PicturePojo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.tab_home), false, view); //Mostrar Toolbar en un Fragment
        //Declarando nuestro recyclerView. Al hacer el findById en un fragment hay que anteponer view siempre
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        //Declaramos el Layout que contendrá a nuestro RecyclerView-
        // puede ser una Lista(LinearLayoutManager)
        //puede ser en forma de Grid (GridLayoutManager)
        //Puede ser de forma Escalonada (StaggeredGridMAnager)
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); //Orientacion vertical

        picturesRecycler.setLayoutManager(linearLayoutManager);

        //Adapter: Hay que pasarle un ArrayList y  El cardview con el que va a trabajar
        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buildPictures(),R.layout.cardview_imagen, getActivity());
        //Método del array Builpictures
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return  view;

    }

    //Método del ArrayList de nuestro modelo (PicturePojo
    public ArrayList<PicturePojo> buildPictures() {
        ArrayList<PicturePojo> pictures = new ArrayList<>();
        //hay que pasarle una imagen que en este caso será de una url, el username, tiempo y numero de likes
        pictures.add(new PicturePojo("https://socialunderground.co/wp-content/uploads/2017/02/Adria%CC%80-Cuernolobo-Van-Gohg.jpg", "Vincent Van Gogh", "7 días","7 Me gusta"));
        pictures.add(new PicturePojo("https://socialunderground.co/wp-content/uploads/2017/02/Adria%CC%80-Cuernolobo-Frida.jpg", "Frida Kahlo", "10 días","5 Me gusta"));
        pictures.add(new PicturePojo("https://i0.wp.com/galeriafotocreativa.com/wp-content/uploads/2014/04/tatuaje_muneca_pusera.jpg", "José Manuel", "9 días","15 Me gusta"));
        return pictures;
    }



    //Método para mostrar la toolbar en un fragment
    public void showToolbar(String titulo, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar); //Dos primeras lineas obligatorias para toolbar
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo); //Titulo de Toolbar
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton); //Boton de regreso



    }

}
