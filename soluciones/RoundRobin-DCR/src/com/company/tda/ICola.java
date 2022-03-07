package com.company.tda;

public interface ICola<E> {
    void encolar(E e);
    E desencolar();
    boolean esVacia();
    int longitud();
    E primero();
}
