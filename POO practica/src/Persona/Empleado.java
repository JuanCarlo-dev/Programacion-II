package Persona;

public class Empleado extends Persona{
    private String puesto;

    public  Empleado(String nombre, int ID, String puesto) {
        super(nombre, ID);
        this.puesto = puesto;

    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String mostrarInfo() {
        return "\nNombre: "+ getNombre() + "\nID: "+ getID() + "\nPuesto: "+ puesto;

    }

    public String registro() {
        return getNombre() + "," +getID() + "," +getPuesto();
    }

    public String toString(){
        return getNombre();
    }
}
