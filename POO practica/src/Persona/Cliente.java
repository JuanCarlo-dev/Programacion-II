package Persona;

public class Cliente extends Persona {
    private String correo;

    public Cliente( String nombre, int ID, String correo) {
        super(nombre,ID);
        this.correo = correo;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public  String mostrarInfo() {
        return "\nNombre: "+ getNombre()+ "\nID: "+ getID()+ "\nCorreo: "+ correo;

    }

    public String registro() {
        return getNombre() + "," +getID() + "," +getCorreo();
    }


    public String toString(){
        return getNombre();
    }


}
