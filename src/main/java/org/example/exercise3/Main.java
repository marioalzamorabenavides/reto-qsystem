package org.example.exercise3;

public class Main {

    public static void main(String[] args) {
        Operations suma = (a, b) -> a + b;
        Operations resta = (a, b) -> a - b;
        Operations producto = (a, b) -> a * b;

        System.out.println("\nSuma: 5 + 3");
        int resultadoSuma = realizarOperacion(suma, 5, 3);
        suma.mostrarResultado(resultadoSuma);

        System.out.println("\nResta: 7 - 2 ");
        int resultadoResta = realizarOperacion(resta, 7, 2);
        resta.mostrarResultado(resultadoResta);

        System.out.println("\nMultiplicacion: 4 * 6 ");
        int resultadoMultiplicacion = realizarOperacion(producto, 4, 6);
        producto.mostrarResultado(resultadoMultiplicacion);
    }

    private static int realizarOperacion(Operations operacion, int a, int b) {
        return operacion.operacion(a, b);
    }
}
