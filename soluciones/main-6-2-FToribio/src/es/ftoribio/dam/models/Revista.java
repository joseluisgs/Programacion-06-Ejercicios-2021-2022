package es.ftoribio.dam.models;

public class Revista extends Ficha {
    private final int numeroRevista;
    private final int yearPblicacion;

    public Revista(String tittle, int numeroRevista, int yearPblicacion) {
        super(tittle);
        this.numeroRevista = numeroRevista;
        this.yearPblicacion = yearPblicacion;
    }

    public int getNumeroRevista() {
        return numeroRevista;
    }

    public int getYearPblicacion() {
        return yearPblicacion;
    }

    @Override
    public String toString() {
        return super.toString() +"Revista 📖 {" +
                "numero revista= " + numeroRevista +
                ", año publicacion= " + yearPblicacion +
                " } \n";
    }
}
