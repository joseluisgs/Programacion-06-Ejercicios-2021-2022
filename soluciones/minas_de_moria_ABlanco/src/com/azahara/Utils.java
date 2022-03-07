package com.azahara;

public class Utils {

    public static boolean huir(){

        System.out.println("!! CORRED INSENSATOS !!");
        int probabilidad = (int)((Math.random()*100)+1);
        if(probabilidad<=80){
            System.out.println("!! VIVIREMOS PARA VER OTRO AMANECER, si salimos... !!");
            return true;
        }else{
            System.out.println("!! la compañia a fracasado ☠ ☠ ☠ !!");
            return false;
        }
    }
}
