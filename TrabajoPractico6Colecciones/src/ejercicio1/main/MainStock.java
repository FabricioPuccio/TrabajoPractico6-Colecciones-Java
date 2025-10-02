package ejercicio1.main;
import ejercicio1.servicios.GestorInventario;
public class MainStock {
    public static void main(String[] args) {
        System.out.println("SISTEMA DE GESTIÓN DE INVENTARIO - EJERCICIO 1");
        System.out.println("===================================================");

        // TELL DON'T ASK: Solo le decimos al gestor qué hacer
        GestorInventario gestor = new GestorInventario();
        gestor.ejecutarTodasLasTareas();
        gestor.mostrarEstadisticas();

        System.out.println("\nEJECUCIÓN COMPLETADA - EJERCICIO 1 LISTO!");
    }
}
