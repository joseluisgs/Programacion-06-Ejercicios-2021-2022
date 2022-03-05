package com.azahara.Constructor;

import com.azahara.Enum.Peligro;
import com.azahara.Pojo.SalasVarias.Sala;
import com.azahara.Pojo.SalasVarias.SalaAccion;
import com.azahara.Pojo.SalasVarias.SalaHabilidad;
import com.azahara.Pojo.SalasVarias.SalaHechizo;

import static com.azahara.Enum.Peligro.*;

public class SalaConstructor {
    public Sala salaConstructorRandom(){

        int peligro = ((int)(Math.random()*3));
        System.out.println(" comprobacion: el tipo de peligro ha salido " + peligro);
         Peligro peligroDeSala = Peligro.values()[peligro];

         if(peligroDeSala.equals(Magico)){

             int poderMaligno = ((int)(Math.random()*10)+1);
             return new SalaHechizo(poderMaligno);
         }else if(peligroDeSala.equals(Accion)){

             int enemigos = ((int)(Math.random()*10)+1);
             int flechas = ((int)(Math.random()*10)+1);
                return new SalaAccion(enemigos, flechas);

         }else {
             return new SalaHabilidad();

         }
    }
}
