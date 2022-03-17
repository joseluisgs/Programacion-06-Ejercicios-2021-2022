package models;

import java.util.Objects;

public class Cliente {

    private static int contador = 0;
    private final int id;
    private String nombre;
    private int edad;

    public Cliente() {
        this.id = ++contador;
    }

    public Cliente(String nombre, int edad) {
        this.id = ++contador;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id
                && getEdad() == cliente.getEdad()
                && getNombre().equals(cliente.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getNombre(), getEdad());
    }
}
