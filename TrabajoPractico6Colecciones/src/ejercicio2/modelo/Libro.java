package ejercicio2.modelo;

public class Libro {
    private String isbn;
    private String titulo;
    private int anioPublicacion;
    private Autor autor;

    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    // Getters
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public Autor getAutor() { return autor; }

    // TELL DON'T ASK: El libro sabe mostrarse
    public void mostrarInfo() {
        System.out.printf("""
            LIBRO:
            ├── ISBN: %s
            ├── Título: %s
            ├── Año: %d
            └── Autor: %s
            %n""", isbn, titulo, anioPublicacion, autor.getNombre());
    }

    @Override
    public String toString() {
        return String.format("Libro[ISBN:%s, Título:%s, Año:%d]",
                isbn, titulo, anioPublicacion);
    }
}
