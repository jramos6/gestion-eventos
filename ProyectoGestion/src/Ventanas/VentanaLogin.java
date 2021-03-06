package Ventanas;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BasesDeDatos.BD;
import Data.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Ventana que valida el usuario y la contraseña para poder utilizar el programa. En caso de no estar registrado
 * se da la opción de registro
 * @author Javier Rivero y Aitor Santamaria
 *
 */
public class VentanaLogin extends JFrame {

	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pnlNorte, panelSur;
	private JTextField txtUsuario, txtNombre, txtDNI, txtEdad;
	private JPasswordField txtContrasenia;
	private JLabel lblUsuario, lblContra, lblNombre, lblEdad, lblDNI, lblRepitaContrasea;
	private JPasswordField txtContra2;
	private boolean activado=false;
	private boolean estaRegistrandose;
	public static BD bd; //Aquí tenemos la Base De Datos
	private String usuAdmin="admin123"; //Datos de acceso de administrador (usuario)
	public static Usuario u;

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {	
		setResizable(false);
		bd = new BD();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnlNorte = new JPanel();
		pnlNorte.setBackground(Color.CYAN);
		contentPane.add(pnlNorte, BorderLayout.NORTH);
		
		JLabel lblParaContinuar = new JLabel("Introduzca los datos:");
		lblParaContinuar.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblParaContinuar.setBackground(Color.CYAN);
		pnlNorte.add(lblParaContinuar);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JFrame vl = this;
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Conectamos con la ventana principal		
				vl.dispose();
				VentanaPrincipal v = new VentanaPrincipal();
				v.setVisible(true);
				
			}
		});
		btnVolver.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		panelSur.add(btnVolver);
		btnVolver.setToolTipText("Para volver a la pantalla de inicio pulse Volver.");
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Escondemos el botón registrarse
				
				btnRegistrarse.setVisible(false);
				
				//Activamos campos para registro del usuario:
				
				campoRegistro();	
				
				
			}
		});
		btnRegistrarse.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		panelSur.add(btnRegistrarse);
		btnRegistrarse.setToolTipText("Si no tiene un usuario o contraseña presione Registrarse.");
		
		JButton btnAcceder = new JButton("Acceder");	
		btnAcceder.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					registroAcceso();
				}
			}
		});

		btnAcceder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registroAcceso();
			}	
		});
		btnAcceder.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		panelSur.add(btnAcceder);
		btnAcceder.setToolTipText("Una vez introducidos el nombre de usuario y la contraseña pulse para entrar al programa.");
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(281, 108, 130, 26);
		panelCentro.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblUsuario.setBounds(208, 113, 61, 16);
		panelCentro.add(lblUsuario);
		
		lblContra = new JLabel("Contraseña:");
		lblContra.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblContra.setBounds(185, 164, 84, 16);
		panelCentro.add(lblContra);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					registroAcceso();
				}
			}
		});
		txtContrasenia.setBounds(281, 159, 130, 26);
		panelCentro.add(txtContrasenia);
		
		//Por defecto los parametros a partir de este punto seran invisibles y estaran desabilitados. Para activarlos -> método campoRegistro()
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setEnabled(false);
		lblNombre.setVisible(false);
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNombre.setBounds(208, 15, 61, 16);
		panelCentro.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setVisible(false);
		txtNombre.setBounds(281, 10, 130, 26);
		panelCentro.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblDNI = new JLabel("DNI:");
		lblDNI.setEnabled(false);
		lblDNI.setVisible(false);
		lblDNI.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblDNI.setBounds(228, 62, 41, 16);
		panelCentro.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setEnabled(false);
		txtDNI.setVisible(false);
		txtDNI.setBounds(281, 57, 130, 26);
		panelCentro.add(txtDNI);
		txtDNI.setColumns(10);
		txtDNI.setToolTipText("Introduzca el DNI con el siguiente formato: 00000000A");
		
		lblEdad = new JLabel("Edad: ");
		lblEdad.setEnabled(false);
		lblEdad.setVisible(false);
		lblEdad.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblEdad.setBounds(228, 248, 41, 16);
		panelCentro.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setEnabled(false);
		txtEdad.setVisible(false);
		txtEdad.setBounds(281, 243, 130, 26);
		panelCentro.add(txtEdad);
		txtEdad.setColumns(10);
		
		lblRepitaContrasea = new JLabel("Repita contraseña: ");
		lblRepitaContrasea.setEnabled(false);
		lblRepitaContrasea.setVisible(false);
		lblRepitaContrasea.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblRepitaContrasea.setBounds(139, 210, 130, 16);
		panelCentro.add(lblRepitaContrasea);
		
		txtContra2 = new JPasswordField();
		txtContra2.setEnabled(false);
		txtContra2.setVisible(false);
		txtContra2.setBounds(281, 205, 130, 26);
		panelCentro.add(txtContra2);
		
		JLabel label = new JLabel("?");
		label.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(512, 260, 61, 26);
		panelCentro.add(label);
		label.setToolTipText("Introduzca su usuario y contraseña. Si no esta registrado, pulse el botón de registrarse");
		
	}
	
	
	/**
	 * Método para desactivar los campos de registro
	 */
	private void camposDisableados(){
		lblNombre.setEnabled(false);
		lblDNI.setEnabled(false);
		lblEdad.setEnabled(false);
		txtNombre.setEnabled(false);
		txtDNI.setEnabled(false);
		txtEdad.setEnabled(false);
		txtContra2.setEnabled(false);
		lblRepitaContrasea.setEnabled(false);
	}
	
	/**
	 * Método para activar los campos de registro:
	 */
	private void campoRegistro(){
		
		activado=true;
		estaRegistrandose=true;
		
		lblNombre.setEnabled(true);
		lblDNI.setEnabled(true);
		lblEdad.setEnabled(true);
		txtNombre.setEnabled(true);
		txtDNI.setEnabled(true);
		txtEdad.setEnabled(true);
		txtContra2.setEnabled(true);
		lblRepitaContrasea.setEnabled(true);
		
		lblNombre.setVisible(true);
		lblDNI.setVisible(true);
		lblEdad.setVisible(true);
		txtNombre.setVisible(true);
		txtDNI.setVisible(true);
		txtEdad.setVisible(true);
		txtContra2.setVisible(true);
		lblRepitaContrasea.setVisible(true);
		
	}
	
	
	/**
	 * Método para vaciar los campos
	 */
	private void vaciarCampos(){
		
		txtNombre.setText("");
		txtDNI.setText("");
		txtEdad.setText("");
		txtContra2.setText("");
		txtContrasenia.setText("");
		txtUsuario.setText("");
	}
	
	private void vaciarCamposContrasenia(){
		txtContra2.setText("");
		txtContrasenia.setText("");
	}
	
	private void registroAcceso(){
		
		VentanaLogin vl =this;
		
		//Una vez clickado el botón acceder:
		// 1. Comprobamos que los datos estén bien
		// 2. Pasamos a la siguiente ventana  
	
		//Comprobamos que ningún campo esta vacío:
		
		String txtNom = txtNombre.getText();
		String txtDni = txtDNI.getText();
		String txtContr1 = txtContrasenia.getText();
		String txtContr2 = txtContra2.getText();
		String txtEd = txtEdad.getText();
		String txtUsu = txtUsuario.getText();
		boolean haEntrado=false;
		
		//Si activado esta en true significa que es un nuevo registro
		
		if(activado==true){
			//Nuevo registro para la base de datos
			haEntrado=false;
			//1- Comprobamos que todos los campos estan escritos
			
			if(txtDni.equals("")||txtNom.equals("")||txtUsu.equals("")||txtContr1.equals("")||txtContr2.equals("")||txtEd.equals("") ){
				JOptionPane.showMessageDialog(null, "No se pueden dejar campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
				//Si ha escrito algo en uno de los campos los borramos
				vaciarCampos();
				haEntrado=true;
			}
			
			//2-Comprobamos que los campos tienen un tipo de datos correcto
			
			/* DNI: length = 9
			 * Edad: 0-140
			 */
			
			else if(txtDni.length()!=9 || isNumeric(txtDni.substring(0, 7))==false || isNumeric(txtDni.substring(8))==true){
				//DNI de tamaño 9, numeros del 0 al 7, letra el 8
				JOptionPane.showMessageDialog(null, "Formato de DNI incorrecto. Por favor, introduzca un DNI que siga el siguiente formato: 00000000A", "ERROR", JOptionPane.ERROR_MESSAGE);
				txtDNI.setText("");
				haEntrado=true;
			}
			
			else if(VentanaLogin.bd.dniUsado(txtDni)==true){
				//Significa que el DNI ya esta siendo usado --> Salta un error
				JOptionPane.showMessageDialog(null, "El DNI ya está siendo usado. No puede usar ese DNI.\nSi consideras que es un error póngase en contacto con el administrador del programa", "Error", JOptionPane.ERROR_MESSAGE);
				vaciarCampos();
				haEntrado=true;
			}
			
			else if(txtEd.startsWith("-")){ //Descartamos los numeros negativos
				JOptionPane.showMessageDialog(null, "Edad incorrecta. No se puede tener una edad negativa");
				txtEdad.setText("");
				haEntrado=true;
			}
			
			else if(txtEd.length()==1 || txtEd.startsWith("1") && !(txtEd.endsWith("8") || txtEd.endsWith("9"))){ //Descartamos a niñ@s menores de 18 años
				JOptionPane.showMessageDialog(null, "Para usar este programa hay que tener al menos 18 años");
				txtEdad.setText("");
				haEntrado=true;
			}
			
			//3- Comprobamos que el usuario no existe
			Usuario u = bd.obtenerUsuario(txtUsu);
			if(u!=null){
				JOptionPane.showMessageDialog(null, "El nombre de usuario escogido ya existe. Por favor, introduzca otro nombre de usuario", "Error", JOptionPane.ERROR_MESSAGE);
				txtUsuario.setText("");
				haEntrado=true;
			}
			
			
			//4- Comprobamos que las contraseñas coinciden entre sí
			
			else if(!txtContr1.equals(txtContr2)){
				JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
				vaciarCamposContrasenia(); //Vaciamos sólo los campos de contraseñas
				haEntrado=true;
			}
			
			//5- registramos el nuevo usuario en la base de datos:
			else if(haEntrado==false){
					//b.insertarNuevoUsuario(u);
					bd.insertarNuevoUsuario(txtNombre.getText(),txtDNI.getText(),txtUsuario.getText(),txtContrasenia.getText(),Integer.parseInt(txtEdad.getText()));
					JOptionPane.showMessageDialog(null, "Bienvenido al programa "+txtNom);
					
					String nombre = bd.nombreUsuario(txtUsu);
					
					VentanaMenuUsuario v = new VentanaMenuUsuario(nombre);
					v.setVisible(true);
					vl.dispose();
			}	
			
		}else{
			//Usuario que existe en la base de datos
			
			//1- Comprobamos que los campos de usuario y contraseña estan escritos
			
			if(txtUsu.equals("")|| txtContr1.equals("")){
				JOptionPane.showMessageDialog(null, "No se pueden dejar campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
				//Si ha escrito algo en un campo lo borramos
				vaciarCampos();
			}
			
			
			//2- Comprobamos que el usuario existe en la base de datos
			u = bd.obtenerUsuario(txtUsu);
			if(u==null){
				JOptionPane.showMessageDialog(null, "El nombre de usuario escogido no existe. Por favor, regístrese", "Error", JOptionPane.ERROR_MESSAGE);
				txtUsuario.setText("");
				txtContrasenia.setText("");
			}else{
				//Cuando se registra satisfactoriamente
				
				//Si el usuario se trata del administrador abrimos una ventana a la que solo pueden acceder los administradores
				if(txtUsu.equals(usuAdmin) && txtContr1.equals(VentanaLogin.bd.obtenerContraAdmin())){
						VentanaAdministrador va= new VentanaAdministrador();
						va.setVisible(true);
						vl.dispose();
						u.esAdmin=true;
				}
				
				else if(txtContr1.equals(bd.contraseniaUsuario(txtUsu))){
				
					String nombre = bd.nombreUsuario(txtUsu);
					
				JOptionPane.showMessageDialog(null, "Bienvenido " +nombre, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
				
				//Aquí pasamos a la siguiente ventana

				VentanaMenuUsuario v = new VentanaMenuUsuario(nombre);
				v.setVisible(true);
				vl.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "DATOS INCORRECTOS", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		
	
	}
	
	/**
	 * Método que comprueba si el texto seleccionado es un número
	 * Sacado de: http://www.aprenderaprogramar.com/foros/index.php?topic=809.0
	 * @param str
	 * @return true si es un número, false si no lo es
	 */
	 public static boolean isNumeric(String str) {
	        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
	    }
}
