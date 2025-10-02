# Trabajo Práctico 6 - Colecciones en Java

## 📋 Información Académica
- **Materia:** Programación II
- **Trabajo Práctico:** N° 6 - Colecciones
- **Profesora:** Cinthia Rigoni
- **Tutor:** Jerónimo Cortez
- **Estudiante:** Fabricio Puccio
- **Fecha de Entrega:** 02 de Octubre de 2025
- **Carrera:** Tecnicatura Universitaria en Programación a Distancia

## 📋 Descripción
Implementación de tres sistemas utilizando colecciones **ArrayList** y relaciones entre objetos en Java, para la materia Programación II.

## 🏗️ Sistemas Implementados

### 1. 🏪 Sistema de Stock
**Gestión de productos con categorías y inventario**
- Clases: `Producto`, `Inventario`, `CategoriaProducto` (enum)
- Funcionalidades: CRUD completo, búsquedas, filtros, reportes de stock
- Relación: 1 a N (Inventario → Productos)

### 2. 📚 Sistema de Biblioteca  
**Gestión de libros y autores**
- Clases: `Biblioteca`, `Libro`, `Autor`
- Funcionalidades: Gestión de libros, búsqueda por ISBN, filtros por año
- Relación: 1 a N (Biblioteca → Libros)

### 3. 🎓 Sistema Universitario
**Gestión de profesores y cursos con relaciones bidireccionales**
- Clases: `Universidad`, `Profesor`, `Curso`
- Funcionalidades: Asignación bidireccional, sincronización automática
- Relación: Bidireccional 1 a N (Profesor ↔ Cursos)

## 🎯 Objetivos Cumplidos

- ✅ **ArrayList** como estructura principal
- ✅ **Enumeraciones** con métodos y descripciones
- ✅ **Relaciones 1 a N** unidireccionales y bidireccionales
- ✅ **Principio "Tell Don't Ask"** aplicado correctamente
- ✅ **Encapsulamiento** y modularidad
- ✅ **Búsquedas, filtros y ordenamientos**

## 🚀 Cómo Ejecutar

### Prerrequisitos
- Java JDK 8 o superior
- Git (opcional)

### Compilación y Ejecución
```bash
# Compilar todos los ejercicios
find src -name "*.java" > sources.txt
javac -d bin @sources.txt

# Ejecutar cada sistema
java -cp bin ejercicio1.MainStock
java -cp bin ejercicio2.MainBiblioteca
java -cp bin ejercicio3.MainUniversidad