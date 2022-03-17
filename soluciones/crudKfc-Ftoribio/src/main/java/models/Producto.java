package models;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private static int contador = 0;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.id = ++contador;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", nombre = " + nombre +
                ", precio = " + precio +
                ", stock = " + stock + "\n";
    }
}
