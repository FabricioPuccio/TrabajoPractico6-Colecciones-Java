package ejercicio3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos;

    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public List<Curso> getCursos() { return new ArrayList<>(cursos); } // Copia defensiva

    // TELL DON'T ASK: El profesor gestiona sus cursos
    public void agregarCurso(Curso curso) {
        if(curso != null && !cursos.contains(curso)) {
            cursos.add(curso);
            // Sincronización bidireccional
            if(curso.getProfesor() != this) {
                curso.setProfesor(this);
            }
            System.out.println("Curso '" + curso.getNombre() + "' agregado al profesor " + nombre);
        }
    }

    public void eliminarCurso(Curso curso) {
        if(curso != null && cursos.contains(curso)) {
            cursos.remove(curso);
            // Sincronización bidireccional
            if(curso.getProfesor() == this) {
                curso.removerProfesor();
            }
            System.out.println("Curso '" + curso.getNombre() + "' removido del profesor " + nombre);
        }
    }

    public void listarCursos() {
        if(cursos.isEmpty()) {
            System.out.println("El profesor " + nombre + " no tiene cursos asignados");
            return;
        }

        System.out.println("\nCURSOS DEL PROFESOR " + nombre.toUpperCase() + ":");
        for(Curso curso : cursos) {
            System.out.println("   ├── " + curso.getCodigo() + " - " + curso.getNombre());
        }
    }

    public void mostrarInfo() {
        System.out.printf("""
            PROFESOR:
            ├── ID: %s
            ├── Nombre: %s
            ├── Especialidad: %s
            └── Cursos asignados: %d
            %n""", id, nombre, especialidad, cursos.size());
    }

    public int getCantidadCursos() {
        return cursos.size();
    }

    @Override
    public String toString() {
        return String.format("Profesor[ID:%s, Nombre:%s, Especialidad:%s]", id, nombre, especialidad);
    }
}
