package ejercicio3.servicios;

import ejercicio3.modelo.*;
import java.util.ArrayList;
import java.util.List;

public class GestorUniversidad {
    private Universidad universidad;

    public GestorUniversidad() {
        this.universidad = new Universidad("Universidad Tecnológica Nacional");
        inicializarDatosPrueba();
    }

    private void inicializarDatosPrueba() {
        // Crear profesores
        Profesor[] profesores = {
                new Profesor("P001", "Jerónimo Cortez", "Programación II"),
                new Profesor("P002", "Carlos López", "Base de Datos I"),
                new Profesor("P003", "María Fernández", "Probabilidad y Estadística I")
        };

        // Crear cursos
        Curso[] cursos = {
                new Curso("C001", "Programación Orientada a Objetos"),
                new Curso("C002", "Algoritmos Avanzados"),
                new Curso("C003", "Base de Datos I"),
                new Curso("C004", "Visualizar Datos en R"),
                new Curso("C005", "Patrones de Diseño")
        };

        // Agregar profesores a la universidad
        for(Profesor profesor : profesores) {
            if(universidad.agregarProfesor(profesor)) {
                System.out.println("Profesor agregado: " + profesor.getNombre());
            }
        }

        // Agregar cursos a la universidad
        for(Curso curso : cursos) {
            if(universidad.agregarCurso(curso)) {
                System.out.println("Curso agregado: " + curso.getNombre());
            }
        }
    }

    public void ejecutarTodasLasTareas() {
        System.out.println("\nEJECUTANDO 8 TAREAS REQUERIDAS - UNIVERSIDAD");
        System.out.println("//".repeat(55));

        tarea1_agregarProfesoresYCursos();
        tarea2_asignarProfesoresACursos();
        tarea3_listarCursosYProfesores();
        tarea4_cambiarProfesorDeCurso();
        tarea5_removerCurso();
        tarea6_removerProfesor();
        tarea7_listarEstadoFinal();
        tarea8_reporteCursosPorProfesor();
    }

    private void tarea1_agregarProfesoresYCursos() {
        System.out.println("\n1) AGREGAR PROFESORES Y CURSOS:");
        System.out.println("Universidad: " + universidad.getNombre());
        System.out.println("Resumen inicial:");
        System.out.println(" ├── Profesores: " + universidad.getCantidadProfesores());
        System.out.println(" └── Cursos: " + universidad.getCantidadCursos());
    }

    private void tarea2_asignarProfesoresACursos() {
        System.out.println("\n2) ASIGNAR PROFESORES A CURSOS:");

        // Asignaciones iniciales
        String[][] asignaciones = {
                {"C001", "P001"}, // POO -> Ana García
                {"C002", "P003"}, // Estructuras -> María Fernández
                {"C003", "P002"}, // BD I -> Carlos López
                {"C004", "P003"}, // Algoritmos Avanzados -> María Fernández
                {"C005", "P001"}  // Patrones -> Ana García
        };

        for(String[] asignacion : asignaciones) {
            String codigoCurso = asignacion[0];
            String idProfesor = asignacion[1];

            if(universidad.asignarProfesorACurso(codigoCurso, idProfesor)) {
                Curso curso = universidad.buscarCursoPorCodigo(codigoCurso);
                Profesor profesor = universidad.buscarProfesorPorId(idProfesor);
                System.out.println(" * " + curso.getNombre() + " → " + profesor.getNombre());
            }
        }
    }

    private void tarea3_listarCursosYProfesores() {
        System.out.println("\n3) LISTAR CURSOS Y PROFESORES:");

        System.out.println("\n--- LISTA DE CURSOS ---");
        universidad.listarCursos();

        System.out.println("\n--- LISTA DE PROFESORES ---");
        universidad.listarProfesores();

        // Mostrar cursos por profesor
        System.out.println("\n--- CURSOS POR PROFESOR ---");
        for(Profesor profesor : getProfesores()) {
            System.out.println("\n" + profesor.getNombre() + ":");
            profesor.listarCursos();
        }
    }

