package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BasesDeDatos.BD;
import Data.PanelCal;
import Data.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VentanaCalendario extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public VentanaCalendario(String numInvitados, String nombre, boolean estaEnElMenuUsuario, String actividad) {
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
				
				//TODO TENEMOS QUE COMPROBAR SI VIENE DEL MENU DE USUARIOS, PORQUE SI ES ASÍ TIENE QUE VOLVER A ESE MENÚ, NO A LA PÁGINA DE RESERVAS (parecido a lo del admin)
				
				if(VentanaLogin.u.esAdmin==true){
					VentanaAdministrador va = new VentanaAdministrador();
					va.setVisible(true);
					vc.dispose();
				}	
				//Si el usuario no es un administrador
				else{
					
					if(estaEnElMenuUsuario==true){
						VentanaEventos ve = new VentanaEventos(nombre,true);
						ve.setVisible(true);
						vc.dispose();
					}else{
						VentanaMenuUsuario vmu = new VentanaMenuUsuario(nombre);
						vmu.setVisible(true);
						vc.dispose();
					}
					
					
				}
				
			}
			
		});
		panelSur.add(btnVolver);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		//Se abre un calendario en la ventana
		PanelCal pc = new PanelCal();
		panelCentro.add(pc,BorderLayout.CENTER);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				java.util.Date fecha = new Date();
				
				int anioActual = fecha.getYear()+2000-100;
				int mesActual = fecha.getMonth()+1;
				int diaActual = fecha.getDay()+1;
				int fechaActual = anioActual*10000+mesActual*100+diaActual;
				int fechaCompleta = (pc.anio*10000)+(pc.mes*100)+(pc.dia);
				
				if(fechaCompleta==0){
					JOptionPane.showMessageDialog(null, "Elija una opción, por favor", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				//Comprobamos que la fecha sea mayor a la actual
				else if(fechaCompleta<fechaActual){			
					JOptionPane.showMessageDialog(null,"Introduzca una fecha que no haya pasado", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					VentanaEspacio vs = new VentanaEspacio(numInvitados, nombre,pc.anio,pc.mes,pc.dia, actividad);
					vs.setVisible(true);
					vc.dispose();
				}
				
			}
		});
		panelSur.add(btnAceptar);
		
		if(estaEnElMenuUsuario==false){
			btnAceptar.setVisible(false);
		}
		

	}

}
