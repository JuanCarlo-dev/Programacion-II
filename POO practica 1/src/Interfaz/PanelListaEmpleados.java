package Interfaz;

import BaseDeDatos.BaseDeDatos;
import Tienda.Tienda;

import javax.swing.*;

public class PanelListaEmpleados extends JFrame {
    private Tienda tienda;
    private BaseDeDatos baseDeDatos;
    public PanelListaEmpleados(Tienda tienda) {
        this.tienda = tienda;
        this.baseDeDatos = new BaseDeDatos();

        setTitle("Lista de Empleados");
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea info = new JTextArea();
        info.setEditable(false);
        info.setText(baseDeDatos.mostrarEmpleados());
        JScrollPane scroll = new JScrollPane(info);

        add(scroll);
        setVisible(true);





    }
}
