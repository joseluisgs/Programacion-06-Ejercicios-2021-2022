package com.company.tda;

public interface IPila<T> {
    void push(T dato);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
