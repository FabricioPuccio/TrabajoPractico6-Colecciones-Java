package ejercicio3.modelo;

public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null; // Inicialmente sin profesor
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }

    // TELL DON'T ASK: El curso gestiona su profesor con sincronización bidireccional
    public void setProfesor(Profesor nuevoProfesor) {
        // Remover del profesor actual si existe
        if(this.profesor != null && this.profesor != nuevoProfesor) {
            this.profesor.eliminarCurso(this);
        }

        // Asignar nuevo profesor
        this.profesor = nuevoProfesor;

        // Sincronización bidireccional
        if(nuevoProfesor != null && !nuevoProfesor.getCursos().contains(this)) {
            nuevoProfesor.agregarCurso(this);
        }
    }

    public void removerProfesor() {
        this.profesor = null;
    }

    public void mostrarInfo() {
        String profesorInfo = (profesor != null) ? profesor.getNombre() : "Sin asignar";
        System.out.printf("""
            CURSO:
            ├── Código: %s
            ├── Nombre: %s
            └── Profesor: %s
            %n""", codigo, nombre, profesorInfo);
    }

    @Override
    public String toString() {
        return String.format("Curso[Código:%s, Nombre:%s]", codigo, nombre);
    }
}
