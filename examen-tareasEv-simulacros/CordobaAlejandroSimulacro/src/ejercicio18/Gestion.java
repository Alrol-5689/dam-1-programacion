package ejercicio18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;


public class Gestion {
	
	private Lectura l = new Lectura();
	private int opcion= 0;
	private Scanner sc = new Scanner(System.in);
	private Path rutaPalabras = Path.of("palabras.txt");	
	
	protected void star() {
		
		do {
			
			opcion = l.pedirOpcion(sc, 1, 3, "\ndescripción:\n" + """
					1.- Añadir palabra.
					2.- Mostrar palabras.
					3.- Salir.
					\nSelecciona una opcion: """ + " ");
			
			switch (opcion) {
				case 1:
					
					System.out.println("Escribe la palabra que quieres registrar: ");
					String palabra = sc.nextLine();
					
					try (BufferedWriter writer = Files.newBufferedWriter(
							rutaPalabras, 
							StandardOpenOption.CREATE,
							StandardOpenOption.APPEND
						)) {
				            writer.write(palabra);
				            writer.newLine();		        
				    } catch (IOException e) {
				        System.out.println("Error al guardar las cuentas: " + e.getMessage());
				    }
					break;
				case 2:
					try (BufferedReader reader = Files.newBufferedReader(rutaPalabras)) {
				        String linea;
				        while ((linea = reader.readLine()) != null) {
				        	System.out.println(linea);
				        }
				    } catch (IOException e) {
				        System.out.println("Error al cargar las cuentas: " + e.getMessage());
				    }
					break;
				case 3: System.out.println("Hasta la próxima!");
					break;
				default:
			}



			
		}while(opcion != 3);
		
	}


}

