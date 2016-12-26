package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Data.Evento;
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
			connect= DriverManager.getConnection("jdbc:sqlite:DBproyecto.db");
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
			e.printStackTrace();
		}
	}
	
	public BD(){
		conectar();
	}
	
	/**
	 * Método para obtener un usuario completo desde la BD
	 * @param usuario
	 * @return
	 */
	public Usuario obtenerUsuario(String usuario){
		String query;
		Usuario u=null;
		
		query="SELECT * FROM USUARIO WHERE Usuario='"+usuario+"'"; 
		try {
			ResultSet rs = stm.executeQuery(query);
			if(rs.next()) //Si la select ha devuelto filas
				u=new Usuario(rs.getString("nombre"), rs.getString("dni"),rs.getString("usuario"),rs.getString("contrasenia"),rs.getInt("edad"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return u;
	}
	
	/**
	 * Método para insertar nuevo usuario en la base de datos
	 * @param Nombre
	 * @param DNI
	 * @param Usuario
	 * @param Contrasenia
	 * @param Edad
	 */
	public void insertarNuevoUsuario(String Nombre, String DNI, String Usuario, String Contrasenia,int Edad){
		String query = "INSERT INTO USUARIO (Nombre, DNI, Usuario, Contrasenia, Edad) VALUES ('"+Nombre+"','"+DNI+"','"+Usuario+"','"+Contrasenia+"',"+Edad+")";
		try {
			stm.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método para devolver el nombre del usuario
	 * @param usuario
	 * @return
	 */
	public String nombreUsuario(String usuario){ 
		String query;
		String nombre="";
		query="SELECT Nombre FROM USUARIO WHERE Usuario='"+usuario+"'";
		try {
			ResultSet rs=stm.executeQuery(query);
			if(rs.next()){
				nombre = rs.getString("Nombre");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nombre;
	}
	
	/**
	 * Método para obtener de la BD los campos de tipos de música --> VentanaMusica
	 * @return tipos
	 */
	public String[] comboMusicaTipo(){
		String query;
		int cont=1;
		String[] tipos=null;
		try {
		query="SELECT COUNT(DISTINCT(tipo)) FROM musica";
		ResultSet rs;
		rs=stm.executeQuery(query);
		if(rs.next())
			cont=rs.getInt(1);
		rs.close();
		tipos = new String[cont];
		query="SELECT DISTINCT(tipo) FROM musica";
		int i=0;
			rs = stm.executeQuery(query);
			while(rs.next()){
				tipos[i]=rs.getString("tipo");
				i++;
			}
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return tipos;
	}
	
	/**
	 * Método para obtener de la BD los campos de duración de música --> VentanaMusica
	 * @return duracion
	 */
	public String[] comboMusicaDur(){
		String query;
		int cont=1;
		String[] duracion=null;
		try {
		query="SELECT COUNT(DISTINCT(duracion)) FROM musica";
		ResultSet rs;
		rs=stm.executeQuery(query);
		if(rs.next())
			cont=rs.getInt(1);
		rs.close();
		duracion = new String[cont];
		query="SELECT DISTINCT(duracion) FROM musica";
		int i=0;
			rs = stm.executeQuery(query);
			while(rs.next()){
				duracion[i]=rs.getString("duracion");
				i++;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return duracion;
	}
	/**
	 * Método para obtener el precio de la tupla seleccionada de música
	 * @param tipo
	 * @param duracion
	 * @return
	 */
	public int precioMusica(String tipo, String duracion){
		String query;
		int precio=0;
		query="SELECT precio FROM musica WHERE tipo='"+tipo+"' AND duracion='"+duracion+"'";
		ResultSet rs;
		try {
			rs=stm.executeQuery(query);
			if(rs.next()){
				precio=rs.getInt("precio");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return precio;
	}
	
	/**
	 * Método para obtener de la BD los campos de tipo de baile --> VentanaMusica
	 * @return duracion
	 */
	public String[] comboBaileTipo(){
		String query;
		int cont=1;
		String[] tipo=null;
		try {
		query="SELECT COUNT(DISTINCT(tipo)) FROM baile";
		ResultSet rs;
		rs=stm.executeQuery(query);
		if(rs.next())
			cont=rs.getInt(1);
		rs.close();
		tipo = new String[cont];
		query="SELECT DISTINCT(tipo) FROM baile";
		int i=0;
			rs = stm.executeQuery(query);
			while(rs.next()){
				tipo[i]=rs.getString("tipo");
				i++;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipo;
	}
	
	/**
	 * Método para obtener de la BD los campos de duración de baile --> VentanaMusica
	 * @return duracion
	 */
	public String[] comboBaileDur(){
		String query;
		int cont=1;
		String[] duracion=null;
		try {
		query="SELECT COUNT(DISTINCT(duracion)) FROM baile";
		ResultSet rs;
		rs=stm.executeQuery(query);
		if(rs.next())
			cont=rs.getInt(1);
		rs.close();
		duracion = new String[cont];
		query="SELECT DISTINCT(duracion) FROM baile";
		int i=0;
			rs = stm.executeQuery(query);
			while(rs.next()){
				duracion[i]=rs.getString("duracion");
				i++;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return duracion;
	}
	
	/**
	 * Método para introducir un nuevo evento en la base de datos
	 * @param presupuesto
	 * @param invitados
	 * @param codigo
	 * @param actividad
	 */
	public void insertarNuevoEventos(int presupuesto, int invitados, int codigo, String actividad){
		String query = "INSERT INTO Eventos (presupuesto, invitados, codigo, actividad) VALUES ("+presupuesto+","+invitados+","+codigo+",'"+actividad+"')";
		try {
			stm.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Evento obtenerEvento(String usuario){
		String query;
		Evento ev=null;
		
		query="SELECT * FROM Eventos WHERE USUARIO='"+usuario+"'"; 
		try {
			ResultSet rs = stm.executeQuery(query);
			if(rs.next()) //Si la select ha devuelto filas
				ev=new Evento(rs.getDouble("presupuesto"), rs.getInt("invitados"), rs.getInt("codigo"), rs.getString("actividad"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return ev;
	}
}
