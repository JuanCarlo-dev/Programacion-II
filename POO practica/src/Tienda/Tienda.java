package Tienda;

import Persona.Cliente;
import Persona.Empleado;
import Producto.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tienda {
    private String nombre;
    public List<Producto> inventario;
    public List<Venta> ventas;
    public HashMap<Integer, Cliente> clientes;
    public HashMap<Integer, Empleado> empleados;

    public Tienda(String nombre){
        this.nombre = nombre;
        this.clientes = new HashMap<>();
        this.empleados = new HashMap<>();
        this.ventas = new ArrayList<>();
        this.inventario = new ArrayList<>();
    }

    public Cliente crearCliente(String nombre, int ID, String correo){
        Cliente c = new Cliente(nombre, ID, correo);
        clientes.put(ID, c);
        return c;
    }

    public Empleado crearEmpleado(String nombre, int ID, String puesto){
        Empleado e = new Empleado(nombre, ID, puesto);
        empleados.put(ID, e);
        return e;
    }

    public void agregarProducto(Producto p){
        inventario.add(p);
    }

    public void registrarVenta(Venta v){
        ventas.add(v);
    }

    public String mostrarClientes(){
        StringBuilder registros = new StringBuilder();
        for(Cliente c : clientes.values()){
            registros.append(c.mostrarInfo());
            registros.append("\n- - - - - - - - - - - -");
        }
        return registros.toString();
    }
    public String mostrarEmpleados(){
        StringBuilder registros = new StringBuilder();
        for(Empleado e : empleados.values()){
            registros.append(e.mostrarInfo());
            registros.append("\n- - - - - - - - - - - -");
        }
        return registros.toString();
    }

    public String mostrarProductos(){
        StringBuilder registros = new StringBuilder();
        for(Producto p : inventario){
            registros.append(p.mostrarInfo());
            registros.append("\n------------");
        }
        return registros.toString();
    }

    public String mostrarVentas(){
        StringBuilder registros = new StringBuilder();
        for(Venta v : ventas){
            registros.append(v.mostrarDetalle());
            registros.append("\n- - - - - - -");
        }
        return registros.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente getCliente(int id) {
        return clientes.get(id);
    }

    public Empleado getEmpleado(int id) {
        return empleados.get(id);
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

}
