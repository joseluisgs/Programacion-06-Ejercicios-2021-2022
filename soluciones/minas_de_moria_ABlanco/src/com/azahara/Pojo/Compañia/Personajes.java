package com.azahara.Pojo.Compañia;

import com.azahara.Enum.Estado;

public abstract class Personajes {

    protected String nombre;
    protected Estado estado = Estado.Vivo;

    public Personajes(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
