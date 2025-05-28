package box;

import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrimosLeer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Path ruta = Path.of("primos.txt");
		
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
