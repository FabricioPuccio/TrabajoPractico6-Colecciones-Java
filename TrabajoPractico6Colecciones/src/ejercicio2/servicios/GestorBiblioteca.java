package ejercicio2.servicios;

import ejercicio2.modelo.*;
import java.util.List;

public class GestorBiblioteca {
    private Biblioteca biblioteca;

    public GestorBiblioteca() {
        this.biblioteca = new Biblioteca("Biblioteca Central TUPAD");
        inicializarDatosPrueba();
    }

    private void inicializarDatosPrueba() {
        // Crear autores de prueba
        Autor autor1 = new Autor("A001", "Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("A002", "Jorge Luis Borges", "Argentina");
        Autor autor3 = new Autor("A003", "Julio Cortázar", "Argentina");

        // Crear y agregar libros a la biblioteca
        Libro[] librosPrueba = {
                new Libro("ISBN001", "Cien años de soledad", 1967, autor1),
                new Libro("ISBN002", "El Aleph", 1949, autor2),
                new Libro("ISBN003", "Rayuela", 1963, autor3),
                new Libro("ISBN004", "Crónica de una muerte anunciada", 1981, autor1),
                new Libro("ISBN005", "Ficciones", 1944, autor2)
        };

        // Agregar libros a la biblioteca
        for(Libro libro : librosPrueba) {
            if(biblioteca.agregarLibro(libro)) {
                System.out.println("Libro agregado: " + libro.getTitulo());
            }
        }
    }

    public void ejecutarTodasLasTareas() {
        System.out.println("\nEJECUTANDO TAREAS REQUERIDAS - BIBLIOTECA");
        System.out.println("||".repeat(55));

        tarea1_crearBiblioteca();
        tarea2_listarLibros();
        tarea3_buscarLibroPorIsbn();
        tarea4_filtrarLibrosPorAnio();
        tarea5_eliminarLibro();
        tarea6_mostrarCantidadLibros();
        tarea7_mostrarAutoresDisponibles();
        tarea8_listarLibrosRestantes();
        tarea9_mostrarEstadisticas();
    }

    private void tarea1_crearBiblioteca() {
        System.out.println("\n1) BIBLIOTECA CREADA:");
        System.out.println("Biblioteca: " + biblioteca.getNombre());
        System.out.println("Biblioteca inicializada con datos de prueba");
    }

    private void tarea2_listarLibros() {
        System.out.println("\n2) LISTAR TODOS LOS LIBROS:");
        biblioteca.listarLibros();
    }

    private void tarea3_buscarLibroPorIsbn() {
        System.out.println("\n3) BUSCAR LIBRO POR ISBN 'ISBN004':");
        Libro encontrado = biblioteca.buscarLibroPorIsbn("ISBN004");
        if(encontrado != null) {
            encontrado.mostrarInfo();
            System.out.println("Información del autor:");
            encontrado.getAutor().mostrarInfo();
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    private void tarea4_filtrarLibrosPorAnio() {
        System.out.println("\n4) FILTRAR LIBROS DEL AÑO 1949:");
        List<Libro> libros1949 = biblioteca.filtrarLibrosPorAnio(1949);
        if(libros1949.isEmpty()) {
            System.out.println("No hay libros publicados en 1949");
        } else {
            System.out.println("Libros encontrados del año 1949: " + libros1949.size());
            for(Libro libro : libros1949) {
                libro.mostrarInfo();
            }
        }
    }

    private void tarea5_eliminarLibro() {
        System.out.println("\n5) ELIMINAR LIBRO 'ISBN002':");
        if(biblioteca.eliminarLibro("ISBN002")) {
            System.out.println("Libro eliminado exitosamente");
        } else {
            System.out.println("No se pudo eliminar el libro");
        }
    }

    private void tarea6_mostrarCantidadLibros() {
        System.out.println("\n6) CANTIDAD TOTAL DE LIBROS:");
        int cantidad = biblioteca.obtenerCantidadLibros();
        System.out.println("Total de libros en biblioteca: " + cantidad);
    }

    private void tarea7_mostrarAutoresDisponibles() {
        System.out.println("\n7) AUTORES DISPONIBLES EN BIBLIOTECA:");
        List<Autor> autores = biblioteca.obtenerAutoresUnicos();
        if(autores.isEmpty()) {
            System.out.println("No hay autores registrados");
        } else {
            System.out.println("Autores encontrados: " + autores.size());
            for(Autor autor : autores) {
                autor.mostrarInfo();
            }
        }
    }

    private void tarea8_listarLibrosRestantes() {
        System.out.println("\n8) LISTA FINAL DE LIBROS:");
        biblioteca.listarLibros();
    }

    private void tarea9_mostrarEstadisticas() {
        System.out.println("\n9) ESTADÍSTICAS DE LA BIBLIOTECA:");
        System.out.println("RESUMEN FINAL:");
        System.out.println("├── Biblioteca: " + biblioteca.getNombre());
        System.out.println("├── Total de libros: " + biblioteca.obtenerCantidadLibros());
        System.out.println("├── Autores únicos: " + biblioteca.obtenerAutoresUnicos().size());
        System.out.println("└── Libros por autor disponibles para consulta");
    }
}
