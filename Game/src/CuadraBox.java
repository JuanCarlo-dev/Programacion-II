import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CuadraBox  extends JPanel implements ActionListener, KeyListener {
    int x=50, y=50;
    int vEnemigoX=3, vEnemigoY=3;
    int enemigox=200, enemigoy=200;
    boolean enemigoDos = false;
    int enemigo2x = 100, enemigo2y = 100;
    int e2vx = 3, e2vy = 3;
    boolean gameOver = false;


    Timer timer= new Timer(10,this);
    boolean colision= false;

    public CuadraBox() {
        timer.start();
        setFocusable(true);
        addKeyListener(this);

        new Timer(30000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enemigoDos= true;
                ((Timer)e.getSource()).stop();
            }
        }).start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(colision?Color.red:Color.BLUE);
        g.fillRect(x,y,50,50);
        g.setColor(Color.black);
        g.fillRect(enemigox,enemigoy,50,50);

        if (enemigoDos) {
            g.fillRect(enemigo2x, enemigo2y, 50, 50);
        }

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 60));
            g.drawString("GAME OVER", getWidth()/2 - 150, getHeight()/2);
        }

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        enemigox += vEnemigoX;
        enemigoy += vEnemigoY;

        int ancho = getWidth();
        int alto = getHeight();

        if (enemigox <= 0 || enemigox + 50 >= ancho) {
            vEnemigoX = -vEnemigoX;
        }

        if (enemigoy <= 0 || enemigoy + 50 >= alto) {
            vEnemigoY = -vEnemigoY;
        }

        if (enemigoDos) {
            enemigo2x += e2vx;
            enemigo2y += e2vy;

            if (enemigo2x <= 0 || enemigo2x + 50 >= ancho) e2vx = -e2vx;
            if (enemigo2y <= 0 || enemigo2y + 50 >= alto) e2vy = -e2vy;
        }
        //enemigox+=1;
        //enemigoy+=1;
        Rectangle jugador = new Rectangle(x,y,50,50);
        Rectangle enemigo = new Rectangle(enemigox,enemigoy,50,50);
        if (jugador.intersects(enemigo)) colision=true;
        if (enemigoDos) {
            Rectangle enemigo2 = new Rectangle(enemigo2x, enemigo2y, 50, 50);
            if (jugador.intersects(enemigo2)) {
                colision = true;
            }
        }

        if (colision) {
            gameOver = true;
            timer.stop();
        }
        //colision=jugador.intersects(enemigo);
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver) return;
        int codigoTeclado = e.getKeyCode();
        System.out.println(codigoTeclado);
        if (codigoTeclado == KeyEvent.VK_LEFT) x-=20;
        if (codigoTeclado == KeyEvent.VK_RIGHT) x+=20;
        if (codigoTeclado == KeyEvent.VK_DOWN) y+=20;
        if (codigoTeclado == KeyEvent.VK_UP) y-=20;

        x = Math.max(0, Math.min(x, getWidth() - 50));
        y = Math.max(0, Math.min(y, getHeight() - 50));

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        JPanel panel = new CuadraBox();
        ventana.add(panel);
        ventana.setSize(700,700);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
