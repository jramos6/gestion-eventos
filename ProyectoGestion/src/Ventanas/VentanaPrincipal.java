package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	JPanel panelNorte;
	JPanel panelSur;
	static JPanel panelOeste;
	JPanel panelEste;
	JPanel panelCentro;
	JLabel labelCentro;
	static JLabel labelOeste;
	JLabel labelEste;
	private JLabel lblGestinDeEventos;
	private JButton btnSalir;
	private JButton btnEntrar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelNorte = new JPanel();
		panelNorte.setBackground(Color.CYAN);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		lblGestinDeEventos = new JLabel("Gestión de eventos JA!");
		lblGestinDeEventos.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		panelNorte.add(lblGestinDeEventos);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Hacer la ventana de salida TODO
				Thread t = new Thread();
				
				System.exit(0);
			}
		});
		panelSur.add(btnSalir);
		JFrame vp=this;
		btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Conectamos con la ventana login
				
				VentanaLogin v = new VentanaLogin();
				v.setVisible(true);
				vp.dispose();
				
				
			}
		});
		panelSur.add(btnEntrar);
		
		panelOeste = new JPanel();
        
		ImageIcon im = new ImageIcon("src/imagenes/azurmendi.jpg");
		labelOeste = new JLabel(im);
		labelOeste.setSize(50, 50);
		panelOeste.add(labelOeste);
		
		final Runnable r = new Runnable() {
			
			@Override
			public void run() {
				while(true){
					
							VentanaPrincipal.labelOeste.setBounds(VentanaPrincipal.labelOeste.getX(), VentanaPrincipal.labelOeste.getY()+50, VentanaPrincipal.labelOeste.getWidth(), VentanaPrincipal.labelOeste.getHeight());
							if(VentanaPrincipal.labelOeste.getY()>VentanaPrincipal.panelOeste.getY()+VentanaPrincipal.panelOeste.getHeight())
								VentanaPrincipal.labelOeste.setBounds(VentanaPrincipal.labelOeste.getX(), VentanaPrincipal.panelOeste.getY(), VentanaPrincipal.labelOeste.getWidth(), VentanaPrincipal.labelOeste.getHeight());
								//lblPublicidad.setAlignmentY(panelIzquierdo.getY());
							try {
								Thread.sleep(300);
							} catch (InterruptedException e) {
								// 
								e.printStackTrace();
							}
						}
					}
		
	
		
		};	
	
		panelOeste.setLayout(new BorderLayout());
		
		contentPane.add(panelOeste, BorderLayout.WEST);

		panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		panelCentro = new JPanel();
		panelCentro.setLayout(new BorderLayout()); // Para que la imagen se agrande
		
		labelCentro = new JLabel();
		panelCentro.add(labelCentro, BorderLayout.CENTER);
		
		labelCentro.setIcon (new ImageIcon("src/imagenes/imagenevento.jpg"));
		contentPane.add(panelCentro, BorderLayout.CENTER);
	
		}
		
		
	}