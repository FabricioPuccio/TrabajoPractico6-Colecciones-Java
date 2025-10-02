package ejercicio3.main;

import ejercicio3.servicios.GestorUniversidad;

public class MainUniversidad {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE GESTIÓN UNIVERSITARIA - EJERCICIO 3");
        System.out.println("===================================================");
        System.out.println("RELACIONES BIDIRECCIONALES 1:N");
        System.out.println("SINCRONIZACIÓN AUTOMÁTICA");
        System.out.println("===================================================");

        // TELL DON'T ASK: Solo le decimos al gestor qué hacer
        GestorUniversidad gestor = new GestorUniversidad();
        gestor.ejecutarTodasLasTareas();
        gestor.mostrarEstadisticasFinales();

        System.out.println("\n¡EJECUCIÓN COMPLETADA! - TRES EJERCICIOS TERMINADOS");
        System.out.println("===================================================");
    }
}
