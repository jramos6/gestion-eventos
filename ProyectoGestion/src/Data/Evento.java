package Data;


public class Evento {
	
	protected double presupuesto;
	protected int invitados;
	protected String lugar;
	protected int fecha;

	public Evento() {
		
	}

	public Evento(double presupuesto, int invitados, String lugar, int fecha) {
	super();
	this.presupuesto = presupuesto;
	this.invitados = invitados;
	this.lugar = lugar;
	this.fecha = fecha;
}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public int getInvitados() {
		return invitados;
	}

	public void setInvitados(int invitados) {
		this.invitados = invitados;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Evento [presupuesto=" + presupuesto + ", invitados=" + invitados + ", lugar=" + lugar + ", fecha="
				+ fecha + "]";
	}
	
	
}
