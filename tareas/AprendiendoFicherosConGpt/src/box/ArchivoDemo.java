package box;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ArchivoDemo {

    public static void main(String[] args) {
        // Paso 1: Definir la ruta con Paths
        Path ruta = Path.of("tareas", "AprendiendoFicherosConGpt", "demo.txt"); // Path = Paths.get("");

        // Paso 2: Escribir en el archivo con BufferedWriter
        try (BufferedWriter writer = Files.newBufferedWriter(ruta, StandardOpenOption.APPEND,
                StandardOpenOption.CREATE)) {
            writer.write("Hola mundo");
            writer.newLine();
            writer.write("Esto es una prueba con BufferedWriter");
            writer.newLine();
            writer.write("¡Funciona!");
            System.out.println("Archivo creado y texto escrito con éxito.");
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }

        // Paso 3: Leer el archivo con BufferedReader
        System.out.println("\nContenido del archivo:");
        try (BufferedReader reader = Files.newBufferedReader(ruta)) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
    }
}
