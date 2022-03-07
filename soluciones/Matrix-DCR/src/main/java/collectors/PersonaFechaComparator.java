package collectors;

import models.Personajes;

import java.util.Comparator;

public class PersonaFechaComparator implements Comparator<Personajes> {
    @Override
    public int compare(Personajes p1, Personajes p2) {
        int res = p1.getFechaCreacion().compareTo(p2.getFechaCreacion());
        if (res == 0) res = p1.getName().compareTo(p2.getName());
        return res;
    }

    @Override
    public Comparator<Personajes> reversed() {
        return Comparator.super.reversed();
    }
}
