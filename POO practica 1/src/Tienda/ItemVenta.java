package Tienda;

import Producto.Producto;

public class ItemVenta {
    private Producto producto;
    private int cantidad;

    public ItemVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double Subtotal() {
        return producto.getPrecio() * cantidad;
    }

    public String mostrarDetalle() {
        return cantidad+producto.getNombre()  +"- - - - - - "
                + producto.getPrecio() + "c/u--->  Subtotal: $" + Subtotal();
    }

    @Override
    public String toString() {
        return  cantidad +".  "+ producto.getNombre() + " -- $" + producto.getPrecio() + "  --> Subtotal: $" + Subtotal();
    }

}
