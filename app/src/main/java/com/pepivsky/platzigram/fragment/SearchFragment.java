package com.pepivsky.platzigram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.searchRecycler);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false); //orientacion del recycler

        picturesRecycler.setLayoutManager(gridLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_imagen, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    //Método del ArrayList de nuestro modelo (PicturePojo
    public ArrayList<PicturePojo> buildPictures() {
        ArrayList<PicturePojo> pictures = new ArrayList<>();
        //hay que pasarle una imagen que en este caso será de una url, el username, tiempo y numero de likes
        pictures.add(new PicturePojo("https://socialunderground.co/wp-content/uploads/2017/02/Adria%CC%80-Cuernolobo-Van-Gohg.jpg", "Vincent Van Gogh", "7 días","7 Me gusta"));
        pictures.add(new PicturePojo("https://socialunderground.co/wp-content/uploads/2017/02/Adria%CC%80-Cuernolobo-Frida.jpg", "Frida Kahlo", "10 días","5 Me gusta"));
        pictures.add(new PicturePojo("https://i0.wp.com/galeriafotocreativa.com/wp-content/uploads/2014/04/tatuaje_muneca_pusera.jpg", "José Manuel", "9 días","15 Me gusta"));
        pictures.add(new PicturePojo("https://socialunderground.co/wp-content/uploads/2017/02/Adria%CC%80-Cuernolobo-Frida.jpg", "Frida Kahlo", "10 días","5 Me gusta"));
        pictures.add(new PicturePojo("https://i0.wp.com/galeriafotocreativa.com/wp-content/uploads/2014/04/tatuaje_muneca_pusera.jpg", "José Manuel", "9 días","15 Me gusta"));
        pictures.add(new PicturePojo("https://socialunderground.co/wp-content/uploads/2017/02/Adria%CC%80-Cuernolobo-Frida.jpg", "Frida Kahlo", "10 días","5 Me gusta"));
        pictures.add(new PicturePojo("https://i0.wp.com/galeriafotocreativa.com/wp-content/uploads/2014/04/tatuaje_muneca_pusera.jpg", "José Manuel", "9 días","15 Me gusta"));
        return pictures;
    }


}