    private void tarea4_cambiarProfesorDeCurso() {
        System.out.println("\n4) CAMBIAR PROFESOR DE UN CURSO:");
        System.out.println("Cambiando profesor de 'Algoritmos Avanzados' (C002)");

        // Buscar el curso y mostrar profesor actual
        Curso curso = universidad.buscarCursoPorCodigo("C002");
        if(curso != null && curso.getProfesor() != null) {
            System.out.println("   Profesor actual: " + curso.getProfesor().getNombre());
        }

        // Cambiar a otro profesor
        if(universidad.asignarProfesorACurso("C002", "P001")) {
            System.out.println("Nuevo profesor asignado: Jerónimo Cortez");

            // Verificar sincronización bidireccional
            Curso cursoActualizado = universidad.buscarCursoPorCodigo("C002");
            Profesor nuevoProfesor = universidad.buscarProfesorPorId("P001");

            System.out.println("Verificando sincronización:");
            System.out.println("      - Curso tiene profesor: " +
                    (cursoActualizado.getProfesor() != null ? cursoActualizado.getProfesor().getNombre() : "Ninguno"));
            System.out.println("      - Profesor tiene curso: " +
                    (nuevoProfesor.getCursos().contains(cursoActualizado) ? "Sí" : "No"));
        }
    }

    private void tarea5_removerCurso() {
        System.out.println("\n5) REMOVER UN CURSO:");
        System.out.println("Eliminando curso 'Base de Datos I' (C003)");

        // Mostrar estado antes de eliminar
        Curso curso = universidad.buscarCursoPorCodigo("C003");
        if(curso != null && curso.getProfesor() != null) {
            System.out.println("   Profesor asignado antes: " + curso.getProfesor().getNombre());
        }

        if(universidad.eliminarCurso("C003")) {
            System.out.println("Curso eliminado exitosamente");

            // Verificar que el profesor ya no tiene este curso
            Profesor profesor = universidad.buscarProfesorPorId("P002");
            if(profesor != null) {
                System.out.println("Cursos del profesor Carlos López después:");
                profesor.listarCursos();
            }
        }
    }

    private void tarea6_removerProfesor() {
        System.out.println("\n6) REMOVER UN PROFESOR:");
        System.out.println("Eliminando profesor 'Carlos López' (P002)");

        if(universidad.eliminarProfesor("P002")) {
            System.out.println("Profesor eliminado exitosamente");

            // Verificar que los cursos quedaron sin profesor
            System.out.println("Estado de cursos después de eliminar profesor:");
            universidad.listarCursos();
        }
    }

    private void tarea7_listarEstadoFinal() {
        System.out.println("\n7) LISTA FINAL:");
        System.out.println("ESTADO FINAL DE LA UNIVERSIDAD");
        System.out.println("=".repeat(40));

        universidad.listarProfesores();
        universidad.listarCursos();
    }

    private void tarea8_reporteCursosPorProfesor() {
        System.out.println("\n8) REPORTE: CURSOS POR PROFESOR");
        universidad.mostrarReporteCursosPorProfesor();
    }

    // Métodos auxiliares
    private List<Profesor> getProfesores() {
        // En una implementación real, esto vendría de la universidad
        List<Profesor> profesores = new ArrayList<>();
        profesores.add(universidad.buscarProfesorPorId("P001"));
        profesores.add(universidad.buscarProfesorPorId("P002"));
        profesores.add(universidad.buscarProfesorPorId("P003"));
        return profesores;
    }

    public void mostrarEstadisticasFinales() {
        System.out.println("\nESTADÍSTICAS FINALES:");
        System.out.println("├── Universidad: " + universidad.getNombre());
        System.out.println("├── Profesores activos: " + universidad.getCantidadProfesores());
        System.out.println("├── Cursos activos: " + universidad.getCantidadCursos());
        System.out.println("└── Relaciones bidireccionales verificadas ✓");
    }
}