package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Window;

import javax.swing.SwingConstants;

/**
 * Fragmento de código cogido de:
 * @author from   www.java2s.com
 */
public class VentanaBarraProgreso extends JFrame {
	
	private int progress;
	
	public VentanaBarraProgreso(String nombre){
		JProgressBar pb = new JProgressBar();
		setAlwaysOnTop(true);
		setResizable(false);
		setBounds(300, 250, 150, 150);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		getContentPane().add(pb);

		JLabel lblProcesando = new JLabel("Procesando");
		lblProcesando.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblProcesando, BorderLayout.NORTH);
		pack();
		setVisible(true);
		
		Timer timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				progress += 1;
				if (progress >= 100) {
					progress = 100;
					((Timer) e.getSource()).stop();
					JOptionPane.showMessageDialog(null, "Pago completado satisfactoriamente");
					VentanaMenuUsuario vmu = new VentanaMenuUsuario(nombre);
					vmu.setVisible(true);
					dispose();
				}
				pb.setValue(progress);
			}
		});
		timer.start();
	}
}