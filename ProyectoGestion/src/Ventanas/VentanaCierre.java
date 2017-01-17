package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaCierre extends JFrame {

	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel aEtiquetas[];



	/**
	 * Create the frame.
	 */
	public VentanaCierre() {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Cerrando aplicación");
		aEtiquetas = new JLabel[25];
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(250, 250, 250, 60);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		for(int i=0;i<aEtiquetas.length;i++){
			aEtiquetas[i] = new JLabel(".");
			aEtiquetas[i].setForeground(Color.BLUE);
			aEtiquetas[i].setVisible(false);
			panel.add(aEtiquetas[i]);
			
		}
		contentPane.add(panel, BorderLayout.CENTER);
		this.setVisible(true);
	}

}
