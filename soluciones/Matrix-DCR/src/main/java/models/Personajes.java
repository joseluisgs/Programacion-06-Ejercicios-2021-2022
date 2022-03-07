package models;

import java.time.LocalDateTime;

public abstract class Personajes {
    private static int contador = 1;
    private final Localizacion localizacion;
    protected int id;
    protected String name;
    private int edad;
    private LocalDateTime fechaCreacion;

    public Personajes(String nombre, Localizacion localizacion) {
        this.edad = edadAleatoria();
        this.name = nombre;
        this.id = contador++;
        this.fechaCreacion = LocalDateTime.now();
        this.localizacion = localizacion;

    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int edadAleatoria() {
        return (int) (Math.random() * (40 - 20) + 20);
    }

    @Override
    public String toString() {
        return "Personajes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", edad=" + edad +
                ", fechaCreacion=" + fechaCreacion +
                ", localizacion=" + localizacion +
                '}';
    }
}
