package Interfaz;

import BaseDeDatos.BaseDeDatos;
import Producto.*;
import Tienda.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelProductos extends JFrame {
    private Tienda tienda;
    private BaseDeDatos baseDeDatos;
    private JTextField[] campos;
    private JTextField campo1;
    private JTextField[] camposCo;
    private JTextField[] campoExtra;

    public PanelProductos(Tienda tienda) {
        this.tienda = tienda;
        this.baseDeDatos = new BaseDeDatos();

        setSize(300,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        setVisible(true);

        JPanel tipos=new JPanel();
        tipos.setLayout(new GridLayout(1,2));
        JLabel tipo = new JLabel("Tipo: ");
        tipo.setHorizontalAlignment(SwingConstants.CENTER);
        tipos.add(tipo);
        String[] opciones={"Accesorio","Consola","Videojuego"};
        JComboBox<String> tipoCombo = new JComboBox<>(opciones);
        tipos.add(tipoCombo);
        add(tipos,BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2,5,5));
        panel.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));

        agregarCamposBase(panel);

        add(panel, BorderLayout.CENTER);


        JButton agregar = new JButton("Agregar");
        add(agregar, BorderLayout.SOUTH);

        tipoCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();

                agregarCamposBase(panel);

                switch(tipoCombo.getSelectedIndex()){
                    case 0:
                        JLabel opcionAcc = new JLabel("Tipo: ");
                        opcionAcc.setHorizontalAlignment(SwingConstants.CENTER);
                        panel.add(opcionAcc);
                        campo1 = new JTextField();
                        panel.add(campo1);
                        break;
                    case 1:
                        String[] extras = {"Fabricante: ","Modelo: "};
                        camposCo = new JTextField[extras.length];
                        for (int i = 0; i < extras.length; i++) {
                            JLabel opcionCon = new JLabel(extras[i]);
                            opcionCon.setHorizontalAlignment(SwingConstants.CENTER);
                            panel.add(opcionCon);
                            camposCo[i]= new JTextField();
                            panel.add(camposCo[i]);
                        }
                        break;
                    case 2:
                        String[] extrasVid = {"Genero: ","Plataforma: "};
                        campoExtra = new JTextField[extrasVid.length];
                        for (int i = 0; i < extrasVid.length; i++) {
                            JLabel opcionVid = new JLabel(extrasVid[i]);
                            opcionVid.setHorizontalAlignment(SwingConstants.CENTER);
                            panel.add(opcionVid);
                            campoExtra[i]= new JTextField();
                            panel.add(campoExtra[i]);
                        }
                        break;
                }
                panel.revalidate();
                panel.repaint();
            }
        });
        tipoCombo.setSelectedIndex(0);

        agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    int opcion = tipoCombo.getSelectedIndex();
                    String nombre = campos[0].getText();
                    double precio = Double.parseDouble(campos[1].getText());
                    int stock = Integer.parseInt(campos[2].getText());

                    Producto p = null;

                    switch (opcion) {
                        case 0:
                            String tipo = campo1.getText();
                            p = new Accesorio(nombre, precio, stock, tipo);
                            break;
                        case 1:
                            String fabr = camposCo[0].getText();
                            String modelo = camposCo[1].getText();
                            p = new Consola(nombre, precio, stock, fabr, modelo);
                            break;
                        case 2:
                            String genero = campoExtra[0].getText();
                            String plataforma = campoExtra[1].getText();
                            p = new Videojuego(nombre, precio, stock, genero, plataforma);
                            break;

                    }
                    tienda.agregarProducto(p);
                    baseDeDatos.guardarProducto(p);
                    dispose();

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al agregar producto revisa que todos los campos " +
                            "\nesten llenos y q reciban los tipo de datos requeridos ");
                }
            }
        });




    }

    private void agregarCamposBase(JPanel panel) {
        String[] etiquetas = {"Nombre: ", "Precio: ", "Stock: "};
        campos= new JTextField[etiquetas.length];
        for (int i = 0; i < etiquetas.length; i++) {
            JLabel label = new JLabel(etiquetas[i]);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(label);
            campos[i] = new JTextField();
            panel.add(campos[i]);
        }
    }
}
