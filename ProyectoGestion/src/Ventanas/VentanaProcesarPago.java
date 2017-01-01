package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class VentanaProcesarPago extends JFrame implements Runnable {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public VentanaProcesarPago() {
		setTitle("Proceso de Pago\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estamos procesando su pago espere unos segundos por favor...\n");
		lblNewLabel.setBounds(16, 23, 417, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Salir\n");
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 13));
		btnNewButton.setBounds(244, 243, 140, 29);
		contentPane.add(btnNewButton);
		
		JButton btnMostrarFactura = new JButton("Mostrar Factura");
		btnMostrarFactura.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 13));
		btnMostrarFactura.setBounds(51, 243, 181, 29);
		contentPane.add(btnMostrarFactura);
		
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
