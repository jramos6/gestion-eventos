package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;

public class VentanaEscogerPago extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEscogerPago frame = new VentanaEscogerPago();
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
	public VentanaEscogerPago() {
		setTitle("Pago");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Especifique la forma de pago deseada:");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(35, 34, 331, 16);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnMetalico = new JRadioButton("En Metalico");
		rdbtnMetalico.setBounds(72, 76, 141, 23);
		contentPane.add(rdbtnMetalico);
		
		
		
		JRadioButton rdbtnTarjeta = new JRadioButton("Con Tarjeta de credito\n\n\n\n\n");
		rdbtnTarjeta.setBounds(72, 111, 204, 23);
		contentPane.add(rdbtnTarjeta);
		
		JRadioButton rdbtnTransferenciaBancaria = new JRadioButton("Transferencia Bancaria");
		rdbtnTransferenciaBancaria.setBounds(72, 146, 189, 23);
		contentPane.add(rdbtnTransferenciaBancaria);
		
		if(rdbtnMetalico.isSelected()==true){
			
			Confirmar c1= new Confirmar(null);
			
	
		}
		else if(rdbtnTarjeta.isSelected()==true){
			
			Confirmar c2= new Confirmar(null);
		}
		else 
		{
			Confirmar c3= new Confirmar(null);
		}
	

		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 13));
		btnAtras.setBounds(310, 193, 117, 29);
		contentPane.add(btnAtras);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 13));
		btnNewButton.setBounds(310, 234, 117, 29);
		contentPane.add(btnNewButton);
	}
}
