package com.azahara;

import com.azahara.ControladorMoira.ControladorMoira;
import com.azahara.Pojo.SalasVarias.Sala;
import com.azahara.Repositorios.Repository;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //entramos en las minas
        System.out.println("no queda otra, entraremos en las ¡¡ MINAS DE MOIRA !!");
        ControladorMoira c = new ControladorMoira();
         c.crearPersonajes();
         c.crearSalas();

        //vamos pasando salas

        boolean muertos =false;
        int salasPorRecorrer=36;
        do{
            System.out.println(" \n \n Entraremos el la siguiente sala de moria !! ");
            Sala s = c.entrerEnSala();
            muertos = c.lucharEnSala(s);
            salasPorRecorrer--;

            Thread.sleep(2000);


        }while(!muertos && salasPorRecorrer!=0);

        if(!muertos){
            System.out.println("porfin salimos y podemos ver el sol ");
            System.out.println("nos queda mucho por recorrer pero veremos otro día !! ");
        }


    }
}
