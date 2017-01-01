package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaElegirRestaurante extends JFrame {

	private JPanel contentPane;
	private String nomUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaElegirRestaurante frame = new VentanaElegirRestaurante();
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
	public VentanaElegirRestaurante() {
		setTitle("Haga Su Eleccion ;)");
		setForeground(new Color(0, 0, 128));
		setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblRestaurantesDisponibles = new JLabel("Restaurantes Disponibles:");
		lblRestaurantesDisponibles.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		panel.add(lblRestaurantesDisponibles);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		final JFrame ver=this;
		JButton btnAtras = new JButton("Atras ");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaComida vc= new VentanaComida(nomUsuario);
				vc.setVisible(true);
				ver.dispose();

			}
		});
		btnAtras.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 13));
		panel_1.add(btnAtras);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		
		List list_Restaurantes = new List();
		panel_4.add(list_Restaurantes);
		
		// (hay que crear la tabla restaurante y hacer metodo en la clase BD 
		//que saque todos los restaurantes -> SELECT * FROM RESTAURANTE...) 
	}

}