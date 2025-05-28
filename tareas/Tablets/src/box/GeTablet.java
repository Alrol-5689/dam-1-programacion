package box;

import java.util.ArrayList;
import java.util.Scanner;

public class GeTablet {
	
	// ATRIBUTOS
	
	protected Scanner sc = new Scanner(System.in);

	// MÉTODOS
	
	protected void eliminarTablet(LeTablet leTab, ArrayList<Tablet> arrayTablets, ArrayList<Reserva> arrayReservas) {
	    
	    ArrayList<Tablet> tabletsAEliminar = new ArrayList<>();

	    // Buscar tablets para eliminar
	    System.out.print("\nIntroduce el dato con el que realizar la búsqueda de las tablets que van a ser eliminadas: ");
	    tabletsAEliminar = leTab.filtrarTablets(arrayTablets, sc.nextLine()); // no usamos encontrarTablet porque quizá quiere eliminar varias

	    System.out.println(); // Salto de línea

	    // Si no hay resultados, salir
	    if (tabletsAEliminar.isEmpty()) {
	        System.out.println("❌ No se encontraron tablets con ese criterio.");
	        return;
	    }
	    // Mostrar tablets encontradas
	    for (Tablet t : tabletsAEliminar) {
	        System.out.println(t.toString());
	    }
	    // Si solo hay 1 tablet encontrada, saltamos el filtrado adicional
	    if (tabletsAEliminar.size() == 1) {
	        System.out.print("\n¿Es correcta la tablet a eliminar? ( S / N ): ");
	        if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\n🚫 Abortamos proceso de borrado.");
	            return;
	        }
	    } else {
	        // Si hay más de 1 tablet, preguntar si se quiere seguir filtrando
	        String entrada = "S";
	        while (entrada.equalsIgnoreCase("S") && tabletsAEliminar.size()>1) {
	            System.out.print("\n¿Quieres seguir filtrando? ( S / N ): ");
	            entrada = sc.nextLine();
	            if (entrada.equalsIgnoreCase("S")) {
	                System.out.print("\nIntroduce el nuevo filtro: ");
	                tabletsAEliminar = leTab.filtrarTablets(tabletsAEliminar, sc.nextLine());
	                // Si después del filtrado no hay coincidencias, salir
	                if (tabletsAEliminar.isEmpty()) {
	                    System.out.println("\n❌ No se encontraron tablets con este filtro.");
	                    return;
	                }
	                // Mostrar tablets después del filtrado
	                System.out.println("\n📌 Tablets encontradas tras el filtro:");
	                for (Tablet t : tabletsAEliminar) {
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
	    // controlamos eliminar también las tablets de arrayReservas. Una mejora sería avisar para que sepa que está eliminando tablets reservadas.
	    for(int i=0; i<arrayReservas.size(); i++) {
	    	Reserva r = arrayReservas.get(i);
	    	for(Tablet t : tabletsAEliminar) {
	    		if(t.equals(r.tablet)) {
	    			arrayReservas.remove(i);
	    			i--; // al eliminar una reserva, la siguiente ocupa su lugar, por lo que es necesario restar i y volver a pasar por esa posicion
	    			break; // volvemos a reservas porque una reserva solo está vinculada a una tablet
	    		}
	    	}
	    }
	    arrayTablets.removeAll(tabletsAEliminar);
	    // verificamos si la tablet está en arrayReservas y la eliminar de ahí también llegado el caso
	    /*for(Reserva r : arrayReservas) {
	    	for (Tablet t : tabletsAEliminar) {
	    		if(t.equals(r.tablet)) arrayReservas.remove(r); // eliminamos la posible reserva que pueda tener	    		
		        arrayTablets.remove(t); // luego eliminar la tablet de arrayTablets
		    }	    	
	    }*/
	    System.out.println("\nBorrado realizado con éxito.");
	}
	
	protected Tablet encontrarTablet(LeTablet leTab, ArrayList<Tablet> array, String entrada) {
	
	    ArrayList<Tablet> tabletsFiltradas = leTab.filtrarTablets(array, entrada);
	    
	    while (tabletsFiltradas.size() > 1) {
	
	    	System.out.println("\nSe encontraron varias tablets:\n");
	    	for (Tablet c : tabletsFiltradas) {
	    		System.out.println(c.toString());
	    	}    
	             
	        System.out.print("\nIntroduce otro dato para filtrar la búsqueda (o escribe \"S\" para salir): ");
	        String nuevoFiltro = sc.nextLine();
	        if(nuevoFiltro.equalsIgnoreCase("s")) return null;
	        
	        tabletsFiltradas = leTab.filtrarTablets(tabletsFiltradas, nuevoFiltro);
	
	        if (tabletsFiltradas.isEmpty()) {
	            System.out.println("\nEl filtro no ha refinado la lista..");
	            return null;
	        } 
	    }	    
	    if(tabletsFiltradas.isEmpty()) {
	    	System.out.println("\nAún no hay tablets o no hay ninguna con estos filtro.");
	    	return null;
	    }
	    return tabletsFiltradas.get(0); // Devuelve el cliente único encontrado
	}

	protected Tablet encontrarTablet_AReservar(LeTablet leTab, ArrayList<Tablet> arrayTablets) {
		
		// este método creo que me sobra, el método reservarTablet en GeReserva podría simplemente usar encontrarTablet...Pensarlo
		Tablet aReservar;
		while(true) {
			System.out.print("\nIntroduce el dato con el que realizar la búsqueda de la tablet que va a ser reservada: ");
			aReservar = encontrarTablet(leTab, arrayTablets, sc.nextLine());
			if(aReservar != null) break;
			System.out.print("\n¿Quieres intentarlo de nuevo? ( S / N ): ");
			if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\nReserva cancelada.");
	            return null;
	        }			
		}	
		System.out.println("\nVa a reservarse ---> "+aReservar.toString()+"\n");
		return aReservar;
	}
	
	protected void modificarTablet(LeTablet leTab, ArrayList<Tablet> arrayTablets, LeReserva leRes, ArrayList<Reserva> arrayReservas) {
		
		ArrayList<Tablet> tabletsAModificar = new ArrayList<>();	
		// primero buscamos la tablet a modificar
		System.out.print("\nIntroduce el dato con el que realizar la búsqueda de las tablets que van a ser modificadas: ");
		tabletsAModificar = leTab.filtrarTablets(arrayTablets, sc.nextLine());
		System.out.println(" "); // salto de línea
		if (tabletsAModificar.isEmpty()) {
	        System.out.println("No se encontraron tablets con ese criterio.");
	        return;
	    }
		// si seguimos en el método es que tenemos tablet / tablets que modificar. Las imprimimos
		for(Tablet t : tabletsAModificar) {
			System.out.println(t.toString());
		}
		// seguimos filtrando hasta que se decida. Se puede filtrar por id para modificar solo una 
		String entrada = "S";
		while(entrada.equalsIgnoreCase("S")) {
			if(tabletsAModificar.size() > 1) System.out.print("\nSeguimos filtrando ( S / N ): ");
			entrada = sc.nextLine();
			if(entrada.equalsIgnoreCase("S")) {
				System.out.print("\nIntroduce el nuevo filtro: ");
				tabletsAModificar = leTab.filtrarTablets(tabletsAModificar, sc.nextLine());
				if (tabletsAModificar.isEmpty()) {
	                System.out.println("\nNo se encontraron tablets con este filtro.");
	                return;
				} // mostramos como va la lista según los filtros:
				for(Tablet t : tabletsAModificar) {
						System.out.println(t.toString());
				}
			}
		}	// cuando pare de filtrar preguntamos si son correctas las tablets a modificar:
		System.out.print(tabletsAModificar.size()==1 ? 
				"\nInserta \"S\" si la tablet a modificar es correcta u otra letra para cancelar " :
				"\nInserta \"S\" si las tablets a modificar son correctas u otra letra para cancelar ");
		
		if(!sc.nextLine().equalsIgnoreCase("s")) {
			System.out.println("\nAbortamos modificación de tablets");
			return;
		} // pedimos los nuevos datos:
		System.out.println("\nIntroduce los nuevos datos o deja en blando para mantenerlos:\n");
		System.out.print("Nueva marca: ");
		String marca = sc.nextLine().toUpperCase();
		System.out.print("Nuevo modelo: ");
		String modelo = sc.nextLine();
		System.out.print("Nuevo color: ");
		String color = sc.nextLine().toLowerCase();
		
		// iniciamos estas como null para que se puedan quedar los campos vacíos. Para ello no pueden ser de tipo primitivo:
		Double pulgadas = null, precio = null;
		Integer anyo = null;
		boolean entradaValida = false; // controlamos que se meten los datos numéricos correctamente

		System.out.print("Nuevas pulgadas: ");
		do {			
			String inputPulgadas = sc.nextLine();
			try {
				if(!inputPulgadas.isBlank()) pulgadas = Double.parseDouble(inputPulgadas.replace(",", "."));
				entradaValida = true;
			}catch(NumberFormatException e) {
				System.out.print("❌ Error: Debes introducir un número válido para pulgadas: ");
			}
		}while(!entradaValida);
		entradaValida = false;

		System.out.print("Nuevo precio: ");
		do {
			String inputPrecio = sc.nextLine();
			try {
				if(!inputPrecio.isBlank()) precio = Double.parseDouble(inputPrecio.replace(",", "."));
				entradaValida = true;
			}catch(NumberFormatException e) {
				System.out.print("❌ Error: Debes introducir un número válido para precio: ");
			}
		}while(!entradaValida);
		entradaValida = false;
		// si no introduce un número int este campo no cambiará. 
		System.out.print("Nuevo año de lanzamiento: ");
		do {
		    String inputAnyo = sc.nextLine();
		    try { 
		        if (!inputAnyo.isBlank()) anyo = Integer.parseInt(inputAnyo); 
		        entradaValida = true;
		    } catch (NumberFormatException e) { 
		        System.out.println("❌ Error: Debes introducir un número válido para el año de lanzamiento: ");
		    }
		}while(!entradaValida);
		entradaValida = false;
	    // resumimos los cambios pertinentes y preguntamos cómo proceder
	    System.out.println("\nResumen de cambios:\n"); 
	    
	    System.out.println("Marca: " + (!marca.isBlank() ? marca : "[SIN CAMBIOS]"));
	    System.out.println("Modelo: " + (!modelo.isBlank() ? modelo : "[SIN CAMBIOS]"));
	    System.out.println("Color: " + (!color.isBlank() ? color : "[SIN CAMBIOS]"));
	    System.out.println("Pulgadas: " + (pulgadas != null ? pulgadas + "\"" : "[SIN CAMBIOS]"));
	    System.out.println("Precio: " + (precio != null ? precio + "€" : "[SIN CAMBIOS]"));
	    System.out.println("Año de lanzamiento: " + (anyo != null ? anyo : "[SIN CAMBIOS]"));
	    
		System.out.print("\nIntroduce \"S\" si el resumen es correcto u otra letra para salir: ");
		// salimos del método al no tener confirmación
		if(!sc.nextLine().equalsIgnoreCase("S")) {
			System.out.println("\nAbortamos modificación de tablets");
			return;
		} // cambiamos los valores y contamos cuántas de ellas están reservadas
		int reservadas = 0;
		for(Tablet t : tabletsAModificar) {
			if(!marca.isBlank()) t.setMarca(marca);
			if(!modelo.isBlank()) t.setModelo(modelo);
			if(!color.isBlank()) t.setColor(color);
			if(pulgadas != null) t.setPulgadas(pulgadas);
			if(precio != null) t.setPrecio(precio);
			if(anyo != null) t.setLanzamiento(anyo);
			if(!t.isDisponible()) reservadas++;
			System.out.println(t.toString());
		}
		System.out.println("\nTablets modificadas correctamente.");
		// si hay alguna tablet reservada preguntamos se quiere cancelar sus reservas , sino salimos del método con las tablets modificadas
		if(reservadas>0) {
			for(Tablet t : tabletsAModificar) {
				if(!t.isDisponible()) System.out.println(t.toString());
			}
			
			System.out.println(reservadas ==1 ? 
					"\nEsta tablet está reservada. Insterta \"S\" para cancelar su reserva u otra letra para mantenerla: ":
					"\nEstas tablets están reservadas. Insterta \"S\" para cancelar sus reservas u otra letra para mantenerlas: ");
			// si quiere cancelar su reserva, las ponemos como disponibles y las eliminamos de arrayReservas
			// siempre que una tablet pueda tener solo una unica reserva en principio este doble for each no debería dar error
			if(sc.nextLine().equalsIgnoreCase("S")) {
				ArrayList<Reserva> reservasAEliminar = new ArrayList<>();
				for(Reserva r : arrayReservas) {
					for(Tablet t : tabletsAModificar) {
						if(r.tablet.equals(t)) {
							reservasAEliminar.add(r);
							break; // una tablet solo puede estar vinculada a una reserva. Cambiamos de "r" cuando hay coincidencia
						}			
					}
				}
				arrayReservas.removeAll(reservasAEliminar);
				
				for(Tablet t : tabletsAModificar) {
					t.setDisponible(true);
				}

				System.out.println("\nTablets disponibles."); // si introduce "s" se ponen disponibles
			}else System.out.println("\nNo se modificó su disponibilidad."); // si no las quiere cambiar se dejan reservadas
		}
		
	}
		


	protected void nuevaTablet(ArrayList<Tablet> arrayTablets) {
		
		Tablet tablet = new Tablet();
		ArrayList<Tablet> arrayTabletsIntroducidas = new ArrayList<>();	
		int unidades =0; // aqui guardaremos la cantidad de tablets que se meterán en el sistema
		boolean camposCorrectos = false; // para repetir el proceso si se ha introducido un campo mal
		System.out.println("\nVamos a añadir tablets en el sistema. Completa los campos: ");
		while(!camposCorrectos) {
	        System.out.print("\nMarca: ");
	        tablet.setMarca(sc.nextLine().toUpperCase());

	        System.out.print("Modelo: ");
	        tablet.setModelo(sc.nextLine());

	        System.out.print("Color: ");
	        tablet.setColor(sc.nextLine().toLowerCase());

	        System.out.print("Pulgadas: ");
	        tablet.setPulgadas(sc.nextDouble());
	        sc.nextLine(); //  Limpiar buffer

	        System.out.print("Precio: ");
	        tablet.setPrecio(sc.nextDouble());
	        sc.nextLine(); //  Limpiar buffer

	        System.out.print("Año de lanzamiento: ");
	        tablet.setLanzamiento(sc.nextInt());
	        sc.nextLine(); //  Limpiar buffer

	        System.out.print("Dime las unidades que vas a añadir: ");
	        unidades = sc.nextInt();
	        sc.nextLine(); //  Limpiar buffer 	
	        boolean opcionValida = true; // para controlar que se introduce S, N o X
	        String entrada = " ";
			System.out.println("\nResumen: "+tablet.getResumen()+" Unidades: "+unidades
					+"\n\n¿Están todos los campos correctos?\n"
					+"\n  Sí.- S"
					+"\n  No.- N"
					+"\n  Cancelar operación.- X\n");
	        do {
				entrada = sc.nextLine();
				System.out.println(""); // para que salte línea en consola
				if(entrada.equalsIgnoreCase("S")) {
					opcionValida = true;
					camposCorrectos = true;
				}else if(entrada.equalsIgnoreCase("N")) {
					opcionValida = true;
					System.out.println("Ok, vamos a introducir los campos de nuevo:");			
				}else if(entrada.equalsIgnoreCase("X")) {
					opcionValida = true;
					tablet = null;
					System.out.println("❌ Operación cancelada.");
					return;
				}else {
					opcionValida = false;
					System.out.print("Opción incorrecta. Introduce S, N, o X: ");			
				}
	        }while(!opcionValida);

		}
		for(int i=0; i<unidades; i++) {
			Tablet nuevaTablet = new Tablet (tablet.getMarca(), tablet.getModelo(), tablet.getColor(), 
                    tablet.getPulgadas(), tablet.getPrecio(), tablet.getLanzamiento());
			arrayTablets.add(nuevaTablet);
			arrayTabletsIntroducidas.add(nuevaTablet);
		}
		if(arrayTabletsIntroducidas.size()==1) {
			System.out.println("Se ha insertado en el sistema la siguiente tablet:\n ");
		}else if(arrayTabletsIntroducidas.size()>1) System.out.println("Se han insertado en el sistema las siguientes tablets:\n ");
		
		for(Tablet a : arrayTabletsIntroducidas) {
			System.out.println(a.toString());
		}
	}


}
