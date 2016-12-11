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

public class VentanaComida extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaComida frame = new VentanaComida();
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
	public VentanaComida() {
		int eleccionMenu=0;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JButton btnCancelar = new JButton("Cancelar");
		panelSur.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		panelSur.add(btnAceptar);
		
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
		
		JLabel lblMen1 = new JLabel("Menú 1");
		lblMen1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "1. PRIMEROS PLATOS: \n- Ensalada de marisco y setas \n- Percebes \n- Changurro \n- Micuit de pato \n- Revuelto de setas \n2. SEGUNDOS PLATOS \n- Solomillo con salsa de queso y almendras y pimientos verdes \n- Lubina al horno con patatas panaderas \n3. POSTRES: \n- Helado de idiazabal con tarta de queso y frambuesa \n- Sorbete de limón \n\n50€/persona","Menú 1", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lblMen1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMen1);
		
		JLabel lblMen2 = new JLabel("Menú 2");
		lblMen2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "1. PRIMEROS PLATOS: \n- Jamón ibérico \n- Cigala \n -Foie \n- Almejas a la marinera \n - Fritos variados \n2. SEGUNDOS PLATOS: \n- Entrecot con pimientos rojos \n- Rape a la marinera \n3. POSTRES: \n- Sorbete de mandarina \n- Tarta panchineta \n\n35€/persona","Menú 2", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lblMen2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMen2);
		
		JLabel lblMen3 = new JLabel("Menú 3");
		lblMen3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "1. PRIMEROS PLATOS: \n- Croquetas caseras\n- Ensalada de Ventresca, piquillo y ajo \n- Foie de hígado de pato \n- Hojaldre con hongos sobre crema de habitas \n2. SEGUNDOS PLATOS: \n- Bacalao a la vizcaína \n- Entrecot con guarnición \n- Lomos de merluza con almejas \n- Entrecot con guarnición \n3. POSTRES: \n- Tarta casera con helado de vainilla con cookies\n \n60€/persona","Menú 3", JOptionPane.INFORMATION_MESSAGE);;
			}
		});
		lblMen3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMen3);
		
		JButton btnMen1 = new JButton("1");
		panel.add(btnMen1);
		
		
		JButton btnMen2 = new JButton("2");
		panel.add(btnMen2);
		
		JButton btnMen3 = new JButton("3");
		panel.add(btnMen3);
		
		JPanel panelMenus = new JPanel();
		panelCentro.add(panelMenus);
		panelMenus.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblAdicional = new JLabel("Adicional");
		panelMenus.add(lblAdicional);
		precioMenu(eleccionMenu=1);
		precioMenu(eleccionMenu=2);
		precioMenu(eleccionMenu=3);
		
		JPanel panelAdic = new JPanel();
		panelCentro.add(panelAdic);
		panelAdic.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCafsInfusiones = new JLabel("Cafés - infusiones");
		lblCafsInfusiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblCafsInfusiones.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		panelAdic.add(lblCafsInfusiones);
		
		JLabel lblVinos = new JLabel("Vinos");
		lblVinos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVinos.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		panelAdic.add(lblVinos);
		
		JPanel panelSN_1 = new JPanel();
		panelAdic.add(panelSN_1);
		panelSN_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rdbtnSi = new JRadioButton("Sí");
		panelSN_1.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		panelSN_1.add(rdbtnNo);
		
		JPanel panelSN_2 = new JPanel();
		panelAdic.add(panelSN_2);
		panelSN_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rdbtnS = new JRadioButton("Sí");
		panelSN_2.add(rdbtnS);
		
		JRadioButton rdbtnNo_1 = new JRadioButton("No");
		panelSN_2.add(rdbtnNo_1);
	}
	/**
	 * Método para establecer el precio del menú basandonos en la elección del usuario
	 */
	public double precioMenu(int eleccionMenu){
		double precioIndividual=0;
		if(eleccionMenu==1){
			precioIndividual=50;
		}else if(eleccionMenu==2){
			precioIndividual=35;
		}else{
			precioIndividual=12.5;
		}
		return precioIndividual;
	}
		
}
