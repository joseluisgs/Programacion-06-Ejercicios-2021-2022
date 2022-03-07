package models;

import collectors.PersonaFechaComparator;
import collectors.PersonaIdComparator;
import factories.GenericoFactory;
import factories.SmithFactory;
import tda.Cola;
import tda.Matriz;

import java.util.*;

public class Matrix {
    private static Matrix instance = null;
    private final int GENERICOS_ALMACENADOS = 200;
    private final int dimension;
    private final Matriz<Personajes> matriz;
    private final Cola<Generico> colaPersonajes;
    private final Set<Personajes> agentesMuertos;
    private final List<Personajes> virusSmith;
    private final List<Personajes> usuariosCreados;
    private int totalPersonajes;


    private Matrix(int rows) {
        matriz = new Matriz(rows);
        this.dimension = rows;
        colaPersonajes = new Cola<Generico>();
        agentesMuertos = new TreeSet<>(new PersonaFechaComparator());
        virusSmith = new ArrayList<>();
        usuariosCreados = new ArrayList<>();
    }

    public static Matrix getInstance(int rows) {
        if (instance == null) {
            instance = new Matrix(rows);
        }
        return instance;
    }

    public void iniciar() {
        crearPersonajes();
        poisicionarNeo();
        posicionarSmith();
        posicionarGenericos();
        System.out.println(getMatriz().toString());
    }

    public Matriz<Personajes> getMatriz() {
        return matriz;
    }

    public Cola<Generico> getColaPersonajes() {
        return colaPersonajes;
    }

    public void crearPersonajes() {
        for (int i = 0; i < GENERICOS_ALMACENADOS; i++) {
            colaPersonajes.add(GenericoFactory.createRandom());
        }
        totalPersonajes += 200;
    }

    private void poisicionarNeo() {
        int fila = (int) (Math.random() * matriz.getRows());
        int columna = (int) (Math.random() * matriz.getCols());
        Neo neo = new Neo();
        darLocalizacion(neo, fila, columna);
        matriz.set(fila, columna, neo);
        usuariosCreados.add(neo);
        totalPersonajes++;
    }

    private void posicionarGenericos() {
        for (int i = 0; i < matriz.getRows(); i++) {
            for (int j = 0; j < matriz.getCols(); j++) {
                if (matriz.get(i, j) == null) {
                    Personajes p = colaPersonajes.desencolar();
                    darLocalizacion(p, i, j);
                    matriz.set(i, j, p);
                    usuariosCreados.add(p);
                }

            }
        }
    }

    private void darLocalizacion(Personajes p, int i, int j) {
        p.getLocalizacion().setLatitud(i);
        p.getLocalizacion().setLongitud(j);
    }

    private void posicionarSmith() {
        int columna;
        int fila;
        boolean isNull = false;
        do {
            fila = (int) (Math.random() * matriz.getRows());
            columna = (int) (Math.random() * matriz.getCols());

            if (matriz.get(fila, columna) == null) {
                Smith smith = SmithFactory.createRandom();
                darLocalizacion(smith, fila, columna);
                matriz.set(fila, columna, smith);
                isNull = true;
                virusSmith.add(smith);
                usuariosCreados.add(smith);
            }

        } while (!isNull);
        totalPersonajes++;
    }

    public void comprobarPosibilidadMuerte() {
        for (int i = 0; i < matriz.getRows(); i++) {
            for (int j = 0; j < matriz.getCols(); j++) {
                if (matriz.get(i, j) instanceof Generico) {
                    if (((Generico) matriz.get(i, j)).getProbabilidadMorir() < 30) {
                        System.out.println("Tengo " + ((Generico) matriz.get(i, j)).getProbabilidadMorir() + " asi que muero.");
                        matriz.set(i, j, null);

                        Generico generico = colaPersonajes.desencolar();
                        matriz.set(i, j, generico);
                        usuariosCreados.add(generico);
                        darLocalizacion(generico, i, j);
                    } else {
                        ((Generico) matriz.get(i, j)).setProbabilidadMorir(((Generico) matriz.get(i, j)).getProbabilidadMorir() - 10);
                    }

                }
            }
        }
        System.out.println();
    }


