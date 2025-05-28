package box;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MetodosPublicaciones {

	protected Path rutaPublicaciones = Paths.get("publicaciones.txt");

	protected ArrayList<Publicacion> cargarPublicacionesDesdeArchivo(ArrayList<CuentaUsuario> cuentas) {

		ArrayList<Publicacion> publicaciones = new ArrayList<>();
		int mayorId = 0;
		try (BufferedReader reader = Files.newBufferedReader(rutaPublicaciones)) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] partes = linea.split(";");
				if (partes.length >= 4) {
					int idPublicacion = Integer.parseInt(partes[0]);
					LocalDate fecha = LocalDate.parse(partes[1]);
					String mensaje = partes[2];
					String dniAutor = partes[3];

					for (CuentaUsuario c : cuentas) {
						if (c.getDni().equalsIgnoreCase(dniAutor)) {
							Publicacion p = new Publicacion(mensaje, fecha, c);
							p.setId(idPublicacion);
							publicaciones.add(p);
							break;
						}
					}
					if (idPublicacion > mayorId) {
						mayorId = idPublicacion;
					}
				}
			}
			Publicacion.idSiguiente = mayorId;
		} catch (IOException e) {
			System.err.println("Error al cargar las publicaciones: " + e.getMessage());
		}
		return publicaciones;

	}

	protected void guardarPublicacionesEnArchivo(ArrayList<Publicacion> publicaciones) {

		try (BufferedWriter writer = Files.newBufferedWriter(rutaPublicaciones)) {
			for (Publicacion p : publicaciones) {
				writer.write(formatoPublicacion(p));
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.println("Error al guardar las cuentas: " + e.getMessage());
		}

	}

	protected String formatoPublicacion(Publicacion c) {

		return c.getId() + ";" + c.getFecha() + ";" + c.getMensaje().replace(";", ",") + ";" + c.getAutor().getDni();

	}

	protected void publicar(CuentaUsuario usuario, ArrayList<Publicacion> publicaciones, Lectura l, Scanner sc) {

		String mensaje = l.pedirString(sc, false, "Escribe tu publicación: ");
		usuario.publicarMensaje(mensaje, publicaciones);

	}

	protected void eliminarPublicacion(CuentaUsuario usuario, ArrayList<Publicacion> publicaciones, Lectura l,
			Scanner sc) {

		System.out.println("Encuentra la publicación que quieres eliminar.");
		Publicacion aEliminar = encontrarPublicacionUsuario(usuario.getLista_publicaciones(), l, sc);
		if (aEliminar == null) {
			System.out.println("Abortamos proceso de eliminación.");
			return;
		} else {
			boolean confirmacion = l.confirmacionSiNo(sc,
					"¿Seguro que quieres eliminar la publicacion? ( 's' / 'n' ): ");
			if (confirmacion) {
				usuario.getLista_publicaciones().remove(aEliminar);
				publicaciones.remove(aEliminar);
				System.out.println("Publicación eliminada correctamente.");
			} else {
				System.out.println("Abortamos");
			}
		}
	}

	protected Publicacion encontrarPublicacionUsuario(ArrayList<Publicacion> lista, Lectura l, Scanner sc) {

		Publicacion publicacionEncontrada = null;
		if (lista.isEmpty()) { // Si la lista está vacía retornamos null
			System.out.println("Esta lista no tiene publicaciones. Salimos del proceso de búsqueda.");
			return null;
		} // Compruebo que todas las publicaciones de la lista pertenecen al mismo autor.
		CuentaUsuario autor = lista.get(0).getAutor();
		for (Publicacion p : lista) {
			if (!p.getAutor().equals(autor)) {
				System.err.println("Error. Estas publicaciones no pertenecen a una sola cuenta.");
				return null;
			}
		}
		do {
			// Mostramos la lista
			System.out.println("Publicaciones disponibles:");
			lista.stream().forEach(System.out::println);
			// Preguntamso cómo proceder. Si ha visto la publicación rapidamente
			// seleccionará introducri la Id y listo.
			int opcion = l.pedirOpcion(sc, 1, 3, "\nOpciones:\n" + """
					1.- Filtrar por fecha.
					2.- Encontré la publicación. Introducir ID.
					3.- Salir.
					\nSelecciona una opcion: """ + " ");
			if (opcion == 1) { // Filtramos por fecha para refinar la lista
				LocalDate desde = l.pedirFecha(sc, "Se publicó en una fecha igual o posterior a...");
				LocalDate hasta = l.pedirFecha(sc, "Se publicó en una fecha igual o anterior a...");
				lista = filtrarPublicacionUsuario_Fecha(lista, desde, hasta);
				if (lista.size() == 1) {
					System.out.println("Publicación encontrada: " + lista.get(0));
					return lista.get(0);
				} else if (lista.isEmpty()) {
					System.out.println("No se encontraron publicaciones en ese rango de fechas.");
					return null;
				}
			} else if (opcion == 2) { // Ha visto la publicación. Pedimos Id
				int id = l.pedirInt(sc, "Introduce el ID de la publicación: ");
				for (Publicacion p : lista) {
					if (p.getId() == id) {
						publicacionEncontrada = p;
						System.out.println("Publicación encontrada: " + publicacionEncontrada);
						return publicacionEncontrada;
					}
				}
				System.out.println("Ninguna coincidencia.");
			} else {
				return null;
			}
		} while (lista.size() > 1); // Volvemos a mostrar la lista y repetimos el proceso
		return null; // nunca llega a aquí

	}

	protected ArrayList<Publicacion> filtrarPublicacionUsuario_Fecha(ArrayList<Publicacion> lista, LocalDate desde,
			LocalDate hasta) {

		ArrayList<Publicacion> listaFiltrada = new ArrayList<>();
		CuentaUsuario autor = lista.get(0).getAutor();
		for (Publicacion p : lista) {
			if (!p.getAutor().equals(autor)) {
				System.err.println("Error. Estas publicaciones no pertenecen a una sola cuenta.");
				return lista;
			}
		}
		for (Publicacion p : lista) {
			if ((p.getFecha().isEqual(desde) || p.getFecha().isAfter(desde))
					&& (p.getFecha().isEqual(hasta) || p.getFecha().isBefore(hasta))) {
				listaFiltrada.add(p);
			}
		}
		return listaFiltrada;

	}

}
