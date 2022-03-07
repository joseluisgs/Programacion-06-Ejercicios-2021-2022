package models;

public class Generico extends Personajes implements IPersonaje {
    private int probabilidadMorir;

    public Generico(String nombre, Localizacion localizacion) {
        super(nombre, localizacion);
        this.probabilidadMorir = porcentajeMuerte();
    }

    public int getProbabilidadMorir() {
        return probabilidadMorir;
    }

    public void setProbabilidadMorir(int probabilidadMorir) {
        this.probabilidadMorir = probabilidadMorir;
    }

    public int porcentajeMuerte() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "PRS";
    }

    @Override
    public void generar() {

    }

    @Override
    public void pedir() {

    }

    @Override
    public String mostrar() {
        return "Id: " + getId() +
                "Nombre: " + getName() +
                "FechaCreacion: " + getFechaCreacion() +
                "Localizacion: " + getLocalizacion();
    }
}
