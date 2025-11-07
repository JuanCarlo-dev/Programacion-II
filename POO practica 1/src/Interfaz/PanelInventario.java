package Interfaz;

import BaseDeDatos.BaseDeDatos;
import Tienda.Tienda;

import javax.swing.*;

public class PanelInventario extends JFrame {
    private Tienda tienda;
    private BaseDeDatos baseDeDatos;
    public PanelInventario(Tienda tienda) {
        this.tienda = tienda;
        this.baseDeDatos = new BaseDeDatos();

        setTitle("Inventario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350, 350);
        setLocationRelativeTo(null);

        JTextArea info = new JTextArea();
        info.setEditable(false);
        info.setText(baseDeDatos.mostrarProductos());
        JScrollPane scroll = new JScrollPane(info);

        add(scroll);
        setVisible(true);

    }
}
