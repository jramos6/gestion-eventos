package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class VentanaLogin extends JFrame {

	private JPanel contentPane, pnlNorte, panelSur;
	private JTextField txtUsuario;
	private JPasswordField txtContrasenia;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField txtEdad;
	private JLabel lblUsuario, lblContra, lblNombre, lblEdad, lblDNI;
	private JLabel lblRepitaContrasea;
	private JPasswordField txtContra2;
	private boolean activado=false;
	private boolean estaRegistrandose=false;
	public static BD b;
	

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		b = new BD();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Una vez clickado el botón acceder:
				// 1. Comprobamos que los datos estén bien
				// 2. Pasamos a la siguiente ventana  
			
				//Comprobamos que ningún campo está vacío:
				
				String txtNom = txtNombre.getText();
				String txtDni = txtDNI.getText();
				String txtContr1 = txtContrasenia.getText();
				String txtContr2 = txtContra2.getText();
				String txtEd = txtEdad.getText();
				String txtUsu = txtUsuario.getText();
				
				//Si activado esta en true significa que es un nuevo registro
				
				if(activado==true){
					//Nuevo registro para la base de datos
					
					//1- Comprobamos que todos los campos estan escritos
					
					if(txtDni.equals("")||txtNom.equals("")||txtUsu.equals("")||txtContr1.equals("")||txtContr2.equals("")||txtEd.equals("") ){
						JOptionPane.showMessageDialog(null, "No se pueden dejar campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
						//Si ha escrito algo en uno de los campos los borramos
						vaciarCampos();
					}
					
					//2-Comprobamos que los campos tienen un tipo de datos correcto
					
					/* DNI: length = 9
					 * Edad: 0-140
					 */
					
					if(txtDni.length()!=9){ //DNI de tamaño 9
						JOptionPane.showMessageDialog(null, "Formato de DNI incorrecto. Por favor, introduzca un DNI que siga el siguiente formato: 12345678A");
						txtEdad.setText("");
					}
					
					if(txtEd.startsWith("-")){ //Descartamos los numeros negativos
						JOptionPane.showMessageDialog(null, "Edad incorrecta. No se puede tener una edad negativa");
						txtEdad.setText("");
					}
					
					if(txtEd.length()==1 || txtEd.startsWith("1") && !(txtEd.endsWith("8") || txtEd.endsWith("9"))){ //Descartamos a niñ@s menores de 18 años
						JOptionPane.showMessageDialog(null, "Para usar este programa hay que tener al menos 18 años");
						txtEdad.setText("");
					}
					
					//3- Comprobamos que el usuario no existe
					Usuario u = BD.obtenerUsuario(txtUsu);
					if(u!=null){
						JOptionPane.showMessageDialog(null, "El nombre de usuario escogido ya existe. Por favor, introduzca otro nombre de usuario", "Error", JOptionPane.ERROR_MESSAGE);
						txtUsuario.setText("");
					}
					
					
					//4- Comprobamos que las contraseñas coinciden entre sí
					
					if(!txtContr1.equals(txtContr2)){
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
						vaciarCamposContrasenia(); //Vaciamos sólo los campos de contraseñas
					}
					
					//5- registramos el nuevo usuario en la base de datos:
			 
							//b.insertarNuevoUsuario(u);
							b.insertarNuevoUsuario(txtNombre.getText(),txtDNI.getText(),txtUsuario.getText(),txtContrasenia.getText(),Integer.parseInt(txtEdad.getText()));
					
				}else{
					//Usuario que existe en la base de datos
					
					//1- Comprobamos que los campos de usuario y contraseña estan escritos
					
					if(txtUsu.equals("")|| txtContr1.equals("")){
						JOptionPane.showMessageDialog(null, "No se pueden dejar campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
						//Si ha escrito algo en un campo lo borramos
						vaciarCampos();
					}
					
					
					//2- Comprobamos que el usuario existe en la base de datos
					Usuario u = BD.obtenerUsuario(txtUsu);
					if(u==null){
						JOptionPane.showMessageDialog(null, "El nombre de usuario escogido no existe. Por favor, regístrese", "Error", JOptionPane.ERROR_MESSAGE);
						txtUsuario.setText("");
						txtContrasenia.setText("");
					}else{
						//Cuando se registra satisfactoriamente 
						
						JOptionPane.showMessageDialog(null, "Bienvenido " +txtUsuario.getText(), "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
						
						//Aquí pasamos a la siguiente ventana

						VentanaMenuUsuario v = new VentanaMenuUsuario();
						v.setVisible(true);
						vl.dispose();
					}
				}
	
				
			}
		});
		btnAcceder.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		panelSur.add(btnAcceder);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(190, 74, 130, 26);
		panelCentro.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblUsuario.setBounds(117, 79, 61, 16);
		panelCentro.add(lblUsuario);
		
		lblContra = new JLabel("Contraseña:");
		lblContra.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblContra.setBounds(94, 113, 84, 16);
		panelCentro.add(lblContra);
		
		JButton button = new JButton("?");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Para continuar introduzca el usuario y la contraseña. Si no está registrado regístrese.", "Información", JOptionPane.INFORMATION_MESSAGE);
			}

		});
		button.setForeground(new Color(255, 0, 0));
		button.setBackground(new Color(255, 255, 255));
		button.setBounds(403, 168, 31, 29);
		panelCentro.add(button);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(190, 108, 130, 26);
		panelCentro.add(txtContrasenia);
		
		//Por defecto los parámetros a partir de este punto serán invisibles y estarán desabilitados. Para activarlos -> método campoRegistro()
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setEnabled(false);
		lblNombre.setVisible(false);
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNombre.setBounds(117, 15, 61, 16);
		panelCentro.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setVisible(false);
		txtNombre.setBounds(190, 10, 130, 26);
		panelCentro.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblDNI = new JLabel("DNI:");
		lblDNI.setEnabled(false);
		lblDNI.setVisible(false);
		lblDNI.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblDNI.setBounds(137, 46, 41, 16);
		panelCentro.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setEnabled(false);
		txtDNI.setVisible(false);
		txtDNI.setBounds(190, 41, 130, 26);
		panelCentro.add(txtDNI);
		txtDNI.setColumns(10);
		
		lblEdad = new JLabel("Edad: ");
		lblEdad.setEnabled(false);
		lblEdad.setVisible(false);
		lblEdad.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblEdad.setBounds(137, 173, 41, 16);
		panelCentro.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setEnabled(false);
		txtEdad.setVisible(false);
		txtEdad.setBounds(190, 168, 130, 26);
		panelCentro.add(txtEdad);
		txtEdad.setColumns(10);
		
		lblRepitaContrasea = new JLabel("Repita contraseña: ");
		lblRepitaContrasea.setEnabled(false);
		lblRepitaContrasea.setVisible(false);
		lblRepitaContrasea.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblRepitaContrasea.setBounds(48, 146, 130, 16);
		panelCentro.add(lblRepitaContrasea);
		
		txtContra2 = new JPasswordField();
		txtContra2.setEnabled(false);
		txtContra2.setVisible(false);
		txtContra2.setBounds(190, 141, 130, 26);
		panelCentro.add(txtContra2);
		
		
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

}
