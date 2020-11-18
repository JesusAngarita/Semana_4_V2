package com.example.semana_4_v2;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.MascotaPerfilViewHolder> {

    ArrayList<MascotaPerfil> mascotasperfil;
    Activity activity;
    int votos = 0;

    //Construye la lista de mascotasperfil
    public MascotaPerfilAdaptador(ArrayList<MascotaPerfil> mascotasperfil, Activity activity){
        this.mascotasperfil=mascotasperfil;
        this.activity=activity;
    }

    //Inflará el layout y lo pasará al viewholder para que él obtenga los views
    @Override
    public MascotaPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //aquí se indica cuál es el layout que estará "reciclando" el recycler view. En este caso: "cardview_mascotaperfil"
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotaperfil, parent, false);
        return new MascotaPerfilViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view.
    @Override
    public void onBindViewHolder(final MascotaPerfilViewHolder mascotaperfilViewHolder, int position) {
        final MascotaPerfil mascotaperfil=mascotasperfil.get(position);
        mascotaperfilViewHolder.imgFotoPerfil.setImageResource(mascotaperfil.getFoto());
        mascotaperfilViewHolder.tvLikeCountCVPerfil.setText(String.valueOf(mascotaperfil.getVotos()+votos));
    }

    @Override
    public int getItemCount() {//cantidad de elementos que contiene mi lista
        return mascotasperfil.size();
    }

    public static class MascotaPerfilViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFotoPerfil;
        private ImageView imgLikeCountCVPerfil;
        public TextView tvLikeCountCVPerfil;

        public MascotaPerfilViewHolder(View itemView) {
            super(itemView);
            imgFotoPerfil=(ImageView) itemView.findViewById(R.id.imgFotoPerfil);
            tvLikeCountCVPerfil=(TextView) itemView.findViewById(R.id.tvLikeCountCVPerfil);
            imgLikeCountCVPerfil=(ImageView) itemView.findViewById(R.id.imgLikeCountCVPerfil);
        }
    }
}
