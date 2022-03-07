package models;

public class Localizacion {
    private final String nombreCiudad;
    private int latitud;
    private int longitud;

    public Localizacion(String ciudad) {
        this.nombreCiudad = ciudad;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
}
