package Data;

/**
 * Clase que almacena los eventos culturales
 * @author Javier Rivero y Aitor Santamaria
 *
 */
public class Culturales extends Evento {

	private static String funcion;

	public Culturales() {
		super(presupuesto, codigo, codigo, funcion);
		// Auto-generated constructor stub
	}

	public Culturales(double presupuesto, int invitados, String lugar, int fecha) {
		super(presupuesto, invitados, codigo, actividad);
		// Auto-generated constructor stub
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	@Override
	public String toString() {
		return "Culturales [funcion=" + funcion + "]";
	}

}
