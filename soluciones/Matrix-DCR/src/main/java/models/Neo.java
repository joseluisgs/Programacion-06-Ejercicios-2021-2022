package models;

public class Neo extends Personajes implements IPersonaje {
    private final boolean esElegido;

    public Neo() {
        super("Neo", new Localizacion("Madrid"));
        this.esElegido = esElegido();
    }

    public boolean esElegido() {
        return (int) (Math.random() * 100) > 50;
    }

    @Override
    public String toString() {
        return "😎";
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
