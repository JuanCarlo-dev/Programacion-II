package Interfaz;

import BaseDeDatos.BaseDeDatos;
import Tienda.Tienda;

import javax.swing.*;

public class PanelListaClientes extends JFrame {
    private Tienda tienda;
    private BaseDeDatos baseDeDatos;
 public PanelListaClientes(Tienda tienda) {
     this.tienda = tienda;
     this.baseDeDatos = new BaseDeDatos();

     setTitle("Lista de Clientes");
     setSize(300,300);
     setLocationRelativeTo(null);
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

     JTextArea info = new JTextArea();
     info.setEditable(false);
     info.setText(baseDeDatos.mostrarClientes());
     JScrollPane scroll = new JScrollPane(info);

     add(scroll);
     setVisible(true);


 }
}
