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
		
		JPanel panelMenus = new JPanel();
		panelCentro.add(panelMenus);
		panelMenus.setLayout(new GridLayout(3, 0, 0, 0));
		
		JButton btnMen1 = new JButton("Menú 1");
		btnMen1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "1. Jamón ibérico, cigala, fuet, almejas a la marinera, fritos variados \n2. Entrecot con pimientos rojos, rape a la marinera \n3. Sorbete de mandarina, tarta panchineta \n35€/persona","Menú 1", JOptionPane.INFORMATION_MESSAGE);;
			}
		});
		panelMenus.add(btnMen1);
		
		JButton btnMen2 = new JButton("Menú 2");
		btnMen2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "1. Ensalada de marisco y setas, percebes, changurro, micuit de pato, revuelto de setas \n2. Solomillo con salsa de queso y almendras y pimientos verdes, lubina al horno con patatas panaderas \n3. Helado de idiazabal con tarta de queso y frambuesa, sorbete de limón \n50€/persona","Menú 2", JOptionPane.INFORMATION_MESSAGE);;
			}
		});
		panelMenus.add(btnMen2);
		
		JButton btnMen3 = new JButton("Menú 3");
		btnMen3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "1. Ensalada mixta, garbanzos, vainas con patatas, macarrones con salsa de tomate \n2. Albóndigas con patatas, pechuga de pollo con salsa de mostaza, chicharro al horno, lomo con patatas \n3. Jogurt, fruta del tiempo, natillas \n12,5€/persona","Menú 3", JOptionPane.INFORMATION_MESSAGE);;
			}
		});
		panelMenus.add(btnMen3);
		
		JLabel lblAdicional = new JLabel("Adicional");
		panelCentro.add(lblAdicional);
		
		JComboBox comboBoxAdicional = new JComboBox();
		panelCentro.add(comboBoxAdicional);
	}

}
