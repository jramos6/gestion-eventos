package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;


public class Confirmar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblFormaPago, lblTarjeta, lblCuenta;
	private JTextField textFieldTarjeta,textField_Banc1, textField_Banc2, textField_Banc3, textField_Banc4;
	private JTextField textField_Banc5;
	private int longit=4;
	private boolean dentro=false;
	private boolean esElFinal=false;

	/**
	 * Create the dialog.
	 */
	public Confirmar(String numInvitados, String nombre, long precioFinal, int anio, int mes, int dia, String seleccion) {
		setResizable(false);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 450, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		final JDialog vc=this;
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(133, 333, 450, 39);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane);
		
		Confirmar c = this;
		JButton okButton = new JButton("Aceptar");
		okButton.setEnabled(false);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(seleccion.equals("Tarjeta de credito")){	
					String numTarjeta = textFieldTarjeta.getText();
					//Comprobamos si tiene 16 numeros
					if(numTarjeta.length()!=16){
						JOptionPane.showMessageDialog(null, "Número de tarjeta incorrecto. Introduzca el número con 16 cifras, sin espacios", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else{
						if(isNumeric(numTarjeta)==true){ //Comprobamos que tenga solo caracteres numéricos
							VentanaBarraProgreso vbp = new VentanaBarraProgreso(nombre);
							vbp.setVisible(true);

							Timer t = new Timer(13000, new ActionListener() { // Usamos esto para cerrar la ventana una vez hayan pasado 13 segundos (cuando la barra de progreso haya acabado)
																				
								@Override
								public void actionPerformed(ActionEvent e) {
									c.dispose();
								}
							});
							t.start();
						}else{
							JOptionPane.showMessageDialog(null, "Número incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
							textFieldTarjeta.setText("");
						}
					
					}
				}else if(seleccion.equals("Transferencia bancaria")){
					
					
					if(isNumeric(textField_Banc1.getText())==false){
						textField_Banc1.setBackground(Color.red);
						textField_Banc1.setForeground(Color.white);
						dentro=true;
					}if(isNumeric(textField_Banc2.getText())==false){
						textField_Banc2.setBackground(Color.red);
						textField_Banc2.setForeground(Color.white);
						dentro=true;
					}if(isNumeric(textField_Banc3.getText())==false){
						textField_Banc3.setBackground(Color.red);
						textField_Banc3.setForeground(Color.white);
						dentro=true;
					}if(isNumeric(textField_Banc4.getText())==false){
						textField_Banc4.setBackground(Color.red);
						textField_Banc4.setForeground(Color.white);
						dentro=true;
					}if(isNumeric(textField_Banc5.getText())==false){
						textField_Banc5.setBackground(Color.red);
						textField_Banc5.setForeground(Color.white);
						dentro=true;
					}if(dentro==true){
							JOptionPane.showMessageDialog(null, "Introduzca solamente números", "ERROR", JOptionPane.ERROR_MESSAGE);
					
					Timer ti = new Timer(2000, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							textField_Banc1.setBackground(Color.white);
							textField_Banc1.setForeground(Color.black);
							textField_Banc2.setBackground(Color.white);
							textField_Banc2.setForeground(Color.black);
							textField_Banc3.setBackground(Color.white);
							textField_Banc3.setForeground(Color.black);
							textField_Banc4.setBackground(Color.white);
							textField_Banc4.setForeground(Color.black);
							textField_Banc5.setBackground(Color.white);
							textField_Banc5.setForeground(Color.black);
							ponemosEnBlanco();
							okButton.setEnabled(false);
						}
					});ti.start(); 
					ti.setRepeats(false); //Con este método hacemos que el timer solo se active cuando se tenga que activar, y no que esté activado todo el rato
					
				}
					if (dentro == false) {
						VentanaBarraProgreso vbp = new VentanaBarraProgreso(nombre);
						vbp.setVisible(true);

						Timer t = new Timer(13000, new ActionListener() { // Usamos esto para cerrar la ventana una vez hayan pasado 13 segundos (cuando la barra de progreso haya acabado)
																			
							@Override
							public void actionPerformed(ActionEvent e) {
								c.dispose();
							}
						});
						t.start();
					}
					
				}
				dentro=false;
				
			}
			});
			
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEscogerPago vep= new VentanaEscogerPago(numInvitados, nombre, anio, mes, dia, precioFinal);
				vep.setVisible(true);
				vc.dispose();
			}
		});
		
		buttonPane.add(cancelButton);
				
		
		buttonPane.add(okButton);
		
	
		
		
		lblFormaPago = new JLabel("HAS SELECCIONADO LA FORMA DE PAGO: "+seleccion);
	
		
		lblFormaPago.setBounds(38, 18, 498, 16);
		getContentPane().add(lblFormaPago);
		
		
		JLabel lblTarjeta = new JLabel("Introduzca número de tarjeta:");
		lblTarjeta.setEnabled(false);
		lblTarjeta.setBounds(38, 136, 234, 16);
		getContentPane().add(lblTarjeta);
		
		
		textFieldTarjeta = new JTextField();
		textFieldTarjeta.setFont(new Font("Consolas", Font.PLAIN, 14));
		textFieldTarjeta.setToolTipText("16 dígitos sin espacios");
		textFieldTarjeta.setEnabled(false);
		textFieldTarjeta.setBounds(275, 131, 130, 26);
		getContentPane().add(textFieldTarjeta);
		textFieldTarjeta.setColumns(10);
		
		JLabel lblCuenta = new JLabel("Introduzca número de la cuenta bancaria:");
		lblCuenta.setEnabled(false);
		lblCuenta.setBounds(38, 189, 279, 16);
		getContentPane().add(lblCuenta);
		
		textField_Banc1 = new JTextField();
		textField_Banc1.setFont(new Font("Consolas", Font.PLAIN, 14));
		textField_Banc1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Banc1.addKeyListener(new KeyAdapter() {
			@Override
			//Cada vez que escriba el usuario una letra comprobamos que en total ha escrito menos de longit caracteres (4)
			public void keyTyped(KeyEvent e) {
				if (textField_Banc1.getText().length()==longit){
				    e.consume(); //Cuando se cumple la condición no permite que se inserten más números
					textField_Banc1.transferFocus(); //Y salta a la siguiente celda
				}
			}
		});
		textField_Banc1.setEnabled(false);
		textField_Banc1.setBounds(38, 239, 83, 26);
		getContentPane().add(textField_Banc1);
		textField_Banc1.setColumns(4);
		
		textField_Banc2 = new JTextField();
		textField_Banc2.setFont(new Font("Consolas", Font.PLAIN, 14));
		textField_Banc2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Banc2.addKeyListener(new KeyAdapter() {
			@Override
			//Cada vez que escriba el usuario una letra comprobamos que en total ha escrito menos de longit caracteres (4)
			public void keyTyped(KeyEvent e) {
				if (textField_Banc2.getText().length()==longit){
				    e.consume(); //Cuando se cumple la condición no permite que se inserten más números
					textField_Banc2.transferFocus(); //Y salta a la siguiente celda
				}
			}
		});
		textField_Banc2.setEnabled(false);
		textField_Banc2.setBounds(133, 239, 83, 26);
		getContentPane().add(textField_Banc2);
		textField_Banc2.setColumns(10);
		
		textField_Banc3 = new JTextField();
		textField_Banc3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Banc3.setFont(new Font("Consolas", Font.PLAIN, 14));
		textField_Banc3.addKeyListener(new KeyAdapter() {
			@Override
			//Cada vez que escriba el usuario una letra comprobamos que en total ha escrito menos de longit caracteres (4)
			public void keyTyped(KeyEvent e) {
				if (textField_Banc3.getText().length()==longit){
				    e.consume(); //Cuando se cumple la condición no permite que se inserten más números
					textField_Banc3.transferFocus(); //Y salta a la siguiente celda
				}
			}
		});
		textField_Banc3.setEnabled(false);
		textField_Banc3.setColumns(10);
		textField_Banc3.setBounds(228, 239, 83, 26);
		getContentPane().add(textField_Banc3);
		
		textField_Banc4 = new JTextField();
		textField_Banc4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Banc4.setFont(new Font("Consolas", Font.PLAIN, 14));
		textField_Banc4.addKeyListener(new KeyAdapter() {
			@Override
			//Cada vez que escriba el usuario una letra comprobamos que en total ha escrito menos de longit caracteres (4)
			public void keyTyped(KeyEvent e) {
				if (textField_Banc4.getText().length()==longit){
				    e.consume(); //Cuando se cumple la condición no permite que se inserten más números
					textField_Banc4.transferFocus(); //Y salta a la siguiente celda
				}
			}
		});
		textField_Banc4.setEnabled(false);
		textField_Banc4.setColumns(10);
		textField_Banc4.setBounds(322, 239, 83, 26);
		getContentPane().add(textField_Banc4);
		
		JLabel lblPrecioFinal = new JLabel("Precio final: ");
		lblPrecioFinal.setBounds(38, 78, 83, 16);
		getContentPane().add(lblPrecioFinal);
		
		JLabel lblPrecioFinalMasIva = new JLabel("New label");
		lblPrecioFinalMasIva.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblPrecioFinalMasIva.setBounds(119, 76, 123, 16);
		getContentPane().add(lblPrecioFinalMasIva);
		lblPrecioFinalMasIva.setText(""+(precioFinal)+" €");
		
		textField_Banc5 = new JTextField();
		textField_Banc5.setFont(new Font("Consolas", Font.PLAIN, 14));
		textField_Banc5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Banc5.addKeyListener(new KeyAdapter() {
			@Override
			//Cada vez que escriba el usuario una letra comprobamos que en total ha escrito menos de longit caracteres (4)
			public void keyTyped(KeyEvent e) {
				if (textField_Banc5.getText().length()== longit){
				    e.consume(); //Cuando se cumple la condición no permite que se inserten más números
					okButton.setEnabled(true);
					okButton.setToolTipText("");
					
				}
			}
		});
		textField_Banc5.setEnabled(false);
		textField_Banc5.setBounds(417, 239, 83, 26);
		getContentPane().add(textField_Banc5);
		textField_Banc5.setColumns(10);
		
		if(seleccion.equals("Tarjeta de credito")){	
			okButton.setToolTipText("Introduzca los 16 dígitos para continuar");
			lblTarjeta.setEnabled(true);
			textFieldTarjeta.setEnabled(true);
			lblCuenta.setEnabled(false);
			textField_Banc1.setEnabled(false);
			textField_Banc2.setEnabled(false);
			textField_Banc3.setEnabled(false);
			textField_Banc4.setEnabled(false);
			textField_Banc5.setEnabled(false);
			textField_Banc1.setVisible(false);
			textField_Banc2.setVisible(false);
			textField_Banc3.setVisible(false);
			textField_Banc4.setVisible(false);
			textField_Banc5.setVisible(false);
			textFieldTarjeta.setVisible(true);
			okButton.setEnabled(true);
			lblCuenta.setVisible(false);
			lblTarjeta.setVisible(true);
			
		}else if(seleccion.equals("Transferencia bancaria")){
			okButton.setToolTipText("Introduzca los 20 dígitos para continuar");
			lblTarjeta.setEnabled(false);
			textFieldTarjeta.setEnabled(false);
			lblCuenta.setEnabled(true);
			textField_Banc1.setEnabled(true);
			textField_Banc2.setEnabled(true);
			textField_Banc3.setEnabled(true);
			textField_Banc4.setEnabled(true);
			textField_Banc5.setEnabled(true);
			textFieldTarjeta.setVisible(false);
			textField_Banc1.setVisible(true);
			textField_Banc2.setVisible(true);
			textField_Banc3.setVisible(true);
			textField_Banc4.setVisible(true);
			textField_Banc5.setVisible(true);
			lblCuenta.setVisible(true);
			lblTarjeta.setVisible(false);
			
		}else{
			okButton.setEnabled(false);
			textField_Banc1.setVisible(false);
			textField_Banc2.setVisible(false);
			textField_Banc3.setVisible(false);
			textField_Banc4.setVisible(false);
			textField_Banc5.setVisible(false);
			textFieldTarjeta.setVisible(false);
			lblCuenta.setVisible(false);
			lblTarjeta.setVisible(false);
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
	 
	 /**
	  * Método para vaciar los campos de texto
	  */
	 public void ponemosEnBlanco(){
			textField_Banc1.setText("");
			textField_Banc2.setText("");
			textField_Banc3.setText("");
			textField_Banc4.setText("");
			textField_Banc5.setText("");
	 }

}

