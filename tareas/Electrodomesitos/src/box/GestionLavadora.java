package box;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionLavadora {
	
	/*protected void precioFinal(Lavadora lavadora) {
		if(lavadora != null) {
			lavadora.precioFinal();
			if(lavadora.carga >= 30) lavadora.precioBase += 50;
		}	
	}*/
	
	protected void mostrarLavadoras(ArrayList<Electrodomestico> arrayElectrodomesticos) {
		double sumaPrecioLavadoras = 0;
		for(Electrodomestico e : arrayElectrodomesticos) {
			if(e instanceof Lavadora) {
				System.out.println(e.toString()); 
				sumaPrecioLavadoras += e.getPrecio();
			}
		}
		System.out.println("\nEl precio de todas las lavadoras es de: "+sumaPrecioLavadoras+" €.\n");
	}
	
	protected void altaLavadora(ArrayList<Electrodomestico> arrayElectrodomesticos, Scanner sc) {
		
		// Lavadora nuevaLavadora;
		String marca = "", modelo = "", color = "", input = "";
		int unidades = 1, carga = 5;
		double precio = 100, peso = 5;
		char consumo = 'F';
		boolean datosCorrectos = false;
		
		while(!datosCorrectos) {
		
			System.out.println("\nIntroduce los valores de la/s nueva/s lavadora/s (deja en blanco los campos que desconozcas):");
			
			System.out.print("\nMarca: ");
			input = sc.nextLine();
			marca = input.isBlank() ? "Genérica" : input; // puedo también hacer esto desde el constructor
			
			System.out.print("Modelo: ");
			input = sc.nextLine();
			modelo = input.isBlank() ? "Estandar" : input; // puedo también hacer esto desde el constructor
			
			System.out.print("Color: ");
			input = sc.nextLine();
			color = input.isBlank() ? "blanco" : input; // el método comprobarColor en Electrodomésticos hará el resto en caso de que ponga uno diferente
			
			System.out.print("Consumo (A-F): ");
			while (true) {
			    input = sc.nextLine().trim();
			    if (input.isBlank()) {
			        consumo = 'F'; // Valor por defecto
			        break;
			    }
			    if (input.length() == 1 && "ABCDEFabcdef".contains(input)) { // Solo permite caracteres de A-F
			        consumo = Character.toUpperCase(input.charAt(0)); // Convierte a mayúscula
			        break;
			    }
			    System.out.print("Entrada inválida. Ingresa un consumo entre A-F: ");
			}	
			
			System.out.print("Peso (kg): ");
			while(true) {
				try {
					input = sc.nextLine().trim();
					peso = input.isBlank() ? 5.0 : Double.parseDouble(input.replace(',', '.'));
					break;			
				}catch(NumberFormatException e) {
					 System.out.print("Error. Ingresa un número válido o pulsa intro para dejar el valor por defecto: ");
				}
			}
			
			System.out.print("Precio base (€): ");
			while(true) {
				try {
					input = sc.nextLine();
					precio = input.isBlank() ? 100.0 : Double.parseDouble(input.replace(',', '.'));
					break;
				}catch(NumberFormatException e) {
					System.out.print("Error. Ingresa un número válido o pulsa intro para dejar el valor por defecto: ");
				}
			}
			
			System.out.print("Carga (kg): ");			
			while(true) {
				try {
					input = sc.nextLine();
					carga = input.isBlank() ? 5 : Integer.parseInt(input); 
					break;
				}catch(NumberFormatException e) {
					System.out.print("Error. Ingresa un número válido o pulsa intro para dejar el valor por defecto: ");
				}
			}
			
			System.out.print("Unidades: ");
			while(true) {
				try {
					input = sc.nextLine();
					unidades = input.isBlank() ? 1 : Integer.parseInt(input); 
					break;
				}catch(NumberFormatException e) {
					System.out.print("Error. Ingresa un número válido o pulsa intro para añadir solo una lavadora: ");
				}
			}
			
				System.out.println("\nResumen: ");
				System.out.println("\n | Marca: "+marca+" | Modelo: "+modelo+" | Color: "+color+" | Consumo: '"+consumo+"' "
									+ "| Peso: "+peso+" kg | Precio base: "+precio+" € | Carga: "+carga+" kg | Unidades: "+unidades+" |\n");
				System.out.println("1.- Campos correctos. Proceder con el alta.");
				System.out.println("2.- Volver a rellenar los campos.");
				System.out.println("3.- Salir.");
				System.out.print("\nSelecciona una opción: ");
			while(true) {
				input = sc.nextLine();
				if(input.equalsIgnoreCase("1")) {
					datosCorrectos = true;
					break;
				}else if(input.equalsIgnoreCase("2")) {
					System.out.println("\nVolvamos a intentarlo.");
					break; // como datosCorrectos sigue siendo false vuelve a pedir todos los datos.
				}else if(input.equalsIgnoreCase("3")) {
					System.out.print("\nAlta cancelada.");
					return; // salimos del método. Vuelta al menú principal.
				}else {
					System.out.print("\nError. Introduce 1, 2 o 3: ");
				}
			}
		}
		ArrayList<Lavadora> nuevasLavadoras = new ArrayList<>();
		
		for(int i = 0; i < unidades; i++) {
			Lavadora l = new Lavadora(marca, modelo, color, consumo, peso, precio, carga);
			nuevasLavadoras.add(l);
		}
		arrayElectrodomesticos.addAll(nuevasLavadoras);
		System.out.println("\nIntroducida/s:\n");
		for(Lavadora e : nuevasLavadoras) {
			System.out.println(e.toString());
		}
		System.out.println("\nProceso realizado con éxito.");
		
	}
	
	protected ArrayList<Electrodomestico> filtrarLavadoras(ArrayList<Electrodomestico> arrayElectrodomesticos, String entrada) {		
	    ArrayList<Electrodomestico> lavadorasFiltradas = new ArrayList<>(); 
	    try { // Primero intentamos convertir a int para buscar por ID 
	        int idOCarga = Integer.parseInt(entrada);
	        for (Electrodomestico t : arrayElectrodomesticos) { 
	        	if(t instanceof Lavadora) {
	        		if(t.getId() == idOCarga || ((Lavadora) t).getCarga() == idOCarga) {
	        			lavadorasFiltradas.add(t);  
	        		}
	        	}           
	        }
	    } catch (NumberFormatException e) {} // No es un número entero, seguimos probando...
	    entrada = entrada.replace(",", "."); // para poder filtrar por peso o precio
	    try { // Ahora intentamos convertir a double para buscar por precio o peso
	        double precioOPeso = Double.parseDouble(entrada);
	        for (Electrodomestico t : arrayElectrodomesticos) {
	        	if(t instanceof Lavadora) {
	        		if (t.getPrecio() == precioOPeso || t.getPeso() == precioOPeso) {
	        			lavadorasFiltradas.add(t);
	        		}
	        	}	            	            
	        }
	    } catch (NumberFormatException e) {} // No es un número decimal, seguimos probando...
	    if(entrada.length() == 1 && "ABCDEFabcdef".contains(entrada)) { // buscamos por consumo:
	    	char consumo = Character.toUpperCase(entrada.charAt(0));
	    	for(Electrodomestico e : arrayElectrodomesticos) {
	    		if(e instanceof Lavadora) {
	    			if(e.getConsumo() == consumo) {
	    				lavadorasFiltradas.add(e);
	    			}
	    		}  		
	    	}
	    }
	    for (Electrodomestico t : arrayElectrodomesticos) { // Finalmente, buscamos por Marca, modelo o color
	    	if(t instanceof Lavadora) {
	    		if (t.getMarca().equalsIgnoreCase(entrada) || t.getModelo().equalsIgnoreCase(entrada) || t.getColor().equalsIgnoreCase(entrada)) {
	    			lavadorasFiltradas.add(t);
	    		}
	    	}
	        
	    }
	    return lavadorasFiltradas; // Retornamos la lista con los resultados (vacía si no hay coincidencias)
	}
	
	protected Lavadora encontrarLavadora(ArrayList<Electrodomestico> array, String entrada, Scanner sc) {
		
	    ArrayList<Electrodomestico> lavadorasFiltradas = filtrarLavadoras(array, entrada);
	    
	    while (lavadorasFiltradas.size() > 1) {
	
	    	System.out.println("\nSe encontraron varias lavadoras:\n");
	    	for (Electrodomestico c : lavadorasFiltradas) {
	    		System.out.println(c.toString());
	    	}    
	             
	        System.out.print("\nIntroduce otro dato para filtrar la búsqueda (o escribe \"S\" para salir): ");
	        String nuevoFiltro = sc.nextLine();
	        if(nuevoFiltro.equalsIgnoreCase("s")) return null;
	        
	        lavadorasFiltradas = filtrarLavadoras(lavadorasFiltradas, nuevoFiltro);
	
	        if (lavadorasFiltradas.isEmpty()) {
	            System.out.println("\nEl filtro no ha refinado la lista..");
	            return null;
	        } 
	    }	    
	    if(lavadorasFiltradas.isEmpty()) {
	    	System.out.println("\nAún no hay tablets o no hay ninguna con estos filtro.");
	    	return null;
	    }
	    return (Lavadora) lavadorasFiltradas.get(0); // Devuelve el cliente único encontrado
	}
	
	protected void eliminarLavadora(ArrayList<Electrodomestico> arrayElectrodomesticos, Scanner sc) {
	    
	    ArrayList<Electrodomestico> lavadorasAEliminar = new ArrayList<>();

	    // Buscar tablets para eliminar
	    System.out.print("\nIntroduce el dato con el que realizar la búsqueda de las lavadoras que van a ser eliminadas: ");
	    lavadorasAEliminar = filtrarLavadoras(arrayElectrodomesticos, sc.nextLine()); // no usamos encontrarTablet porque quizá quiere eliminar varias

	    System.out.println(); // Salto de línea

	    // Si no hay resultados, salir
	    if (lavadorasAEliminar.isEmpty()) {
	        System.out.println("❌ No se encontraron lavadoras con ese criterio.");
	        return;
	    }
	    // Mostrar tablets encontradas
	    for (Electrodomestico t : lavadorasAEliminar) {
	        System.out.println(t.toString());
	    }
	    // Si solo hay 1 tablet encontrada, saltamos el filtrado adicional
	    if (lavadorasAEliminar.size() == 1) {
	        System.out.print("\n¿Es correcta la lavadora a eliminar? ( S / N ): ");
	        if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\n🚫 Abortamos proceso de borrado.");
	            return;
	        }
	    } else {
	        // Si hay más de 1 tablet, preguntar si se quiere seguir filtrando
	        String entrada = "S";
	        while (entrada.equalsIgnoreCase("S") && lavadorasAEliminar.size()>1) {
	            System.out.print("\n¿Quieres seguir filtrando? ( S / N ): ");
	            entrada = sc.nextLine();
	            if (entrada.equalsIgnoreCase("S")) {
	                System.out.print("\nIntroduce el nuevo filtro: ");
	                lavadorasAEliminar = filtrarLavadoras(lavadorasAEliminar, sc.nextLine());
	                // Si después del filtrado no hay coincidencias, salir
	                if (lavadorasAEliminar.isEmpty()) {
	                    System.out.println("\n❌ No se encontraron lavadoras con este filtro.");
	                    return;
	                }
	                // Mostrar tablets después del filtrado
	                System.out.println("\n📌 Lavadoras encontradas tras el filtro:");
	                for (Electrodomestico t : lavadorasAEliminar) {
	                    System.out.println(t.toString());
	                }
	            } else if (!entrada.equalsIgnoreCase("N")) {
	                System.out.println("\n⚠ Opción incorrecta, intenta de nuevo.\n");
	                entrada = "S"; // Mantener en el bucle si la opción es incorrecta
	            }
	        }
	        // Confirmar eliminación después del filtrado
	        System.out.print("\n¿Son correctas las tablets a eliminar? ( S / N ): ");
	        if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\n🚫 Abortamos proceso de borrado.");
	            return;
	        }
	    }

	    arrayElectrodomesticos.removeAll(lavadorasAEliminar);
	    // verificamos si la tablet está en arrayReservas y la eliminar de ahí también llegado el caso
	    /*for(Reserva r : arrayReservas) {
	    	for (Tablet t : tabletsAEliminar) {
	    		if(t.equals(r.tablet)) arrayReservas.remove(r); // eliminamos la posible reserva que pueda tener	    		
		        arrayTablets.remove(t); // luego eliminar la tablet de arrayTablets
		    }	    	
	    }*/
	    System.out.println("\nBorrado realizado con éxito.");
	}

}
