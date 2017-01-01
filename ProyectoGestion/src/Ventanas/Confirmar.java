package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class Confirmar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String nomRdbtn;
	private JLabel lblFormaPago;
	private JLabel lblTarjeta;
	private JLabel lblCuenta;
	private JTextField textFieldTarjeta;
	private JTextField textField_Banc1;
	private JTextField textField_Banc2;
	private JTextField textField_Banc3;
	private JTextField textField_Banc4;


	/**
	 * Create the dialog.
	 */
	public Confirmar(String nomRdbtn) {
		this.nomRdbtn=nomRdbtn;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 450, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		final JDialog vc=this;
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 239, 450, 39);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VentanaProcesarPago vp= new VentanaProcesarPago();
						vp.setVisible(true);
						vc.dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VentanaEscogerPago vep= new VentanaEscogerPago();
						vep.setVisible(true);
						vc.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel lblFormaPago = new JLabel("HAS SELECCIONADO LA FORMA DE PAGO: \n"+nomRdbtn);
		if(nomRdbtn.equals("rdbtnTarjeta")){
			
			lblTarjeta.setEnabled(true);
			textFieldTarjeta.setEnabled(true);

			lblCuenta.setEnabled(false);
			textField_Banc1.setEnabled(false);
			textField_Banc2.setEnabled(false);
			textField_Banc3.setEnabled(false);
			textField_Banc4.setEnabled(false);

			
		}else if(nomRdbtn.equalsIgnoreCase("Banco")){
			
			lblTarjeta.setEnabled(false);
			textFieldTarjeta.setEnabled(false);

			
			
			lblCuenta.setEnabled(true);
			textField_Banc1.setEnabled(true);
			textField_Banc2.setEnabled(true);
			textField_Banc3.setEnabled(true);
			textField_Banc4.setEnabled(true);

			
			
		}else{
			
		}
		lblFormaPago.setBounds(38, 18, 299, 16);
		getContentPane().add(lblFormaPago);
		
		{
			JLabel lblTarjeta = new JLabel("Introduzca numero de tarjeta:");
			lblTarjeta.setEnabled(false);
			lblTarjeta.setBounds(38, 60, 234, 16);
			getContentPane().add(lblTarjeta);
		}
		
		textFieldTarjeta = new JTextField();
		textFieldTarjeta.setEnabled(false);
		textFieldTarjeta.setBounds(240, 55, 130, 26);
		getContentPane().add(textFieldTarjeta);
		textFieldTarjeta.setColumns(10);
		
		JLabel lblCuenta = new JLabel("Introduzca numero de la cuenta bancaria:");
		lblCuenta.setEnabled(false);
		lblCuenta.setBounds(39, 100, 279, 16);
		getContentPane().add(lblCuenta);
		
		textField_Banc1 = new JTextField();
		textField_Banc1.setEnabled(false);
		textField_Banc1.setBounds(38, 131, 83, 26);
		getContentPane().add(textField_Banc1);
		textField_Banc1.setColumns(10);
		
		textField_Banc2 = new JTextField();
		textField_Banc2.setEnabled(false);
		textField_Banc2.setBounds(133, 131, 83, 26);
		getContentPane().add(textField_Banc2);
		textField_Banc2.setColumns(10);
		
		textField_Banc3 = new JTextField();
		textField_Banc3.setEnabled(false);
		textField_Banc3.setColumns(10);
		textField_Banc3.setBounds(228, 131, 83, 26);
		getContentPane().add(textField_Banc3);
		
		textField_Banc4 = new JTextField();
		textField_Banc4.setEnabled(false);
		textField_Banc4.setColumns(10);
		textField_Banc4.setBounds(320, 131, 83, 26);
		getContentPane().add(textField_Banc4);
	}
}

