package ejercicio1.modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // TELL DON'T ASK: Métodos que realizan acciones
    public boolean agregarProducto(Producto producto) {
        if(producto != null && buscarProductoPorId(producto.getId()) == null) {
            productos.add(producto);
            return true;
        }
        return false;
    }

    public void listarProductos() {
        if(productos.isEmpty()) {
            System.out.println("El inventario está vacío");
            return;
        }

        System.out.println("\nLISTA DE PRODUCTOS (" + productos.size() + " productos):");
        for(Producto producto : productos) {
            producto.mostrarInfo();
        }
    }

    public Producto buscarProductoPorId(String id) {
        Producto producto = null;
        int i = 0;

        while (i < this.productos.size() && !this.productos.get(i).getId().equals(id)){
            i++;
        }

        if (i < this.productos.size()){
            producto = this.productos.get(i);
        }
        return producto;

        // Otra alternativa con for-each
//        for(Producto p : productos) {
//            if(p.getId().equals(id)) {
//                return p;
//            }
//        }
//        return null;
    }

    public boolean eliminarProducto(String id) {
        Producto producto = buscarProductoPorId(id);
        if(producto != null) {
            productos.remove(producto);
            return true;
        }
        return false;
    }

    public boolean actualizarStock(String id, int nuevaCantidad) {
        Producto producto = buscarProductoPorId(id);
        if(producto != null && nuevaCantidad >= 0) {
            producto.setCantidad(nuevaCantidad);
            return true;
        }
        return false;
    }

    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        List<Producto> resultado = new ArrayList<>();
        for(Producto producto : productos) {
            if(producto.getCategoria() == categoria) {
                resultado.add(producto);
            }
        }
        return resultado;
    }

    public int obtenerTotalStock() {
        int total = 0;
        for(Producto producto : productos) {
            total += producto.getCantidad();
        }
        return total;
    }

    public Producto obtenerProductoConMayorStock() {
        if(this.productos.isEmpty()) return null;

        Producto mayorStock = productos.get(0);
        for(Producto producto : productos) {
            if(producto.getCantidad() > mayorStock.getCantidad()) {
                mayorStock = producto;
            }
        }
        return mayorStock;
    }

    public List<Producto> filtrarProductosPorPrecio(double precioMin, double precioMax) {
        List<Producto> resultado = new ArrayList<>();
        for(Producto producto : productos) {
            if(producto.getPrecio() >= precioMin && producto.getPrecio() <= precioMax) {
                resultado.add(producto);
            }
        }
        return resultado;
    }

    public int obtenerCantidadProductos() {
        return productos.size();
    }
}
