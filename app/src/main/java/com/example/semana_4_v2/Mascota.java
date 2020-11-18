package com.example.semana_4_v2;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.stream.Stream;

@Parcel
public class Mascota extends ArrayList<String> {

    public int foto;
    public String nombre;
    public String descripcion;
    public int votos;

    //Constructor vacío necesario para la biblioteca Parceler
    public Mascota() {
    }

    public Mascota(int foto, String nombre, String descripcion, int votos) {
        this.foto = foto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.votos = votos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
}

