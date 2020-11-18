package com.example.semana_4_v2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.KeyEvent;

public class Acercade extends AppCompatActivity {

    public Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.huella_gato);

        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent anteriorActividad=new Intent(Acercade.this, MainActivity.class);
            startActivity(anteriorActividad);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
