package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana para escoger entre las diferentes formas de pago
 * @author Javier Rivero y Aitor Santamaria
 *
 */
public class VentanaEscogerPago extends JFrame {

	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelS, panelCentro, panelCiz, panelCder, panelCizNom, panelCizNumInv, panelCizFecha;
	private JPanel panelCizTotPre;
	private JRadioButton rdbtnMetalico, rdbtnTarjeta, rdbtnTransferenciaBancaria;
	private JLabel lblEspecificacinDeLa, lblNombre, lblNmeroDeInvitados, lblFechaDelEvento, lblTotalPrecio;
	private JTextField txtNombre, txtNumInv, txtFecha, txtTotalPrecio;

	/**
	 * Create the frame.
	 */
	public VentanaEscogerPago(String numInvitados, String nombre, int anio, int mes, int dia, long precioFinal, int vez) {
		setResizable(false);
		setTitle("Pago");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	
		VentanaEscogerPago vep = this;
		
		panelS = new JPanel();
		contentPane.add(panelS, BorderLayout.SOUTH);
		
		JButton btnCancelar = new JButton("Cancelar reserva");
		panelS.add(btnCancelar);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMenuUsuario vmu = new VentanaMenuUsuario(nombre);
				vmu.setVisible(true);
				vep.dispose();
				
			}
		});
		btnCancelar.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String seleccion=null;
				
				if(rdbtnMetalico.isSelected()==false && rdbtnTarjeta.isSelected()==false && rdbtnTransferenciaBancaria.isSelected()==false){
					JOptionPane.showMessageDialog(null, "Elija la forma de pago");
				}
				else {
				if(rdbtnMetalico.isSelected()){
					seleccion="Metálico";
				}else if(rdbtnTarjeta.isSelected()){
					seleccion="Tarjeta de credito";
				}else if(rdbtnTransferenciaBancaria.isSelected()){
					seleccion="Transferencia bancaria";
				}
				
				Confirmar c = new Confirmar(numInvitados, nombre, precioFinal, anio, mes, dia, seleccion);
				c.setVisible(true);
				vep.dispose();
				
				}
			}
		});
		panelS.add(btnConfirmar);
		btnConfirmar.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		panelCiz = new JPanel();
		panelCentro.add(panelCiz);
		panelCiz.setLayout(new GridLayout(5, 1, 0, 0));
		
		lblEspecificacinDeLa = new JLabel("Especificación de la reserva: ");
		panelCiz.add(lblEspecificacinDeLa);
		
		panelCizNom = new JPanel();
		panelCiz.add(panelCizNom);
		panelCizNom.setLayout(new GridLayout(1, 2, 0, 0));
		
		lblNombre = new JLabel("Nombre: ");
		panelCizNom.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Consolas", Font.PLAIN, 14));
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setEditable(false);
		panelCizNom.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setText(nombre);
		
		panelCizNumInv = new JPanel();
		panelCiz.add(panelCizNumInv);
		panelCizNumInv.setLayout(new GridLayout(1, 2, 0, 0));
		
		lblNmeroDeInvitados = new JLabel("Número de invitados:");
		panelCizNumInv.add(lblNmeroDeInvitados);
		
		txtNumInv = new JTextField();
		txtNumInv.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumInv.setFont(new Font("Consolas", Font.PLAIN, 14));
		txtNumInv.setEditable(false);
		panelCizNumInv.add(txtNumInv);
		txtNumInv.setColumns(10);
		txtNumInv.setText(numInvitados);
		
		panelCizFecha = new JPanel();
		panelCiz.add(panelCizFecha);
		panelCizFecha.setLayout(new GridLayout(1, 2, 0, 0));
		
		lblFechaDelEvento = new JLabel("Fecha del evento: ");
		panelCizFecha.add(lblFechaDelEvento);
		
		txtFecha = new JTextField();
		txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecha.setFont(new Font("Consolas", Font.PLAIN, 14));
		txtFecha.setEditable(false);
		panelCizFecha.add(txtFecha);
		txtFecha.setColumns(10);
		txtFecha.setText(dia+"/"+mes+"/"+anio);
		
		panelCizTotPre = new JPanel();
		panelCiz.add(panelCizTotPre);
		panelCizTotPre.setLayout(new GridLayout(1, 2, 0, 0));
		
		lblTotalPrecio = new JLabel("Total precio: ");
		panelCizTotPre.add(lblTotalPrecio);
		
		txtTotalPrecio = new JTextField();
		txtTotalPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalPrecio.setFont(new Font("Consolas", Font.PLAIN, 14));
		txtTotalPrecio.setEditable(false);
		panelCizTotPre.add(txtTotalPrecio);
		txtTotalPrecio.setColumns(10);
		String precFin = ""+precioFinal+"";
		txtTotalPrecio.setText(precFin+" €");
		
		panelCder = new JPanel();
		panelCentro.add(panelCder);
		panelCder.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("  Especifique la forma de pago:");
		panelCder.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		
		rdbtnTransferenciaBancaria = new JRadioButton("Transferencia bancaria");
		panelCder.add(rdbtnTransferenciaBancaria);
		
		rdbtnMetalico = new JRadioButton("En metálico");
		panelCder.add(rdbtnMetalico);
		
		rdbtnTarjeta = new JRadioButton("Con tarjeta de crédito\n\n\n\n\n");
		panelCder.add(rdbtnTarjeta);
		rdbtnTarjeta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnTarjeta.isSelected()==true){
					rdbtnMetalico.setSelected(false);
					rdbtnTransferenciaBancaria.setSelected(false);
					//Confirmar c2= new Confirmar(null);
				}
			}
		});
		rdbtnMetalico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnMetalico.isSelected()){	
					rdbtnTarjeta.setSelected(false);
					rdbtnTransferenciaBancaria.setSelected(false);
					//Confirmar c1= new Confirmar(null);
				}
			}
		});
		rdbtnTransferenciaBancaria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnTransferenciaBancaria.isSelected()) {
					rdbtnMetalico.setSelected(false);
					rdbtnTarjeta.setSelected(false);
					
					//Confirmar c3= new Confirmar(null);
				}
			}
		});
	
		if(vez==0){
			btnCancelar.setVisible(true);
		}else{
			btnCancelar.setVisible(false);
		}
		
	}
}
