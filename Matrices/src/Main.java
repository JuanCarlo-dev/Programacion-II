public class Main {
    public static void main(String[] args) {
        int[][] datosA={
                {1,2,3},
                {4,5,6}
        };

        int[][] datosB={
                {1,9,3},
                {0,5,3}
        };

        int[][] datos1={
                {1,9,3},
                {0,5,3},
                {1,2,3}
        };


        Matriz A = new Matriz(datosA);
        Matriz B = new Matriz(datosB);
        Matriz One = new Matriz(datos1);

        System.out.println("Matriz A:");
        A.mostrarMatriz();
        System.out.println(A.comprobarMismoTamaño(B));
        System.out.println("");


        System.out.println("Matriz B:");
        B.mostrarMatriz();
        System.out.println( B.comprobarMismoTamaño(A));
        System.out.println("");



        Matriz c= A.suma(B);
        System.out.println("Matriz C:");
        c.mostrarMatriz();
        System.out.println();

        Matriz d= A.resta(B);
        System.out.println("Matriz D:");
        d.mostrarMatriz();
        System.out.println("");

        Matriz e= A.multiplicacion(One);
        System.out.println("Matriz E:");
        e.mostrarMatriz();
        System.out.println("");

        Matriz f= A.tranpuesta();
        System.out.println("Matriz F:");
        f.mostrarMatriz();
        System.out.println("");


    }
}