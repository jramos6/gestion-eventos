package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

import java.awt.GridLayout;
import java.awt.JobAttributes;
import java.awt.TrayIcon.MessageType;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaEscoger extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumInvitados;


	/**
	 * Create the frame.
	 */
	public VentanaEscoger(String numInvitados) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.CYAN);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblEscojaServiciosAdicionales = new JLabel("Escoja servicios adicionales");
		panelNorte.add(lblEscojaServiciosAdicionales);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		VentanaEscoger vs = this;
		JButton btnCerrarSesin = new JButton("Cerrar Sesión");
		btnCerrarSesin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Hasta la próxima");
				
				VentanaLogin vl = new VentanaLogin();
				vl.setVisible(true);
				vs.dispose();
			}
		});
		panelSur.add(btnCerrarSesin);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaEventos ve = new VentanaEventos();
				ve.setVisible(true);
				vs.dispose();
			}
		});
		panelSur.add(btnVolver);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.WEST);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 1, 0, 0));
		
		/**
		 * Al pulsar el botón se abrirá la ventana de comida
		 */
		JButton btnComida = new JButton("Comida");
		VentanaEscoger ve=this;
		btnComida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				VentanaComida vc = new VentanaComida(numInvitados);
				vc.setVisible(true);
				ve.dispose();
			}
		});
		panelCentro.add(btnComida);
		
		/**
		 * Al pulsar el botón se abrirá la ventana de música
		 */
		JButton btnMsica = new JButton("Música");
		btnMsica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMusica vm = new VentanaMusica(numInvitados);
				vm.setVisible(true);
				ve.dispose();
				
			}
		});
		panelCentro.add(btnMsica);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Página en construcción, disculpe las molestias");
			}
		});
		panelCentro.add(btnPagar);
	}
	
	public JTextField getTxtNumInvitados() {
		return txtNumInvitados;
	}
	
	public void setTxtNumInvitados(JTextField txtNumInvitados) {
		this.txtNumInvitados = txtNumInvitados;
	}
}
