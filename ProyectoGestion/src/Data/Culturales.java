package Data;

public class Culturales extends Evento{

private String funcion;

public Culturales() {
	super();
	// TODO Auto-generated constructor stub
}

public Culturales(double presupuesto, int invitados, String lugar, int fecha) {
	super(presupuesto, invitados, lugar, fecha);
	// TODO Auto-generated constructor stub
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
