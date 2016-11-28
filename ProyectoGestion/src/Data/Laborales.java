package Data;

public class Laborales extends Evento  {


private String sala;
private String servicio;


	public Laborales() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laborales(double presupuesto, int invitados, String lugar, int fecha) {
		super(presupuesto, invitados, lugar, fecha);
		// TODO Auto-generated constructor stub
		
		
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	@Override
	public String toString() {
		return "Laborales [sala=" + sala + ", servicio=" + servicio + "]";
	}


}

