package com.company;

import com.company.models.Proceso;
import com.company.tda.Cola;
import com.company.tda.Pila;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        Cola<Proceso> procesos= new Cola<>();
        Pila<Proceso> almacen= new Pila<>();

        float tiempoCpu=0;

        do{
            if (tiempoCpu % 2000== 0.00f){
                Proceso proceso= new Proceso();
                System.out.println("➕ Añadido proceso " + proceso);
                procesos.encolar(proceso);
            }

            if(tiempoCpu% 200 ==0.00f){
                Proceso p1= procesos.desencolar();
                System.out.println("\n🔄 Ejecutando proceso " + p1);
                float num= (float)Math.round((p1.getQuantum()-0.2f)*100)/100;
                p1.setQuantum(num);

                if (p1.getQuantum() > 0){
                    procesos.encolar(p1);

                }else{
                    System.out.println("Proceso " + p1.getpNumero() + " terminado.");
                    p1.setQuantum(0);
                    almacen.push(p1);
                }

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tiempoCpu+=1000;
        }while (tiempoCpu<=60000);

        System.out.println("\nEl tiempo de CPU ha finalizado.");

        while (!procesos.esVacia()){
            System.out.println(procesos.primero());
            procesos.desencolar();
        }


        System.out.println("\nProcesos Terminados: ");
        for (Proceso p: almacen) {
            System.out.println("❌ "+p);
        }
    }

}
