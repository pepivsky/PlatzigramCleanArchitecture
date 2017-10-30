package com.pepivsky.platzigram.adapterR;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Picture;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.pepivsky.platzigram.R;
import com.pepivsky.platzigram.modelR.PicturePojo;
import com.pepivsky.platzigram.view.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by noisecontrollers on 31/07/2017.
 */
//Adapter que va a sincronzar la lista reutilizando las tarjetas
public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{

    //Arreglo de datos
    private ArrayList<PicturePojo> pictures; //Puede venir de internet o de una base de datos
    private int resource; //Este recurso será el Cardview
    private Activity activity;

    //constructor
    public PictureAdapterRecyclerView(ArrayList<PicturePojo> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override //Método para inflar o mostrar en la pantalla
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    //método para trabajar el ArrayList y sus objetos este método nos da acceso a los views y podemos tambien asignarles un valor
    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {

        PicturePojo picturePojo = pictures.get(position);
        holder.usernameCard.setText(picturePojo.getUserName());
        holder.timeCard.setText(picturePojo.getTime());
        holder.likeNumberCard.setText(picturePojo.getLikeNumber());
        //Libreria Picasso para imágenes de internet e insertarlas en el CardView
        Picasso.with(activity).load(picturePojo.getPicture()).into(holder.pictureCard);
        //Recordar dar el permiso de internet en Manifest

        //Listener al tocar la imagen del cardview
        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);

                //Código para la transicion de un elemento de recylerview (Cardview) a "activity detalle"
//Validación si el dispositivo tiene lollipop hace un efecto y si no hace otro (Esto sirve para que al agregar una trasicion la app pueda funcionar en versiones antiguas de android
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);//transicion de salida si es actividad no se necesita poner "activity."
                    //Si no se quiere personalizar la transicion hay que poner "new explode" y tomarà los valores por defecto
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity, v, activity.getString(R.string.transitionname_picture)).toBundle());
                //Si se corre en un disp. menor a lollipop no habrá transición
                }else {
                    activity.startActivity(intent);

                }
                //activity.startActivity(intent); //Hay que poner  activity para lanzar el intent del recyclerview
            }
        });

    }

    //método que devuelve cuantos elementos tengo
    @Override
    public int getItemCount() {
        return pictures.size(); //Recibe la coleccion de objetos de picturepojo
    }

    //Clase inner esta clase trabaja con todos los views de la tarjeta cardview
    public class PictureViewHolder extends RecyclerView.ViewHolder{

    //Views que conforman nuestro CardView
    private ImageView pictureCard;
    private TextView usernameCard;
    private TextView timeCard;
    private TextView likeNumberCard;

    public PictureViewHolder(View itemView) {
        super(itemView);
        //instancias
        pictureCard    = (ImageView) itemView.findViewById(R.id.pictureCard);
        usernameCard   = (TextView) itemView.findViewById(R.id.userNameCard);
        timeCard       = (TextView) itemView.findViewById(R.id.timeCard);
        likeNumberCard = (TextView) itemView.findViewById(R.id.likeNumberCard);


    }
}
}
