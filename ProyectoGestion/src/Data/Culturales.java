package Data;

public class Culturales extends Evento{

private static String funcion;

public Culturales() {
	super(presupuesto, codigo, codigo, funcion);
	// TODO Auto-generated constructor stub
}

public Culturales(double presupuesto, int invitados, String lugar, int fecha) {
	super(presupuesto, invitados, codigo, actividad);
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
