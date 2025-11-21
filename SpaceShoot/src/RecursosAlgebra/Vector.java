package RecursosAlgebra;

public class Vector {
    public double x, y;
    public Vector(double x, double y){ this.x = x; this.y = y; }
    public Vector sumar(Vector v){
        return new Vector(x+v.x, y+v.y);
    }

    public Vector restar(Vector v){
        return new Vector(x-v.x, y-v.y);
    }

    public Vector escalar(double k){
        return new Vector(x*k, y*k);
    }

    public double magnitud(){
        return Math.sqrt(x*x + y*y);
    }

    public Vector rotar(double ang) {
        double c=Math.cos(ang), s=Math.sin(ang);
        return new Vector(x*c - y*s, x*s + y*c);
    }

    public Vector normalizar(){
        double m = magnitud(); return m==0? new Vector(0,0): new Vector(x/m,y/m);
    }

    public Vector copiar() {
        return new Vector(this.x, this.y);
    }


}
