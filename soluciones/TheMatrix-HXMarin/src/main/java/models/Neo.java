package models;

public class Neo extends Personaje {
    private int elegir = (int)(Math.random() * 100);

    public Neo(int edad) {
        super("Neo", edad);
        this.elegir = elegir;
        elegido();
    }

    public int getElegir() {
        return elegir;
    }

    public void setElegir(int elegir) {
        this.elegir = elegir;
    }

    public void elegido() {
        if (elegir > 50){
            System.out.println("Neo es el elegido.");
        }else{
            System.out.println("Neo está en apuros...");
        }
    }
}

