package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class VentanaEventos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumInvitados;

	/**
	 * Create the frame.
	 */
	public VentanaEventos(String nombre, boolean estaEnElMenuUsuario) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.CYAN);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblCaractersticasDelEvento = new JLabel("Características del evento");
		lblCaractersticasDelEvento.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		panelNorte.add(lblCaractersticasDelEvento);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JFrame ve=this;
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Conectamos con la VentanaMenuUsuario

				VentanaMenuUsuario vmu = new VentanaMenuUsuario(nombre);
				vmu.setVisible(true);
				ve.dispose();
			}
		});
		panelSur.add(btnVolver);
		
		JComboBox comboTipoEventos = new JComboBox();
		
		JButton btnSiguiente = new JButton("Siguiente");
		
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//tenemos que comprobar que el número de invitados es mayor que 0
				try{
					if(getTxtNumInvitados().getText().equals("")){
						JOptionPane.showMessageDialog(null, "Error, introduzca número de invitados");
						getTxtNumInvitados().setText("");	
						
					} else if(Integer.parseInt(getTxtNumInvitados().getText())<1){
						JOptionPane.showMessageDialog(null, "Error, número de invitados demasiado pequeño. Vuelva a introducir número de invitados");
						getTxtNumInvitados().setText("");	
						
					}else{
							
					//Conectamos con la ventana de calendario:
					VentanaCalendario vc = new VentanaCalendario(txtNumInvitados.getText(), nombre, true);	
						vc.setVisible(true);
						ve.dispose();
						
					}
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "Introduzca un número válido, por favor");
				}
			}
		});
		panelSur.add(btnSiguiente);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblTipoEvento = new JLabel("Tipo evento:");
		panelCentro.add(lblTipoEvento);
		
		comboTipoEventos.setModel(new DefaultComboBoxModel(new String[] {"", "Cultural", "Laboral", "Social"}));
		/*comboTipoEventos.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Imprime por pantalla la selección del comboBox
				System.out.println(comboTipoEventos.getSelectedItem());
			}
		});*/
		panelCentro.add(comboTipoEventos);
		
		JLabel lblNmeroDeInvitados = new JLabel("Número de invitados:");
		panelCentro.add(lblNmeroDeInvitados);
		
		JPanel panel = new JPanel();
		panelCentro.add(panel);
		panel.setLayout(null);
		
		setTxtNumInvitados(new JTextField());
		getTxtNumInvitados().setBounds(72, 35, 130, 26);
		panel.add(getTxtNumInvitados());
		getTxtNumInvitados().setColumns(10);
		
		JLabel lblPresupuestoInicial = new JLabel("Presupuesto inicial:");
		panelCentro.add(lblPresupuestoInicial);
		
		JComboBox comboPresupInic = new JComboBox();
		comboPresupInic.setModel(new DefaultComboBoxModel(new String[] {"", "10€ - 100€", "100€ - 500€", "500€ - 1.500€", "1.500€ -10.000€", "Más de 10.000€ "}));
		panelCentro.add(comboPresupInic);
	}


	public JTextField getTxtNumInvitados() {
		return txtNumInvitados;
	}
	
	public void setTxtNumInvitados(JTextField txtNumInvitados) {
		this.txtNumInvitados = txtNumInvitados;
	}
}