    public void simulacionMatrix() {
        int tiempo = 0;
        boolean exit = false;
        do {
            if (tiempo % 1000 == 0 && !colaPersonajes.isEmpty()) {
                comprobarPosibilidadMuerte();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

            if (tiempo % 2000 == 0) {
                infectarVirusSmith();
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

            if (tiempo % 5000 == 0) {
                ataqueNeo();

//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

            if (tiempo % 5000 == 0) {
                System.out.println("\n");
                System.out.println(matriz);
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

            if (tiempo % 10000 == 0) {
                rellenarHuecos();
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

            tiempo++;
            exit = tiempo < 120000 && !colaPersonajes.isEmpty();
        } while (exit);
        System.out.println("El tiempo es: " + tiempo);
    }

    private void rellenarHuecos() {
        for (int i = 0; i < matriz.getRows(); i++) {
            for (int j = 0; j < matriz.getCols(); j++) {
                if (matriz.get(i, j) == null && !colaPersonajes.isEmpty()) {
                    Generico generico = colaPersonajes.desencolar();
                    matriz.set(i, j, generico);
                    usuariosCreados.add(generico);
                }
            }
        }
    }

    private void ataqueNeo() {
        int ataque = 1;
        for (int fila = 0; fila < matriz.getRows(); fila++) {
            for (int col = 0; col < matriz.getCols(); col++) {
                if (matriz.get(fila, col) instanceof Neo && ataque == 1) {
                    Neo neo = (Neo) matriz.get(fila, col);
                    ataque--;

                    if (neo.esElegido()) {
                        System.out.println("Neo siente que es el elegido y se dispone a matar.");
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                if (fila + i >= 0 && fila + i < dimension && col + j >= 0 && col + j < dimension) {
                                    if (matriz.get((fila + i), (col + j)) instanceof Smith) {

                                        System.out.println("Neo acaba con " + matriz.get((fila + i), (col + j)).getName());
                                        agentesMuertos.add(matriz.get((fila + i), (col + j)));
                                        matriz.set((fila + i), (col + j), null);

                                    }
                                }
                            }
                        }

                    } else System.out.println("Neo no siente que sea el elegido y no hace nada.");
                    cambioPosicionNeo(fila, col);
                }
            }

        }
        System.out.println();

    }

    private void cambioPosicionNeo(int rows, int cols) {
        int fila = (int) (Math.random() * matriz.getRows());
        int col = (int) (Math.random() * matriz.getCols());

        Neo neo = (Neo) matriz.get(rows, cols);
        matriz.set(rows, cols, null);
        System.out.println("Neo cambia de posicion.");
        if (matriz.get(fila, col) instanceof Smith) {
            System.out.println("Neo acaba con el agente " + matriz.get(fila, col).getName());
            agentesMuertos.add(matriz.get(fila, col));
            matriz.set(fila, col, null);

        }
        if (matriz.get(fila, col) instanceof Generico) {
            System.out.println("Neo intercambia la posicion con " + matriz.get(fila, col).getName());
            Generico generico = (Generico) matriz.get(fila, col);
            matriz.set(rows, cols, generico);
            darLocalizacion(generico, rows, cols);
        }
        matriz.set(fila, col, neo);
        darLocalizacion(neo, fila, col);
    }

    private void infectarVirusSmith() {
        for (int fila = 0; fila < matriz.getRows(); fila++) {
            for (int col = 0; col < matriz.getCols(); col++) {
                if (matriz.get(fila, col) instanceof Smith) {
                    Smith sm = (Smith) matriz.get(fila, col);
                    int numeroInfeccion = sm.getPorcentajeInfectar();

                    System.out.println("El agente " + sm.getName() + " puede infectar a " + sm.getPorcentajeInfectar());

                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (fila + i >= 0 && fila + i < dimension && col + j >= 0 && col + j < dimension && numeroInfeccion > 0) {
                                if (matriz.get((fila + i), (col + j)) instanceof Generico) {
                                    numeroInfeccion--;
                                    Smith smith = SmithFactory.createRandom();
                                    virusSmith.add(smith);
                                    usuariosCreados.add(smith);

                                    System.out.println(sm.getName() + " infecta y crea a " + smith.getName());
                                    matriz.set((fila + i), (col + j), smith);
                                    darLocalizacion(smith, (fila + i), (col + j));
                                    totalPersonajes++;

                                }

                            }

                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public void informe() {
        System.out.println("Lista de agentes muertos.");
        for (Personajes eliminados : agentesMuertos) {
            System.out.println("ID:" + eliminados.getId() + " | Nombre:" + eliminados.getName() + " | Fecha:" + eliminados.getFechaCreacion());
        }

        System.out.println();

        System.out.println("Lista de agentes Smith ordenado por fecha de manera descendente.");
        Collections.sort(virusSmith, new PersonaFechaComparator().reversed());
        for (Personajes agentes : virusSmith) {
            System.out.println("ID:" + agentes.getId() + " | Nombre:" + agentes.getName() + " | Fecha:" + agentes.getFechaCreacion());
        }

        System.out.println();
        System.out.println("Lista de usuarios creados ordenados por id.");
        Collections.sort(usuariosCreados, new PersonaIdComparator());
        for (Personajes usuarios : usuariosCreados) {
            System.out.println("ID:" + usuarios.getId() + " | Nombre:" + usuarios.getName() + " | Fecha:" + usuarios.getFechaCreacion());
        }

    }
}
