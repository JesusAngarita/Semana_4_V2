package com.example.semana_4_v2;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class MascotaPerfil extends ArrayList<String> {

    public int foto;
    public int votos;

    //Constructor vacío necesario para la biblioteca Parceler
    public MascotaPerfil() {
    }

    public MascotaPerfil(int foto, int votos) {
        this.foto = foto;
        this.votos = votos;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
}

