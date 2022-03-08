package models;

public class Proceso {
    private String identidad;
    private float tiempo = randomTiempo();
    private int prioridad = randomPrioridad();

    public Proceso(){}
    public Proceso(String identidad, float tiempo, int prioridad) {
        this.identidad = identidad;
        this.tiempo = tiempo;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tieempo) {
        this.tiempo = tiempo;
    }


    public int randomPrioridad(){
        return (int)(Math.random()*3);
    }

    public int randomTiempo(){
        return (int)(Math.random()*100);
    }
}
