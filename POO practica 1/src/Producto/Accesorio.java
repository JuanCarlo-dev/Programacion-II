package Producto;

public class Accesorio extends Producto {
    private String tipo;

    public Accesorio(String nombre, double precio, int stock, String tipo) {
        super(nombre, precio, stock);
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }


    @Override
    public String mostrarInfo() {
        return "\nNombre: "+ getNombre()+ "\nPrecio: "+ getPrecio()+ "\nStock: "+ getStock() + "\nTipo: "+ tipo;
    }

    @Override
    public String registro() {
        return "Accesorio, "+getNombre()+", "+getPrecio()+", "+getStock()+", "+getTipo();
    }


}
