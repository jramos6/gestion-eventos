package ud.prog3.pr02;

/** Clase para definir instancias lÛgicas de coches con posiciÛn, direcciÛn y velocidad.
 * @author Andoni EguÌluz
 * Facultad de IngenierÌa - Universidad de Deusto (2014)
 */
public class Coche {
	protected double miVelocidad;  // Velocidad en pixels/segundo
	protected double miDireccionActual;  // DirecciÛn en la que estoy mirando en grados (de 0 a 360)
	protected double posX;  // PosiciÛn en X (horizontal)
	protected double posY;  // PosiciÛn en Y (vertical)
	protected String piloto;  // Nombre de piloto
	protected static final double MASA=1;
	protected static final double COEF_RZTO_SUELO=15.5;
	protected static final double COEF_RZTO_AIRE=0.35;
	protected static final double FUERZA_BASE_ADELANTE=2000;
	protected static final double FUERZA_BASE_ATRAS=1000;
	
	// Constructores
	
	public Coche() {
		miVelocidad = 0;
		miDireccionActual = 0;
		posX = 300;
		posY = 300;
	}
	
	/** Devuelve la velocidad actual del coche en pÌxeles por segundo
	 * @return	velocidad
	 */
	public double getVelocidad() {
		return miVelocidad;
	}

	/** Cambia la velocidad actual del coche
	 * @param miVelocidad
	 */
	public void setVelocidad( double miVelocidad ) {
		this.miVelocidad = miVelocidad;
	}

	public double getDireccionActual() {
		return miDireccionActual;
	}

	public void setDireccionActual( double dir ) {
		// if (dir < 0) dir = 360 + dir;
		if (dir > 360) dir = dir - 360;
		miDireccionActual = dir;
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosicion( double posX, double posY ) {
		setPosX( posX );
		setPosY( posY );
	}
	
	public void setPosX( double posX ) {
		this.posX = posX; 
	}
	
	public void setPosY( double posY ) {
		this.posY = posY; 
	}
	
	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}


	/** Cambia la velocidad actual del coche
	 * @param aceleracion	Incremento/decremento de la velocidad en pixels/segundo
	 * @param tiempo	Tiempo transcurrido en segundos
	 */
	public void acelera( double aceleracion, double tiempo ) {
		miVelocidad = MundoJuego.calcVelocidadConAceleracion( miVelocidad, aceleracion, tiempo );
	}
	
	/** Cambia la direcciÛn actual del coche
	 * @param giro	Angulo de giro a sumar o restar de la direcciÛn actual, en grados (-180 a +180)
	 * 				Considerando positivo giro antihorario, negativo giro horario
	 */
	public void gira( double giro ) {
		setDireccionActual( miDireccionActual + giro );
	}
	
	/** Cambia la posiciÛn del coche dependiendo de su velocidad y direcciÛn
	 * @param tiempoDeMovimiento	Tiempo transcurrido, en segundos
	 */
	public void mueve( double tiempoDeMovimiento ) {
		setPosX( posX + MundoJuego.calcMovtoX( miVelocidad, miDireccionActual, tiempoDeMovimiento ) );
		setPosY( posY + MundoJuego.calcMovtoY( miVelocidad, miDireccionActual, tiempoDeMovimiento ) );
	}
	
	  public double fuerzaAceleracionAdelante() {
          if (miVelocidad<=-150) return FUERZA_BASE_ADELANTE;
          else if (miVelocidad<=0)
                return FUERZA_BASE_ADELANTE*(-miVelocidad/150*0.5+0.5);
          else if (miVelocidad<=250)
                return FUERZA_BASE_ADELANTE*(miVelocidad/250*0.5+0.5);
          else if (miVelocidad<=750)
                return FUERZA_BASE_ADELANTE;
          else return FUERZA_BASE_ADELANTE*(-(miVelocidad-1000)/250);
	  }
	  
	  public double fuerzaAceleracionAtras() {
          if (miVelocidad<=-350) return FUERZA_BASE_ATRAS*((miVelocidad+500)/150+1);
          else if (miVelocidad<=-200)
                return FUERZA_BASE_ATRAS;
          else if (miVelocidad<=0)
                return FUERZA_BASE_ATRAS*(miVelocidad+200/200*0.7+1);
          else if (miVelocidad<=250)
                return FUERZA_BASE_ATRAS*(miVelocidad/250*0.55+0.3);
          else return 850;
	  }
	
	@Override
	public String toString() {
		return piloto + " (" + posX + "," + posY + ") - " +
			   "Velocidad: " + miVelocidad + " ## DirecciÛn: " + miDireccionActual; 
	}
}
