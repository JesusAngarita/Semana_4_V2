package com.example.semana_4_v2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Favoritos extends AppCompatActivity {

    public Toolbar toolbar;
    ArrayList<Mascota> mascotas;
    public RecyclerView rvMascotasTOP;
    public RecyclerView.Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.huella_gato);

        inicializarListaMascotas();
        inicializarAdaptador();

        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

        Toast.makeText(this, getResources().getString(R.string.favoritos), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void inicializarListaMascotas(){
        mascotas=new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro_uno, "Tony", "Tierno y juguetón", 5));
        mascotas.add(new Mascota(R.drawable.perro_tres, "killer", "El canson de la casa", 6));
        mascotas.add(new Mascota(R.drawable.perro_cuatro, "chester", "El negrito mas tierno", 2));
        mascotas.add(new Mascota(R.drawable.perro_cinco, "Eragon", "El lider de la manada", 4));
        mascotas.add(new Mascota(R.drawable.perro_dos, "Dollar", "Me siento observado", 3));
        mascotas.add(new Mascota(R.drawable.perro_seis, "Maximo", "Aventurero en crecimiento", 8));

        Collections.sort(mascotas, new Comparator<Mascota>(){

            @Override
            public int compare(Mascota lhs, Mascota rhs) {
                return lhs.getVotos() - rhs.getVotos();
            }
        });

        mascotas.remove(0);
        Collections.reverse(mascotas);
    }

    private void inicializarAdaptador(){
        rvMascotasTOP=(RecyclerView) findViewById(R.id.rvMascotasTOP);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasTOP.setLayoutManager(llm);
        adaptador=new MascotaAdaptador(mascotas, this);
        rvMascotasTOP.setAdapter(adaptador);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent anteriorActividad=new Intent(Favoritos.this, MainActivity.class);
            startActivity(anteriorActividad);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
