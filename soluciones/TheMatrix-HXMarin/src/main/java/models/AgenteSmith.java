package models;

public class AgenteSmith extends Personaje{
    private int infecta = (int)(Math.random()*100);

    public AgenteSmith(int edad) {
        super("Smith", edad);
        this.infecta = infecta;
        infectando();
    }

    public int getInfecta() {
        return infecta;
    }

    public void setInfecta(int infecta) {
      this.infecta = infecta;
    }
    public void infectando(){
        if(infecta < 50){
            System.out.println("Smith no ha infectado...");
        }else
            System.out.println("¿Está preparado para morir Señor Anderson?");
    }
}

