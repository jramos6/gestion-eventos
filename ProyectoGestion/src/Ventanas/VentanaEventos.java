package Ventanas;

import java.awt.BorderLayout;

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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

/**
 * Ventana en la que se elige el tipo de evento y el número de invitados que va a acoger
 * @author Javier Rivero y Aitor Santamaria
 *
 */
public class VentanaEventos extends JFrame {

	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumInvitados;
	private String actividad;

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
		btnVolver.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
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
		btnSiguiente.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		
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
						//cogemos el elemento seleccionado	
						actividad = (String) comboTipoEventos.getSelectedItem();
						
					
					VentanaCalendario vc = new VentanaCalendario(txtNumInvitados.getText(), nombre, true, actividad);	
						vc.setVisible(true);
						ve.dispose();
						
					}
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "Introduzca un número válido, por favor");
					getTxtNumInvitados().setText("");
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
	
		
	}


	public JTextField getTxtNumInvitados() {
		return txtNumInvitados;
	}
	
	public void setTxtNumInvitados(JTextField txtNumInvitados) {
		this.txtNumInvitados = txtNumInvitados;
	}
}
