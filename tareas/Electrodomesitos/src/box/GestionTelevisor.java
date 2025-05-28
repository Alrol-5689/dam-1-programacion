package box;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionTelevisor {
	
	/*protected void precioFinal(Televisor televisor){
		if(televisor != null) {
			televisor.precioFinal();
			if(televisor.resolucion > 40) televisor.precioBase += televisor.precioBase*0.3;
			if(televisor.tdt) televisor.precioBase += 50;
		}	
	}*/
	
	protected void mostrarTelevisores(ArrayList<Electrodomestico> arrayElectrodomesticos) {
		double sumaPrecioTelevisores = 0;
		for(Electrodomestico e : arrayElectrodomesticos) {
			if(e instanceof Televisor) {
				System.out.println(e.toString()); 
				sumaPrecioTelevisores += e.getPrecio();
			}
		}
		System.out.println("\nEl precio de todos los televisores es de: "+sumaPrecioTelevisores+" €.\n");
	}
	
	protected void altaTelevisor(ArrayList<Electrodomestico> arrayElectrodomesticos, Scanner sc) {
		
		// Lavadora nuevaLavadora;
		String marca = "", modelo = "", color = "", input = "";
		int unidades = 1;
		double precio = 100, peso = 5, resolucion = 20;
		char consumo = 'F';
		boolean datosCorrectos = false, tdt = false;
		
		while(!datosCorrectos) {
		
			System.out.println("\nIntroduce los valores de el/los nuevo/s televisor/es (deja en blanco los campos que desconozcas):");
			
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
			
			System.out.print("Resolución (pulgadas): ");			
			while(true) {
				try {
					input = sc.nextLine();
					resolucion = input.isBlank() ? 20 : Double.parseDouble(input.replace(',', '.')); 
					break;
				}catch(NumberFormatException e) {
					System.out.print("Error. Ingresa un número válido o pulsa intro para dejar el valor por defecto: ");
				}
			}
			
			System.out.print("¿Dispone de TDT? ( S / N ): ");
			while(true) {
				input = sc.nextLine();
				if(!input.isBlank()) {
					if(input.equalsIgnoreCase("S")) {
						tdt = true;
						break;
					}else if(input.equalsIgnoreCase("N")) {
						tdt = false;
						break;
					}else System.out.print("Por favor, introduce una 'S' o una 'N': ");					
				}else break;
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
									+ "| Peso: "+peso+" kg | Precio base: "+precio+" € | Resolución: "+resolucion+"'' "
									+ (tdt ? " TDT: SÍ |" : " TDT: NO |") + " Unidades: "+unidades+" |\n");
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
		ArrayList<Televisor> nuevosTelevisores = new ArrayList<>();
		
		for(int i = 0; i < unidades; i++) {
			Televisor t = new Televisor(marca, modelo, color, consumo, peso, precio, resolucion, tdt);
			nuevosTelevisores.add(t);
		}
		arrayElectrodomesticos.addAll(nuevosTelevisores);
		System.out.println("\nIntroducida/s:\n");
		for(Televisor e : nuevosTelevisores) {
			System.out.println(e.toString());
		}
		System.out.println("\nProceso realizado con éxito.");
		
	}
	
	protected ArrayList<Electrodomestico> filtrarTelevisores(ArrayList<Electrodomestico> arrayElectrodomesticos, String entrada) {		
	    ArrayList<Electrodomestico> televisoresFiltrados = new ArrayList<>(); 
	    try { // Primero intentamos convertir a int para buscar por ID 
	        int dni = Integer.parseInt(entrada);
	        for (Electrodomestico t : arrayElectrodomesticos) { 
	        	if(t instanceof Televisor) {
	        		if(t.getId() == dni) {
	        			televisoresFiltrados.add(t);  
	        		}
	        	}           
	        }
	    } catch (NumberFormatException e) {} // No es un número entero, seguimos probando...
	    entrada = entrada.replace(",", "."); // para poder filtrar por peso o precio
	    try { // Ahora intentamos convertir a double para buscar por precio o peso
	        double precioOPesoOResolucion = Double.parseDouble(entrada);
	        for (Electrodomestico t : arrayElectrodomesticos) {
	        	if(t instanceof Televisor) {
	        		if (t.getPrecio() == precioOPesoOResolucion || t.getPeso() == precioOPesoOResolucion || ((Televisor) t).getResolucion() == precioOPesoOResolucion) {
	        			televisoresFiltrados.add(t);
	        		}
	        	}	            	            
	        }
	    } catch (NumberFormatException e) {} // No es un número decimal, seguimos probando...
	    if(entrada.length() == 1 && "ABCDEFabcdef".contains(entrada)) { // buscamos por consumo:
	    	char consumo = Character.toUpperCase(entrada.charAt(0));
	    	for(Electrodomestico e : arrayElectrodomesticos) {
	    		if(e instanceof Televisor) {
	    			if(e.getConsumo() == consumo) {
	    				televisoresFiltrados.add(e);
	    			}
	    		}  		
	    	}
	    }
	    for (Electrodomestico t : arrayElectrodomesticos) { // Finalmente, buscamos por Marca, modelo o color
	    	if(t instanceof Televisor) {
	    		if (t.getMarca().equalsIgnoreCase(entrada) || t.getModelo().equalsIgnoreCase(entrada) || t.getColor().equalsIgnoreCase(entrada)) {
	    			televisoresFiltrados.add(t);
	    		}
	    	}
	        
	    }
	    return televisoresFiltrados; // Retornamos la lista con los resultados (vacía si no hay coincidencias)
	}
	
	protected Televisor encontrarTelevisor(ArrayList<Electrodomestico> arrayElectrodomesticos, String entrada, Scanner sc) {
		
	    ArrayList<Electrodomestico> televisoresFiltrados = filtrarTelevisores(arrayElectrodomesticos, entrada);
	    
	    while (televisoresFiltrados.size() > 1) {
	
	    	System.out.println("\nSe encontraron varios televisores:\n");
	    	for (Electrodomestico c : televisoresFiltrados) { // son televisores. El casting se hace en "filtrarTelevisores" justo encima del while
	    		System.out.println(c.toString());
	    	}    
	             
	        System.out.print("\nIntroduce otro dato para filtrar la búsqueda (o escribe \"S\" para salir): ");
	        String nuevoFiltro = sc.nextLine();
	        if(nuevoFiltro.equalsIgnoreCase("s")) return null;
	        
	        televisoresFiltrados = filtrarTelevisores(televisoresFiltrados, nuevoFiltro);
	
	        if (televisoresFiltrados.isEmpty()) {
	            System.out.println("\nEl filtro no ha refinado la lista..");
	            return null;
	        } 
	    }	    
	    if(televisoresFiltrados.isEmpty()) {
	    	System.out.println("\nAún no hay tablets o no hay ninguna con estos filtro.");
	    	return null;
	    }
	    return (Televisor) televisoresFiltrados.get(0); // Devuelve el cliente único encontrado
	}
	
	protected void eliminarTelevisor(ArrayList<Electrodomestico> arrayElectrodomesticos, Scanner sc) {
	    
	    ArrayList<Electrodomestico> televisoresAEliminar = new ArrayList<>();

	    // Buscar tablets para eliminar
	    System.out.print("\nIntroduce el dato con el que realizar la búsqueda de los televisores que van a ser eliminados: ");
	    televisoresAEliminar = filtrarTelevisores(arrayElectrodomesticos, sc.nextLine()); // no usamos encontrarTablet porque quizá quiere eliminar varias

	    System.out.println(); // Salto de línea

	    // Si no hay resultados, salir
	    if (televisoresAEliminar.isEmpty()) {
	        System.out.println("❌ No se encontraron televisores con ese criterio.");
	        return;
	    }
	    // Mostrar tablets encontradas
	    for (Electrodomestico t : televisoresAEliminar) {
	        System.out.println(t.toString());
	    }
	    // Si solo hay 1 tablet encontrada, saltamos el filtrado adicional
	    if (televisoresAEliminar.size() == 1) {
	        System.out.print("\n¿Es correcta el televisor a eliminar? ( S / N ): ");
	        if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\n🚫 Abortamos proceso de borrado.");
	            return;
	        }
	    } else {
	        // Si hay más de 1 tablet, preguntar si se quiere seguir filtrando
	        String entrada = "S";
	        while (entrada.equalsIgnoreCase("S") && televisoresAEliminar.size()>1) {
	            System.out.print("\n¿Quieres seguir filtrando? ( S / N ): ");
	            entrada = sc.nextLine();
	            if (entrada.equalsIgnoreCase("S")) {
	                System.out.print("\nIntroduce el nuevo filtro: ");
	                televisoresAEliminar = filtrarTelevisores(televisoresAEliminar, sc.nextLine());
	                // Si después del filtrado no hay coincidencias, salir
	                if (televisoresAEliminar.isEmpty()) {
	                    System.out.println("\n❌ No se encontraron televisores con este filtro.");
	                    return;
	                }
	                // Mostrar tablets después del filtrado
	                System.out.println("\n📌 Televisores encontradas tras el filtro:");
	                for (Electrodomestico t : televisoresAEliminar) {
	                    System.out.println(t.toString());
	                }
	            } else if (!entrada.equalsIgnoreCase("N")) {
	                System.out.println("\n⚠ Opción incorrecta, intenta de nuevo.\n");
	                entrada = "S"; // Mantener en el bucle si la opción es incorrecta
	            }
	        }
	        // Confirmar eliminación después del filtrado
	        System.out.print("\n¿Son correctas los televisores a eliminar? ( S / N ): ");
	        if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\n🚫 Abortamos proceso de borrado.");
	            return;
	        }
	    }

	    arrayElectrodomesticos.removeAll(televisoresAEliminar);
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
