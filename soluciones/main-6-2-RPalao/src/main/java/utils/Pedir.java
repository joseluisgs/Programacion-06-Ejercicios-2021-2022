package utils;

import models.Tipos;

import java.util.Scanner;

public class Pedir {

    /**
     * Para pedir el tipo de item a añadir.
     * @return el tipo
     */
    public static Tipos pedirTipo(){
        Scanner scanner = new Scanner(System.in);
        Tipos tipoFinal = null;
        String tipo;

        //Pedir el tipo de item
        do {
            System.out.println("Dime qué item es Libro, Revista, DVD");
            tipo = scanner.nextLine();
            tipo=tipo.trim();
        }while (!tipo.equalsIgnoreCase("LIBRO") && !tipo.equalsIgnoreCase("REVISTA") && !tipo.equalsIgnoreCase("DVD"));

        //Devolver el enum correspondiente
        if (tipo.equalsIgnoreCase("LIBRO")){
            tipoFinal=Tipos.LIBRO;
        }else if (tipo.equalsIgnoreCase("REVISTA")){
            tipoFinal=Tipos.REVISTA;
        }else if (tipo.equalsIgnoreCase("DVD")){
            tipoFinal=Tipos.DVD;
        }
        return tipoFinal;
    }


    /**
     * Para pedir cadenas.
     * @return la cadena
     */
    public static String pedirString(String frase) {
        Scanner scanner = new Scanner(System.in);
        String cadena;

            System.out.println(frase);
            return cadena = scanner.nextLine();
    }



    public static int pedirInt(String frase) {
        Scanner scanner = new Scanner(System.in);
        int num;
            do {
                try {
                    System.out.println(frase);
                    num = scanner.nextInt();
                }catch (Exception e) {
                    System.out.println("Error");
                    num = -1;
                    scanner.next();
                }
            }while (num < 1);
        return num;
    }

}
