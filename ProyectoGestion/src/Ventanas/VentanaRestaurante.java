package Ventanas;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRestaurante extends JFrame {

	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public VentanaRestaurante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRestaurante = new JLabel("Restaurante \n");
		lblRestaurante.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 20));
		lblRestaurante.setBounds(67, 21, 308, 16);
		contentPane.add(lblRestaurante);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(16, 62, 199, 118);
		contentPane.add(lblImagen);
		
		JLabel lblDesc = new JLabel("");
		lblDesc.setBounds(231, 64, 199, 116);
		contentPane.add(lblDesc);
		
		final JFrame vr=this;
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaElegirRestaurante elr= new VentanaElegirRestaurante(vr);
				elr.setVisible(true);
				vr.dispose();
			}
		});
		btnAtrs.setBounds(199, 230, 117, 29);
		contentPane.add(btnAtrs);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(312, 230, 117, 29);
		contentPane.add(btnSalir);
	}
}