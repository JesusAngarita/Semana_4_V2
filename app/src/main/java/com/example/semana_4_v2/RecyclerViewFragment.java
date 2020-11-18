package com.example.semana_4_v2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvMascotas=(RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public MascotaAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador=new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas=new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro_uno, "Tony", "Tierno y juguetón", 5));
        mascotas.add(new Mascota(R.drawable.perro_tres, "killer", "El canson de la casa", 6));
        mascotas.add(new Mascota(R.drawable.perro_cuatro, "chester", "El negrito mas tierno", 2));
        mascotas.add(new Mascota(R.drawable.perro_cinco, "Eragon", "El lider de la manada", 4));
        mascotas.add(new Mascota(R.drawable.perro_dos, "Dollar", "Me siento observado", 3));
        mascotas.add(new Mascota(R.drawable.perro_seis, "Maximo", "Aventurero en crecimiento", 8));
    }
}

