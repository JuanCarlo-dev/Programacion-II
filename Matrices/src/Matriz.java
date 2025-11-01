public class Matriz {
    private int[][] datos;
    private int filas;
    private int columnas;

    public Matriz(int filas, int columnas) {
        if (filas<=0 || columnas<=0) {
            throw new IllegalArgumentException("Filas y columnas deben ser >0");
        }
        this.filas = filas;
        this.columnas = columnas;
        this.datos = new int[filas][columnas];
    }

    public Matriz(int[][] datos) {
        if (datos==null) {
            throw new IllegalArgumentException("Datos deben ser >=0");
        }
        this.filas = datos.length;
        this.columnas = (filas==0)?0 : datos[0].length;
        this.datos = new int[filas][columnas];
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                this.datos[f][c] = datos[f][c];
            }
        }
    }

    public  void mostrarMatriz() {
        System.out.println("--------------");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(datos[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("--------------");
    }

    public boolean comprobarMismoTamaño(Matriz matriz) {
        if (this.filas!=matriz.filas ||this.columnas!=matriz.columnas){
            System.out.println("Las matrices no son del mismo tamaño");
            return false;
        }
        return true;
    }

    public Matriz suma(Matriz matriz) {
        if(comprobarMismoTamaño(matriz)){
            Matriz resultado= new Matriz(filas, columnas);
            for (int f = 0; f < filas; f++) {
                for (int c = 0; c < columnas; c++) {
                    resultado.datos[f][c]=this.datos[f][c] + matriz.datos[f][c];

                }
            }
            return resultado;
        }
        return null;

    }

    public boolean comprobarSiSePuedeMultiplicar(Matriz matriz) {
        if(this.columnas!= matriz.filas){
            System.out.println("El numero de columnas de la matriz1 no es igual al numero de filas de la matriz2");
            return false;
        }
        return true;
    }

    public Matriz resta(Matriz matriz) {
        if(comprobarMismoTamaño(matriz)){
            Matriz resultado= new Matriz(filas, columnas);
            for (int f = 0; f < filas; f++) {
                for (int c = 0; c < columnas; c++) {
                    resultado.datos[f][c]=this.datos[f][c] - matriz.datos[f][c];

                }
            }
            return resultado;
        }
        return null;

    }

    public void setValor(int i, int j, int valor) {
        datos[i][j] = valor;
    }

    public Matriz multiplicacion(Matriz matriz) {
        if(comprobarSiSePuedeMultiplicar(matriz)){
            Matriz resultado= new Matriz(this.filas,matriz.columnas);
            for (int f = 0; f < filas; f++) {
                for (int c = 0; c < columnas; c++) {
                    int suma= 0;
                    for (int k = 0; k < this.columnas; k++) {
                        suma += this.datos[f][k] * matriz.datos[k][c];
                    }
                    resultado.setValor(f, c, suma);
                }
            }
            return resultado;
        }
        return null;

    }

    public Matriz tranpuesta() {
        Matriz tranpuesta= new Matriz(columnas,filas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tranpuesta.setValor(j, i, datos[i][j]);
            }
        }
        return tranpuesta;


    }
}
