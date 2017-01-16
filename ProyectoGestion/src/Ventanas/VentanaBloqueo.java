package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;

public class VentanaBloqueo extends JFrame {

	private JPanel contentPane, panelSur;
	private JTextField txtContrasenia;
	protected int keyCode;
	private JLabel lblContrasenia;
	private JButton btnDesbloquear;
	

	/**
	 * Create the frame.
	 */
	public VentanaBloqueo() {
		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
						
				if(e.getKeyCode()==KeyEvent.VK_8){
					camposVisibles();
					
				}
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		lblContrasenia = new JLabel("Contraseña: ");
		lblContrasenia.setEnabled(false);
		panelSur.add(lblContrasenia);
		
		txtContrasenia = new JTextField();
		txtContrasenia.setEnabled(false);
		txtContrasenia.setToolTipText("");
		panelSur.add(txtContrasenia);
		txtContrasenia.setColumns(10);
		
		
		VentanaBloqueo vb = this;
		btnDesbloquear = new JButton("Desbloquear");
		btnDesbloquear.setEnabled(false);
		btnDesbloquear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String txtC=txtContrasenia.getText();
				//Comprobamos que la contraseña de desbloqueo es correcta
				String des = "desbloqueo2000";
				if(txtC.equals(des)){
					VentanaAdministrador va = new VentanaAdministrador();
					va.setVisible(true);
					vb.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Vuelva a introducir la contraseña de desbloqueo","ERROR",JOptionPane.ERROR_MESSAGE);
					txtContrasenia.setText(""); //Vaciamos campo
				}

			}
		});
		btnDesbloquear.setForeground(Color.BLUE);
		panelSur.add(btnDesbloquear);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		JLabel lblBloqueo = new JLabel("");
		panelCentro.add(lblBloqueo);
		ImageIcon i = new ImageIcon("src/imagenes/bloqueo.jpg");
		
		lblBloqueo.setIcon(i);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.RED);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblElProgramaDe = new JLabel("EL PROGRAMA DE GESTIÓN DE EVENTOS ESTÁ BLOQUEADO");
		lblElProgramaDe.setForeground(Color.WHITE);
		panelNorte.add(lblElProgramaDe);
		
		panelSur.setVisible(false);
		lblContrasenia.setVisible(false);
		txtContrasenia.setVisible(false);
		btnDesbloquear.setVisible(false);
	}
	
	/**
	 * Método para visibilizar y abilitar los campos
	 */
	public void camposVisibles(){
		panelSur.setVisible(true);
		lblContrasenia.setVisible(true);
		txtContrasenia.setVisible(true);
		btnDesbloquear.setVisible(true);
		
		lblContrasenia.setEnabled(true);
		txtContrasenia.setEnabled(true);
		btnDesbloquear.setEnabled(true);
		
	}

}
