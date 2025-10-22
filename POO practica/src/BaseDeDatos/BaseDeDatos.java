package BaseDeDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    public static void guardar(String archivo, String datos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(datos);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en archivo: " + archivo);
            e.printStackTrace();
        }
    }

    public static List<String> leer(String ruta) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }

    public static void sobrescribir(String ruta, List<String> lineas) {
        try (PrintWriter writer = new PrintWriter(ruta)) {
            for (String linea : lineas) {
                writer.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al sobrescribir archivo: " + e.getMessage());
        }
    }


}
