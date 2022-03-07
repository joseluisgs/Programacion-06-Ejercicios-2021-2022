package com.azahara.Pojo.SalasVarias;

import com.azahara.Enum.Peligro;
import com.azahara.Pojo.SalasVarias.Sala;

public class SalaAccion extends Sala {

    private int flechas;
    private int enemigos;


    public SalaAccion(int flechas, int enemigos) {
        super();
        this.flechas = flechas;
        this.enemigos = enemigos;
    }

    public int getFlechas() {
        return flechas;
    }

    public void setFlechas(int flechas) {
        this.flechas = flechas;
    }

    public int getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(int enemigos) {
        this.enemigos = enemigos;
    }
}

