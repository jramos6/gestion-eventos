package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Font;


public class Confirmar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblFormaPago, lblTarjeta, lblCuenta;
	private JTextField textFieldTarjeta,textField_Banc1, textField_Banc2, textField_Banc3, textField_Banc4;
	

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
			
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaProcesarPago vp= new VentanaProcesarPago();
				vp.setVisible(true);
				vc.dispose();
				
				}
			});
				
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEscogerPago vep= new VentanaEscogerPago(nombre, numInvitados, anio, mes, dia, precioFinal);
				vep.setVisible(true);
				vc.dispose();
			}
		});
		//cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
				
		//okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		//getRootPane().setDefaultButton(okButton);
	
		
		
		lblFormaPago = new JLabel("HAS SELECCIONADO LA FORMA DE PAGO: \n"+seleccion);
	
		
		lblFormaPago.setBounds(38, 18, 498, 16);
		getContentPane().add(lblFormaPago);
		
		
		JLabel lblTarjeta = new JLabel("Introduzca numero de tarjeta:");
		lblTarjeta.setEnabled(false);
		lblTarjeta.setBounds(38, 136, 234, 16);
		getContentPane().add(lblTarjeta);
		
		
		textFieldTarjeta = new JTextField();
		textFieldTarjeta.setEnabled(false);
		textFieldTarjeta.setBounds(275, 131, 130, 26);
		getContentPane().add(textFieldTarjeta);
		textFieldTarjeta.setColumns(10);
		
		JLabel lblCuenta = new JLabel("Introduzca numero de la cuenta bancaria:");
		lblCuenta.setEnabled(false);
		lblCuenta.setBounds(38, 189, 279, 16);
		getContentPane().add(lblCuenta);
		
		textField_Banc1 = new JTextField();
		textField_Banc1.setEnabled(false);
		textField_Banc1.setBounds(38, 239, 83, 26);
		getContentPane().add(textField_Banc1);
		textField_Banc1.setColumns(10);
		
		textField_Banc2 = new JTextField();
		textField_Banc2.setEnabled(false);
		textField_Banc2.setBounds(133, 239, 83, 26);
		getContentPane().add(textField_Banc2);
		textField_Banc2.setColumns(10);
		
		textField_Banc3 = new JTextField();
		textField_Banc3.setEnabled(false);
		textField_Banc3.setColumns(10);
		textField_Banc3.setBounds(228, 239, 83, 26);
		getContentPane().add(textField_Banc3);
		
		textField_Banc4 = new JTextField();
		textField_Banc4.setEnabled(false);
		textField_Banc4.setColumns(10);
		textField_Banc4.setBounds(322, 239, 83, 26);
		getContentPane().add(textField_Banc4);
		
		JLabel lblPrecioFinal = new JLabel("Precio final: ");
		lblPrecioFinal.setBounds(38, 78, 96, 16);
		getContentPane().add(lblPrecioFinal);
		
		JLabel lblPrecioFinalMasIva = new JLabel("New label");
		lblPrecioFinalMasIva.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblPrecioFinalMasIva.setBounds(133, 78, 123, 16);
		getContentPane().add(lblPrecioFinalMasIva);
		lblPrecioFinalMasIva.setText(""+(precioFinal+(precioFinal*0.21))+" €"); //Al precio se le suma el 21 % de IVA
		
		if(seleccion.equals("Tarjeta de credito")){	
			lblTarjeta.setEnabled(true);
			textFieldTarjeta.setEnabled(true);
			lblCuenta.setEnabled(false);
			textField_Banc1.setEnabled(false);
			textField_Banc2.setEnabled(false);
			textField_Banc3.setEnabled(false);
			textField_Banc4.setEnabled(false);

			
		}else if(seleccion.equals("Transferencia bancaria")){
			
			lblTarjeta.setEnabled(false);
			textFieldTarjeta.setEnabled(false);

			
			
			lblCuenta.setEnabled(true);
			textField_Banc1.setEnabled(true);
			textField_Banc2.setEnabled(true);
			textField_Banc3.setEnabled(true);
			textField_Banc4.setEnabled(true);

			
			
		}
		
		
	}
}

