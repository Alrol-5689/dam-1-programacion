package box;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrimosEscribir2 {

	public static void main(String[] args) {
		
		PrimosEscribir pe = new PrimosEscribir();		
		Path ruta = Path.of("primos.txt");
		
		try(BufferedWriter writer = Files.newBufferedWriter(ruta)) {
			for (int i = 2; i <= 500; i++) {
	            if (pe.esPrimo(i)) {
	            	writer.write(String.valueOf(i));
	                writer.newLine();
	            }
	        }
            System.out.println("Archivo primos.txt creado con los números primos entre 1 y 500.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }

	}
	
	public boolean esPrimo(int numero) {
		if(numero < 2) {
			return false;
		}
		for(int i = 2; i < numero; i++) {
			if(numero % i == 0) {
				return false;
			}
		}
		return true;
	}

}
