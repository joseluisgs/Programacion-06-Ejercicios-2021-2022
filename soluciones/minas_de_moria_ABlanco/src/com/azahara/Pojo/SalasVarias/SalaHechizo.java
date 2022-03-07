package com.azahara.Pojo.SalasVarias;

import com.azahara.Enum.Peligro;
import com.azahara.Pojo.SalasVarias.Sala;

public class SalaHechizo extends Sala {


    int poderMaligno = ((int)(Math.random()*10)+1);

    public SalaHechizo( int poderMaligno) {
        super();
        this.poderMaligno = poderMaligno;
    }

    public int getPoderMaligno() {
        return poderMaligno;
    }

    public void setPoderMaligno(int poderMaligno) {
        this.poderMaligno = poderMaligno;
    }


}
