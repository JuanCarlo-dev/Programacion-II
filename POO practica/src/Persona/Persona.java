package Persona;

public abstract class Persona {
    private String nombre;
    private int ID;

    public Persona(String nombre, int ID) {
        this.nombre = nombre;
        this.ID = ID;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public abstract String mostrarInfo();

}
