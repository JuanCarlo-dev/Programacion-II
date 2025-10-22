package Interfaz;

import BaseDeDatos.BaseDeDatos;
import Producto.Producto;
import Producto.Accesorio;
import Producto.Videojuego;
import Producto.Consola;
import Tienda.Tienda;
import Tienda.ItemVenta;
import Tienda.Venta;
import Persona.Cliente;
import Persona.Empleado;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Interfaz extends JFrame {
    private Tienda tienda;
    public Interfaz() {
        tienda= new Tienda(" \"Tienda Don Inturias\"");
        cargarDatos();
        setTitle("La Mejor Tienda Gamer");
        getContentPane().setBackground(Color.BLACK);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel(tienda.getNombre());
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        add(titulo, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));
        String[] opciones={"CREAR CLIENTE","CREAR EMPLEADO","AGREGAR PRODUCTO","REGISTRAR VENTA",
                "MOSTRAR CLIENTES","MOSTRAR EMPLEADOS","MOSTRAR PRODUCTOS","MOSTRAR VENTAS"};
        for (int i = 0; i < opciones.length; i++) {
            JButton boton = new JButton(opciones[i]);
            boton.setForeground(Color.WHITE);
            boton.setBackground(Color.DARK_GRAY);
            boton.setFocusPainted(false);

            String opcion = opciones[i];

            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    switch (opcion) {
                        case "CREAR CLIENTE":
                            crearCliente();
                            break;
                        case "CREAR EMPLEADO":
                            crearEmpleado();
                            break;
                        case "AGREGAR PRODUCTO":
                            agregarProducto();
                            break;
                        case "REGISTRAR VENTA":
                            registrarVenta();
                            break;
                        case "MOSTRAR CLIENTES":
                            mostrarClientes();
                            break;
                        case "MOSTRAR EMPLEADOS":
                            mostrarEmpleados();
                            break;
                        case "MOSTRAR PRODUCTOS":
                            mostrarProductos();
                            break;
                        case "MOSTRAR VENTAS":
                            mostrarVentas();
                            break;

                    }

                }
            });

            panel.add(boton);
        }
        add(panel, BorderLayout.CENTER);

        setVisible(true);

    }

    public void crearCliente() {
        JFrame ventana= new JFrame("Crear Cliente");
        ventana.setSize(300,150);
        ventana.setLayout(new BorderLayout());
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(this);

        JPanel panel1= new JPanel();
        panel1.setLayout(new GridLayout(3,2));
        String[] datos={"Nombre:  ","ID:  ","Email:  "};
        JTextField[] campos= new JTextField[datos.length];

        for (int i = 0; i < datos.length; i++) {
            JLabel etiqueta = new JLabel(datos[i]);
            etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(etiqueta);
            campos[i]= new JTextField(8);
            panel1.add(campos[i]);

        }

        ventana.add(panel1, BorderLayout.CENTER);

        JButton guardar= new JButton("Guardar");
        ventana.add(guardar, BorderLayout.SOUTH);

        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<campos.length; i++){
                    if (campos[i].getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Por favor complete todos los campos " , "Error", JOptionPane.ERROR_MESSAGE);
                        return;

                    }
                }
                int id;
                try {
                    id = Integer.parseInt(campos[1].getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese solo numeros en el campo Id", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Cliente cliente = tienda.crearCliente(campos[0].getText(),id,campos[2].getText());
                BaseDeDatos.guardar("C:\\Users\\pc\\IdeaProjects\\POO practica\\src\\BaseDeDatos\\Clientes.txt",cliente.registro());
                ventana.dispose();


            }

        });
        ventana.setVisible(true);

    }

    public void crearEmpleado() {
        JFrame ventana= new JFrame("Crear Empleado");
        ventana.setSize(300,150);
        ventana.setLayout(new BorderLayout());
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(this);

        JPanel panel1= new JPanel();
        panel1.setLayout(new GridLayout(3,2));
        String[] datos={"Nombre:  ","ID:  ","Puesto:  "};
        JTextField[] campos= new JTextField[datos.length];

        for (int i = 0; i < datos.length; i++) {
            JLabel etiqueta = new JLabel(datos[i]);
            etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(etiqueta);
            campos[i]= new JTextField(8);
            panel1.add(campos[i]);

        }

        ventana.add(panel1, BorderLayout.CENTER);

        JButton guardar= new JButton("Guardar");
        ventana.add(guardar, BorderLayout.SOUTH);

        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<campos.length; i++){
                    if (campos[i].getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Por favor complete todos los campos " , "Error", JOptionPane.ERROR_MESSAGE);
                        return;

                    }
                }
                int id;
                try {
                    id = Integer.parseInt(campos[1].getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese solo numeros en el campo Id", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Empleado empleado = tienda.crearEmpleado(campos[0].getText(),id,campos[2].getText());
                BaseDeDatos.guardar("C:\\Users\\pc\\IdeaProjects\\POO practica\\src\\BaseDeDatos\\Empleados.txt",empleado.registro());
                ventana.dispose();


            }

        });
        ventana.setVisible(true);

    }

    public void agregarProducto() {
        JFrame ventana= new JFrame("Agregar Producto");
        ventana.setSize(300,230);
        ventana.setLayout(new BorderLayout());
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(this);

        JPanel panel= new JPanel();
        panel.setLayout(new GridLayout(0,2,5,5));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));
        JLabel tipo = new JLabel("Tipo de Producto: ");
        String[] tipos= {"Accesorio","Videojuego","Consola",};
        JComboBox<String> comboTipos= new JComboBox<>(tipos);

        ventana.add(panel, BorderLayout.CENTER);


        panel.add(tipo);
        panel.add(comboTipos);
        String[] camposComunes= {"Nombre: ","Precio: ","Stock: "};
        JTextField[] campoComun= new JTextField[camposComunes.length];
        for (int i = 0; i < camposComunes.length; i++) {
            JLabel etiqueta = new JLabel(camposComunes[i]);
            etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(etiqueta);
            campoComun[i]= new JTextField(8);
            panel.add(campoComun[i]);
        }

        JPanel panelAccesorio= new JPanel(new GridLayout(1,2));
        panelAccesorio.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JTextField categoria= new JTextField();
        JLabel campoAccesorio= new JLabel("Categoria: ");
        campoAccesorio.setHorizontalAlignment(SwingConstants.CENTER);
        panelAccesorio.add(campoAccesorio);
        panelAccesorio.add(categoria);

        JPanel panelVideojuego= new JPanel(new GridLayout(2,2));
        panelVideojuego.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JTextField genero= new JTextField();
        JTextField plataforma= new JTextField();
        JLabel campoGenero= new JLabel("Genero: ");
        campoGenero.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel campoPlataforma= new JLabel("Plataforma: ");
        campoPlataforma.setHorizontalAlignment(SwingConstants.CENTER);
        panelVideojuego.add(campoGenero);
        panelVideojuego.add(genero);
        panelVideojuego.add(campoPlataforma);
        panelVideojuego.add(plataforma);

        JPanel panelConsola= new JPanel(new GridLayout(2,2));
        panelConsola.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JTextField fabricante= new JTextField();
        JTextField modelo= new JTextField();
        JLabel campoFabricante= new JLabel("Fabricante: ");
        campoFabricante.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel campoModelo= new JLabel("Modelo: ");
        campoModelo.setHorizontalAlignment(SwingConstants.CENTER);
        panelConsola.add(campoFabricante);
        panelConsola.add(fabricante);
        panelConsola.add(campoModelo);
        panelConsola.add(modelo);



        JPanel panelDinamico = new JPanel(new BorderLayout());
        JButton agregar= new JButton("AGREGAR");
        JPanel panelsur =new JPanel(new BorderLayout());
        panelsur.add(panelDinamico, BorderLayout.CENTER);
        panelsur.add(agregar, BorderLayout.SOUTH);
        ventana.add(panelsur,BorderLayout.SOUTH);


        comboTipos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelDinamico.removeAll();

                switch (comboTipos.getSelectedIndex()) {
                    case 0:
                        panelDinamico.add(panelAccesorio);
                        break;
                    case 1:
                        panelDinamico.add(panelVideojuego);
                        break;
                    case 2:
                        panelDinamico.add(panelConsola);
                        break;
                }
                panelDinamico.revalidate();
                panelDinamico.repaint();
            }
        });

        comboTipos.setSelectedIndex(0);

        agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    try {
                        int tipo = (int) comboTipos.getSelectedIndex();

                        String nombre = campoComun[0].getText();
                        double precio = Double.parseDouble(campoComun[1].getText());
                        int stock = Integer.parseInt(campoComun[2].getText());

                        Producto nuevoProducto = null;


                        switch (tipo) {
                            case 0:
                                String categ = categoria.getText();
                                nuevoProducto = new Accesorio(nombre, precio, stock, categ);
                                break;

                            case 1:

                                String gen = genero.getText();
                                String plataf = plataforma.getText();
                                nuevoProducto = new Videojuego(nombre, precio, stock, gen, plataf);
                                break;

                            case 2:

                                String fabric = fabricante.getText();
                                String modl = modelo.getText();
                                nuevoProducto = new Consola(nombre, precio, stock, fabric, modl);
                                break;
                        }

                        if (nuevoProducto != null) {
                            tienda.agregarProducto(nuevoProducto);
                            BaseDeDatos.guardar("C:\\Users\\pc\\IdeaProjects\\POO practica\\src\\BaseDeDatos\\Producto.txt",nuevoProducto.registro());

                            ventana.dispose();

                        }


                    } catch (Exception ex) {

                        JOptionPane.showMessageDialog(ventana, "Error al agregar producto revisa que todos los campos " +
                                "\nesten llenos y q reciban los tipo de datos requeridos " );
                    }

            }
        });

        ventana.setVisible(true);

    }

    public void registrarVenta() {
        JFrame ventana = new JFrame();
        ventana.setTitle("Venta");
        ventana.setSize(300,450);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(this);

        JPanel panelSuperior = new JPanel(new GridLayout(2, 2,10,10));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelSuperior.add(new JLabel("Cliente:"));
        JComboBox<Cliente> comboClientes = new JComboBox<>(tienda.clientes.values().toArray(new Cliente[0]));
        panelSuperior.add(comboClientes);

        panelSuperior.add(new JLabel("Empleado:"));
        JComboBox<Empleado> comboEmpleados = new JComboBox<>(tienda.empleados.values().toArray(new Empleado[0]));
        panelSuperior.add(comboEmpleados);

        ventana.add(panelSuperior, BorderLayout.NORTH);

        JPanel panelProducto = new JPanel(new BorderLayout());
        panelProducto.setBorder(BorderFactory.createTitledBorder("Agregar Productos"));
        JPanel filasProducto = new JPanel(new GridLayout(2, 2,10,10));
        filasProducto.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel producto = new JLabel("Producto: ");
        producto.setHorizontalAlignment(SwingConstants.CENTER);
        filasProducto.add(producto);
        JComboBox<Producto> comboProductos = new JComboBox<>(tienda.inventario.toArray(new Producto[0]));
        filasProducto.add(comboProductos);

        JLabel cantidad = new JLabel("Cantidad: ");
        cantidad.setHorizontalAlignment(SwingConstants.CENTER);
        filasProducto.add(cantidad);
        JTextField campoCantidad = new JTextField();
        campoCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        filasProducto.add(campoCantidad);

        panelProducto.add(filasProducto, BorderLayout.NORTH);


        JTextArea areaDetalle = new JTextArea(9, 20);
        areaDetalle.setEditable(false);
        areaDetalle.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JScrollPane scrollDetalle = new JScrollPane(areaDetalle);
        scrollDetalle.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        panelProducto.add(scrollDetalle, BorderLayout.CENTER);


        JButton AgregarProducto = new JButton("Agregar Producto");
        JPanel paneBotonAgregar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        paneBotonAgregar.add(AgregarProducto);
        panelProducto.add(paneBotonAgregar, BorderLayout.SOUTH);

        ventana.add(panelProducto, BorderLayout.CENTER);


        JButton RegistrarVenta = new JButton("Registrar Venta");
        ventana.add(RegistrarVenta, BorderLayout.SOUTH);

        List<ItemVenta> productosAgregados = new ArrayList<>();
        double[] totalVenta = {0};

        AgregarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Producto productoSeleccionado = (Producto) comboProductos.getSelectedItem();
                String textoCantidad = campoCantidad.getText();

                if (productoSeleccionado == null || textoCantidad.isEmpty()) {
                    JOptionPane.showMessageDialog(ventana, "Seleccione un producto y cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int cantidad;
                try {
                    cantidad = Integer.parseInt(textoCantidad);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ventana, "Cantidad inválida.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (cantidad == 0 || cantidad > productoSeleccionado.getStock()) {
                    JOptionPane.showMessageDialog(ventana, "Cantidad no válida o excede el stock disponible.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //productoSeleccionado.reducirStock(cantidad);

                ItemVenta item = new ItemVenta(productoSeleccionado, cantidad);
                productosAgregados.add(item);
                totalVenta[0] += item.Subtotal();

                areaDetalle.append(item.toString() + "\n");
                campoCantidad.setText("");
            }
        });

        RegistrarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (productosAgregados.isEmpty()) {
                    JOptionPane.showMessageDialog(ventana, "Agrega al menos un producto.");
                    return;
                }

                Cliente cliente = (Cliente) comboClientes.getSelectedItem();
                Empleado empleado = (Empleado) comboEmpleados.getSelectedItem();
                String id = "V" + (tienda.ventas.size() + 1);
                Venta venta = new Venta(empleado, cliente, id);


                for (ItemVenta item : productosAgregados) {
                    venta.agregarProducto(item.getProducto(), item.getCantidad());
                }

                tienda.registrarVenta(venta);
                BaseDeDatos.guardar("C:\\Users\\pc\\IdeaProjects\\POO practica\\src\\BaseDeDatos\\Ventas.txt",venta.registro());
                guardarInventarioActualizado();


                ventana.dispose();


            }
        });

        ventana.setVisible(true);
    }


    public void mostrarClientes() {
        JFrame ventana= new JFrame("Clientes Registrados");
        ventana.setSize(300,300);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(this);

        JTextArea informacion= new JTextArea();
        informacion.setEditable(false);
        JScrollPane info= new JScrollPane(informacion);
        informacion.setText(tienda.mostrarClientes());
        ventana.add(info);


        ventana.setVisible(true);

    }


    public void mostrarEmpleados(){
        JFrame ventana= new JFrame("Empleados Registrados");
        ventana.setSize(310,300);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(this);

        JTextArea informacion= new JTextArea();
        informacion.setEditable(false);
        JScrollPane info= new JScrollPane(informacion);
        informacion.setText(tienda.mostrarEmpleados());
        ventana.add(info);


        ventana.setVisible(true);
    }


    public void mostrarProductos() {
        JFrame ventana= new JFrame("Inventario");
        ventana.setSize(300,300);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(this);

        JTextArea informacion= new JTextArea();
        informacion.setEditable(false);
        JScrollPane info= new JScrollPane(informacion);
        informacion.setText(tienda.mostrarProductos());
        ventana.add(info);

        ventana.setVisible(true);
    }


    public void mostrarVentas() {
        JFrame ventana= new JFrame("Ventas Registradas");
        ventana.setSize(300,300);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(this);

        JTextArea informacion= new JTextArea();
        informacion.setEditable(false);
        JScrollPane info= new JScrollPane(informacion);
        informacion.setText(tienda.mostrarVentas());
        ventana.add(info);

        ventana.setVisible(true);

    }

    private void cargarDatos() {

        List<String> clientes = BaseDeDatos.leer("C:\\Users\\pc\\IdeaProjects\\POO practica\\src\\BaseDeDatos\\Clientes.txt");
        for (String linea : clientes) {
            String[] partes = linea.split(",");
            if (partes.length == 3) {
                String nombre = partes[0].trim();
                int id = Integer.parseInt(partes[1].trim());
                String correo = partes[2].trim();
                tienda.crearCliente(nombre, id, correo);
            }
        }


        List<String> empleados = BaseDeDatos.leer("C:\\Users\\pc\\IdeaProjects\\POO practica\\src\\BaseDeDatos\\Empleados.txt");
        for (String linea : empleados) {
            String[] partes = linea.split(",");
            if (partes.length == 3) {
                String nombre = partes[0].trim();
                int id = Integer.parseInt(partes[1].trim());
                String puesto = partes[2].trim();
                tienda.crearEmpleado(nombre, id, puesto);
            }
        }


        List<String> productos = BaseDeDatos.leer("C:\\Users\\pc\\IdeaProjects\\POO practica\\src\\BaseDeDatos\\Producto.txt");
        for (String linea : productos) {
            String[] partes = linea.split(",");
            String nombre = partes[0].trim();
            double precio = Double.parseDouble(partes[1].trim());
            int stock = Integer.parseInt(partes[2].trim());


            if (partes.length == 4) {
                String tipo = partes[3].trim();
                tienda.agregarProducto(new Accesorio(nombre, precio, stock, tipo));
            } else if (partes.length == 5) {
                String extra1 = partes[3].trim();
                String extra2 = partes[4].trim();


                if (extra1.matches("[a-zA-Z]+") && extra2.matches("[a-zA-Z0-9 ]+")) {

                    tienda.agregarProducto(new Videojuego(nombre, precio, stock, extra1, extra2));
                } else {

                    tienda.agregarProducto(new Consola(nombre, precio, stock, extra1, extra2));
                }
            }
        }


    }

    private void guardarInventarioActualizado() {
        List<String> lineas = new ArrayList<>();
        for (Producto p : tienda.inventario) {
            lineas.add(p.registro());
        }

        BaseDeDatos.sobrescribir("C:\\Users\\pc\\IdeaProjects\\POO practica\\src\\BaseDeDatos\\Producto.txt", lineas);
    }





}
