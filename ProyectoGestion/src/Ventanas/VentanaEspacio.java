package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.Espacios;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaEspacio extends JFrame {

	private JPanel contentPane;
	private String espacio;
	private JRadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5,radioButton6,radioButton7;
	private JLabel lblPre1,lblPre2,lblPre3,lblPre4,lblPre5,lblPre6,lblPre7;
	private long precioFinal;

	/**
	 * Create the frame.
	 */
	public VentanaEspacio(String numInvitados, String nombre, int anio, int mes, int dia) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelN = new JPanel();
		panelN.setBackground(Color.CYAN);
		contentPane.add(panelN, BorderLayout.NORTH);
		
		JLabel lblEspaciosDisponiblesPara = new JLabel("Espacios disponibles para el día escogido:");
		lblEspaciosDisponiblesPara.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		panelN.add(lblEspaciosDisponiblesPara);
		
		JPanel panelS = new JPanel();
		contentPane.add(panelS, BorderLayout.SOUTH);
		
		VentanaEspacio vs = this;
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaCalendario vc = new VentanaCalendario(numInvitados, nombre,true);
				vc.setVisible(true);
				vs.dispose();
			}
		});
		panelS.add(btnVolver);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Ponemos el booleano de el espacio elegido en true, para que la siguiente vez aparezca como reservado
				
				Espacios es = new Espacios();
				
				if(radioButton1.isSelected()){
					es.comedorGrande=true;
					precioFinal=precioFinal+200;
					siguienteVentana(numInvitados, vs, nombre, anio, mes, dia, precioFinal, "Comedor Grande");
				}else if(radioButton2.isSelected()){
					es.comedorMediano=true;
					precioFinal=precioFinal+150;
					siguienteVentana(numInvitados, vs, nombre, anio, mes, dia, precioFinal, "Comedor Mediano");
				}else if(radioButton3.isSelected()){
					es.comedorPequenio=true;
					precioFinal=precioFinal+50;
					siguienteVentana(numInvitados, vs, nombre, anio, mes, dia, precioFinal, "Comedor Pequeño");
				}else if(radioButton4.isSelected()){
					es.reunionGrande=true;
					precioFinal=precioFinal+50;
					siguienteVentana(numInvitados, vs, nombre, anio, mes, dia, precioFinal, "Sala de reuniones grande");
				}else if(radioButton5.isSelected()){
					es.reunionPequenio=true;
					precioFinal=precioFinal+20;
					siguienteVentana(numInvitados, vs, nombre, anio, mes, dia, precioFinal, "Sala de reuniones pequeña");
				}else if(radioButton6.isSelected()){
					es.musicaGrande=true;
					precioFinal=precioFinal+60;
					siguienteVentana(numInvitados, vs, nombre, anio, mes, dia, precioFinal, "Sala de música grande");
				}else if(radioButton7.isSelected()){
					es.musicaPequenio=true;
					precioFinal=precioFinal+30;
					siguienteVentana(numInvitados, vs, nombre, anio, mes, dia, precioFinal, "Sala de música pequeña");
				}else{
					JOptionPane.showMessageDialog(null, "Elija un espacio");
				}

			}
		});
		panelS.add(btnAceptar);
		
		JPanel panelE = new JPanel();
		contentPane.add(panelE, BorderLayout.EAST);
		
		JPanel panelW = new JPanel();
		contentPane.add(panelW, BorderLayout.WEST);
		
		JPanel panelC = new JPanel();
		contentPane.add(panelC, BorderLayout.CENTER);
		panelC.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblComedorGrande = new JLabel("1) Comedor grande:");
		panelC.add(lblComedorGrande);
		
		radioButton1 = new JRadioButton("");
		radioButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(radioButton2.isSelected()){
					radioButton2.setSelected(false);
					
				}
				if(radioButton3.isSelected()){
					radioButton3.setSelected(false);
				}
				if(radioButton4.isSelected()){
					radioButton4.setSelected(false);
				}
				if(radioButton5.isSelected()){
					radioButton5.setSelected(false);
				}
				if(radioButton6.isSelected()){
					radioButton6.setSelected(false);
				}
				if(radioButton7.isSelected()){
					radioButton7.setSelected(false);
				}
				
				
			}
		});
		
		JLabel lblNewLabelComGrandeCap = new JLabel("  (300 personas)");
		panelC.add(lblNewLabelComGrandeCap);
		panelC.add(radioButton1);
		
		lblPre1 = new JLabel("200 €");
		panelC.add(lblPre1);
		
		JLabel lblComedorMediano = new JLabel("2) Comedor mediano:");
		panelC.add(lblComedorMediano);
		
		radioButton2 = new JRadioButton("");
		radioButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(radioButton1.isSelected()){
					radioButton1.setSelected(false);
				}
				if(radioButton3.isSelected()){
					radioButton3.setSelected(false);
				}
				if(radioButton4.isSelected()){
					radioButton4.setSelected(false);
				}
				if(radioButton5.isSelected()){
					radioButton5.setSelected(false);
				}
				if(radioButton6.isSelected()){
					radioButton6.setSelected(false);
				}
				if(radioButton7.isSelected()){
					radioButton7.setSelected(false);
				}
			}
		});
		
		JLabel lblPersonas = new JLabel("  (100 personas)");
		panelC.add(lblPersonas);
		panelC.add(radioButton2);
		
		lblPre2 = new JLabel("150 €");
		panelC.add(lblPre2);
		
		JLabel lblComedorPequeo = new JLabel("3) Comedor pequeño:");
		panelC.add(lblComedorPequeo);
		
		radioButton3 = new JRadioButton("");
		radioButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(radioButton1.isSelected()){
					radioButton1.setSelected(false);
				}
				if(radioButton2.isSelected()){
					radioButton2.setSelected(false);
				}
				if(radioButton4.isSelected()){
					radioButton4.setSelected(false);
				}
				if(radioButton5.isSelected()){
					radioButton5.setSelected(false);
				}
				if(radioButton6.isSelected()){
					radioButton6.setSelected(false);
				}
				if(radioButton7.isSelected()){
					radioButton7.setSelected(false);
				}
			}
		});
		
		JLabel lblPersonas_1 = new JLabel("  (50 personas)");
		panelC.add(lblPersonas_1);
		panelC.add(radioButton3);
		
		lblPre3 = new JLabel("50 €");
		panelC.add(lblPre3);
		
		JLabel lblSalaDeReuniones = new JLabel("4) Sala de reuniones 1:");
		panelC.add(lblSalaDeReuniones);
		
		radioButton4 = new JRadioButton("");
		radioButton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radioButton1.isSelected()){
					radioButton1.setSelected(false);
				}
				if(radioButton2.isSelected()){
					radioButton2.setSelected(false);
				}
				if(radioButton3.isSelected()){
					radioButton3.setSelected(false);
				}
				if(radioButton5.isSelected()){
					radioButton5.setSelected(false);
				}
				if(radioButton6.isSelected()){
					radioButton6.setSelected(false);
				}
				if(radioButton7.isSelected()){
					radioButton7.setSelected(false);
				}
			}
		});
		
		JLabel lblPersonas_2 = new JLabel("  (60 personas)");
		panelC.add(lblPersonas_2);
		panelC.add(radioButton4);
		
		lblPre4 = new JLabel("50 €");
		panelC.add(lblPre4);
		
		JLabel lblSalaDe = new JLabel("5) Sala de reuniones 2:");
		panelC.add(lblSalaDe);
		
		radioButton5 = new JRadioButton("");
		radioButton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radioButton1.isSelected()){
					radioButton1.setSelected(false);
				}
				if(radioButton2.isSelected()){
					radioButton2.setSelected(false);
				}
				if(radioButton3.isSelected()){
					radioButton3.setSelected(false);
				}
				if(radioButton4.isSelected()){
					radioButton4.setSelected(false);
				}
				if(radioButton6.isSelected()){
					radioButton6.setSelected(false);
				}
				if(radioButton7.isSelected()){
					radioButton7.setSelected(false);
				}
			}
		});
		
		JLabel lblPersonas_3 = new JLabel("  (20 personas)");
		panelC.add(lblPersonas_3);
		panelC.add(radioButton5);
		
		lblPre5 = new JLabel("20 €");
		panelC.add(lblPre5);
		
		JLabel lblSalnDe = new JLabel("6) Salón de música: ");
		panelC.add(lblSalnDe);
		
		radioButton6 = new JRadioButton("");
		radioButton6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radioButton1.isSelected()){
					radioButton1.setSelected(false);
				}
				if(radioButton2.isSelected()){
					radioButton2.setSelected(false);
				}
				if(radioButton3.isSelected()){
					radioButton3.setSelected(false);
				}
				if(radioButton4.isSelected()){
					radioButton4.setSelected(false);
				}
				if(radioButton5.isSelected()){
					radioButton5.setSelected(false);
				}
				if(radioButton7.isSelected()){
					radioButton7.setSelected(false);
				}
			}
		});
		
		JLabel lblgrande = new JLabel("  (grande)");
		panelC.add(lblgrande);
		panelC.add(radioButton6);
		
		lblPre6 = new JLabel("60 €");
		panelC.add(lblPre6);
		
		JLabel lblSalnDe_1 = new JLabel("7) Salón de música: ");
		panelC.add(lblSalnDe_1);
		
		radioButton7 = new JRadioButton("");
		radioButton7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radioButton1.isSelected()){
					radioButton1.setSelected(false);
				}
				if(radioButton2.isSelected()){
					radioButton2.setSelected(false);
				}
				if(radioButton3.isSelected()){
					radioButton3.setSelected(false);
				}
				if(radioButton4.isSelected()){
					radioButton4.setSelected(false);
				}
				if(radioButton5.isSelected()){
					radioButton5.setSelected(false);
				}
				if(radioButton6.isSelected()){
					radioButton6.setSelected(false);
				}
			}
		});
		
		JLabel lblpequeo = new JLabel("  (pequeño)");
		panelC.add(lblpequeo);
		panelC.add(radioButton7);
		
		lblPre7 = new JLabel("30 €");
		panelC.add(lblPre7);
	}
	
	public void siguienteVentana(String numInvitados, JFrame vs, String nombre, int anio, int mes, int dia, long precioFinal, String espacio){
		VentanaEscoger ves = new VentanaEscoger(numInvitados, nombre, anio, mes, dia, precioFinal, false, false, espacio);
		ves.setVisible(true);
		vs.dispose();
	}

}
