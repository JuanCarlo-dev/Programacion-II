package Producto;

public class Consola extends Producto {
    private String fabricante;
    private String modelo;

    public Consola(String nombe,double precio,int stock, String fabricante, String modelo) {
        super(nombe,precio,stock);
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }



    @Override
    public String mostrarInfo() {
        return "\nNombre: "+ getNombre()+ "\nPrecio: "+ getPrecio()+ "\nStock: "+ getStock() + "\nFabricante: "+ fabricante + "\nModelo: "+ modelo;

    }

    public String registro() {
        return "Consola, "+getNombre()+", "+getPrecio()+", "+getStock()+", "+getFabricante()+", "+getModelo();
    }

}

