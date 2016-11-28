package Data;

public class Sociales extends Evento {

	private String restaurante;
	private boolean transporte;
	
	public Sociales() {
		super();
		
	}
	public Sociales(double presupuesto, int invitados, String lugar, int fecha) {
		super(presupuesto, invitados, lugar, fecha);
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
