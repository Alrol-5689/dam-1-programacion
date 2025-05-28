package baseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionBD {
	
	private Conexion conexion = new Conexion();
	private Connection con;
	private Statement st;
	private ResultSet resultado;
	
	public boolean comprobarUsuario(String dni, String pass) throws SQLException{
		boolean encontrado = false;
		con = conexion.getConexion();
		String sql= "SELECT * FROM usuarios WHERE usuario = '"+dni+"' and CONTRASENIA = '"+pass+"' ";
		try {
			st = (Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			while(resultado.next()) {
				encontrado = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}
	
	public boolean insertarUsuario(String dni, String pass) throws SQLException{
		boolean insertado = false;
		con = conexion.getConexion();
		String sql = "insert into usuarios (usuario, contrasenia) values ('"+dni+"', '"+pass+"')";
		try {
			st = (Statement) con.createStatement();
			int confirmar = st.executeUpdate(sql);
			if(confirmar == 1) {
				insertado = true;
			}
			st.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return insertado;
	}
	
	

}
