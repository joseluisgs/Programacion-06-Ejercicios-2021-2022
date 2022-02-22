package models;

public class Personaje implements IPersonaje{
    private String nombre;
    private int edad;
    private Localizacion localizarPersonaje;


    public Personaje(String nombre, int edad) {
        setNombre(nombre);
        this.edad = edad;
        this.localizarPersonaje = localizarPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre.trim().equals("")){
            throw new IllegalArgumentException("EL NOMBRE NO PUEDE ESTAR VACIO");
        }else
            this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Localizacion getLocalizarPersonaje() {
        return localizarPersonaje;
    }

    public void setLocalizarPersonaje(Localizacion localizarPersonaje) {
        this.localizarPersonaje = localizarPersonaje;
    }

    @Override
    public void pedir() {

    }

    @Override
    public void mostrar() {

    }

    @Override
    public void generar() {

    }
}
