package models;

public class Localizacion {
    private int altitud;
    private int longitud;
    private String nombreCiudad;

    public Localizacion(int altitud, int longitud, String nombreCiudad) {
        this.altitud = altitud;
        this.longitud = longitud;
        setNombreCiudad(nombreCiudad);
    }

    public int getAltitud() {
        return altitud;
    }

    public void setAltitud(int altitud) {
        this.altitud = altitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        if (nombreCiudad.trim().equals("")){
            throw new IllegalArgumentException("El nombre de la ciudad no puede estar vacio...");
        }else
            this.nombreCiudad = nombreCiudad;
    }
}
