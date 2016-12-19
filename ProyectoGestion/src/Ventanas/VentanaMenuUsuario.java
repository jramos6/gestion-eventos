package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sqlite.core.DB;

import BasesDeDatos.BD;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMenuUsuario extends JFrame {

	private JPanel contentPane;
	private String nomUsuario;
	/**
	 * Create the frame.
	 */
	public VentanaMenuUsuario(String nomUsuario) {
		this.nomUsuario=nomUsuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.CYAN);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		
		
		JLabel lblHola = new JLabel("Hola, "+nomUsuario);
		lblHola.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		panelNorte.add(lblHola);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(0, 3, 0, 0));
		
		JFrame vmu=this;
		JButton btnCerrarSesin = new JButton("Cerrar sesión");
		btnCerrarSesin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Volvemos al login
				VentanaLogin vl = new VentanaLogin();
				vl.setVisible(true);
				vmu.dispose();
			}
		});
		panelSur.add(btnCerrarSesin);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(3, 0, 0, 0));
		
		JButton btnNuevaReserva = new JButton("Nueva reserva");
		btnNuevaReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				VentanaEventos ve = new VentanaEventos();
				ve.setVisible(true);
				vmu.dispose();
				}
		});
		btnNuevaReserva.setBackground(Color.WHITE);
		panelCentro.add(btnNuevaReserva);
		
		JButton btnMisReservas = new JButton("Mis reservas");
		btnMisReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO Sacar la información referente a las reservas del usuario
				
			}
		});
		panelCentro.add(btnMisReservas);
		
		JButton btnCalendario = new JButton("Calendario");
		panelCentro.add(btnCalendario);
	}

}
