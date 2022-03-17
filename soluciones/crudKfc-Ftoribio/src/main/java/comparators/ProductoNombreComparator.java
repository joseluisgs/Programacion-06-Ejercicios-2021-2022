package comparators;

import models.Producto;

import java.util.Comparator;

/**
 * Comparador de productos por nombre.
 */
public class ProductoNombreComparator implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
        return p1.getNombre().compareTo(p2.getNombre());
    }

    @Override
    public Comparator<Producto> reversed() {
        return Comparator.super.reversed();
    }
}