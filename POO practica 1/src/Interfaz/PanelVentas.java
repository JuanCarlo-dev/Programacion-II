package Interfaz;

import BaseDeDatos.BaseDeDatos;
import Persona.*;
import Producto.Producto;
import Tienda.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelVentas extends JFrame {
    private Tienda tienda;
    private BaseDeDatos baseDeDatos;

    public PanelVentas(Tienda tienda) {
        this.tienda = tienda;
        this.baseDeDatos = new BaseDeDatos();

        setTitle("Venta");
        setSize(300,450);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(this);
        setLayout(new BorderLayout());

        JPanel norte = new JPanel();
        norte.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        norte.setLayout(new GridLayout(0,2,5,5));

        norte.add(new JLabel("Cliente: "));
        baseDeDatos.cargarClientes();
        JComboBox<String> cliente = new JComboBox();
        for (Cliente c : baseDeDatos.cargarClientes()) {
            cliente.addItem(c.getNombre());
        }
        norte.add(cliente);

        norte.add(new JLabel("Empleado: "));
        baseDeDatos.cargarEmpleados();
        JComboBox<String> empleado = new JComboBox();
        for (Empleado e : baseDeDatos.cargarEmpleados()) {
            empleado.addItem(e.getNombre());
        }
        norte.add(empleado);

        norte.add(new JLabel("Producto: "));
        baseDeDatos.cargarProductos();
        JComboBox<Producto> producto = new JComboBox<>(baseDeDatos.cargarProductos().toArray(new Producto[0]));
        /*ComboBox<String> producto = new JComboBox();
        for (Producto p : baseDeDatos.cargarProductos()) {
            producto.addItem(p.getNombre());
        }*/
        norte.add(producto);

        norte.add(new JLabel("Cantidad: "));
        JTextField cantidad = new JTextField();
        norte.add(cantidad);

        JButton agregar = new JButton("Agregar");
        norte.add(agregar);

        add(norte, BorderLayout.NORTH);

        JPanel south = new JPanel();
        south.setLayout(new BorderLayout());
        JTextArea areaDetalles = new JTextArea();
        areaDetalles.setEditable(false);
        JScrollPane scrollPaneDetalles = new JScrollPane(areaDetalles);
        scrollPaneDetalles.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        south.add(scrollPaneDetalles, BorderLayout.CENTER);
        south.setBorder(BorderFactory.createTitledBorder("Productos"));

        JButton registrar = new JButton("Registrar");
        south.add(registrar, BorderLayout.SOUTH);

        add(south, BorderLayout.CENTER);

        List<ItemVenta> productosAgregados = new ArrayList<>();
        double[] totalVenta = {0};

        agregar.addActionListener(e -> {
            Producto productoSeleccionado = (Producto) producto.getSelectedItem();
            String textoCantidad = cantidad.getText();

            if (productoSeleccionado == null && textoCantidad.isEmpty()) {
                JOptionPane.showMessageDialog( null,"Seleccione un producto y cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int cantidades;
            try {
                cantidades = Integer.parseInt(textoCantidad);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Cantidad inválida.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cantidades == 0 || cantidades > productoSeleccionado.getStock()) {
                JOptionPane.showMessageDialog(null, "Cantidad no válida o excede el stock disponible.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }


            ItemVenta item = new ItemVenta(productoSeleccionado, cantidades);
            productosAgregados.add(item);
            totalVenta[0] += item.Subtotal();

            areaDetalles.append(item.toString() + "\n");
            cantidad.setText("");
        });

        registrar.addActionListener(e -> {

        });



        setVisible(true);

    }




}


