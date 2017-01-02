package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BasesDeDatos.BD;
import Data.Evento;
import Data.Usuario;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMisReservas extends JFrame {

	private JPanel contentPane;
	private JTextField txtReservas;
	private String nomUsuario;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMisReservas frame = new VentanaMisReservas();
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
	public VentanaMisReservas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.CYAN);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblAContinuacinSe = new JLabel("A continuación se muestran todas las reservas:");
		lblAContinuacinSe.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblAContinuacinSe.setHorizontalAlignment(SwingConstants.LEFT);
		panelNorte.add(lblAContinuacinSe);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		VentanaMisReservas vmr = this;
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMenuUsuario vmu = new VentanaMenuUsuario(nomUsuario);
				vmu.setVisible(true);
				vmr.dispose();
			}
		});
		panelSur.add(btnVolver);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtReservas = new JTextField();
		txtReservas.setEditable(false);
		panelCentro.add(txtReservas);
		txtReservas.setColumns(10);
		
	
	}

}
