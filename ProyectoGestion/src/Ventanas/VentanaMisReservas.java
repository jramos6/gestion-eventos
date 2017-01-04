package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import BasesDeDatos.BD;
import Data.Evento;
import Data.Usuario;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;

public class VentanaMisReservas extends JFrame {

	private JPanel contentPane;
	private JTextArea txtReservas;
	private String nomUsuario;
	

	/**
	 * Create the frame.
	 */
	public VentanaMisReservas(String nombre) {
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
		
		txtReservas = new JTextArea();
		txtReservas.setFont(new Font("Consolas", Font.PLAIN, 13));
		txtReservas.setEditable(false);
		panelCentro.add(txtReservas);
		txtReservas.setColumns(100);
		
		//Anyadimos scroll a la ventana para que se vean todos los campos
		JScrollPane scroll = new JScrollPane(txtReservas);    
        scroll.setBounds(new Rectangle(30,30,100,200));                                                    
        vmr.add(scroll);                   
        vmr.show(true);  
		
		//Mostramos todas las reservas del usuario, sacando la informacion almacenada en la base de datos
		ArrayList<String> a = VentanaLogin.bd.mostrarEventos(nombre);
		txtReservas.setText(String.format("%10s%10s%15s%10s%15s%15s%15s%15s%20s\n","USUARIO","PRECIO","INVITADOS","CODIGO","ACTIVIDAD","FECHA","COD_MUSICA","COD_BAILE","ESPACIO"));
		for(int i=0;i<a.size();i++){
			txtReservas.append(a.get(i));
		}
		
	}

}
