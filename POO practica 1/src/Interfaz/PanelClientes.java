package Interfaz;


import Persona.Cliente;
import Tienda.Tienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelClientes extends JFrame {
    private Tienda tienda;

    public PanelClientes(Tienda tienda) {
        this.tienda = tienda;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(250, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2));
        String[] etiquetas={"Nombre: ","ID: ", "Correo: "};
        JTextField[] campos=new JTextField[etiquetas.length];
        for (int i = 0; i < etiquetas.length; i++) {
            JLabel etiqueta = new JLabel(etiquetas[i]);
            etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(etiqueta);
            campos[i] = new JTextField(10);
            panel.add(campos[i]);
        }

        add(panel, BorderLayout.CENTER);

        JButton agregar= new JButton("AGREGAR");
        agregar.setFocusPainted(false);
        add(agregar, BorderLayout.SOUTH);

        agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < campos.length; i++) {
                    if (campos[i].getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
                        return;
                    }

                }


                int id;

                try {
                    id = Integer.parseInt(campos[1].getText());
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,"Por favor ingrese solo numeros en el campo id");
                    return;
                }

                Cliente c=tienda.crearCliente(campos[0].getText(),id,campos[2].getText());
                dispose();

            }
        });


        setVisible(true);

    }

}

