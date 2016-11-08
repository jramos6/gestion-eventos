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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		BD BD = new BD();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnlNorte = new JPanel();
		pnlNorte.setBackground(Color.CYAN);
		contentPane.add(pnlNorte, BorderLayout.NORTH);
		
		JLabel lblParaContinuar = new JLabel("Para continuar introduzca los datos:");
		lblParaContinuar.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblParaContinuar.setBackground(Color.CYAN);
		pnlNorte.add(lblParaContinuar);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		panelSur.add(btnVolver);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Activamos campos para registro del usuario:
				
				campoRegistro();
				
				//Una vez clickado el botón aceptar:
				// 1. Comprobamos que los datos estén bien
				// 2. Pasamos a la siguiente ventana TODO 
			
				//Comprobamos que ningún campo está vacío:
				
				String txtNom = txtNombre.getText();
				String txtDni = txtDNI.getText();
				String txtContr1 = txtContrasenia.getText();
				String txtContr2 = txtContra2.getText();
				String txtEd = txtEdad.getText();
				String txtUsu = txtUsuario.getText();
				
				
				if(activado==true){
					if(txtNom.equals("") || txtDni.equals("") || txtContr1.equals("") || txtContr2.equals("") || txtEd.equals("") || txtUsu.equals("")){
						JOptionPane.showMessageDialog(null, "Error! No se pueden dejar campos en blanco", "Error!", JOptionPane.ERROR_MESSAGE);
						vaciarCampos();
					}
				}else{
					if(txtUsu.equals("") || txtContr1.equals("")){
						JOptionPane.showMessageDialog(null, "Error! No es posible dejar campos en blanco", "Error!", JOptionPane.ERROR_MESSAGE);
						vaciarCampos();
					}
				}
				
				
				//Comprobamos que el usuario no está repetido (mirando en la BD) TODO
				Usuario u = BD.obtenerUsuario(txtUsu);
				
				
				
				//Comprobamos que las dos contraseñas coincidan (en caso de registro)
				
				if(activado==true){
					if(!txtContr1.equals(txtContr2)){
						JOptionPane.showMessageDialog(null, "Error! Las contraseñas no coinciden", "Error!", JOptionPane.ERROR_MESSAGE);
						vaciarCamposContrasenia();
					}
					
				}
				
				
				//Comprobamos que la edad sea positiva (en caso de registro) 
				
				
				
				
			}
		});
		btnRegistrarse.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		panelSur.add(btnRegistrarse);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Una vez clickado el botón aceptar:
				// 1. Comprobamos que los datos estén bien
				// 2. Pasamos a la siguiente ventana  
			
				//Comprobamos que ningún campo está vacío:
				
				String txtNom = txtNombre.getText();
				String txtDni = txtDNI.getText();
				String txtContr1 = txtContrasenia.getText();
				String txtContr2 = txtContra2.getText();
				String txtEd = txtEdad.getText();
				String txtUsu = txtUsuario.getText();
				
				
				if(activado==true){
					if(txtNom.equals("") || txtDni.equals("") || txtContr1.equals("") || txtContr2.equals("") || txtEd.equals("") || txtUsu.equals("")){
						JOptionPane.showMessageDialog(null, "Error! No se pueden dejar campos en blanco", "Error!", JOptionPane.ERROR_MESSAGE);
						vaciarCampos();
					}
				}else{
					if(txtUsu.equals("") || txtContr1.equals("")){
						JOptionPane.showMessageDialog(null, "Error! No es posible dejar campos en blanco", "Error!", JOptionPane.ERROR_MESSAGE);
						vaciarCampos();
					}
				}
				
				
				//Comprobamos que el usuario está en la BD 
				
				Usuario u = BD.obtenerUsuario(txtUsu);
				
				if (u == null) {
					JOptionPane.showMessageDialog(null, "Lo sentimos, el usuario no está registrado en la Base de Datos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					campoRegistro();
				} else if (!u.getContras().equals(txtContr1)) {
					JOptionPane.showMessageDialog(null, "Lo sentimos, la contraseña es incorrecta", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					// new ABRIR UNA NUEVA VENTANA (LA SIGUIENTE A ESTA) TODO
					//ventana.dispose();
				}
			
				
				//Comprobamos que las dos contraseñas coincidan (en caso de registro)
				
				if(activado==true){
					if(!txtContr1.equals(txtContr2)){
						JOptionPane.showMessageDialog(null, "Error! Las contraseñas no coinciden", "Error!", JOptionPane.ERROR_MESSAGE);
						vaciarCamposContrasenia();
					}
					
				}
				
				
				//Comprobamos que la edad sea positiva (en caso de registro) TODO (preguntar como se hace...)
				
				
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
	 * Método para activar los campos de registro:
	 */
	private void campoRegistro(){
		
		activado=true;
		
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
