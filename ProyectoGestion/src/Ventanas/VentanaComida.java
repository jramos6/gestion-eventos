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
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VentanaComida extends JFrame {

	private JPanel contentPane;
	private JTextField txtImporteAPagar;
	private double suma;
	private int numInvitados;

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
				VentanaMenuUsuario vmu = new VentanaMenuUsuario(getTitle());
				vmu.setVisible(true);
				vc.dispose();
			}
		});
		panelSur.add(btnMenPrincipal);
		
		
		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Volvemos a la página de datos generales de evento
				
				VentanaEventos ve = new VentanaEventos(100,100);
				ve.setVisible(true);
				vc.dispose();
				
			}
		});
		panelSur.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panelSur.add(btnAceptar);
		
		JLabel lblTotal = new JLabel("Total -->");
		panelSur.add(lblTotal);
		
		txtImporteAPagar = new JTextField();
		txtImporteAPagar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panelSur.add(txtImporteAPagar);
		txtImporteAPagar.setColumns(10);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblCatering = new JLabel("Catering");
		panelCentro.add(lblCatering);
		
		JComboBox comboBoxCatering = new JComboBox();
		comboBoxCatering.setModel(new DefaultComboBoxModel(new String[] {"", "Comida autóctona", "Comida asiática", "Comida africana", "Comida vegana", "Comida baja en grasas"}));
		panelCentro.add(comboBoxCatering);
		
		JLabel lblBanquete = new JLabel("Banquete");
		panelCentro.add(lblBanquete);
		
		JPanel panel = new JPanel();
		panelCentro.add(panel);
		panel.setLayout(new GridLayout(2, 3, 0, 0));
		
		JButton botMen1 = new JButton("Ver Menú 1");
		botMen1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				JOptionPane.showMessageDialog(null, "1. PRIMEROS PLATOS: \n- Ensalada de marisco y setas \n- Percebes \n- Changurro \n- Micuit de pato \n- Revuelto de setas \n2. SEGUNDOS PLATOS \n- Solomillo con salsa de queso y almendras y pimientos verdes \n- Lubina al horno con patatas panaderas \n3. POSTRES: \n- Helado de idiazabal con tarta de queso y frambuesa \n- Sorbete de limón \n\n50€/persona","Menú 1", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		botMen1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(botMen1);
		
		JButton botMen2 = new JButton("Ver Menú 2");
		botMen2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "1. PRIMEROS PLATOS: \n- Jamón ibérico \n- Cigala \n -Foie \n- Almejas a la marinera \n - Fritos variados \n2. SEGUNDOS PLATOS: \n- Entrecot con pimientos rojos \n- Rape a la marinera \n3. POSTRES: \n- Sorbete de mandarina \n- Tarta panchineta \n\n35€/persona","Menú 2", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		botMen2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(botMen2);
		
		JButton botMen3 = new JButton("Ver Menú 3");
		botMen3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "1. PRIMEROS PLATOS: \n- Croquetas caseras\n- Ensalada de Ventresca, piquillo y ajo \n- Foie de hígado de pato \n- Hojaldre con hongos sobre crema de habitas \n2. SEGUNDOS PLATOS: \n- Bacalao a la vizcaína \n- Entrecot con guarnición \n- Lomos de merluza con almejas \n- Entrecot con guarnición \n3. POSTRES: \n- Tarta casera con helado de vainilla con cookies\n \n60€/persona","Menú 3", JOptionPane.INFORMATION_MESSAGE);;
			}
		});
		botMen3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(botMen3);
		
		JButton btnMen1 = new JButton("1");
		btnMen1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
				suma = suma + 50*VentanaComida.this.numInvitados;
				txtImporteAPagar.setText(suma + " €");
			}
		});
		panel.add(btnMen1);
		
		
		JButton btnMen2 = new JButton("2");
		btnMen2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				suma = suma + 35;
				txtImporteAPagar.setText(suma + " €");
	
			}
		});
		panel.add(btnMen2);
		
		JButton btnMen3 = new JButton("3");
		btnMen3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				suma = suma + 60;
				txtImporteAPagar.setText(suma + " €");
	
			}
		});
		panel.add(btnMen3);
		
		JPanel panelMenus = new JPanel();
		panelCentro.add(panelMenus);
		panelMenus.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblAdicional = new JLabel("Adicional");
		panelMenus.add(lblAdicional);

		JPanel panelAdic = new JPanel();
		panelCentro.add(panelAdic);
		panelAdic.setLayout(new GridLayout(2, 0, 0, 0));
		
		JRadioButton rdbtnCafsInfusiones = new JRadioButton("Cafés - infusiones");
		panelAdic.add(rdbtnCafsInfusiones);
		
		JRadioButton rdbtnVinos = new JRadioButton("Vinos");
		panelAdic.add(rdbtnVinos);
		
	}
	
}
