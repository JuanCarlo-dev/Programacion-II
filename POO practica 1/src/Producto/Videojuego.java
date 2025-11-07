package Producto;

public class Videojuego extends Producto {
    private String genero;
    private String plataforma;

    public Videojuego(String nombre, double precio, int stock, String genero, String plataforma) {
        super(nombre, precio, stock);
        this.genero = genero;
        this.plataforma = plataforma;
    }
    public String getGenero() {
        return genero;
    }
    public String getPlataforma() {
        return plataforma;
    }

    @Override
    public String mostrarInfo() {
        return "\nNombre: "+ getNombre()+ "\nPrecio: "+ getPrecio()+ "\nStock: "+ getStock()+"\nGenero: "+ genero+ "\nPlataforma: "+ plataforma;
    }

    public String registro() {
        return "Videojuego, "+getNombre()+", "+getPrecio()+", "+getStock()+", "+getGenero()+", "+getPlataforma();
    }


}
