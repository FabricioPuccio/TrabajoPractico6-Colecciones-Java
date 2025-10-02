package ejercicio2.modelo;

public class Autor {
    private String id;
    private String nombre;
    private String nacionalidad;

    public Autor(String id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getNacionalidad() { return nacionalidad; }

    // TELL DON'T ASK: El autor sabe mostrarse
    public void mostrarInfo() {
        System.out.printf("""
            AUTOR:
            ├── ID: %s
            ├── Nombre: %s
            └── Nacionalidad: %s
            %n""", id, nombre, nacionalidad);
    }

    @Override
    public String toString() {
        return String.format("Autor[ID:%s, Nombre:%s]", id, nombre);
    }
}
