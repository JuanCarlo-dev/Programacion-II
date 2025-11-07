package BaseDeDatos;

import Persona.*;
import Producto.*;
import Tienda.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos implements Interface{
    private static final String CLIENTES_FILE = "C:\\Users\\pc\\IdeaProjects\\POO practica\\src\\BaseDeDatos\\Clientes.txt";
    private static final String EMPLEADOS_FILE="C:\\Users\\pc\\IdeaProjects\\POO practica\\src\\BaseDeDatos\\Empleados.txt";
    private static final String PRODUCTOS_FILE="C:\\Users\\pc\\IdeaProjects\\POO practica\\src\\BaseDeDatos\\Producto.txt";

    @Override
    public void guardarCliente(Cliente cliente) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CLIENTES_FILE, true))) {
            bw.write(cliente.registro());
            bw.newLine();
        }catch (Exception e) {
            System.out.println("Error al guardar el cliente");
            e.printStackTrace();

        }


    }
    @Override
    public ArrayList<Cliente> cargarClientes() {
        ArrayList<Cliente> clientes= new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CLIENTES_FILE))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                clientes.add(new Cliente(datos[0], Integer.parseInt(datos[1]), datos[2]));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return clientes;

    }

    public String mostrarClientes(){
        ArrayList<Cliente> clientes= cargarClientes();
        StringBuilder registros = new StringBuilder();
        for(Cliente c : clientes){
            registros.append(c.mostrarInfo());
            registros.append("\n- - - - - - - - - - - -");
        }
        return registros.toString();
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(EMPLEADOS_FILE, true))) {
            bw.write(empleado.registro());
            bw.newLine();
        }catch (Exception e) {
            System.out.println("Error al guardar el cliente");
            e.printStackTrace();

        }

    }

    @Override
    public ArrayList<Empleado> cargarEmpleados() {
        ArrayList<Empleado> empleados= new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(EMPLEADOS_FILE))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                empleados.add(new Empleado(datos[0], Integer.parseInt(datos[1]), datos[2]));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return empleados;
    }

    public String mostrarEmpleados(){
        ArrayList<Empleado> empleados= cargarEmpleados();
        StringBuilder registros = new StringBuilder();
        for(Empleado e : empleados){
            registros.append(e.mostrarInfo());
            registros.append("\n- - - - - - - - - - - -");
        }
        return registros.toString();
    }

    @Override
    public void guardarProducto(Producto producto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PRODUCTOS_FILE, true))) {
            bw.write(producto.registro());
            bw.newLine();
        }catch (IOException e) {
            e.printStackTrace();

        }

    }

    @Override
    public ArrayList<Producto> cargarProductos() {
        ArrayList<Producto> productos= new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PRODUCTOS_FILE))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String tipo = datos[0];
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2].trim());
                int stock = Integer.parseInt(datos[3].trim());

                Producto p= null;

                switch (tipo) {
                    case "Accesorio":
                        p= new Accesorio(nombre, precio, stock, datos[4]);
                        break;
                    case "Consola":
                        p=new Consola(nombre,precio,stock,datos[4],datos[5]);
                        break;
                    case "Videojuego":
                        p=new Videojuego(nombre,precio,stock,datos[4],datos[5]);
                        break;
                }
                productos.add(p );

            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return productos;

    }

    public String mostrarProductos(){
        ArrayList<Producto> productos= cargarProductos();
        StringBuilder registros = new StringBuilder();
        for(Producto p : productos){
            registros.append(p.mostrarInfo());
            registros.append("\n- - - - - - - - - - - -");
        }
        return registros.toString();
    }

    @Override
    public void guardarVenta(Venta venta) {

    }






    @Override
    public ArrayList<Venta> cargarVentas() {
       return null;
    }


}
