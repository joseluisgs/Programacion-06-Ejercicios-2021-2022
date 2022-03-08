package es.ftoribio.dam;

import es.ftoribio.dam.models.Biblioteca;
import es.ftoribio.dam.utils.Menu;

public class Main {
    public static void main(String[] args){
        Biblioteca biblioteca = Biblioteca.getInstance();
        int option;

        do {
            option= Menu.optionMenu();
            biblioteca.menu(option);
        }while(option!=5);
    }
}
