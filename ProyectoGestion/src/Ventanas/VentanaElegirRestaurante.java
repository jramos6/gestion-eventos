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

import Data.Restaurante;

import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class VentanaElegirRestaurante extends JFrame {

	private JPanel contentPane;
	private JFrame ventanaAnterior;
	
	public VentanaElegirRestaurante(JFrame va) {
		setResizable(false);
		ventanaAnterior=va;
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
				
				va.setVisible(true);
				ver.dispose();

			}
		});
		btnAtras.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 13));
		panel_1.add(btnAtras);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		ArrayList<Restaurante> a=null;
		a = VentanaLogin.bd.consultaLista();
		DefaultListModel dlm = new DefaultListModel();
		for(Restaurante r: a){
			dlm.addElement(r.toString());
		}
		JList list = new JList(dlm);
		panel_4.add(list);
	
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2){
		        	new VentanaRestaurante();
	        		ver.dispose();
	        	
		        }
			}
		});
	}
	
}
	
