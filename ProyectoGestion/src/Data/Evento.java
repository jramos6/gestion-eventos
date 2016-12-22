package Data;


public class Evento {
	
	protected static double presupuesto;
	protected int invitados;
	protected static int codigo;
	protected static String actividad;


	public Evento(double presupuesto, int invitados, int codigo, String actividad) {
	super();
	this.presupuesto = presupuesto;
	this.invitados = invitados;
	this.codigo = codigo;
	this.actividad = actividad;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	@Override
	public String toString() {
		return "Evento [presupuesto=" + presupuesto + ", invitados=" + invitados + ", codigo=" + codigo + ", actividad="
				+ actividad + "]";
	}

	
	
}
