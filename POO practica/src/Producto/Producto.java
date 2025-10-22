package Producto;

public abstract class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString() {
        return getNombre();
    }

    public abstract String mostrarInfo();
    public void mostrarDetalle(){
        System.out.println( getNombre()+"---------"+ getPrecio());
    };

    public void reducirStock(int cantidad) {
        if (stock >= cantidad) {
            stock -= cantidad;
        }
        else {
            System.out.println("Stock no disponible");
        }

    }

    public abstract String registro() ;
}
