package com.example.semana_4_v2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class PerfilFragment extends Fragment {

    private GridLayoutManager glm;
    ArrayList<MascotaPerfil> mascotasperfil;
    private RecyclerView rvMascotasPerfil;

    public PerfilFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvMascotasPerfil=(RecyclerView) v.findViewById(R.id.rvMascotasPerfil);
        rvMascotasPerfil.setHasFixedSize(true);

        glm=new GridLayoutManager(getActivity(), 3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        glm.setSpanCount(3);
        rvMascotasPerfil.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public MascotaPerfilAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador= new MascotaPerfilAdaptador(mascotasperfil, getActivity());
        rvMascotasPerfil.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotasperfil=new ArrayList<MascotaPerfil>();
        mascotasperfil.add(new MascotaPerfil(R.drawable.perro_dos, 5));
        mascotasperfil.add(new MascotaPerfil(R.drawable.perro_dos, 6));
        mascotasperfil.add(new MascotaPerfil(R.drawable.perro_dos, 2));
        mascotasperfil.add(new MascotaPerfil(R.drawable.perro_dos, 4));
        mascotasperfil.add(new MascotaPerfil(R.drawable.perro_dos, 3));
        mascotasperfil.add(new MascotaPerfil(R.drawable.perro_dos, 8));
        mascotasperfil.add(new MascotaPerfil(R.drawable.perro_dos, 5));
        mascotasperfil.add(new MascotaPerfil(R.drawable.perro_dos, 4));
    }
}
