import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 500);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);

        ImageIcon imagen = new ImageIcon(Main.class.getResource("/img/Disparo.png"));
        JLabel imagenLabel = new JLabel(imagen);
        imagenLabel.setBounds(0, 0, imagen.getIconWidth(), imagen.getIconHeight());

        ventana.add(imagenLabel);
        ventana.setVisible(true);

    }
}