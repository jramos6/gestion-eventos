package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BasesDeDatos.BD;
import Data.PanelCal;
import Data.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCalendario extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaCalendario(String numInvitados) {
		setResizable(false);
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
		
		VentanaCalendario vc = this;
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TODO ESTO NO FUNCIONA: TENEMOS QUE CONSEGUIR QUE EL USUARIO SEA EL QUE HEMOS METIDO, Y NO UNO NUEVO
				
				
				
				if(VentanaLogin.u.esAdmin==true){
					VentanaAdministrador va = new VentanaAdministrador();
					va.setVisible(true);
					vc.dispose();
				}	
				//Si el usuario no es un administrador
				else{
					VentanaEventos ve = new VentanaEventos();
					ve.setVisible(true);
					vc.dispose();
				}
				
			}
			
		});
		panelSur.add(btnVolver);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEspacio vs = new VentanaEspacio(numInvitados);
				vs.setVisible(true);
				vc.dispose();
			}
		});
		panelSur.add(btnAceptar);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		//Se abre un calendario en la ventana
		panelCentro.add(new PanelCal(),BorderLayout.CENTER);
	}

}
