package com.azahara.Pojo.Compañia;

public class Elfo extends Personajes implements IArquero,Luchador{
    //sigleton
    private int flechasCarcaj = 1;


    public Elfo(String nombre) {
        super(nombre);
        this.flechasCarcaj = 1;
    }

    @Override
    public void recargarFlechas(int f) {
        flechasCarcaj += f;
        System.out.println("recarga flechas + -->" +f);
    }

    @Override
    public void disparar() {
        flechasCarcaj -= 1;
        System.out.println("dispara 🏹");
    }

    @Override
    public boolean luchaConElArcoYGana(int enemigos, int flechas) {
        int e = enemigos;
        System.out.println("empieza la lucha");
        while(e!=0 && flechasCarcaj!=0){

            disparar();
            e-=1;
            System.out.println("un elfo nunca falla !! enemigo muerto");

        }
        if(e==0){
            System.out.println("Maté a todos los enemigos, mis antepasados estarían orgullosos");
            flechasCarcaj+= flechas;
            return true;
        }else{
            System.out.println("No me quedan flechas!! perderemos esta batalla pero no la guerra");
            return false;
        }

    }
}
