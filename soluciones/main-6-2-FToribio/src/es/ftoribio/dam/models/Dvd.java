package es.ftoribio.dam.models;

public class Dvd extends Ficha {
    private final String director;
    private final int year;
    private final String type;

    public Dvd(String tittle, String director, int year, String type) {
        super(tittle);
        this.director = director;
        this.year = year;
        this.type = type;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + "Dvd 💿 {" +
                "director= " + director +
                ", año= " + year +
                ", tipo= " + type + " } \n";
    }
}
