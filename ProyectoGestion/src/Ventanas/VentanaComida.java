package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class VentanaComida extends JFrame {

	private JPanel contentPane;
	private JTextField txtImporteAPagar;
	private double suma;
	private int numInvitados;
	private JRadioButton radioButton1, radioButton2, radioButton3, rdbtnVinos, rdbtnCafsInfusiones;
	private JComboBox comboBoxCatering; 
	private JButton botMen1, botMen2, botMen3;
	private JTextField txtNumInvitados;

	/**
	 * Create the frame.
	 */
	public VentanaComida(String numInvitados) {
		suma=0;
		this.numInvitados = Integer.parseInt(numInvitados);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelNorte.getLayout();
		panelNorte.setBackground(Color.CYAN);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblDatosSobreComida = new JLabel("Datos sobre comida");
		lblDatosSobreComida.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		panelNorte.add(lblDatosSobreComida);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JFrame vc = this;
		JButton btnMenPrincipal = new JButton("Menú principal");
		btnMenPrincipal.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnMenPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Volvemos al menú inicial
				JOptionPane.showMessageDialog(null, "Cancelando reserva");
				
				VentanaMenuUsuario vmu = new VentanaMenuUsuario(getTitle());
				vmu.setVisible(true);
				vc.dispose();
			}
		});
		panelSur.add(btnMenPrincipal);
		
		
		JButton btnCancelar = new JButton("Confirmar");
		btnCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Volvemos a la página de datos generales de evento
				
				VentanaEscoger ve = new VentanaEscoger(numInvitados);
				ve.setVisible(true);
				vc.dispose();
				
			}
		});
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		panelSur.add(btnCancelar_1);
		panelSur.add(btnCancelar);
		
		JLabel lblTotal = new JLabel("Total =");
		panelSur.add(lblTotal);
		
		txtImporteAPagar = new JTextField();
		txtImporteAPagar.setEditable(false);
		txtImporteAPagar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panelSur.add(txtImporteAPagar);
		txtImporteAPagar.setColumns(10);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(3, 2, 0, 0));
		
		JRadioButton rdbtnCatering = new JRadioButton("Catering");
		rdbtnCatering.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnCatering.isSelected()){
					comboBoxCatering.setVisible(true);
				}else{
					comboBoxCatering.setVisible(false);
				}
			}
		});
		panelCentro.add(rdbtnCatering);
		
		comboBoxCatering = new JComboBox();
		comboBoxCatering.setModel(new DefaultComboBoxModel(new String[] {"", "Comida autóctona", "Comida asiática", "Comida africana", "Comida vegana", "Comida baja en grasas"}));
		panelCentro.add(comboBoxCatering);


		JRadioButton rdbtnBanquete = new JRadioButton("Banquete");
		rdbtnBanquete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnBanquete.isSelected()){
					botMen1.setVisible(true);
					botMen2.setVisible(true);
					botMen3.setVisible(true);
					radioButton1.setVisible(true);
					radioButton2.setVisible(true);
					radioButton3.setVisible(true);
				}else{
					botMen1.setVisible(false);
					botMen2.setVisible(false);
					botMen3.setVisible(false);
					radioButton1.setVisible(false);
					radioButton2.setVisible(false);
					radioButton3.setVisible(false);
				}
			}
		});
		panelCentro.add(rdbtnBanquete);
		
		JPanel panel = new JPanel();
		panelCentro.add(panel);
		panel.setLayout(new GridLayout(2, 3, 0, 0));
		
		botMen1 = new JButton("Ver Menú 1");
		botMen1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				JOptionPane.showMessageDialog(null, "1. PRIMEROS PLATOS: \n- Ensalada de marisco y setas \n- Percebes \n- Changurro \n- Micuit de pato \n- Revuelto de setas \n2. SEGUNDOS PLATOS \n- Solomillo con salsa de queso y almendras y pimientos verdes \n- Lubina al horno con patatas panaderas \n3. POSTRES: \n- Helado de idiazabal con tarta de queso y frambuesa \n- Sorbete de limón \n\n50€/persona","Menú 1", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		botMen1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(botMen1);
		
		botMen2 = new JButton("Ver Menú 2");
		botMen2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "1. PRIMEROS PLATOS: \n- Jamón ibérico \n- Cigala \n -Foie \n- Almejas a la marinera \n - Fritos variados \n2. SEGUNDOS PLATOS: \n- Entrecot con pimientos rojos \n- Rape a la marinera \n3. POSTRES: \n- Sorbete de mandarina \n- Tarta panchineta \n\n35€/persona","Menú 2", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		botMen2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(botMen2);
		
		botMen3 = new JButton("Ver Menú 3");
		botMen3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "1. PRIMEROS PLATOS: \n- Croquetas caseras\n- Ensalada de Ventresca, piquillo y ajo \n- Foie de hígado de pato \n- Hojaldre con hongos sobre crema de habitas \n2. SEGUNDOS PLATOS: \n- Bacalao a la vizcaína \n- Entrecot con guarnición \n- Lomos de merluza con almejas \n- Entrecot con guarnición \n3. POSTRES: \n- Tarta casera con helado de vainilla con cookies\n \n60€/persona","Menú 3", JOptionPane.INFORMATION_MESSAGE);;
			}
		});
		
		botMen3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(botMen3);
		
		radioButton1 = new JRadioButton("1");
		radioButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	

				double totalMenu1=50*VentanaComida.this.numInvitados;
				
				if(radioButton2.isSelected()){
					radioButton2.setSelected(false);
					suma=suma-35*VentanaComida.this.numInvitados;
				}
				if(radioButton3.isSelected()){
					radioButton3.setSelected(false);
					suma=suma-60*VentanaComida.this.numInvitados;
				}
				
				if(radioButton1.isSelected()){ 
					suma = suma + 50*VentanaComida.this.numInvitados;
					txtImporteAPagar.setText(suma + " €");
				}else{
					txtImporteAPagar.setText(suma-(totalMenu1) + " €");
					suma=suma-totalMenu1;	
				}
			}
		});
		radioButton1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(radioButton1);
		
		radioButton2 = new JRadioButton("2");
		radioButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radioButton1.isSelected()){
					radioButton1.setSelected(false);
					suma=suma-50*VentanaComida.this.numInvitados;
				}
				if(radioButton3.isSelected()){
					radioButton3.setSelected(false);
					suma=suma-60*VentanaComida.this.numInvitados;
				}
				
				double totalMenu2=35*VentanaComida.this.numInvitados;
				if(radioButton2.isSelected()){ 
					suma = suma + 35*VentanaComida.this.numInvitados;
					txtImporteAPagar.setText(suma + " €");
				}else{
					txtImporteAPagar.setText(suma-(totalMenu2) + " €");
					suma=suma-totalMenu2;	
				}
			}
		});
		radioButton2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(radioButton2);
		
		radioButton3 = new JRadioButton("3");
		radioButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(radioButton1.isSelected()){
					radioButton1.setSelected(false);
					suma=suma-50*VentanaComida.this.numInvitados;
				}
				if(radioButton2.isSelected()){
					radioButton2.setSelected(false);
					suma=suma-35*VentanaComida.this.numInvitados;
				}
				
				double totalMenu3=60*VentanaComida.this.numInvitados;
				if(radioButton3.isSelected()){ 
					suma = suma + 60*VentanaComida.this.numInvitados;
					txtImporteAPagar.setText(suma + " €");
				}else{
					txtImporteAPagar.setText(suma-(totalMenu3) + " €");
					suma=suma-totalMenu3;	
				}
			}
		});
		radioButton3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(radioButton3);
		
		JRadioButton rdbtnAdicional = new JRadioButton("Adicional");
		rdbtnAdicional.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnAdicional.isSelected()){
					rdbtnVinos.setVisible(true);
					rdbtnCafsInfusiones.setVisible(true);
				}else{
					rdbtnVinos.setVisible(false);
					rdbtnCafsInfusiones.setVisible(false);
				}
			}
		});
		panelCentro.add(rdbtnAdicional);

		JPanel panelAdic = new JPanel();
		panelCentro.add(panelAdic);
		panelAdic.setLayout(new GridLayout(2, 0, 0, 0));
		
		rdbtnCafsInfusiones = new JRadioButton("Cafés - infusiones");
		rdbtnCafsInfusiones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double totalCafes=4*VentanaComida.this.numInvitados;
				if(rdbtnCafsInfusiones.isSelected()){ //Precios: cafes más infusiones = 4€
					suma = suma + totalCafes;
					txtImporteAPagar.setText(suma + " €");
				}else{
					txtImporteAPagar.setText(suma-(totalCafes) + " €");
					suma=suma-totalCafes;	
				}
			}
		});
		panelAdic.add(rdbtnCafsInfusiones);
		
		rdbtnVinos = new JRadioButton("Vinos");
		rdbtnVinos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double totalVinos=12*VentanaComida.this.numInvitados;
				if(rdbtnVinos.isSelected()){ //Precios: vinos = 12€
					suma = suma + totalVinos;
					txtImporteAPagar.setText(suma + " €");
				}else{
					txtImporteAPagar.setText(suma-(totalVinos) + " €");
					suma=suma-totalVinos;	
				}
			}
		});
		panelAdic.add(rdbtnVinos);
		
		ocultarCampos();
		
		VentanaComida.this.txtImporteAPagar.setText("0.0 €");
	}
	
	/**
	 * Método para ocultar los campos de la parte derecha de la ventana
	 */
	public void ocultarCampos(){
		comboBoxCatering.setVisible(false);
		botMen1.setVisible(false);
		botMen2.setVisible(false);
		botMen3.setVisible(false);
		radioButton1.setVisible(false);
		radioButton2.setVisible(false);
		radioButton3.setVisible(false);
		rdbtnCafsInfusiones.setVisible(false);
		rdbtnVinos.setVisible(false);
		
	}
	
}
