package models;

import controller.BibliotecaController;
import utils.Pedir;

import java.util.ArrayList;
import java.util.Collections;

public class Biblioteca{
    private static Biblioteca instance = null;
    private final ArrayList<Ficha> bibliotecaRepository;
    private final BibliotecaController controladorBiblio;


    //Devolver siempre misma instancia de biblioteca.
    public static Biblioteca getInstance() {
        if (instance == null) {
            instance = new Biblioteca();
        }
      return instance;
    }

    //Constructor
    public Biblioteca() {
        bibliotecaRepository = new ArrayList<>();
        controladorBiblio = new BibliotecaController();
    }

    //Switch de opciones en el menu
    public void menu(int option){
        switch (option){
            case 1: addItem();
            break;
            case 2: searchItem();
            break;
            case 3: removeItem();
            break;
            case 4: listBiblio();
            break;
            case 5: System.out.println("\nGracias, adiós 👋");
            break;
        }
    }

    /**
     * Mostrar listado de la biblioteca
     */
    private void listBiblio() {
        if (bibliotecaRepository.size()==0){
            System.out.println("Biblioteca Vacía");
        }else{
            Collections.sort(bibliotecaRepository);
            System.out.println(bibliotecaRepository);
        }
    }


    /**
     * Eliminar un objeto.
     */
    private void removeItem() {
        int id = Pedir.pedirInt("Dime el ID a eliminar");
        int buscada=controladorBiblio.search(id, bibliotecaRepository);
        if (buscada == -1){
            System.out.println("Esta ficha no ha sido encontrada");
        }else {
            bibliotecaRepository.remove(buscada);
            System.out.println("Ficha eliminada");
        }
    }


    /**
     * Buscar un objeto.
     */
    private void searchItem() {
        int id = Pedir.pedirInt("Dime el ID a buscar");
        int buscada=controladorBiblio.search(id, bibliotecaRepository);
        if (buscada == -1){
            System.out.println("Esta ficha no ha sido encontrada");
        }else {
            System.out.println(bibliotecaRepository.get(buscada));
        }
    }


    /**
     * Añadir objeto al array
     */
    private void addItem() {
        bibliotecaRepository.add(controladorBiblio.add());
        System.out.println(bibliotecaRepository.get(bibliotecaRepository.size()-1));
    }

}
