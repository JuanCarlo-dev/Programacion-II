package Entidades;

import RecursosAlgebra.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Asteroide extends EntidadEspacial {
    private int tamano;
    private double velRot;

    public Asteroide(Vector pos, Vector vel, int tamano){
        super(pos, vel, 0, tamano==3?40: tamano==2?28:16);
        this.tamano = tamano;
        this.velRot = (Math.random()-0.5)*1.0;
    }
    @Override public void actualizar(double dt){
        posicion = posicion.sumar(velocidad.escalar(dt));
        rotacion += velRot * dt;
    }
    public List<Asteroide> dividir(){
        List<Asteroide> res = new ArrayList<>();
        if (tamano > 1) {
            for (int i=0;i<2;i++){
                Vector nuevaVel = velocidad.rotar((i==0?0.4:-0.4));
                Asteroide a = new Asteroide(posicion.copiar(), nuevaVel, tamano-1);
                res.add(a);
            }
        }
        return res;
    }
    @Override public void dibujar(Graphics2D g){ /* dibujar imagen rotada */ }
}
