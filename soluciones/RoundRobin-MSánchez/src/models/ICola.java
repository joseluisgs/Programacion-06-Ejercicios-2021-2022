package models;

import java.util.ArrayList;

public interface ICola {
    void enqueue(Proceso proceso, ArrayList CPU);

    Proceso dequeue(ArrayList CPU);

    boolean isEmpty();

    int size();
    Proceso first();
}
