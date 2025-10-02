package ejercicio1.servicios;

import ejercicio1.modelo.*;
import java.util.List;

public class GestorInventario {
    private Inventario inventario;

    public GestorInventario() {
        this.inventario = new Inventario();
        inicializarDatosPrueba();
    }

    private void inicializarDatosPrueba() {

        // 1. Crear al menos cinco productos con diferentes categorías y agregarlos al inventario.
        Producto[] productosPrueba = {
                new Producto("P001", "Arroz Trimacer", 700.50, 100, CategoriaProducto.ALIMENTOS),
                new Producto("P002", "Smartphone Xiaomi 17", 550000.0, 12, CategoriaProducto.ELECTRONICA),
                new Producto("P003", "Camisa Blanca", 32000.0, 30, CategoriaProducto.ROPA),
                new Producto("P004", "Silla", 5540.0, 30, CategoriaProducto.HOGAR),
                new Producto("P005", "Laptop CX", 750000.0, 5, CategoriaProducto.ELECTRONICA),
                new Producto("P006", "Masitas Paseo", 1250.0, 100, CategoriaProducto.ALIMENTOS),
                new Producto("P007", "Smart TV Samsung", 800500.0, 4, CategoriaProducto.ELECTRONICA),
                new Producto("P008", "Pantalon Cargo", 50000.0, 20, CategoriaProducto.ROPA),
                new Producto("P009", "Mesa Redonda", 11500.0, 15, CategoriaProducto.HOGAR),
                new Producto("P0010", "Monitor Samsung", 255000.0, 5, CategoriaProducto.ELECTRONICA)
        };

        // Agregar al inventario
        for(Producto producto : productosPrueba) {
            if(inventario.agregarProducto(producto)) {
                System.out.println("Producto agregado: " + producto.getNombre());
            }
        }
    }

    public void ejecutarTodasLasTareas() {
        System.out.println("\nEJECUTANDO LAS 10 TAREAS REQUERIDAS");
        System.out.println("=".repeat(50));

        tarea1_listarProductos();
        tarea2_buscarProductoPorId();
        tarea3_filtrarPorCategoria();
        tarea4_eliminarProducto();
        tarea5_actualizarStock();
        tarea6_mostrarTotalStock();
        tarea7_productoMayorStock();
        tarea8_filtrarPorRangoPrecio();
        tarea9_mostrarCategorias();
        tarea10_listaFinal();
    }

    private void tarea1_listarProductos() {
        System.out.println("\n1) LISTAR TODOS LOS PRODUCTOS:");
        inventario.listarProductos();
    }

    private void tarea2_buscarProductoPorId() {
        System.out.println("\n2) BUSCAR PRODUCTO POR ID 'P003':");
        Producto encontrado = inventario.buscarProductoPorId("P003");
        if(encontrado != null) {
            encontrado.mostrarInfo();
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    private void tarea3_filtrarPorCategoria() {
        System.out.println("\n3) FILTRAR PRODUCTOS ELECTRÓNICOS:");
        List<Producto> electronicos = inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);
        if(electronicos.isEmpty()) {
            System.out.println("No hay productos electrónicos");
        } else {
            System.out.println("Productos electrónicos encontrados: " + electronicos.size());
            for(Producto producto : electronicos) {
                producto.mostrarInfo();
            }
        }
    }

    private void tarea4_eliminarProducto() {
        System.out.println("\n4) ELIMINAR PRODUCTO 'P004':");
        if(inventario.eliminarProducto("P004")) {
            System.out.println("Producto eliminado exitosamente");
        } else {
            System.out.println("No se pudo eliminar el producto");
        }
    }

    private void tarea5_actualizarStock() {
        System.out.println("\n5) ACTUALIZAR STOCK DE 'P001' A 150 UNIDADES:");
        if(inventario.actualizarStock("P001", 150)) {
            System.out.println("Stock actualizado exitosamente");
        } else {
            System.out.println("No se pudo actualizar el stock");
        }
    }

    private void tarea6_mostrarTotalStock() {
        System.out.println("\n6) TOTAL DE STOCK DISPONIBLE:");
        int total = inventario.obtenerTotalStock();
        System.out.println("Stock total en inventario: " + total + " unidades");
    }

    private void tarea7_productoMayorStock() {
        System.out.println("\n7) PRODUCTO CON MAYOR STOCK:");
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if(mayorStock != null) {
            System.out.println("Producto con mayor stock:");
            mayorStock.mostrarInfo();
        } else {
            System.out.println("No hay productos en el inventario");
        }
    }

    private void tarea8_filtrarPorRangoPrecio() {
        System.out.println("\n8) FILTRAR PRODUCTOS ENTRE $1000 Y $3000:");
        List<Producto> enRango = inventario.filtrarProductosPorPrecio(1000, 30000);
        if(enRango.isEmpty()) {
            System.out.println("No hay productos en el rango de precios $1000-$30000");
        } else {
            System.out.println("Productos encontrados: " + enRango.size());
            for(Producto producto : enRango) {
                producto.mostrarInfo();
            }
        }
    }

    private void tarea9_mostrarCategorias() {
        System.out.println("\n9) CATEGORÍAS DISPONIBLES:");
        System.out.println("Categorías del sistema:");
        for(CategoriaProducto categoria : CategoriaProducto.values()) {
            System.out.println("  • " + categoria + " - " + categoria.getDescripcion());
        }
    }

    private void tarea10_listaFinal() {
        System.out.println("\n10) LISTA FINAL DE PRODUCTOS:");
        inventario.listarProductos();
    }

    // Método adicional para obtener estadísticas
    public void mostrarEstadisticas() {
        System.out.println("\nESTADÍSTICAS DEL INVENTARIO:");
        System.out.println("├── Productos totales: " + inventario.obtenerCantidadProductos());
        System.out.println("├── Stock total: " + inventario.obtenerTotalStock() + " unidades");
        System.out.println("└── Producto con mayor stock: " +
                (inventario.obtenerProductoConMayorStock() != null ?
                        inventario.obtenerProductoConMayorStock().getNombre() : "N/A"));
    }
}
