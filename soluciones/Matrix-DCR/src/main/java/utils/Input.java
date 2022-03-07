package utils;

import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);

    public static String readString(){
        String cadena="";
        do {
            System.out.println("-> ");
            cadena= sc.next().trim().toLowerCase();
        }while(cadena.length() <= 0);
        return cadena;
    }
    public static int readInt(){
        int number=-1;
        do {
            try {
                number= sc.nextInt();
            }catch(Exception e){
                System.out.println("Error en la introducción del dato.");
                sc.next();
            }
        }while (number < 0);
        return number;
    }
}
