package Ventanas;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Data.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

/**
 * Ventana que muestra al administrador la información de los clientes del programa
 * @author Javier Rivero y Aitor Santamaria
 *
 */
public class VentanaMisClientes extends JFrame {

	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelEste ;
	private JTextArea txtReservas;
	private JTextField txtUsuModif;
	private JButton btnCambios;
	private JTextField txtNombre;
	private JTextField txtDNI1;
	private JTextField txtUsuario;
	private JPasswordField txtContra;
	private JTextField txtEdad;
	private JLabel lblNombre,lblDni, lblUsuario, lblContrasenia, lblEdad;
	private JLabel lblInfo;
	private boolean esNuevo=false;

	/**
	 * Create the frame.
	 */
	public VentanaMisClientes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.CYAN);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblAContinuacinSe = new JLabel("A continuación se muestran todos los clientes:");
		lblAContinuacinSe.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblAContinuacinSe.setHorizontalAlignment(SwingConstants.LEFT);
		panelNorte.add(lblAContinuacinSe);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		VentanaMisClientes vmr = this;
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					VentanaAdministrador va = new VentanaAdministrador();
					va.setVisible(true);
					vmr.dispose();
				}
		});
		panelSur.add(btnVolver);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem()=="Eliminar"){
					btnCambios.setText("Eliminar");
					txtUsuModif.setEditable(true);
					panelEste.setVisible(false);
					btnCambios.setEnabled(true);
					txtUsuModif.setToolTipText("Introduzca el nombre del usuario que desee eliminar");
				}else if(comboBox.getSelectedItem()=="Añadir"){
					panelEste.setVisible(true);
					btnCambios.setText("Añadir");
					txtUsuModif.setText("");
					txtUsuModif.setToolTipText("Introduzca los datos en la parte de la derecha");
					txtUsuModif.setEditable(false);
					lblInfo.setText("Introduzca todos los datos aquí");
					btnCambios.setEnabled(true);
				}else{
					btnCambios.setText("--");
					panelEste.setVisible(false);
					txtUsuModif.setEditable(false);
					btnCambios.setEnabled(false);
					txtUsuModif.setToolTipText("");
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Eliminar", "Añadir"}));
		panelSur.add(comboBox);
		
		JLabel lblCdigo = new JLabel("Usuario: ");
		lblCdigo.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		panelSur.add(lblCdigo);
		
		txtUsuModif = new JTextField();
		txtUsuModif.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		txtUsuModif.setEditable(false);
		panelSur.add(txtUsuModif);
		txtUsuModif.setColumns(10);
		
		btnCambios = new JButton("--");
		btnCambios.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnCambios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(btnCambios.getText()=="Eliminar"){
					//Si el comboBox es eliminar eliminamos el usuario de la base de datos
					
					//Pero primero comprobamos que no sea el administrador, porque ese no se puede eliminar
					
					if(txtUsuModif.getText().equals("admin123")){
						JOptionPane.showMessageDialog(null, "No se puede eliminar al usuario administrador","ERROR",JOptionPane.ERROR_MESSAGE);
						txtUsuModif.setText("");
					}else{
					
					VentanaLogin.bd.eliminarEvento(txtUsuModif.getText()); //Tenemos que borrar tambien los eventos del usuario
					VentanaLogin.bd.eliminarCliente(txtUsuModif.getText()); 
					txtUsuModif.setText("");
					
					//Volvemos a sacar en pantalla todos los usuarios, sin el que acabamos de quitar
					ArrayList<String> a = VentanaLogin.bd.mostrarClientes();
					txtReservas.setText(String.format("%20s%20s%20s%15s\n","NOMBRE","DNI","USUARIO","EDAD"));
					for(int i=0;i<a.size();i++){
						txtReservas.append(a.get(i));
					}
					txtUsuModif.setText("");
					}
					
				}if(btnCambios.getText()=="Añadir"){
					//Insertamos el nuevo usuario en la base de datos
					esNuevo=true;
					insertarEnBD();
				
					//Volvemos a sacar en pantalla todos los usuarios, añadiendo el nuevo
					ArrayList<String> a = VentanaLogin.bd.mostrarClientes();
					txtReservas.setText(String.format("%20s%20s%20s%15s\n","NOMBRE","DNI","USUARIO","EDAD"));
					for(int i=0;i<a.size();i++){
						txtReservas.append(a.get(i));
					}
					txtUsuModif.setText("");
					
				}
			}
		});
		panelSur.add(btnCambios);
		btnCambios.setEnabled(false);
		
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		panelEste.setLayout(new GridLayout(11, 1, 0, 0));
		panelEste.setVisible(false);
		
		lblInfo = new JLabel("New label");
		lblInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		panelEste.add(lblInfo);
		
		lblNombre = new JLabel("Nombre:");
		panelEste.add(lblNombre);
		
		txtNombre = new JTextField();
		panelEste.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblDni = new JLabel("DNI: ");
		panelEste.add(lblDni);
		
		txtDNI1 = new JTextField();
		panelEste.add(txtDNI1);
		txtDNI1.setColumns(10);
		
		lblUsuario = new JLabel("Usuario:");
		panelEste.add(lblUsuario);
		
		txtUsuario = new JTextField();
		panelEste.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblContrasenia = new JLabel("Contraseña: ");
		panelEste.add(lblContrasenia);
		
		txtContra = new JPasswordField();
		panelEste.add(txtContra);
		txtContra.setColumns(10);
		
		lblEdad = new JLabel("Edad: ");
		panelEste.add(lblEdad);
		
		txtEdad = new JTextField();
		panelEste.add(txtEdad);
		txtEdad.setColumns(10);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtReservas = new JTextArea();
		txtReservas.setFont(new Font("Consolas", Font.PLAIN, 13));
		txtReservas.setEditable(false);
		panelCentro.add(txtReservas);
		txtReservas.setColumns(75);
		
		//Anyadimos scroll a la ventana para que se vean todos los campos
		JScrollPane scroll = new JScrollPane(txtReservas);    
        //scroll.setBounds(new Rectangle(30,30,100,200));                                                    
        vmr.getContentPane().add(scroll);                   
        

        //Si el usuario es el administrador tenemos que mostrar la información de todos las reservas de los usuarios
		
			ArrayList<String> a = VentanaLogin.bd.mostrarClientes();
			txtReservas.setText(String.format("%20s%20s%20s%15s\n","NOMBRE","DNI","USUARIO","EDAD"));
			for(int i=0;i<a.size();i++){
				txtReservas.append(a.get(i));
			}
	
	}
		
	public void insertarEnBD(){
		boolean haEntrado = false;
		String nom = txtNombre.getText();
		String dniA = txtDNI1.getText();
		String usu = txtUsuario.getText();
		String con = txtContra.getText();
		String eda = txtEdad.getText();
		
		//Comprobamos que todos los campos están escritos
		if(nom.equals("") || dniA.equals("") || usu.equals("") || con.equals("")|| eda.equals("")){
			JOptionPane.showMessageDialog(null, "No se pueden dejar campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
			vaciarCampos();
			haEntrado=true;
		}
		//Comprobaciones de edad y DNI
		else if(dniA.length()!=9 || isNumeric(dniA.substring(0, 7))==false || isNumeric(dniA.substring(8))==true){
			//DNI de tamaño 9, numeros del 0 al 7, letra el 8
			JOptionPane.showMessageDialog(null, "Formato de DNI incorrecto. Por favor, introduzca un DNI que siga el siguiente formato: 00000000A", "ERROR", JOptionPane.ERROR_MESSAGE);
			txtDNI1.setText("");
			haEntrado=true;
		}

		else if(VentanaLogin.bd.dniUsado(dniA)==true){
			//Significa que el DNI ya está siendo usado --> Salta un error
			JOptionPane.showMessageDialog(null, "El DNI ya está siendo usado. No puede usar ese DNI.\nSi consideras que es un error póngase en contacto con el administrador del programa", "Error", JOptionPane.ERROR_MESSAGE);
			vaciarCampos();
			haEntrado=true;
		}
		
		else if(eda.startsWith("-")){ //Descartamos los numeros negativos
			JOptionPane.showMessageDialog(null, "Edad incorrecta. No se puede tener una edad negativa", "Error", JOptionPane.ERROR_MESSAGE);
			txtEdad.setText("");
			haEntrado=true;
		}
		
		else if(eda.length()==1 || eda.startsWith("1") && !(eda.endsWith("8") || eda.endsWith("9"))){ //Descartamos a niñ@s menores de 18 años
			JOptionPane.showMessageDialog(null, "Para usar este programa hay que tener al menos 18 años", "Error", JOptionPane.ERROR_MESSAGE);
			txtEdad.setText("");
			haEntrado=true;
		}
		
		//3- Comprobamos que el usuario no existe
		Usuario u = VentanaLogin.bd.obtenerUsuario(usu);
		if(u!=null && esNuevo==true){
			JOptionPane.showMessageDialog(null, "El nombre de usuario escogido ya existe. Por favor, introduzca otro nombre de usuario", "Error", JOptionPane.ERROR_MESSAGE);
			txtUsuario.setText("");
			haEntrado=true;
		}else if(haEntrado==false && esNuevo==true){
		//4- registramos el nuevo usuario en la base de datos:
			VentanaLogin.bd.insertarNuevoUsuario(txtNombre.getText(),txtDNI1.getText(),txtUsuario.getText(),txtContra.getText(),Integer.parseInt(txtEdad.getText()));
			JOptionPane.showMessageDialog(null, "Usuario registrado satisfactoriamente","Correcto", JOptionPane.INFORMATION_MESSAGE);
			vaciarCampos();
			
		}
	}
	
	private void vaciarCampos(){
		txtNombre.setText("");
		txtDNI1.setText("");
		txtUsuario.setText("");
		txtContra.setText("");
		txtEdad.setText("");
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
