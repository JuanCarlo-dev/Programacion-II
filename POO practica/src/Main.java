import Interfaz.Interfaz;
import Persona.Cliente;
import Persona.Empleado;
import Producto.Producto;
import Producto.Accesorio;
import Producto.Consola;
import Producto.Videojuego;
import Tienda.Tienda;
import Tienda.Venta;

public class Main {
    public static void main(String[] args) {
        Tienda tienda= new Tienda("Don Inturias");

        Cliente cliente1= tienda.crearCliente("Antuan",213562,"Antuan@gmail.com");
        Cliente cliente2= tienda.crearCliente("Fabiola",432564,"Fabiola@gmail.com");
        Empleado empleado1= tienda.crearEmpleado("Carol",234643,"Vendedor");
        Empleado empleado2= tienda.crearEmpleado("Samuel",7454354,"Vendedor");

        Producto producto1= new Accesorio("LED pant", 4000,6,"Monitor");
        Producto producto2= new Videojuego("Resident Evil", 160,20,"violencia","Steam");
        Producto producto3= new Consola("Xbox",7000,3,"LaboratoryGames", "GP5");

        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);
        tienda.agregarProducto(producto3);

        Venta v= new Venta( empleado2, cliente1,"354345f");
        v.agregarProducto(producto1,2);
        producto1.reducirStock(1);
        v.mostrarDetalle();

        new Interfaz();


    }
}