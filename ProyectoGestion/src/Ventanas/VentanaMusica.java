package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.spi.TimeZoneNameProvider;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMusica extends JFrame{

	private JPanel contentPane, panelCentroBaile ;
	private JTextField textFieldPrecio, textFieldPrecioBaile;
	private JLabel lblTipo, lblDuracin, lblPrecio, lblBaile, lblTipo_1, lblDuracin_1, lblPrecio_1, lblMusica;
	private JComboBox comboBoxDuracion,comboBoxTipoMusica, comboBoxTipoBaile, comboBoxDuracionBaile;
	private JRadioButton radioButtonBaile, radioButtonMusica ;
	private JTextField txtNumInvitados;
	private JButton btnMenPrincipal;
	private String nomUsuario;
	private int anio, mes, dia;
	private long precioF, precioMusica, precioBaile;
	private int cod_m, cod_b;
	

    
	/**
	 * Create the frame.
	 */
	public VentanaMusica(String numInvitados, String nombre, int anio, int mes, int dia,long precioFinal, boolean comida, boolean musica, String espacio, String actividad, int cod_musica, int cod_baile, int num_menu, String catering, String cafes_infusiones, String vinos) {
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
		
		JLabel lblMenMusical = new JLabel("Menú musical");
		lblMenMusical.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		panelNorte.add(lblMenMusical);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		VentanaMusica vm=this;
		JButton btnVolver = new JButton("Cancelar");
		btnVolver.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEscoger ve = new VentanaEscoger(numInvitados, nomUsuario, anio, mes, dia, precioFinal,comida, musica, espacio, actividad, cod_musica, cod_baile, num_menu, catering, cafes_infusiones, vinos);
				ve.setVisible(true);
				vm.dispose();
			}
		});
		
		btnMenPrincipal = new JButton("Menú principal");
		btnMenPrincipal.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnMenPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Volvemos al menú inicial
				JOptionPane.showMessageDialog(null, "Cancelando reserva");
				
				VentanaMenuUsuario vmu = new VentanaMenuUsuario(getTitle());
				vmu.setVisible(true);
				vm.dispose();
			}
		});
		panelSur.add(btnMenPrincipal);
		panelSur.add(btnVolver);
		
		JButton btnAceptar = new JButton("Confirmar");
		btnAceptar.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Obtenemos el codigo de la musica:
				if(radioButtonMusica.isSelected()){
				String tipo1 = (String)comboBoxTipoMusica.getSelectedItem();
				String duracion1 = (String)comboBoxDuracion.getSelectedItem();
				int precioM =(int)precioMusica;

				cod_m = VentanaLogin.bd.codigoMusica(tipo1, duracion1, precioM);
				
				}
				//Obtenemos el codigo del baile
				if(radioButtonBaile.isSelected()){
				String tipo2 = (String)comboBoxTipoBaile.getSelectedItem();
				String duracion2 = (String)comboBoxDuracionBaile.getSelectedItem();
				int precioB = (int)precioBaile;
				
				cod_b = VentanaLogin.bd.codigoBaile(tipo2, duracion2, precioB);
				
				}
				
				
				
				
				
					precioF=precioFinal+precioMusica+precioBaile;
					
					VentanaEscoger ve = new VentanaEscoger(numInvitados, nombre, anio, mes, dia, precioF,comida, true, espacio, actividad, cod_m, cod_b, num_menu, catering, cafes_infusiones, vinos);
					ve.setVisible(true);
					vm.dispose();
				
			
			}
		});
		panelSur.add(btnAceptar);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelCentroMusica = new JPanel();
		panelCentroMusica.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCentro.add(panelCentroMusica);
		panelCentroMusica.setLayout(new GridLayout(4, 2, 0, 0));
		
		lblMusica = new JLabel("Música");
		lblMusica.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroMusica.add(lblMusica);
		
		radioButtonMusica = new JRadioButton("No");
		radioButtonMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(radioButtonMusica.isSelected()){
					radioButtonMusica.setText("Sí");
					ponerEnablesCamposMusica();
					ponerVisibleCamposMusica();
				}else{
					radioButtonMusica.setText("No");
					ponerDisableCamposMusica();
					ponerInvisibleCamposMusica();
				}
				
			}
		});
		panelCentroMusica.add(radioButtonMusica);
		
		lblTipo = new JLabel("Tipo: ");
		lblTipo.setEnabled(false);
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroMusica.add(lblTipo);
		
		comboBoxTipoMusica = new JComboBox();
		comboBoxTipoMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(!comboBoxTipoMusica.getSelectedItem().equals("")){
					comboBoxDuracion.setEnabled(true);
					comboBoxDuracion.setToolTipText("");
				}
				if(!comboBoxDuracion.equals("")){
					int precioFin=VentanaLogin.bd.precioMusica((String)comboBoxTipoMusica.getSelectedItem(), (String)comboBoxDuracion.getSelectedItem());		
					textFieldPrecio.setText(""+precioFin+"");
				}
				
			}
		});
		comboBoxTipoMusica.setEnabled(false);
		String[] tipos = VentanaLogin.bd.comboMusicaTipo();
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>(tipos);
		comboBoxTipoMusica.setModel(dcbm);
		//comboBoxTipoMusica.setModel(new DefaultComboBoxModel(new String[] {"", "Orquesta", "Banda", "Mariachis", "Txistularis"}));
		panelCentroMusica.add(comboBoxTipoMusica);
		
		lblDuracin = new JLabel("Duración: ");
		lblDuracin.setEnabled(false);
		lblDuracin.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroMusica.add(lblDuracin);
		
		comboBoxDuracion = new JComboBox();
		comboBoxDuracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int precioFin=VentanaLogin.bd.precioMusica((String)comboBoxTipoMusica.getSelectedItem(), (String)comboBoxDuracion.getSelectedItem());		
				textFieldPrecio.setText(""+precioFin+"");
				precioMusica=precioFin;
				
			}
		});
		comboBoxDuracion.setEnabled(false);
		String[] duracion = VentanaLogin.bd.comboMusicaDur();
		DefaultComboBoxModel<String> dcbm2 = new DefaultComboBoxModel<String>(duracion);
		comboBoxDuracion.setModel(dcbm2);
		//comboBoxDuracion.setModel(new DefaultComboBoxModel(new String[] {"", "1 hora", "3 horas", "Mitad del evento", "Toda la mañana", "Toda la tarde", "Toda la noche", "Todo el evento"}));
		panelCentroMusica.add(comboBoxDuracion);
		
		if(comboBoxTipoMusica.getSelectedItem().equals("")){
			comboBoxDuracion.setToolTipText("Introduzca primero la opción de tipo");
		}
		
		lblPrecio = new JLabel("Precio: ");
		lblPrecio.setEnabled(false);
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroMusica.add(lblPrecio);
		
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setEnabled(false);
		textFieldPrecio.setEditable(false);
		panelCentroMusica.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		panelCentroBaile = new JPanel();
		panelCentroBaile.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCentro.add(panelCentroBaile);
		panelCentroBaile.setLayout(new GridLayout(4, 2, 0, 0));
		
		lblBaile = new JLabel("Baile: ");
		lblBaile.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroBaile.add(lblBaile);
		
		radioButtonBaile = new JRadioButton("No");
		radioButtonBaile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radioButtonBaile.isSelected()){
					radioButtonBaile.setText("Sí");
					ponerEnablesCamposBaile();
					ponerVisibleCamposBaile();
				}else{
					radioButtonBaile.setText("No");
					ponerDisablesCamposBaile();
					ponerInvisibleCamposBaile();
				}
			}
		});
		panelCentroBaile.add(radioButtonBaile);
		
		lblTipo_1 = new JLabel("Tipo: ");
		lblTipo_1.setEnabled(false);
		lblTipo_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroBaile.add(lblTipo_1);
		
		comboBoxTipoBaile = new JComboBox();
		comboBoxTipoBaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comboBoxTipoBaile.getSelectedItem().equals("")){
					comboBoxDuracionBaile.setEnabled(true);
					comboBoxDuracionBaile.setToolTipText("");
				}
				if(!comboBoxDuracionBaile.equals("")){
					int precioFin=VentanaLogin.bd.precioMusica((String)comboBoxTipoBaile.getSelectedItem(), (String)comboBoxDuracionBaile.getSelectedItem());		
					textFieldPrecioBaile.setText(""+precioFin+"");
				}
			}
		});
		comboBoxTipoBaile.setEnabled(false);
		String[] tipos2 = VentanaLogin.bd.comboBaileTipo();
		DefaultComboBoxModel<String> dcbm3 = new DefaultComboBoxModel<String>(tipos2);
		comboBoxTipoBaile.setModel(dcbm3);
		//comboBoxTipoBaile.setModel(new DefaultComboBoxModel(new String[] {"", "Lento", "Samba", "Ballet", "Salsa", "Bachata", "Tradicional", "Jotas Navarras"}));
		panelCentroBaile.add(comboBoxTipoBaile);
		
		lblDuracin_1 = new JLabel("Duración: ");
		lblDuracin_1.setEnabled(false);
		lblDuracin_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroBaile.add(lblDuracin_1);
		
		comboBoxDuracionBaile = new JComboBox();
		comboBoxDuracionBaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int precioFin=VentanaLogin.bd.precioBaile((String)comboBoxTipoBaile.getSelectedItem(), (String)comboBoxDuracionBaile.getSelectedItem());		
				textFieldPrecioBaile.setText(""+precioFin+"");
				precioBaile=precioFin;
			}
		});
		comboBoxDuracionBaile.setEnabled(false);
		String[] duracion2 = VentanaLogin.bd.comboBaileDur();
		DefaultComboBoxModel<String> dcbm4 = new DefaultComboBoxModel<String>(duracion2);
		comboBoxDuracionBaile.setModel(dcbm4);
		//comboBoxDuracionBaile.setModel(new DefaultComboBoxModel(new String[] {"", "1 hora", "3 horas", "Mitad del evento", "Toda la mañana", "Toda la tarde", "Toda la noche", "Todo el evento"}));
		panelCentroBaile.add(comboBoxDuracionBaile);
		
		if(comboBoxTipoBaile.getSelectedItem().equals("")){
			comboBoxDuracionBaile.setToolTipText("Introduzca primero la opción de tipo");
		}
		
		lblPrecio_1 = new JLabel("Precio: ");
		lblPrecio_1.setEnabled(false);
		lblPrecio_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroBaile.add(lblPrecio_1);
		
		textFieldPrecioBaile = new JTextField();
		textFieldPrecioBaile.setEnabled(false);
		textFieldPrecioBaile.setEditable(false);
		panelCentroBaile.add(textFieldPrecioBaile);
		textFieldPrecioBaile.setColumns(10);

		ponerInvisibleCamposMusica();
		ponerInvisibleCamposBaile();
	}
	
	/**
	 * Método que pone en enable los campos de música
	 */
	public void ponerEnablesCamposMusica(){
		lblTipo.setEnabled(true);
		comboBoxTipoMusica.setEnabled(true);
		lblDuracin.setEnabled(true);
		//comboBoxDuracion.setEnabled(true);
		lblPrecio.setEnabled(true);
		textFieldPrecio.setEnabled(true);
	}
	
	/**
	 * Método que pone visible campos de música
	 */
	public void ponerVisibleCamposMusica(){
		lblTipo.setVisible(true);
		comboBoxTipoMusica.setVisible(true);
		lblDuracin.setVisible(true);
		comboBoxDuracion.setVisible(true);
		lblPrecio.setVisible(true);
		textFieldPrecio.setVisible(true);
	}
	
	/**
	 * Método que pone invisible campos de música
	 */
	public void ponerInvisibleCamposMusica(){
		lblTipo.setVisible(false);
		comboBoxTipoMusica.setVisible(false);
		lblDuracin.setVisible(false);
		comboBoxDuracion.setVisible(false);
		lblPrecio.setVisible(false);
		textFieldPrecio.setVisible(false);
	}
	
	/**
	 * Método que pone en disable los campos de música
	 */
	public void ponerDisableCamposMusica(){
		lblTipo.setEnabled(false);
		comboBoxTipoMusica.setEnabled(false);
		lblDuracin.setEnabled(false);
		comboBoxDuracion.setEnabled(false);
		lblPrecio.setEnabled(false);
		textFieldPrecio.setEnabled(false);
	}
	
	/**
	 * Método que pone en enable los campos de baile
	 */
	public void ponerEnablesCamposBaile(){
			lblTipo_1.setEnabled(true);
			comboBoxTipoBaile.setEnabled(true);
			lblDuracin_1.setEnabled(true);
			//comboBoxDuracionBaile.setEnabled(true);
			lblPrecio_1.setEnabled(true);
			textFieldPrecioBaile.setEnabled(true);
		
	}
	
	/**
	 * Método que pone en disable los campos de baile
	 */
	public void ponerDisablesCamposBaile(){
			lblTipo_1.setEnabled(false);
			comboBoxTipoBaile.setEnabled(false);
			lblDuracin_1.setEnabled(false);
			comboBoxDuracionBaile.setEnabled(false);
			lblPrecio_1.setEnabled(false);
			textFieldPrecioBaile.setEnabled(false);
		
	}
	
	/**
	 * Método que pone en visible los campos de baile
	 */
	public void ponerVisibleCamposBaile(){
			lblTipo_1.setVisible(true);
			comboBoxTipoBaile.setVisible(true);
			lblDuracin_1.setVisible(true);
			comboBoxDuracionBaile.setVisible(true);
			lblPrecio_1.setVisible(true);
			textFieldPrecioBaile.setVisible(true);
		
	}
	
	/**
	 * Método que pone en invisible los campos de baile
	 */
	public void ponerInvisibleCamposBaile(){
			lblTipo_1.setVisible(false);
			comboBoxTipoBaile.setVisible(false);
			lblDuracin_1.setVisible(false);
			comboBoxDuracionBaile.setVisible(false);
			lblPrecio_1.setVisible(false);
			textFieldPrecioBaile.setVisible(false);
		
	}

}
