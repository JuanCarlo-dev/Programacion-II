package Entidades;

import RecursosAlgebra.Vector;

import java.awt.*;
import java.awt.image.BufferedImage;
public class Nave extends EntidadEspacial{
    private double aceleracion=200; // px/s^2
    private double velRotacion = Math.toRadians(180); // deg/s -> rad/s
    private double velocidadMax = 300; // px/s
    private Image img;
    private long ultimoDisparo = 0;

    public Nave(Vector pos, BufferedImage img){
        super(pos, new Vector(0,0), 0, 20);
        this.img = img;
    }


    public void girar(double direccion, double dt){
        rotacion += direccion * velRotacion * dt;
    }

    public void acelerar(double dt){
        Vector dir = new Vector(0, -1).rotar(rotacion);
        velocidad = velocidad.sumar(dir.escalar(aceleracion * dt));
        if (velocidad.magnitud() > velocidadMax) velocidad = velocidad.normalizar().escalar(velocidadMax);
    }


    public Bala disparar(){
        Vector dir = new Vector(0,-1).rotar(rotacion).normalizar();
        Vector velBala = dir.escalar(500).sumar(this.velocidad);
        Vector posBala = posicion.sumar(dir.escalar(this.radio + 8));
        return new Bala(posBala, velBala, 6);
    }
    @Override public void actualizar(double dt){ posicion = posicion.sumar(velocidad.escalar(dt)); }
    @Override public void dibujar(Graphics2D g){ /* centrar y rotar imagen */ }
}
