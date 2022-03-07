package com.azahara.Repositorios;

import java.util.ArrayList;

public class Repository<T> extends ArrayList<T> {


    public void añadir(T t){
        this.add(t);
    }

    public void eliminar(T t){
        this.remove(t);
    }

    public T seleccionar(){
       return this.get(0);
    }

}
