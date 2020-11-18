package com.example.semana_4_v2;

import android.app.Activity;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;
    int votos = 0;

    //Construye la lista de mascotas
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;
    }

    //Inflará el layout y lo pasará al viewholder para que él obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //aquí se indica cuál es el layout que estará "reciclando" el recycler view. En este caso: "cardview_mascota"
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view.
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota=mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvDescriCV.setText(mascota.getDescripcion());
        mascotaViewHolder.tvLikeCountCV.setText(String.valueOf(mascota.getVotos()+votos));

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, mascota.getNombre()+": "+mascota.getDescripcion(), Toast.LENGTH_SHORT).show();
            }
        });

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //votos++;
                Toast.makeText(activity, "Votaste a " + mascota.getNombre()+"!", Toast.LENGTH_SHORT).show();
                Intent irFavoritos=new Intent(activity,Favoritos.class);
                irFavoritos.putExtra("foto", mascota.getFoto());
                irFavoritos.putExtra("nombre", mascota.getNombre());
                irFavoritos.putExtra("descripcion", mascota.getDescripcion());
                irFavoritos.putExtra("votos", new Integer(votos+mascota.getVotos()).toString());

                mascota.setVotos(mascota.getVotos() + 1);//votos + 1

                // Informamos al dataset que los datos han cambiado!
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {//cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvDescriCV;
        public TextView tvLikeCountCV;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto=(ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV=(TextView) itemView.findViewById(R.id.tvNombreCV);
            tvDescriCV=(TextView) itemView.findViewById(R.id.tvDescriCV);
            tvLikeCountCV=(TextView) itemView.findViewById(R.id.tvLikeCountCV);
            btnLike=(ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}

