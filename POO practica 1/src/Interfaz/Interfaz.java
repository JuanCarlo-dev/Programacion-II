package Interfaz;

import Tienda.Tienda;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {
    private Tienda tienda;

    public Interfaz(Tienda tienda) {
        this.tienda = tienda;

        setTitle("La Mejor Tienda Gamer");
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel(tienda.getNombre());
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        add(titulo, BorderLayout.NORTH);


        JPanel panel = new JPanel(new GridLayout(8, 1));
        String[] etiquetas={"CREAR CLIENTE","CREAR EMPLEADO","AGREGAR PRODUCTO","REGISTRAR VENTA","MOSTRAR CLIENTES", "MOSTRAR EMPLEADOS","MOSTRAR PRODUCTOS","MOSTRAR VENTAS"};
        for (int i = 0; i < etiquetas.length; i++) {
            JButton boton = new JButton(etiquetas[i]);
            boton.setBackground(Color.DARK_GRAY);
            boton.setForeground(Color.WHITE);
            boton.setFocusPainted(false);

            String opcion = etiquetas[i];

            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    switch (opcion) {
                        case "CREAR CLIENTE":
                            new PanelClientes(tienda);
                            break;
                        case "CREAR EMPLEADO":
                            new PanelEmpleados(tienda);
                            break;
                        case "AGREGAR PRODUCTO":
                            new PanelProductos(tienda);
                            break;
                        case "REGISTRAR VENTA":
                            new PanelVentas(tienda);
                            break;
                        case "MOSTRAR CLIENTES":
                            new PanelListaClientes(tienda);
                            break;
                        case "MOSTRAR EMPLEADOS":
                            new PanelListaEmpleados(tienda);
                            break;
                        case "MOSTRAR PRODUCTOS":
                            new PanelInventario(tienda);
                            break;
                        case "MOSTRAR VENTAS":
                            new PanelVentaRegistradas();
                            break;
                    }

                }
            });

            panel.add(boton);
        }

        add(panel, BorderLayout.CENTER);

        setVisible(true);

    }
}