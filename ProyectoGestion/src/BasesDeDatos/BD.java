package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Data.Evento;
import Data.Restaurante;
import Data.Usuario;

/**
 * Clase que contiene todos los metodos referentes a la base de datos
 * @author Javier Rivero y Aitor Santamaria
 *
 */
public class BD {

	private Connection connect;
	private static Statement stm;
	
	/**
	 * Metodo que genera una sentencia para entrar a la BD
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
	 * Metodo para conectarse a la BD
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
	 * Metodo que cierra una sentencia 
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
	 * Metodo que permite desconectarse de la BD
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
	 * Metodo para obtener un usuario completo desde la BD
	 * @param usuario: String que contiene el nombre de usuario del cliente
	 * @return u: devuelve el usuario obtenido
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
	 * Metodo para insertar nuevo usuario en la base de datos
	 * @param Nombre: String que contiene el nuevo nombre del usuario
	 * @param DNI: string de 9 caracteres 
	 * @param Usuario: String que contiene el nombre de usuario del cliente
	 * @param Contrasenia: String con la contrasenia del usuario
	 * @param Edad: int con la edad del usuario, mayor que 18
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
	 * Metodo para devolver el nombre del usuario
	 * @param usuario: String que contiene el nombre de usuario del cliente
	 * @return nombre: String de todos los nombres de usuarios
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
	 * Metodo que muestra por pantalla todos la musica
	 * @return a: arrayList de toda la musica
	 */
	public ArrayList<String> mostrarTodasLasMusicas(){
		String query;
		ArrayList<String> a= new ArrayList<String>();
		String musicaCompleto="";
		query="SELECT * FROM musica ";
		try {
			ResultSet rs = stm.executeQuery(query);
			rs.next(); //Con esto omitimos la primera tupla, que no tiene informacion
			while(rs.next()){
				musicaCompleto=String.format("%30s%30s%30d%30d\n",rs.getString("tipo"),rs.getString("duracion"),rs.getInt("precio"),rs.getInt("cod_musica"));
				a.add(musicaCompleto);
			}
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	/**
	 * Metodo para mostrar por pantalla todos los usuarios de la base de datos, con toda su informacion
	 * @return a: arrayList de todos los usuarios
	 */
	public ArrayList<String> mostrarClientes(){
		String query;
		ArrayList<String> a = new ArrayList<String>();
		String clienteCompleto="";
		query="SELECT * FROM USUARIO";
		try {
			ResultSet rs =stm.executeQuery(query);
			while(rs.next()){
				clienteCompleto=String.format("%20s%20s%20s%15d\n", rs.getString("Nombre"), rs.getString("DNI"), rs.getString("Usuario"),rs.getInt("Edad"));
				a.add(clienteCompleto);
			}
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return a;
	}
	
	/**
	 * Metodo que muestra por pantalla todos la musica
	 * @return a: arrayList de todos los bailes
	 */
	public ArrayList<String> mostrarTodosLosBailes(){
		String query;
		ArrayList<String> a= new ArrayList<String>();
		String baileCompleto="";
		query="SELECT * FROM baile ";
		try {
			ResultSet rs = stm.executeQuery(query);
			rs.next(); //Para que no salga la primera tupla //
			while(rs.next()){
				baileCompleto=String.format(String.format("%30s%30s%30d%30d\n",rs.getString("tipo"),rs.getString("duracion"),rs.getInt("precio"),rs.getInt("cod_baile")));
				a.add(baileCompleto);
			}
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	/**
	 * Metodo que muestra por pantalla todos los eventos de todos los usuario (VentanaMisReservas)
	 * @return a: arrayList de todos los eventos
	 */
	public ArrayList<String> mostrarTodosLosEventos(){
		String query;
		ArrayList<String> a= new ArrayList<String>();
		String eventoCompleto="";
		query="SELECT * FROM Eventos";
		try {
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				eventoCompleto=String.format("%10s%10d%15d%10d%15s%15d%15d%15d%30s%20d%20s%20s%10s\n",rs.getString("usuario"),rs.getLong("precio"),rs.getInt("invitados"),rs.getInt("codigo"),rs.getString("actividad"),rs.getInt("fecha"),rs.getInt("cod_musica"),rs.getInt("cod_baile"),rs.getString("espacio"),rs.getInt("num_menu"),rs.getString("catering"),rs.getString("cafes_infusiones"),rs.getString("vinos"));
				a.add(eventoCompleto);//sdddsdddsdsss
			}
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	/**
	 * Metodo que muestra por pantalla todos los eventos de un usuario (VentanaMisReservas)
	 * @param usuario: String que contiene el nombre de usuario del cliente
	 * @return a: arrayList de todos los eventos del usuario
	 */
	public ArrayList<String> mostrarEventos(String usuario){
		String query;
		ArrayList<String> a= new ArrayList<String>();
		String eventoCompleto="";
		query="SELECT * FROM Eventos WHERE usuario='"+usuario+"'";
		try {
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				eventoCompleto=String.format("%10s%10d%15d%10d%15s%15d%15d%15d%30s%20d%20s%20s%10s\n",rs.getString("usuario"),rs.getLong("precio"),rs.getInt("invitados"),rs.getInt("codigo"),rs.getString("actividad"),rs.getInt("fecha"),rs.getInt("cod_musica"),rs.getInt("cod_baile"),rs.getString("espacio"),rs.getInt("num_menu"),rs.getString("catering"),rs.getString("cafes_infusiones"),rs.getString("vinos"));
				a.add(eventoCompleto);
			}
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	/**
	 * Metodo para obtener todas las reservas (reducido) 
	 * @return a: arrayList de todas las reservas
	 */
	public ArrayList<String> sacarReservasTodos(){
		String query;
		ArrayList<String> a = new ArrayList<String>();
		String reservasTodo=""; 
		query="SELECT * FROM Eventos";
		try {
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				reservasTodo=String.format("%20s%20d%20d\n", rs.getString("usuario"),rs.getInt("codigo"),rs.getInt("fecha"));
				a.add(reservasTodo);
			}
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	/**
	 * Contamos el numero total de reservas  
	 * @return cont: int que devuelve el numero total de reservas
	 */
	public int contarReservasTodo(){
		String query;
		int cont=0;
		query="SELECT COUNT(codigo) FROM Eventos";
		try {
			ResultSet rs = stm.executeQuery(query);
			cont=rs.getInt(1);
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return cont;
	}
	
	/**
	 * Metodo para obtener las reservas con un anio especifico
	 * @param anyo: recibe el anio en formato de string 
	 * @return a: arrayList de todas las reservas de ese anio
	 */
	public ArrayList<String> sacarReservasAnyo(String anyo){
		String query;
		ArrayList<String> a = new ArrayList<String>();
		String reservasAnyo=""; 
		query="SELECT * FROM Eventos WHERE fecha LIKE'"+anyo+"%'";
		try {
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				reservasAnyo=String.format("%20s%20d%20d\n", rs.getString("usuario"),rs.getInt("codigo"),rs.getInt("fecha"));
				a.add(reservasAnyo);
			}
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	/**
	 * Contamos el numero total de reservas con el parametro anyo al principio y lo devolvemos
	 * @param anyo: recibe el anio en formato de string
	 * @return cont: int que devuelve el numero total de reservas del anio
	 */
	public int contarReservasAnyo(String anyo){
		String query;
		int cont=1;
		query="SELECT COUNT(codigo) FROM Eventos WHERE fecha LIKE'"+anyo+"%'";
		try {
			ResultSet rs = stm.executeQuery(query);
			cont=rs.getInt(1);
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return cont;
	}
	
	/**
	 * Metodo para obtener las reservas con un mes especifico
	 * @param mes: recibe en formato string el mes que desea
	 * @return a: arrayList de todas las reservas del mes
	 */
	public ArrayList<String> sacarReservasMes(String mes){
		String query;
		ArrayList<String> a = new ArrayList<String>();
		String reservasMes=""; 
		query="SELECT * FROM Eventos WHERE fecha LIKE'"+mes+"%'";
		try {
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				reservasMes=String.format("%20s%20d%20d\n", rs.getString("usuario"),rs.getInt("codigo"),rs.getInt("fecha"));
				a.add(reservasMes);
			}
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	/**
	 * Contamos el numero total de reservas con el parametro mes en el medio y lo devolvemos
	 * @param mes: recibe en formato string el mes que desea
	 * @return cont: int que devuelve el numero total de reservas del mes
	 */
	public int contarReservasMes(String mes){
		String query;
		int cont=0;
		query="SELECT COUNT(codigo) FROM Eventos WHERE fecha LIKE'"+mes+"%'";
		try {
			ResultSet rs = stm.executeQuery(query);
			cont=rs.getInt(1);
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return cont;
	}
	
	/**
	 * Metodo para obtener las reservas de hoy
	 * @param hoy: recibe en formato string el dia de hoy
	 * @return a: arrayList de todas las reservas de hoy
	 */
	public ArrayList<String> sacarReservasHoy(String hoy){
		String query;
		ArrayList<String> a = new ArrayList<String>();
		String reservasHoy=""; 
		query="SELECT * FROM Eventos WHERE fecha LIKE'%"+hoy+"'";
		try {
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				reservasHoy=String.format("%20s%20d%20d\n", rs.getString("usuario"),rs.getInt("codigo"),rs.getInt("fecha"));
				a.add(reservasHoy);
			}
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	/**
	 * Contamos el numero total de reservas con el parametro hoy al final y lo devolvemos
	 * @param hoy: recibe en formato string el dia de hoy
	 * @return cont: int que devuelve el numero total de reservas de hoy
	 */
	public int contarReservasHoy(String hoy){
		String query;
		int cont=1;
		query="SELECT COUNT(codigo) FROM Eventos WHERE fecha LIKE'"+hoy+"'";
		try {
			ResultSet rs = stm.executeQuery(query);
			cont=rs.getInt(1);
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return cont;
	}
	
	
	/**
	 * Metodo que devuelve la suma de precios total
	 * @return ganancias: int con el valor total de ganancias (suma de precio)
	 */
	public int gananciasTotal(){
		int ganancias=0;
		String query;
		query="SELECT precio FROM Eventos";
		try {
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				ganancias=ganancias+rs.getInt("precio");
			}
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return ganancias;
	}
	
	/**
	 * Metodo que devuelve la suma de precios del anio
	 * @param anyo: recibe el anio en formato de string
	 * @return ganancias: int con el valor de ganancias del anio (suma de precio)
	 */
	public int gananciasAnyo(String anyo){
		int ganancias=0;
		String query;
		query="SELECT precio FROM Eventos WHERE fecha LIKE'"+anyo+"%'";
		try {
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				ganancias=ganancias+rs.getInt("precio");
			}
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return ganancias;
	}
	
	/**
	 * Metodo que devuelve la suma de precios del mes
	 * @param mes: recibe el mes en formato de string
	 * @return ganancias: int con el valor de ganancias del mes (suma de precio)
	 */
	public int gananciasMes(String mes){
		int ganancias=0;
		String query;
		query="SELECT precio FROM Eventos WHERE fecha LIKE'"+mes+"%'";
		try {
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				ganancias=ganancias+rs.getInt("precio");
			}
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return ganancias;
	}
	
	/**
	 * Metodo que devuelve la suma de precios de hoy
	 * @param hoy: recibe el dia de hoy en formato de string
	 * @return ganancias: int con el valor de ganancias del dia de hoy (suma de precio)
	 */
	public int gananciasHoy(String hoy){
		int ganancias=0;
		String query;
		query="SELECT precio FROM Eventos WHERE fecha LIKE'"+hoy+"'";
		try {
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				ganancias=ganancias+rs.getInt("precio");
			}
			rs.close();
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return ganancias;
	}
	
	/**
	 * Metodo que devuelve el codigo de la musica escogida por el usuario
	 * @param tipo: String con el tipo de musica
	 * @param duracion: String con la duracion de la musica
	 * @param precio: int con el valor de la musica
	 * @return cod_musica: int con el codigo obtenido de la base de datos
	 */
	public int codigoMusica(String tipo, String duracion, int precio){
		String query;
		int cod_musica=0;
		query="SELECT cod_musica FROM musica where tipo='"+tipo+"' AND duracion='"+duracion+"' AND precio="+precio;
		try {
			ResultSet rs = stm.executeQuery(query);
			cod_musica = rs.getInt("cod_musica");
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return cod_musica;
	}
	
	/**
	 * Metodo que devuelve el codigo del baile escogido por el usuario
	 * @param tipo: String con el tipo de baile
	 * @param duracion: String con la duracion del baile
	 * @param precio: int con el valor del baile
	 * @return cod_baile: int con el codigo obtenido de la base de datos
	 */
	public int codigoBaile(String tipo, String duracion, int precio){
		String query;
		int cod_baile=0;
		query="SELECT cod_baile FROM baile where tipo='"+tipo+"' AND duracion='"+duracion+"' AND precio="+precio;
		try {
			ResultSet rs = stm.executeQuery(query);
			cod_baile=rs.getInt("cod_baile");
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return cod_baile;
	}
	
	/**
	 * Metodo para obtener de la BD los campos de tipos de musica --> VentanaMusica
	 * @return tipos: obtiene en un String[] todos los tipos de musica almacenados en la base de datos
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
	 * Metodo para obtener de la BD los campos de duracion de musica --> VentanaMusica
	 * @return duracion: : obtiene en un String[] todos las duraciones de musica almacenados en la base de datos
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
	 * Metodo para obtener de la BD los campos de precio de musica --> VentanaEditarMB
	 * @return precio: obtiene en un String[] todos los precios de musica almacenados en la base de datos
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
	 * Metodo para obtener el precio de la tupla seleccionada de musica
	 * @param tipo: String con el tipo de musica
	 * @param duracion: String con la duracion de la musica
	 * @return precio: int con el precio de la tupla seleccionada
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
	 * Metodo que devuelve la contrasenia del usuario, para el proceso de acceso
	 * @param usuario: dependiendo del usuario se obtendra una contrasenia u otra
	 * @return contra: String de la contrasenia del usuario
	 */
	public String contraseniaUsuario(String usuario){
		String query;
		String contra="";
		query="SELECT Contrasenia FROM USUARIO WHERE Usuario='"+usuario+"'";
		try {
			ResultSet rs = stm.executeQuery(query);
			if(rs.next()){
				contra=rs.getString("Contrasenia");
			}
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return contra;
	}
	
	/**
	 * Metodo para obtener el precio de la tupla seleccionada de baile
	 * @param tipo: String con el tipo de baile
	 * @param duracion: String con la duracion del baile
	 * @return precio: int con el precio de la tupla seleccionada
	 */
	public int precioBaile(String tipo, String duracion){
		String query;
		int precio=0;
		query="SELECT precio FROM baile WHERE tipo='"+tipo+"' AND duracion='"+duracion+"'";
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
	 * Metodo para obtener de la BD los campos de tipo de baile --> VentanaMusica
	 * @return tipo: devuelve como String[] todos los campos de tipo de la base de datos
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
	 * Metodo para obtener de la BD los campos de duracion de baile --> VentanaMusica
	 * @return duracion: devuelve como String[] todos los campos de duracion de la base de datos
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
	 * Metodo para obtener de la BD los campos de precio de baile --> VentanaEditarMB
	 * @return precio: devuelve como String[] todos los campos de precio de la base de datos
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
	 * Metodo para introducir un nuevo evento en la base de datos 
	 * @param usuario: String que contiene el nombre de usuario del cliente 
	 * @param precio: int que contiene el precio total a pagar por el usuario
	 * @param invitados: numero entero positivo de invitados a la fiesta
	 * @param actividad: string con la informacion de la actividad
	 * @param fecha: dia en formato int del evento
	 * @param cod_musica: codigo de la musica solicitada para el evento, int
	 * @param cod_baile: codigo del baile solicitado para el evento, int
	 * @param espacio: string que recoge el nombre del espacio solicitado
	 * @param num_menu: int con el numero que se va a servir en el evento
	 * @param catering: tipo del catering escogido, String
	 * @param cafes_infusiones: Si/No, dependiendo de la seleccion (String)
	 * @param vinos: Si/No, dependiendo de la seleccion (String)
	 */
	public void insertarNuevoEvento(String usuario, long precio, int invitados, String actividad, int fecha, int cod_musica, int cod_baile, String espacio, int num_menu, String catering, String cafes_infusiones, String vinos){
		String query = "INSERT INTO Eventos (usuario, precio, invitados, actividad, fecha, cod_musica, cod_baile, espacio, num_menu, catering, cafes_infusiones, vinos) VALUES ('"+usuario+"',"+precio+","+invitados+",'"+actividad+"',"+fecha+","+cod_musica+","+cod_baile+",'"+espacio+"',"+num_menu+", '"+catering+"','"+cafes_infusiones+"','"+vinos+"')";
		try {
			stm.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para introducir informacion en la BD de musica
	* @param tipo: String con el tipo de musica
	 * @param duracion: String con la duracion de la musica
	 * @param precio: int con el valor de la musica
	 */
	public void insertarEnMusica(String tipo, String duracion, int precio){
		String query = "INSERT INTO musica (tipo, duracion, precio) VALUES ('"+tipo+"','"+duracion+"',"+precio+")";
		try {
			stm.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ha introducido con exito la siguiente informacion:\n "+tipo+", "+duracion+", "+precio);
		}
	}
	
	/**
	 * Metodo para introducir informacion en la BD de baile
	 * @param tipo: String con el tipo de baile
	 * @param duracion: String con la duracion del baile
	 * @param precio: int con el valor del baile
	 */
	public void insertarEnBaile(String tipo, String duracion, int precio){
		String query = "INSERT INTO baile (tipo, duracion, precio) VALUES ('"+tipo+"','"+duracion+"',"+precio+")";
		try {
			stm.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ha introducido con exito la siguiente informacion:\n "+tipo+", "+duracion+", "+precio);
		}
	}
	
	/**
	 * Metodo para eliminar informacion en la BD de musica
	 * @param tipo: String con el tipo de musica
	 * @param duracion: String con la duracion de la musica
	 * @param precio: int con el valor de la musica
	 */
	public void eliminarEnMusica(String tipo, String duracion, int precio){
		String query = "DELETE FROM musica WHERE tipo='"+tipo+"' AND duracion='"+duracion+"' AND precio="+precio;
		try {
			stm.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ha eliminado con exito la siguiente informacion:\n "+tipo+", "+duracion+", "+precio);
		}
	}
	
	/**
	 * 
	 * Metodo para eliminar informacion en la BD de baile
	 * @param tipo: String con el tipo de baile
	 * @param duracion: String con la duracion del baile
	 * @param precio: int con el valor del baile
	 */
	public void eliminarEnBaile(String tipo, String duracion, int precio){
		String query = "DELETE FROM baile WHERE tipo='"+tipo+"' AND duracion='"+duracion+"' AND precio="+precio;
		try {
			stm.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ha eliminado con exito la siguiente informacion:\n "+tipo+", "+duracion+", "+precio);
		}
	}
	
	/**
	 * Metodo para eliminar usuario de la base de datos (ventana Administrador)
	 * @param dni: string de 9 caracteres 
	 */
	public void eliminarCliente(String usuario){
		String query = "DELETE FROM USUARIO WHERE usuario='"+usuario+"'";
		try {
			stm.executeQuery(query);
		} catch (SQLException e) {
			// Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Ha eliminado con exito el usuario "+usuario);
		}
	}
	
	/**
	 * Metodo para eliminar evento de la base de datos
	 * @param usuario:  String que contiene el nombre de usuario del cliente
	 */
	public void eliminarEvento(String usuario){
		String query = "DELETE FROM Eventos WHERE usuario='"+usuario+"'";
		try {
			stm.executeQuery(query);
		} catch (SQLException e) {
			// Auto-generated catch block
			
		}
	}
	
	/**
	 * Metodo para eliminar evento de la base de datos con el codigo
	 * @param codigo:  int que contiene el codigo del cliente
	 */
	public void eliminarEventoCodigo(int codigo){
		String query = "DELETE FROM Eventos WHERE codigo="+codigo;
		try {
			stm.executeQuery(query);
		} catch (SQLException e) {
			// Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Ha eliminado con exito la reserva");
		}
	}

	/**
	 * Metodo para obtener eventos
	 * @param usuario: String que contiene el nombre de usuario del cliente
	 * @return ev: todos los eventos del usuario
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
	
	/**
	 * Metodo para consultar todos los restaurantes --> (Ventana ElegirRestaurante)
	 * @param dni
	 */
	
	public ArrayList<Restaurante> consultaLista() {

		String query = "SELECT * FROM Restaurante ";

		ArrayList<Restaurante> a = new ArrayList<Restaurante>();

		try {

			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				Restaurante r = new Restaurante(rs.getString("titulo"), rs.getString("desc"), rs.getString("imagen"));
				a.add(r);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return a;

	}
	
	/**
	 * Metodo para obtener la contrasenia del administrador
	 * @return: contrasenia en formato String
	 */
	public String obtenerContraAdmin(){
		String query;
		String contra="";
		query="SELECT Contrasenia FROM USUARIO Where DNI='99999999Z'";
		try {
			ResultSet rs = stm.executeQuery(query);
			if(rs.next()){
				contra=rs.getString("Contrasenia");
			}
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return contra;
	}
	
	/**
	 * Metodo para actualizar la contrasenia del administrador
	 * @param contra: String que tiene la nueva contrasenia del administrador
	 */
	public void actualizarContraAdmin(String contra){
		String query;
		query="UPDATE USUARIO SET Contrasenia='"+contra+"' WHERE DNI='99999999Z'";
		try {
			int rs = stm.executeUpdate(query);
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que comprueba si un DNI esta usado por otro usuario
	 * @param dni: String con el numero de DNI
	 * @return esta: boolean que contiene true si el DNI ya esta siendo usado, o false si no esta siendo usado
	 */
	public boolean dniUsado(String dni){
		String query;
		boolean esta=false;
		query="SELECT * FROM USUARIO WHERE DNI='"+dni+"'";
		try {
			ResultSet rs = stm.executeQuery(query);
			if(rs.next()){
				esta=true;
			}
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		return esta;
	}
	
	
	
}
