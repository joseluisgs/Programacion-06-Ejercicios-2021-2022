package com.azahara.Pojo.Compañia;

import com.azahara.Enum.AnilloPuesto;

public class Hobit  extends Personajes implements IPortador , Luchador{
    //sigleton
    private AnilloPuesto anillo = AnilloPuesto.Quitado;

    public Hobit(String nombre) {
        super(nombre);
    }

    @Override
    public void ponerseAnillo() {
        System.out.println("Frofo se pone el anillo 💍");
        this.anillo = AnilloPuesto.Puesto;
    }

    @Override
    public void quitarseAnilli() {
        System.out.println("Frofo se quita el anillo 💍");
        this.anillo = AnilloPuesto.Quitado;
    }


    @Override
    public boolean luchaConElAnilloYGana() {
        System.out.println(" empieza la lucha");
        boolean anilloPuesto = sePoneElAnillo();
        if (anilloPuesto){
            ponerseAnillo();
            quitarseAnilli();
            //70%
            return (((int)(Math.random()*10)) <= 7);
        }else{
            System.out.println(" frodo decidio no ponerse el anillo");
            //20%
            return (((int)(Math.random()*2)) <= 2);
        }
    }

    private boolean sePoneElAnillo() {
        //decide si ponerse el anillo un 50%
        return (0 == ((int)(Math.random()*2)));
    }
}
