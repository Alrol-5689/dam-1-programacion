package box;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PrimosEscribir {

	public static void main(String[] args) {
		
		PrimosEscribir pe = new PrimosEscribir();
		List<String> primos = new ArrayList<>();		
		Path ruta = Path.of("primos.txt");
		
		for (int i = 2; i <= 500; i++) {
            if (pe.esPrimo(i)) {
                primos.add(String.valueOf(i));
            }
        }
		
		try {
            Files.write(ruta, primos);
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
