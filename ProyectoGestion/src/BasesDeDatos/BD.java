package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Data.Usuario;

public class BD {

	private Connection connect;
	private static Statement stm;
	
	/**
	 * Método que genera una sentencia para entrar a la BD
	 */
	public void crearSentencia()
	{
		try {
			stm = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Método para conectarse a la BD
	 */

	public void conectar()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			connect= DriverManager.getConnection("jdbc:sqlite:Newton.db");
			crearSentencia();
		}catch(Exception e)
		{
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que cierra una sentencia 
	 */
	public void cerrarSentencia()
	{
		try {
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método que permite desconectarse de la BD
	 */
	public void desconectar()
	{
		try {
			cerrarSentencia();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BD(){
		conectar();
	}
	

	public static Usuario obtenerUsuario(String usuario){
		String query;
		Usuario u=null;
		
		query="SELECT * FROM USUARIO WHERE USUARIO='"+usuario+"'"; 
		try {
			ResultSet rs = stm.executeQuery(query);
			if(rs.next()) //Si la select ha devuelto filas
				u=new Usuario(rs.getString("dni"),rs.getString("nombre"),rs.getInt("edad"),rs.getString("contrasenia"),rs.getString("usuario"));
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		} 
		return u;
	}
	
	public void insertarNuevoUsuario(Usuario u){
		String query = "INSERT INTO cliente (dni,nombre,edad,contrasenia,foto) VALUES ('"+u.getDni()+"','"+u.getNombre()+"',"+u.getEdad()+",'"+u.getContras()+"','"+u.getUsuario()+"')";
		try {
			stm.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}