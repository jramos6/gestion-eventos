package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaAdministrador extends JFrame {

	private JPanel contentPane;
	private String numInvitados, nomUsuario;
	private String actividad;
	
	/**
	 * Create the frame.
	 */
	public VentanaAdministrador() {
		setResizable(false);
		setTitle("Ventana Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		VentanaAdministrador va = this;
		JButton btnCerrarSesin = new JButton("Cerrar sesión");
		btnCerrarSesin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				VentanaLogin vl = new VentanaLogin();
				vl.setVisible(true);
				va.dispose();
				
			}
		});
		panelSur.add(btnCerrarSesin);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelIzd = new JPanel();
		panelCentro.add(panelIzd);
		panelIzd.setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton btnActualizarEspacios = new JButton("Actualizar espacios");
		panelIzd.add(btnActualizarEspacios);
		
		JButton btnModificarUsuarios = new JButton("Modificar usuarios");
		btnModificarUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMisClientes vmc = new VentanaMisClientes();
				vmc.setVisible(true);
				va.dispose();
				
			}
		});
		panelIzd.add(btnModificarUsuarios);
		
		JButton btnEstadsticas = new JButton("Mostrar todas las reservas");
		btnEstadsticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMisReservas vmr = new VentanaMisReservas(nomUsuario);
				vmr.setVisible(true);
				va.dispose();
			}
		});
		panelIzd.add(btnEstadsticas);
		
		JPanel panelBloqueo = new JPanel();
		panelIzd.add(panelBloqueo);
		panelBloqueo.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JButton btnBloquearAplicacin = new JButton("BLOQUEAR");
		btnBloquearAplicacin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				VentanaBloqueo vb = new VentanaBloqueo();
				vb.setVisible(true);
				va.dispose();
				
				
				
			}
		});
		panelBloqueo.add(btnBloquearAplicacin);
		btnBloquearAplicacin.setForeground(Color.RED);
		btnBloquearAplicacin.setBackground(Color.WHITE);
		
		JPanel panelDrch = new JPanel();
		panelCentro.add(panelDrch);
		panelDrch.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnCalendario = new JButton("Calendario");
		btnCalendario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaCalendario vc = new VentanaCalendario(numInvitados, nomUsuario, false, actividad);
				vc.setVisible(true);
				va.dispose();
				
			}
		});
		panelDrch.add(btnCalendario);
		
		JButton btnMusicaBaile = new JButton("Editar música-baile");
		btnMusicaBaile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaEditarMB vemb = new VentanaEditarMB();
				vemb.setVisible(true);
				va.dispose();
			}
		});
		panelDrch.add(btnMusicaBaile);
		
		JButton btnVerEventos = new JButton("Ver eventos");
		panelDrch.add(btnVerEventos);
	}
}
