package models;

public class PersonajeGenerico extends Personaje{
    private int muerte = (int)(Math.random() * 100);
    public PersonajeGenerico(String nombre, int edad) {
        super(nombre, edad);
        this.muerte = muerte;
        isMuerto();
    }

    public int getMuerte() {
        return muerte;
    }

    public void setMuerte(int muerte) {
        this.muerte = muerte;
    }
    public void isMuerto(){
        if (muerte < 50){
            System.out.println("El personaje está vivo.");
        }else{
            System.out.println("Está muerto.");
        }
    }
}
