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
import java.util.spi.TimeZoneNameProvider;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMusica extends JFrame{

	private JPanel contentPane, panelCentroBaile ;
	private JTextField textFieldPrecio;
	private JTextField textFieldPrecioBaile;
	private JLabel lblTipo, lblDuracin, lblPrecio, lblBaile, lblTipo_1, lblDuracin_1, lblPrecio_1, lblMusica;
	private JComboBox comboBoxDuracion,comboBoxTipoMusica, comboBoxTipoBaile, comboBoxDuracionBaile;
	private JRadioButton radioButtonBaile, radioButtonMusica ;
	private JTextField txtNumInvitados;
	private JButton btnMenPrincipal;

    
	/**
	 * Create the frame.
	 */
	public VentanaMusica(String numInvitados) {
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
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEscoger ve = new VentanaEscoger(numInvitados);
				ve.setVisible(true);
				vm.dispose();
			}
		});
		
		btnMenPrincipal = new JButton("Menú principal");
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
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaEscoger ve = new VentanaEscoger(numInvitados);
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
		comboBoxTipoMusica.setEnabled(false);
		comboBoxTipoMusica.setModel(new DefaultComboBoxModel(new String[] {"", "Orquesta", "Banda", "Mariachis", "Txistularis"}));
		panelCentroMusica.add(comboBoxTipoMusica);
		
		lblDuracin = new JLabel("Duración: ");
		lblDuracin.setEnabled(false);
		lblDuracin.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroMusica.add(lblDuracin);
		
		comboBoxDuracion = new JComboBox();
		comboBoxDuracion.setEnabled(false);
		comboBoxDuracion.setModel(new DefaultComboBoxModel(new String[] {"", "1 hora", "3 horas", "Mitad del evento", "Toda la mañana", "Toda la tarde", "Toda la noche", "Todo el evento"}));
		panelCentroMusica.add(comboBoxDuracion);
		
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
		comboBoxTipoBaile.setEnabled(false);
		comboBoxTipoBaile.setModel(new DefaultComboBoxModel(new String[] {"", "Lento", "Samba", "Ballet", "Salsa", "Bachata", "Tradicional", "Jotas Navarras"}));
		panelCentroBaile.add(comboBoxTipoBaile);
		
		lblDuracin_1 = new JLabel("Duración: ");
		lblDuracin_1.setEnabled(false);
		lblDuracin_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroBaile.add(lblDuracin_1);
		
		comboBoxDuracionBaile = new JComboBox();
		comboBoxDuracionBaile.setEnabled(false);
		comboBoxDuracionBaile.setModel(new DefaultComboBoxModel(new String[] {"", "1 hora", "3 horas", "Mitad del evento", "Toda la mañana", "Toda la tarde", "Toda la noche", "Todo el evento"}));
		panelCentroBaile.add(comboBoxDuracionBaile);
		
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
		comboBoxDuracion.setEnabled(true);
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
			comboBoxDuracionBaile.setEnabled(true);
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
