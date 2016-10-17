package ud.prog3.pr02;

/** Clase para definir instancias de coches con sus datos lÛgicos y una representaciÛn
 * visual asociada lista para incluir en un panel de Swing.
 * Seg˙n se mueva el coche, su representaciÛn (JLabel) se mover· en consonancia.
 * @author Andoni EguÌluz
 * Facultad de IngenierÌa - Universidad de Deusto (2014)
 */
public class CocheJuego extends Coche {
	private JLabelCoche miGrafico;  // Etiqueta gr·fica del coche
	
	/**  Crea un nuevo coche de juego
	 */
	public CocheJuego() {
		miGrafico = new JLabelCoche();
	}
	
	/** Devuelve el JLabel gr·fico asociado al coche de juego
	 * @return	Etiqueta gr·fica del coche
	 */
	public JLabelCoche getGrafico() {
		return miGrafico;
	}

	@Override
	public void setPosX(double posX) {
		super.setPosX(posX);
		miGrafico.setLocation( (int)posX, (int)posY );
		// miGrafico.repaint();  // Al cambiar la location, Swing redibuja autom·ticamente
	}

	@Override
	public void setPosY(double posY) {
		super.setPosY(posY);
		miGrafico.setLocation( (int)posX, (int)posY );
		// miGrafico.repaint();  // Al cambiar la location, Swing redibuja autom·ticamente
	}

	@Override
	public void setDireccionActual( double dir ) {
		super.setDireccionActual(dir);
		miGrafico.setGiro( miDireccionActual );
		miGrafico.repaint();  // Necesario porque Swing no redibuja al cambiar el giro (no pasa nada en el JLabel)
	}

}
