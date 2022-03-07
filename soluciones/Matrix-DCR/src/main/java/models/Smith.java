package models;

public class Smith extends Personajes implements IPersonaje {
    private final int porcentajeInfectar;

    public Smith(Localizacion localizacion) {
        super("Smith", localizacion);
        this.porcentajeInfectar = probabilidadInfectar();
        setName(name + "-" + id);
    }

    public int probabilidadInfectar() {
        return (int) (Math.random() * 8 + 1);
    }

    public int getPorcentajeInfectar() {
        return porcentajeInfectar;
    }

    @Override
    public String toString() {
        return "🦠";
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
