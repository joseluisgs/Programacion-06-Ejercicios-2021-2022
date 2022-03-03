package utils;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static int optionMenu(){

        int num ;
        do {
            try {
                System.out.println("\nDime que opción quieres --> \n" +
                        "1.- Añadir ítem.\n" +
                        "2.- Buscar ítem.\n" +
                        "3.- Eliminar ítem.\n" +
                        "4.- Listado de la biblioteca\n" +
                        "5.- Salir");
                num = scanner.nextInt();
            }catch (Exception e) {
                System.out.println("Error, número incorrecto");
                num = -1;
                scanner.next();
            }
        }while (num>5 || num<1);
        return num;
    }
}
