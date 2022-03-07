package es.ftoribio.dam.models;

public abstract class Ficha implements Comparable<Ficha> {
    private final int identifier;
    private final String tittle;
    private static int counter = 0;

    public Ficha(String tittle) {
        this.identifier = ++counter;
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }

    public int getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return "Ficha --> " +
                "id=" + identifier +
                ", tittle='" + tittle + " : " ;
    }

    @Override
    public int compareTo(Ficha o) {
        return this.getIdentifier() - o.getIdentifier();
    }
}
