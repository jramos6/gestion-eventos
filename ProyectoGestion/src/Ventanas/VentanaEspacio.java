package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JRadioButton;

public class VentanaEspacio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEspacio frame = new VentanaEspacio();
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
	public VentanaEspacio() {
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
		
		JButton btnVolver = new JButton("Volver");
		panelS.add(btnVolver);
		
		JButton btnAceptar = new JButton("Aceptar");
		panelS.add(btnAceptar);
		
		JPanel panelE = new JPanel();
		contentPane.add(panelE, BorderLayout.EAST);
		
		JPanel panelW = new JPanel();
		contentPane.add(panelW, BorderLayout.WEST);
		
		JPanel panelC = new JPanel();
		contentPane.add(panelC, BorderLayout.CENTER);
		panelC.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblComedorGrande = new JLabel("1) Comedor grande: (300 personas)");
		panelC.add(lblComedorGrande);
		
		JRadioButton radioButton1 = new JRadioButton("");
		panelC.add(radioButton1);
		
		JLabel lblComedorMediano = new JLabel("2) Comedor mediano: (100 personas)");
		panelC.add(lblComedorMediano);
		
		JRadioButton radioButton2 = new JRadioButton("");
		panelC.add(radioButton2);
		
		JLabel lblComedorPequeo = new JLabel("3) Comedor pequeño: (50 personas)");
		panelC.add(lblComedorPequeo);
		
		JRadioButton radioButton3 = new JRadioButton("");
		panelC.add(radioButton3);
		
		JLabel lblSalaDeReuniones = new JLabel("4) Sala de reuniones 1: ");
		panelC.add(lblSalaDeReuniones);
		
		JRadioButton radioButton4 = new JRadioButton("");
		panelC.add(radioButton4);
		
		JLabel lblSalaDe = new JLabel("5) Sala de reuniones 2: ");
		panelC.add(lblSalaDe);
		
		JRadioButton radioButton5 = new JRadioButton("");
		panelC.add(radioButton5);
		
		JLabel lblSalnDe = new JLabel("6) Salón de música grande: ");
		panelC.add(lblSalnDe);
		
		JRadioButton radioButton6 = new JRadioButton("");
		panelC.add(radioButton6);
		
		JLabel lblSalnDe_1 = new JLabel("7) Salón de música pequeño: ");
		panelC.add(lblSalnDe_1);
		
		JRadioButton radioButton7 = new JRadioButton("");
		panelC.add(radioButton7);
	}

}
