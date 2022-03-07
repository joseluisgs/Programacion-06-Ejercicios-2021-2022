package com.azahara.ControladorMoira;

import com.azahara.Constructor.SalaConstructor;
import com.azahara.Pojo.Compañia.*;
import com.azahara.Pojo.SalasVarias.Sala;
import com.azahara.Pojo.SalasVarias.SalaAccion;
import com.azahara.Pojo.SalasVarias.SalaHabilidad;
import com.azahara.Pojo.SalasVarias.SalaHechizo;
import com.azahara.Repositorios.Repository;
import com.azahara.Utils;

import java.util.HashMap;

public class ControladorMoira {

    private HashMap compañia = new HashMap();
    private  Repository<Sala> salas = new Repository();


    public void crearPersonajes() {

        Mago gandalf = new Mago("Gandalf");
        Elfo legolas = new Elfo("Legolas");
        Hobit frodo = new Hobit("Frodo");
        compañia.put(gandalf.getNombre(), gandalf);
        compañia.put(legolas.getNombre(), legolas);
        compañia.put(frodo.getNombre(), frodo);
        System.out.println("preparados para entrar");

    }

    public void crearSalas() {

        SalaConstructor c = new SalaConstructor();
        for (int i = 0; i <36 ; i++){
            salas.add( c.salaConstructorRandom());
        }
        System.out.println("las salas se abren ante ellos");

    }

    public Sala entrerEnSala() {
        Sala s =salas.seleccionar();
        salas.eliminar(s);
        return s;

    }

    public boolean lucharEnSala(Sala s) {

        boolean ganoLucha ;
        boolean siHulleron = false;
        boolean muertos;

        //ver que tipo de sala es y luchar

        if (s instanceof SalaAccion){
            System.out.println(" la sala esta llena de enemigos, Legolas usará sus flechas");
            int flechas = ((SalaAccion) s).getFlechas();
            int enemigos = ((SalaAccion) s).getEnemigos();

            IArquero p = ((IArquero)compañia.get("Legolas"));
            ganoLucha = p.luchaConElArcoYGana(flechas, enemigos);

        }else if (s instanceof SalaHechizo){
            System.out.println(" la sala tiene una criatura maligna, Gandalf usará su Váculo");

            int magiaOscura = ((SalaHechizo) s).getPoderMaligno();
            IMago p = ((IMago)compañia.get("Gandalf"));
             ganoLucha = p.luchaConLaVaraYGana( magiaOscura);

        }else{

            System.out.println(" la sala tienepoder de sauron, Frodo ayudará ");
            IPortador p = ((IPortador) compañia.get("Frodo"));
            ganoLucha = p.luchaConElAnilloYGana();

            System.out.println("");
        }

        // si no ganaron huir
        if (!ganoLucha){
            System.out.println("perdio la lucha");
           siHulleron = Utils.huir();
        }
        if(ganoLucha || siHulleron){
            muertos=false;
            System.out.println(" salieron victoriosos ");
        }else {
            muertos=true;
        }
        return muertos;
    }
}
