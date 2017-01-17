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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelNorte, panelSur, panelEste, panelCentro;
	static JPanel panelOeste;
	JLabel labelCentro, labelEste;
	static JLabel labelOeste;
	private JLabel lblGestinDeEventos;
	private JButton btnSalir, btnEntrar;


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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		btnSalir.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnSalir.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) { 
	
				MiThread mt = new MiThread();
				mt.start();
			}
		});
		
		panelSur.add(btnSalir);
		JFrame vp=this;
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					//Conectamos con la ventana login
					
					VentanaLogin v = new VentanaLogin();
					v.setVisible(true);
					vp.dispose();
				}
			}
		});
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
	
	class MiThread extends Thread{
		public MiThread(){
			super();
		}
		public void run(){
			VentanaCierre vc = new VentanaCierre();
			for(int i=0;i<vc.aEtiquetas.length;i++){
				vc.aEtiquetas[i].setVisible(true);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			vc.dispose();
			System.exit(0);
		}
	}

		
	}