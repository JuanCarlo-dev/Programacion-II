import Interfaz.Interfaz;
import Tienda.Tienda;


public class Main {
    public static void main(String[] args) {
        Tienda tienda= new Tienda("Tienda \"Don Inturias\"");
        new Interfaz(tienda);


    }
}