package com.azahara.Pojo.SalasVarias;

import com.azahara.Constructor.SalaConstructor;
import com.azahara.Enum.Peligro;

public abstract class Sala {
    //cola ArrayDequew
    public static int numeroSalas =0;
    private int NumeroSala;

    public Sala() {
        NumeroSala = numeroSalas++;
    }

    public int getNumeroSala() {
        return NumeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        NumeroSala = numeroSala;
    }
}
