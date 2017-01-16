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
	private JTextField txtCodigo;
	

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
				
				if(VentanaLogin.u.esAdmin==true){
					VentanaAdministrador va = new VentanaAdministrador();
					va.setVisible(true);
					vmr.dispose();
				}else{
					VentanaMenuUsuario vmu = new VentanaMenuUsuario(nombre);
					vmu.setVisible(true);
					vmr.dispose();
				
				}
				
				}
		});
		panelSur.add(btnVolver);
		
		JLabel lblIntroduzcaElCdigo = new JLabel("Introduzca el código:");
		panelSur.add(lblIntroduzcaElCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setToolTipText("Código de la reserva a eliminar");
		panelSur.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Eliminamos la reserva escogida con el método de la base de datos
				int codigo = Integer.parseInt(txtCodigo.getText());
				VentanaLogin.bd.eliminarEventoCodigo(codigo);
				
				//Volvemos a mostrar la lista actualizada en pantalla
				ArrayList<String> a = VentanaLogin.bd.mostrarTodosLosEventos();
				txtReservas.setText(String.format("%10s%10s%15s%10s%15s%15s%15s%15s%30s%20s%20s%20s%10s\n","USUARIO","PRECIO","INVITADOS","CODIGO","ACTIVIDAD","FECHA","COD_MUSICA","COD_BAILE","ESPACIO","NUM_MENU","CATERING","CAFES_INFUSIONES","VINOS"));
				for(int i=0;i<a.size();i++){ 
					txtReservas.append(a.get(i));
				}
			}
		});
		panelSur.add(btnEliminar);
		
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
        vmr.getContentPane().add(scroll);                   
        

        //Si el usuario es el administrador tenemos que mostrar la información de todos las reservas de los usuarios
		if(VentanaLogin.u.esAdmin==true){
			ArrayList<String> a = VentanaLogin.bd.mostrarTodosLosEventos();
			txtReservas.setText(String.format("%10s%10s%15s%10s%15s%15s%15s%15s%30s%20s%20s%20s%10s\n","USUARIO","PRECIO","INVITADOS","CODIGO","ACTIVIDAD","FECHA","COD_MUSICA","COD_BAILE","ESPACIO","NUM_MENU","CATERING","CAFES_INFUSIONES","VINOS"));
			for(int i=0;i<a.size();i++){ 
				txtReservas.append(a.get(i));
			}
			txtCodigo.setVisible(true);
			lblIntroduzcaElCdigo.setVisible(true);
			btnEliminar.setVisible(true);
			
			
			
		}else{
			//Mostramos todas las reservas del usuario (único), sacando la informacion almacenada en la base de datos
			ArrayList<String> a = VentanaLogin.bd.mostrarEventos(nombre);
			txtReservas.setText(String.format("%10s%10s%15s%10s%15s%15s%15s%15s%30s%20s%20s%20s%10s\n","USUARIO","PRECIO","INVITADOS","CODIGO","ACTIVIDAD","FECHA","COD_MUSICA","COD_BAILE","ESPACIO","NUM_MENU","CATERING","CAFES_INFUSIONES","VINOS"));
			for(int i=0;i<a.size();i++){
				txtReservas.append(a.get(i));
			}
			txtCodigo.setVisible(false);
			lblIntroduzcaElCdigo.setVisible(false);
			btnEliminar.setVisible(false);
		}
		
      
      
		
	}

}
