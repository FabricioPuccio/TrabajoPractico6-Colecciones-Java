package ejercicio2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> libros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    public String getNombre() { return nombre; }

    // TELL DON'T ASK: La biblioteca gestiona sus libros
    public boolean agregarLibro(Libro libro) {
        if(libro != null && buscarLibroPorIsbn(libro.getIsbn()) == null) {
            libros.add(libro);
            return true;
        }
        return false;
    }

    public void listarLibros() {
        if(libros.isEmpty()) {
            System.out.println("La biblioteca '" + nombre + "' está vacía");
            return;
        }

        System.out.println("\nLIBROS EN BIBLIOTECA '" + nombre + "' (" + libros.size() + " libros):");
        for(Libro libro : libros) {
            libro.mostrarInfo();
        }
    }

    public Libro buscarLibroPorIsbn(String isbn) {
        Libro libro = null;

        if(this.libros.isEmpty()) return libro;

        int i = 0;
        while(i < this.libros.size() && !this.libros.get(i).getIsbn().equals(isbn)){
            i++;
        }

        if(i < this.libros.size()){
            libro = this.libros.get(i);
        }

        return libro;

//        for(Libro libro : libros) {
//            if(libro.getIsbn().equals(isbn)) {
//                return libro;
//            }
//        }
//        return null;
    }

    public boolean eliminarLibro(String isbn) {
        Libro libro = buscarLibroPorIsbn(isbn);
        if(libro != null) {
            libros.remove(libro);
            return true;
        }
        return false;
    }

    public int obtenerCantidadLibros() {
        return libros.size();
    }

    public List<Libro> filtrarLibrosPorAnio(int anio) {
        List<Libro> resultado = new ArrayList<>();
        for(Libro libro : libros) {
            if(libro.getAnioPublicacion() == anio) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public List<Autor> obtenerAutoresUnicos() {
        List<Autor> autores = new ArrayList<>();
        for(Libro libro : libros) {
            Autor autor = libro.getAutor();
            if(!autores.contains(autor)) {
                autores.add(autor);
            }
        }
        return autores;
    }
}
