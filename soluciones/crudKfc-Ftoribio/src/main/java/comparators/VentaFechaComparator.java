package comparators;


import models.Venta;

import java.util.Comparator;

public class VentaFechaComparator implements Comparator<Venta> {
    @Override
    public int compare(Venta o1, Venta o2) {
        return o1.getCreatedAt().compareTo(o2.getCreatedAt());
    }

    @Override
    public Comparator<Venta> reversed() {
        return Comparator.super.reversed();
    }
}