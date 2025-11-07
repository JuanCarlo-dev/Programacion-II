package BaseDeDatos;

import Persona.*;
import Producto.*;
import Tienda.*;

import java.util.ArrayList;

public interface Interface {
    public void guardarCliente(Cliente cliente) ;
    public void guardarEmpleado(Empleado empleado);
    public void guardarProducto(Producto producto);
    public void guardarVenta(Venta venta);
    public ArrayList<Cliente> cargarClientes();
    public ArrayList<Empleado> cargarEmpleados();
    public ArrayList<Producto> cargarProductos();
    public ArrayList<Venta> cargarVentas();
}
