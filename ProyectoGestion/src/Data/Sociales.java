package Data;

public class Sociales extends Evento {

	private static String restaurante;
	private boolean transporte;
	
	public Sociales() {
		super(presupuesto, codigo, codigo, restaurante);
		
	}
	public Sociales(double presupuesto, int invitados, String lugar, int fecha) {
		super(presupuesto, invitados, codigo, actividad);
	}
	public String getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}
	public boolean isTransporte() {
		return transporte;
	}
	public void setTransporte(boolean transporte) {
		this.transporte = transporte;
	}
	
	public String toString() {
		return "Sociales [restaurante=" + restaurante + ", transporte=" + transporte + "]";
	}


	
}
