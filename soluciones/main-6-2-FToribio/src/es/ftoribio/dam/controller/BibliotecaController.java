package es.ftoribio.dam.controller;


import es.ftoribio.dam.models.*;
import es.ftoribio.dam.utils.Pedir;

import java.util.ArrayList;

public class BibliotecaController {

    public Ficha add() {
        Ficha aux = null;
        Tipos tipo = Pedir.pedirTipo();
        if (tipo == Tipos.LIBRO){
            aux = new Libro(Pedir.pedirString("Dime el título"),
                    Pedir.pedirString("Dime el autor"),Pedir.pedirString("Dime la editorial"));
        }else if (tipo == Tipos.DVD){
            aux = new Dvd(Pedir.pedirString("Dime el título"),Pedir.pedirString("Dime el director"),
                    Pedir.pedirInt("Dime el año de publicación"), Pedir.pedirString("Dime qué tipo de DVD es"));
        }else if (tipo == Tipos.REVISTA){
            aux = new Revista(Pedir.pedirString("Dime el título"),Pedir.pedirInt("Dime el número de revista"),
                    Pedir.pedirInt("Dime el año de publicación"));
        }
        return aux;
    }


    public int search(int id, ArrayList<Ficha> bibliotecaRepository) {
        int aux = -1;
        for (int i=0; i<bibliotecaRepository.size(); i++) {
            if(bibliotecaRepository.get(i).getIdentifier() == id){
                aux = i;
            }
        }
        return aux;
    }
}
