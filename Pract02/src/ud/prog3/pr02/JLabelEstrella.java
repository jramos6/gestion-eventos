package ud.prog3.pr02;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.omg.Messaging.SyncScopeHelper;

public class JLabelEstrella extends JLabel {
	public static final int TAMANYO_ESTRELLA = 40;  // píxels (igual ancho que algo)
	public static final int RADIO_ESFERA_ESTRELLA = 17; 
	private static final boolean DIBUJAR_ESFERA_ESTRELLA = true;  // Dibujado (para depuraciÛn) del bounding circle de choque del coche
	protected long horaMilisec; //Atributo para guardar la hora en milisegundos
	private ArrayList <JLabelEstrella> aEstrellas = new ArrayList <JLabelEstrella>();//Atributo interno
	
	public long getHoraMilisec() {
		return horaMilisec;
	}

	public void setHoraMilisec(long horaMilisec) {
		this.horaMilisec = horaMilisec;
	}

	
	
	
	
}
