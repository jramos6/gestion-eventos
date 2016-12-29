package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaEditarMB extends JFrame {

	private JPanel contentPane, panelEtiquetas, panelTextos, panelCombos;
	private JTextField txtNuevoTipo, txtNuevaDur, txtNuevoPrecio;
	private JButton btnVolver, btnGuardarCambios, btnAniadir, btnEliminar;
	private JRadioButton rdbtnMusica, rdbtnBaile;
	private JComboBox comboBoxTipo,comboBoxDuracion, comboBoxPrecio;
	private JLabel lblPrecio, lblDuracion, lblTipo, lblOpcionesActuales, lblNuevoPrecio,lblNuevaDuracion, lblNuevoTipo;

	/**
	 * Create the frame.
	 */
	public VentanaEditarMB() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(0, 2, 0, 0));
		
		rdbtnMusica = new JRadioButton("Música");
		rdbtnMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnMusica.isSelected()){
					if(rdbtnBaile.isSelected()){
						comboBoxTipo.setSelectedIndex(0);
						comboBoxDuracion.setSelectedIndex(0);
						comboBoxPrecio.setSelectedIndex(0);
					}
					estanVisibles();
					rdbtnBaile.setSelected(false);	
					
					String [] tipos = VentanaLogin.bd.comboMusicaTipo();
					DefaultComboBoxModel<String> dcbm1 = new DefaultComboBoxModel<String>(tipos);
					comboBoxTipo.setModel(dcbm1);
					
					String [] tipos1 = VentanaLogin.bd.comboMusicaDur();
					DefaultComboBoxModel<String> dcbm2 = new DefaultComboBoxModel<String>(tipos1);
					comboBoxDuracion.setModel(dcbm2);
					
					String [] tipos2 = VentanaLogin.bd.comboMusicaPrecio();
					DefaultComboBoxModel<String> dcbm3 = new DefaultComboBoxModel<String>(tipos2);
					comboBoxPrecio.setModel(dcbm3);
				}
				if(rdbtnBaile.isSelected()==false && rdbtnMusica.isSelected()==false){
					estanInvisibles();
				}
			}
		});
		rdbtnMusica.setHorizontalAlignment(SwingConstants.CENTER);
		panelNorte.add(rdbtnMusica);
		
		rdbtnBaile = new JRadioButton("Baile");
		rdbtnBaile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnBaile.isSelected()){
					if(rdbtnMusica.isSelected()){
						comboBoxTipo.setSelectedIndex(0);
						comboBoxDuracion.setSelectedIndex(0);
						comboBoxPrecio.setSelectedIndex(0);
					}
					estanVisibles();
					rdbtnMusica.setSelected(false);
	
					String [] tipos = VentanaLogin.bd.comboBaileTipo();
					DefaultComboBoxModel<String> dcbm1 = new DefaultComboBoxModel<String>(tipos);
					comboBoxTipo.setModel(dcbm1);
					
					String [] tipos1 = VentanaLogin.bd.comboBaileDur();
					DefaultComboBoxModel<String> dcbm2 = new DefaultComboBoxModel<String>(tipos1);
					comboBoxDuracion.setModel(dcbm2);
					
					String [] tipos2 = VentanaLogin.bd.comboBailePrecio();
					DefaultComboBoxModel<String> dcbm3 = new DefaultComboBoxModel<String>(tipos2);
					comboBoxPrecio.setModel(dcbm3);
				}
				if(rdbtnBaile.isSelected()==false && rdbtnMusica.isSelected()==false){
					estanInvisibles();
				}
			}
		});
		rdbtnBaile.setHorizontalAlignment(SwingConstants.CENTER);
		panelNorte.add(rdbtnBaile);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		VentanaEditarMB vemb = this;
		btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaAdministrador va = new VentanaAdministrador();
				va.setVisible(true);
				vemb.dispose();
			}
		});
		panelSur.add(btnVolver);
		
		btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaAdministrador va = new VentanaAdministrador();
				va.setVisible(true);
				vemb.dispose();
			}
		});
		panelSur.add(btnGuardarCambios);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelM = new JPanel();
		panelCentro.add(panelM);
		panelM.setLayout(new GridLayout(6, 1, 0, 0));
		
		lblOpcionesActuales = new JLabel("Opciones actuales:");
		panelM.add(lblOpcionesActuales);
		
		JPanel panelRadioButtonsM = new JPanel();
		panelM.add(panelRadioButtonsM);
		panelRadioButtonsM.setLayout(new GridLayout(0, 3, 0, 0));
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioButtonsM.add(lblTipo);
		
		lblDuracion = new JLabel("Duración:");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioButtonsM.add(lblDuracion);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioButtonsM.add(lblPrecio);
		
		panelCombos = new JPanel();
		panelM.add(panelCombos);
		panelCombos.setLayout(new GridLayout(0, 3, 0, 0));
		
		comboBoxTipo = new JComboBox();
		panelCombos.add(comboBoxTipo);
		
		
		comboBoxDuracion = new JComboBox();
		panelCombos.add(comboBoxDuracion);
		
		comboBoxPrecio = new JComboBox();
		panelCombos.add(comboBoxPrecio);
		
		panelEtiquetas = new JPanel();
		panelM.add(panelEtiquetas);
		panelEtiquetas.setLayout(new GridLayout(0, 3, 0, 0));
		
		lblNuevoTipo = new JLabel("Nuevo tipo:");
		lblNuevoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		panelEtiquetas.add(lblNuevoTipo);
		
		lblNuevaDuracion = new JLabel("Nueva duración:");
		lblNuevaDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		panelEtiquetas.add(lblNuevaDuracion);
		
		lblNuevoPrecio = new JLabel("Nuevo precio:");
		lblNuevoPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		panelEtiquetas.add(lblNuevoPrecio);
		
		panelTextos = new JPanel();
		panelM.add(panelTextos);
		panelTextos.setLayout(new GridLayout(0, 3, 0, 0));
		
		txtNuevoTipo = new JTextField();
		panelTextos.add(txtNuevoTipo);
		txtNuevoTipo.setColumns(10);
		
		txtNuevaDur = new JTextField();
		panelTextos.add(txtNuevaDur);
		txtNuevaDur.setColumns(10);
		
		txtNuevoPrecio = new JTextField();
		panelTextos.add(txtNuevoPrecio);
		txtNuevoPrecio.setColumns(10);
		
		JPanel panelMusicaBotones = new JPanel();
		panelM.add(panelMusicaBotones);
		panelMusicaBotones.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnAniadir = new JButton("Añadir");
		btnAniadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnMusica.isSelected()){
					int precio = Integer.parseInt(txtNuevoPrecio.getText());
					VentanaLogin.bd.insertarEnMusica(txtNuevoTipo.getText(), txtNuevaDur.getText(), precio);
					vaciarTextos();
				}
				if(rdbtnBaile.isSelected()){
					int precio = Integer.parseInt(txtNuevoPrecio.getText());
					VentanaLogin.bd.insertarEnBaile(txtNuevoTipo.getText(), txtNuevaDur.getText(), precio);
					vaciarTextos();
				}
			}
		});
		panelMusicaBotones.add(btnAniadir);
		
		btnEliminar = new JButton("Eliminar");
		panelMusicaBotones.add(btnEliminar);
	
		estanInvisibles();
	}
	/**
	 * Método para poner en visible los campos de la ventana
	 */
	public void estanVisibles(){
		lblOpcionesActuales.setVisible(true);
		lblNuevoTipo.setVisible(true);
		lblDuracion.setVisible(true);
		lblNuevaDuracion.setVisible(true);
		lblNuevoPrecio.setVisible(true);
		lblPrecio.setVisible(true);
		lblTipo.setVisible(true);
		btnAniadir.setVisible(true);
		btnEliminar.setVisible(true);
		btnGuardarCambios.setVisible(true);
		btnVolver.setVisible(true);
		txtNuevaDur.setVisible(true);
		txtNuevoPrecio.setVisible(true);
		txtNuevoTipo.setVisible(true);
		comboBoxDuracion.setVisible(true);
		comboBoxPrecio.setVisible(true);
		comboBoxTipo.setVisible(true);
	}
	/**
	 * Método para poner en invisible los campos de la ventana
	 */
	public void estanInvisibles(){
		lblOpcionesActuales.setVisible(false);
		lblNuevoTipo.setVisible(false);
		lblDuracion.setVisible(false);
		lblNuevaDuracion.setVisible(false);
		lblNuevoPrecio.setVisible(false);
		lblPrecio.setVisible(false);
		lblTipo.setVisible(false);
		btnAniadir.setVisible(false);
		btnEliminar.setVisible(false);
		btnGuardarCambios.setVisible(false);
		btnVolver.setVisible(false);
		txtNuevaDur.setVisible(false);
		txtNuevoPrecio.setVisible(false);
		txtNuevoTipo.setVisible(false);
		comboBoxDuracion.setVisible(false);
		comboBoxPrecio.setVisible(false);
		comboBoxTipo.setVisible(false);
	}
	/**
	 * Método para vaciar los textos de txtFiles
	 */
	public void vaciarTextos(){
		txtNuevaDur.setText("");
		txtNuevoPrecio.setText("");
		txtNuevoTipo.setText("");
	}
	
}
