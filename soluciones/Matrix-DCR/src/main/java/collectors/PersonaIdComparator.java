package collectors;

import models.Personajes;

import java.util.Comparator;

public class PersonaIdComparator implements Comparator<Personajes> {
    @Override
    public int compare(Personajes p1, Personajes p2) {
        return p1.getId() - p2.getId();
    }

    @Override
    public Comparator<Personajes> reversed() {
        return Comparator.super.reversed();
    }
}
