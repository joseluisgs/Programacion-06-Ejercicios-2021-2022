package com.azahara.Pojo.Compañia;

public class Mago extends Personajes implements IMago {
    //sigleton
    private int varaMagia ;

    public Mago(String nombre) {
        super(nombre);
        this.varaMagia = ((int)(Math.random()*30)+1);
    }

    @Override
    public void recargarVara() {
        int inspiracionDeGsndalf = (((int)(Math.random()*10)+1));
        varaMagia+=inspiracionDeGsndalf;
        if(inspiracionDeGsndalf>30){
            inspiracionDeGsndalf=30;
        }
    }

    @Override
    public boolean luchaConLaVaraYGana(int poderMaligno) {
        recargarVara();
        int probabilidad = (((int)(Math.random()*100)+1));
        if(varaMagia>poderMaligno){
            poderVara();
            return true;
        }else if(varaMagia==poderMaligno){
            if (probabilidad<=60){
                poderVara();
                return true;
            }else{
                return false;
            }
        }else{
            if (probabilidad>=60){
                poderVara();
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public void poderVara() {
        System.out.println("NO PUEDES PASAR!! 🎆");
    }
}
