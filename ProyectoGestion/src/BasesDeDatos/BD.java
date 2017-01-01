package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
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
	 * Método para obtener de la BD los campos de precio de música --> VentanaEditarMB
	 * @return duracion
	 */
	public String[] comboMusicaPrecio(){
		String query;
		int cont=1;
		String[] precio=null;
		try {
		query="SELECT COUNT(DISTINCT(precio)) FROM musica";
		ResultSet rs;
		rs=stm.executeQuery(query);
		if(rs.next())
			cont=rs.getInt(1);
		rs.close();
		precio = new String[cont];
		query="SELECT DISTINCT(precio) FROM musica";
		int i=0;
			rs = stm.executeQuery(query);
			while(rs.next()){
				precio[i]=rs.getString("precio");
				i++;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return precio;
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
	 * Método para obtener de la BD los campos de precio de baile --> VentanaEditarMB
	 * @return duracion
	 */
	public String[] comboBailePrecio(){
		String query;
		int cont=1;
		String[] precio=null;
		try {
		query="SELECT COUNT(DISTINCT(precio)) FROM baile";
		ResultSet rs;
		rs=stm.executeQuery(query);
		if(rs.next())
			cont=rs.getInt(1);
		rs.close();
		precio = new String[cont];
		query="SELECT DISTINCT(precio) FROM baile";
		int i=0;
			rs = stm.executeQuery(query);
			while(rs.next()){
				precio[i]=rs.getString("precio");
				i++;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return precio;
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
	
	/**
	 * Método para introducir información en la BD de música
	 * @param tipo
	 * @param duracion
	 * @param precio
	 */
	public void insertarEnMusica(String tipo, String duracion, int precio){
		String query = "INSERT INTO musica (tipo, duracion, precio) VALUES ('"+tipo+"','"+duracion+"',"+precio+")";
		try {
			stm.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ha introducido con éxito la siguiente información:\n "+tipo+", "+duracion+", "+precio);
		}
	}
	
	/**
	 * Método para introducir información en la BD de baile
	 * @param tipo
	 * @param duracion
	 * @param precio
	 */
	public void insertarEnBaile(String tipo, String duracion, int precio){
		String query = "INSERT INTO baile (tipo, duracion, precio) VALUES ('"+tipo+"','"+duracion+"',"+precio+")";
		try {
			stm.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ha introducido con éxito la siguiente información:\n "+tipo+", "+duracion+", "+precio);
		}
	}
	
	/**TODO esto no funciona--> por que?
	 * 
	 * Método para eliminar información en la BD de música
	 * @param tipo
	 * @param duracion
	 * @param precio
	 */
	public void eliminarEnMusica(String tipo, String duracion, int precio){
		String query = "DELETE FROM musica WHERE tipo='"+tipo+"', duracion='"+duracion+"', precio="+precio;
		try {
			stm.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ha eliminado con éxito la siguiente información:\n "+tipo+", "+duracion+", "+precio);
		}
	}
	
	/**TODO esto no funciona--> por que?
	 * 
	 * Método para eliminar información en la BD de baile
	 * @param tipo
	 * @param duracion
	 * @param precio
	 */
	public void eliminarEnBaile(String tipo, String duracion, int precio){
		String query = "DELETE FROM baile WHERE tipo='"+tipo+"', duracion='"+duracion+"', precio="+precio;
		try {
			stm.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ha eliminado con éxito la siguiente información:\n "+tipo+", "+duracion+", "+precio);
		}
	}
	
	/**
	 * Método para obtener eventos
	 * @param usuario
	 * @return
	 */
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
	
	public void obtenerInfoMusica(){
	
	
	}
}
