package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sqlite.core.DB;

import BasesDeDatos.BD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMenuUsuario extends JFrame {

	private JPanel contentPane;
	private String nombre;
	private String numInvitados;
	private String actividad;
	
	/**
	 * Create the frame.
	 */
	public VentanaMenuUsuario(String nombre) {
		setResizable(false);
		this.nombre=nombre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.CYAN);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		
		
		JLabel lblHola = new JLabel("Hola, "+nombre);
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
		panelCentro.setBackground(Color.BLUE);
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(3, 0, 0, 0));
		
		JButton btnNuevaReserva = new JButton("Nueva reserva");
		btnNuevaReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaEventos ve = new VentanaEventos(nombre,true);
				ve.setVisible(true);
				vmu.dispose();
				}
		});
		btnNuevaReserva.setBackground(java.awt.Color.YELLOW);
		panelCentro.add(btnNuevaReserva);
		
		JButton btnMisReservas = new JButton("Mis reservas");
		btnMisReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMisReservas vmr = new VentanaMisReservas(nombre);
				vmr.setVisible(true);
				vmu.dispose();
			}
		});
		panelCentro.add(btnMisReservas);
		
		JButton btnCalendario = new JButton("Calendario");
		btnCalendario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaCalendario vc = new VentanaCalendario(numInvitados, nombre, false, actividad);
				vc.setVisible(true);
				vmu.dispose();
			}
		});
		panelCentro.add(btnCalendario);
	}

}
