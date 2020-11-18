package com.example.semana_4_v2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Toolbar toolbar;
    ArrayList<Mascota> mascotas;
    public RecyclerView rvMascotas;
    public RecyclerView.Adapter adaptador;

    //Para Fragments
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setLogo(R.mipmap.huella_gato);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        //inicializarListaMascotas();
        //inicializarAdaptador();

        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFavorito:
                Intent irFavoritos=new Intent(MainActivity.this, Favoritos.class);
                startActivityForResult(irFavoritos, 0);
                return true;
            case R.id.mContacto:
                Intent irMenuItemContacto=new Intent(MainActivity.this, MenuItemContacto.class);
                startActivityForResult(irMenuItemContacto, 1);
                return true;
            case R.id.mAbout:
                Intent irAcercaDe=new Intent(MainActivity.this, Acercade.class);
                startActivityForResult(irAcercaDe, 2);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.pet_dog);
    }

    public void tomarFoto(View view) {
        Intent camara = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(camara);
    }

}
