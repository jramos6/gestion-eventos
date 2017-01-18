package Ventanas;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

/**
 * Ventana para escoger entre los servicios adicionales que se le presentan al usuario
 * @author Javier Rivero y Aitor Santamaria
 *
 */
public class VentanaEscoger extends JFrame {

	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumInvitados;
	
	
	/**
	 * Create the frame.
	 */
	public VentanaEscoger(String numInvitados, String nombre, int anio, int mes, int dia, long precioFinal, boolean comida, boolean musica, String espacio, String actividad, int cod_musica, int cod_baile, int num_menu, String catering, String cafes_infusiones, String vinos) {
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
		
		JLabel lblEscojaServiciosAdicionales = new JLabel("Escoja servicios adicionales");
		panelNorte.add(lblEscojaServiciosAdicionales);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		VentanaEscoger vs = this;
		JButton btnCerrarSesin = new JButton("Cerrar Sesión");
		btnCerrarSesin.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnCerrarSesin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Hasta la próxima");
				
				VentanaLogin vl = new VentanaLogin();
				vl.setVisible(true);
				vs.dispose();
			}
		});
		panelSur.add(btnCerrarSesin);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Bookshelf Symbol 7", Font.PLAIN, 13));
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaEspacio vp = new VentanaEspacio(numInvitados, nombre, anio, mes, dia, actividad);
				vp.setVisible(true);
				vs.dispose();
			}
		});
		panelSur.add(btnVolver);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.WEST);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 1, 0, 0));
		
		/**
		 * Al pulsar el botón se abrira la ventana de comida
		 */
		JButton btnComida = new JButton("Comida");
		VentanaEscoger ve=this;
		btnComida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				VentanaComida vc = new VentanaComida(numInvitados, nombre, anio, mes, dia, precioFinal, comida, musica, espacio, actividad, cod_musica, cod_baile);
				vc.setVisible(true);
				ve.dispose();
				btnComida.setEnabled(false);
			}
		});
		panelCentro.add(btnComida);
		
		/**
		 * Al pulsar el botón se abrira la ventana de música
		 */
		JButton btnMsica = new JButton("Música");
		btnMsica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMusica vm = new VentanaMusica(numInvitados, nombre, anio, mes, dia, precioFinal, comida, musica, espacio, actividad, cod_musica, cod_baile, num_menu, catering, cafes_infusiones, vinos);
				vm.setVisible(true);
				ve.dispose();
				btnMsica.setEnabled(false);
				
			}
		});
		panelCentro.add(btnMsica);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setForeground(Color.BLUE);
		btnPagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Metemos TODA la información en la base de datos, creando un nuevo evento
				
				int invitadosNumero = Integer.parseInt(numInvitados); //Convertimos en int el string de numero de invitados
				
				int fechaTotal = (anio*10000)+(mes*100)+(dia); //Juntamos la fecha en un formato numérico
				
				//Insertamos la información
				VentanaLogin.bd.insertarNuevoEvento(nombre, precioFinal, invitadosNumero, actividad, fechaTotal, cod_musica, cod_baile, espacio, num_menu, catering, cafes_infusiones, vinos);
				
				VentanaEscogerPago vep = new VentanaEscogerPago(numInvitados, nombre, anio, mes, dia, precioFinal,0);
				vep.setVisible(true);
				ve.dispose();
			}
		});
		panelCentro.add(btnPagar);
		
		/**
		 * Serie de if-s que comprueban si el usuario ha estado antes en las ventanas comida y musica y desabilita los botones si es cierto
		 */
		
		if(comida==false && musica==false){
			btnComida.setVisible(true);
			btnMsica.setVisible(true);
		}else if(comida==true && musica==false){
			btnComida.setVisible(false);
			btnMsica.setVisible(true);
		}else if(comida==false && musica==true){
			btnComida.setVisible(true);
			btnMsica.setVisible(false);
		}else if(comida==true && musica==true){
			btnComida.setVisible(false);
			btnMsica.setVisible(false);
		}
	}
	
	public JTextField getTxtNumInvitados() {
		return txtNumInvitados;
	}
	
	public void setTxtNumInvitados(JTextField txtNumInvitados) {
		this.txtNumInvitados = txtNumInvitados;
	}
	
}
