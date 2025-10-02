package ejercicio1.modelo;

public enum CategoriaProducto {
    //Constantes - Instancias - Valores - Miembros
    ALIMENTOS("Productos comestibles"),
    ELECTRONICA("Dispositivos electrónicos"),
    ROPA("Prendas de vestir"),
    HOGAR("Artículos para el hogar");

    private final String descripcion;

    //Este constructor es AUTOMÁTICAMENTE private
    CategoriaProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
