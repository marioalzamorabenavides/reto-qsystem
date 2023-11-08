package org.example.exercise3;

@FunctionalInterface
public interface Operations {
    int operacion(int a, int b);
    default void mostrarResultado(int resultado) {
        System.out.println("El resultado es: " + resultado);
    }
}