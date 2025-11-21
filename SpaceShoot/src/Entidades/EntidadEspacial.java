package Entidades;

import RecursosAlgebra.Vector;

import java.awt.*;

public abstract class EntidadEspacial {
    protected Vector posicion, velocidad;
    protected double rotacion;
    protected int radio;

    public EntidadEspacial(Vector pos, Vector vel, double rot, int radio){
        this.posicion = pos;
        this.velocidad = vel;
        this.rotacion = rot;
        this.radio = radio;
    }

    public abstract void actualizar(double dt);
    public abstract void dibujar(Graphics2D g);
    public boolean colisionaCon(EntidadEspacial otro){
        return this.posicion.restar(otro.posicion).magnitud() < (this.radio + otro.radio);
    }
}
