package es.ftoribio.dam.models;

public class Libro extends Ficha{
    private final String autor;
    private final String editorial;

    public Libro(String tittle, String autor, String editorial) {
        super(tittle);
        this.autor = autor;
        this.editorial= editorial;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    @Override
    public String toString() {
        return super.toString() +"Libro 📚 {" +
                "autor= " + autor +
                ", editorial= " + editorial + " } \n";
    }
}
