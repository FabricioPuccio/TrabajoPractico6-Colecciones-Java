package ejercicio3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public String getNombre() { return nombre; }

    // GESTIÓN DE PROFESORES
    public boolean agregarProfesor(Profesor profesor) {
        if(profesor != null && !profesores.contains(profesor)) {
            profesores.add(profesor);
            return true;
        }
        return false;
    }

    public boolean eliminarProfesor(String id) {
        Profesor profesor = buscarProfesorPorId(id);
        if(profesor != null) {
            // Remover profesor de todos sus cursos antes de eliminarlo
            for(Curso curso : new ArrayList<>(profesor.getCursos())) {
                curso.removerProfesor();
            }
            profesores.remove(profesor);
            return true;
        }
        return false;
    }

    public Profesor buscarProfesorPorId(String id) {
        if (this.profesores.isEmpty()) return null;
        Profesor profesor = null;

        int i = 0;
        while(i < this.profesores.size() && !this.profesores.get(i).getId().equals(id)){
            i++;
        }

        if(i < this.profesores.size()){
            profesor = this.profesores.get(i);
        }
//        for(Profesor profesor : profesores) {
//            if(profesor.getId().equals(id)) {
//                return profesor;
//            }
//        }
//        return null;
        return profesor;
    }

    public void listarProfesores() {
        if(profesores.isEmpty()) {
            System.out.println("No hay profesores en la universidad");
            return;
        }

        System.out.println("\nPROFESORES DE " + nombre.toUpperCase() + ":");
        for(Profesor profesor : profesores) {
            profesor.mostrarInfo();
        }
    }

    // GESTIÓN DE CURSOS
    public boolean agregarCurso(Curso curso) {
        if(curso != null && !cursos.contains(curso)) {
            cursos.add(curso);
            return true;
        }
        return false;
    }

    public boolean eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if(curso != null) {
            // Remover relación con profesor si existe
            if(curso.getProfesor() != null) {
                curso.getProfesor().eliminarCurso(curso);
            }
            cursos.remove(curso);
            return true;
        }
        return false;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        if(this.cursos.isEmpty()) return null;
        Curso curso = null;

        int i = 0;
        while(i < this.cursos.size() && !this.cursos.get(i).getCodigo().equals(codigo)){
            i++;
        }

        if(i < this.cursos.size()){
            curso = this.cursos.get(i);
        }

        return curso;

//        for(Curso curso : cursos) {
//            if(curso.getCodigo().equals(codigo)) {
//                return curso;
//            }
//        }
//        return null;
    }

    public void listarCursos() {
        if(cursos.isEmpty()) {
            System.out.println("No hay cursos en la universidad");
            return;
        }

        System.out.println("\nCURSOS DE " + nombre.toUpperCase() + ":");
        for(Curso curso : cursos) {
            curso.mostrarInfo();
        }
    }

    // ASIGNACIÓN DE PROFESORES A CURSOS
    public boolean asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);

        if(curso != null && profesor != null) {
            curso.setProfesor(profesor);
            return true;
        }
        return false;
    }

    // REPORTES
    public void mostrarReporteCursosPorProfesor() {
        System.out.println("\nREPORTE: CURSOS POR PROFESOR");
        System.out.println("=".repeat(35));

        for(Profesor profesor : profesores) {
            System.out.printf("%s: %d cursos%n",
                    profesor.getNombre(), profesor.getCantidadCursos());
        }
    }

    public int getCantidadProfesores() {
        return profesores.size();
    }

    public int getCantidadCursos() {
        return cursos.size();
    }
}
