package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Ventana que da la opción de cambiar la contraseña al administrador del programa
 * @author Javier Rivero y Aitor Santamaria
 *
 */
public class VentanaCambiarContrasenya extends JFrame {

	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordFieldContraActual;
	private JPasswordField passwordFieldNuevaContra1;
	private JPasswordField passwordFieldNuevaContra2;

	/**
	 * Create the frame.
	 */
	public VentanaCambiarContrasenya() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelN = new JPanel();
		panelN.setBackground(Color.CYAN);
		contentPane.add(panelN, BorderLayout.NORTH);
		
		JLabel lblCambioDeContrasea = new JLabel("Cambio de contraseña del administrador: ");
		lblCambioDeContrasea.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		panelN.add(lblCambioDeContrasea);
		
		JPanel panelS = new JPanel();
		contentPane.add(panelS, BorderLayout.SOUTH);
		
		VentanaCambiarContrasenya vcc =this;
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaAdministrador va = new VentanaAdministrador();
				va.setVisible(true);
				vcc.dispose();
			}
		});

		panelS.add(btnVolver);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				String contraActual = passwordFieldContraActual.getText();
				String contraNueva1 = passwordFieldNuevaContra1.getText();
				String contraNueva2 = passwordFieldNuevaContra2.getText();
			
				//Comprobamos que no hay espacios vacios
				if(passwordFieldContraActual.getText().equals("") || passwordFieldNuevaContra1.getText().equals("") || passwordFieldNuevaContra2.getText().equals("")){
					JOptionPane.showMessageDialog(null, "No se pueden dejar campos en blanco", "ERROR", JOptionPane.ERROR_MESSAGE);
					vaciarCampos();
				}
				
				//Comprobamos que la contraseña actual es correcta
				
				else if(!contraActual.equals(VentanaLogin.bd.obtenerContraAdmin())){		
					JOptionPane.showMessageDialog(null, "Contraseña actual incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
					vaciarCampos();
				}
				
				//Comprobamos que las dos contraseñas nuevas coinciden
				else if(!contraNueva1.equals(contraNueva2)){
					JOptionPane.showMessageDialog(null, "Las nuevas contraseñas no coinciden", "ERROR", JOptionPane.ERROR_MESSAGE);
					vaciarCampos();
				}else{
				
				//Actualizamos la contraseña del administrador en la base de datos
				VentanaLogin.bd.actualizarContraAdmin(contraNueva1);
				JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente");
				}
			}
		});
		
		panelS.add(btnAceptar);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelRelleno1 = new JPanel();
		panel.add(panelRelleno1);
		
		JPanel panelRelleno2 = new JPanel();
		panel.add(panelRelleno2);
		
		JLabel lblContrasenyaActual = new JLabel("Contraseña actual: ");
		panel.add(lblContrasenyaActual);
		
		passwordFieldContraActual = new JPasswordField();
		panel.add(passwordFieldContraActual);
		
		JLabel lblNuevaContrasenya = new JLabel("Nueva contraseña: ");
		panel.add(lblNuevaContrasenya);
		
		passwordFieldNuevaContra1 = new JPasswordField();
		panel.add(passwordFieldNuevaContra1);
		
		JLabel lblRepetirContrasenya = new JLabel("Repetir contraseña: ");
		panel.add(lblRepetirContrasenya);
		
		passwordFieldNuevaContra2 = new JPasswordField();
		panel.add(passwordFieldNuevaContra2);
		
		JPanel panelRelleno4 = new JPanel();
		panel.add(panelRelleno4);
		
		JPanel panelRelleno3 = new JPanel();
		panel.add(panelRelleno3);
	}

	public void vaciarCampos(){
		passwordFieldContraActual.setText("");
		passwordFieldNuevaContra1.setText("");
		passwordFieldNuevaContra2.setText("");
	}
	
}
