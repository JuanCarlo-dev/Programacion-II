package Entidades;

import RecursosAlgebra.Vector;

import java.awt.*;

public class Bala extends EntidadEspacial {
    private int vida= 90;
    public Bala(Vector pos, Vector vel, int radio){
        super(pos, vel, 0, radio);
    }
    @Override public void actualizar(double dt){
        posicion = posicion.sumar(velocidad.escalar(dt));
        vida--;
    }
    public boolean estaMuerta(){ return vida <= 0; }
    @Override public void dibujar(Graphics2D g){ /* dibujar imagen o fillOval */ }
}
