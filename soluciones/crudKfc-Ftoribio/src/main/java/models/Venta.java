package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int id;
    private LocalDateTime createdAt;
    private Cliente cliente;
    List<LineaVenta> lineasVenta;
    private double total;

    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.createdAt = LocalDateTime.now();
        this.lineasVenta = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Cliente getPersona() {
        return cliente;
    }


    public List<LineaVenta> getLineasVenta() {
        return lineasVenta;
    }

    public void setLineasVenta(List<LineaVenta> lineasVenta) {
        this.lineasVenta = lineasVenta;
    }

    public void insertarLinea(LineaVenta lineaVenta) {
        this.lineasVenta.add(lineaVenta);
    }

    public double getTotal() {
        calcularTotal();
        return total;
    }

    public void calcularTotal() {
        double total = 0;
        for (LineaVenta lineaVenta : lineasVenta) {
            total += lineaVenta.getTotal();
        }
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta {" +
                "id=" + id +
                ", fecha y hora->" + createdAt +
                ", cliente: " + cliente +
                ", lineasVenta: " + lineasVenta +
                ", total = " + total + "€}";

    }
}

