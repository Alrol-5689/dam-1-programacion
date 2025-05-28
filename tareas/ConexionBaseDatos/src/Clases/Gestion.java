package Clases;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Scanner;

import baseDatos.Conexion;
import baseDatos.GestionBD;

public class Gestion {
	
	protected String dni, pass;
	private Scanner sc = new Scanner(System.in);
	private Conexion cn;
	private GestionBD gbd;
	
	protected Gestion() {
		
	}
	
	protected int menuPrincipal() {
		int opcion;
		System.out.println("Menú de opciones.");
		System.out.println("1.- Buscar.");
		System.out.println("2.- Insertar.");
		System.out.println("3.- Eliminar.");
		System.out.println("4.- Salir.");
		opcion = sc.nextInt();
		return opcion;
	}
	
	protected void comprobarUsuario() {
		System.out.println("Dime tu dni: ");
		dni = sc.next();
		System.out.println("Dime tu contraseña: ");
		pass = sc.next();
		
		cn = new Conexion();
		gbd = new GestionBD();
		
		try {
			if(gbd.comprobarUsuario(dni, pass)) {
				System.out.println("Bienvenida al curso.");
			}else System.out.println("Usuario o contraseá incorrecto.");
		}catch(HeadlessException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	protected void insertarUsuario() {
		System.out.println("Dime tu DNI: ");
		dni = sc.next();
		System.out.println("Dime tu contraseña: ");
		pass = sc.next();
		
		cn = new Conexion();
		gbd = new GestionBD();
		
		try {
			if(gbd.comprobarUsuario(dni, pass)) {
				System.out.println("Ya existe el usuario.");
			}else {
				if(gbd.insertarUsuario(dni, pass)) {
					System.out.println("Usuario insertado correctamente.");
				}else System.out.println("Error. No se pudo insertar.");				
			}
		}catch(HeadlessException | SQLException e1) {
			e1.printStackTrace();
		}
		
	}

}
