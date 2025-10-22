package Tienda;

import Persona.Cliente;
import Persona.Empleado;
import Producto.Producto;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private Empleado empleado;
    private String id;
    private Cliente cliente;
    private List<ItemVenta> items;
    private double total;

    public Venta(Empleado empleado, Cliente cliente, String id) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.id = id;
        this.items = new ArrayList<>();
        this.total = 0;
    }

    public void agregarProducto(Producto p, int cantidad) {
           /* if (p.getStock() >= cantidad) {
                ItemVenta item = new ItemVenta(p, cantidad);
                items.add(item);
                total += item.Subtotal();
                p.reducirStock(cantidad);
            } else {
                System.out.println("Stock insuficiente para el producto: " + p.getNombre());
            }*/
        if (p.getStock() <cantidad) {
            System.out.println("Stock insuficiente");
            return;
        }

        p.reducirStock(cantidad);

        ItemVenta item = new ItemVenta(p, cantidad);
        items.add(item);
        total += item.Subtotal();

    }

    public String mostrarDetalle() {

        StringBuilder sb = new StringBuilder();
        sb.append("\nNº: ").append(getId()).append("\n");
        sb.append("Empleado: ").append(empleado.getNombre()).append("  ID: ").append(empleado.getID()).append("\n");
        sb.append("Cliente: ").append(cliente.getNombre()).append("\n");
        sb.append("Detalle:\n");
        for (ItemVenta item : items) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("Total: $").append(total).append("\n");
        return sb.toString();

    }


    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public List<ItemVenta> getItems() {
        return items;
    }
    
    public String getId() {
        return id;
    }

    public String registro() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id)
                .append(", Cliente: ").append(cliente.getID()).append(" - ").append(cliente.getNombre())
                .append(", Empleado: ").append(empleado.getID()).append(" - ").append(empleado.getNombre())
                .append(", Productos: [");

        for (ItemVenta item : items) {
            sb.append(item.getProducto().getNombre())
                    .append(" x").append(item.getCantidad())
                    .append(", ");
        }


        if (!items.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("], Total: $").append(total);

        return sb.toString();
    }




}
