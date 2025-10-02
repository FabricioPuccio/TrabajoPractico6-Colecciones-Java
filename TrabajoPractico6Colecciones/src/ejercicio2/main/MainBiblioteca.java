package ejercicio2.main;

import ejercicio2.servicios.GestorBiblioteca;

public class MainBiblioteca {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE GESTIÓN DE BIBLIOTECA - EJERCICIO 2");
        System.out.println("===================================================");

        // TELL DON'T ASK: Solo le decimos al gestor qué hacer
        GestorBiblioteca gestor = new GestorBiblioteca();
        gestor.ejecutarTodasLasTareas();

        System.out.println("\nEJECUCIÓN COMPLETADA - EJERCICIO 2 LISTO!");
    }
}
