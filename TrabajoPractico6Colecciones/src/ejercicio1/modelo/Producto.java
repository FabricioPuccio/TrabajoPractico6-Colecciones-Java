package ejercicio1.modelo;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;

    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    // Métodos de acceso (getters)
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public CategoriaProducto getCategoria() { return categoria; }

    // Setters controlados
    public void setPrecio(double precio) {
        if(precio >= 0) this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        if(cantidad >= 0) this.cantidad = cantidad;
    }

    // TELL DON'T ASK: El producto sabe mostrarse
    public void mostrarInfo() {
        System.out.printf("""
            PRODUCTO:
            ├── ID: %s
            ├── Nombre: %s
            ├── Precio: $%.2f
            ├── Stock: %d unidades
            └── Categoría: %s (%s)
            %n""", id, nombre, precio, cantidad, categoria, categoria.getDescripcion());
    }

    @Override
    public String toString() {
        return String.format("Producto[ID:%s, Nombre:%s, Precio:$%.2f, Stock:%d, Categoría:%s]",
                id, nombre, precio, cantidad, categoria);
    }
}
