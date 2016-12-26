package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Ventanas.VentanaComida;
import junit.framework.TestCase;

public class TestImporteVinos extends TestCase{

	VentanaComida vc;
	public TestImporteVinos() {
		// TODO Auto-generated constructor stub
		super();
		vc = new VentanaComida("1");
	
	}
	/**
	 * Comprobamos qu el importe de vinos cuando el radio button  no está seleccionado es -12, porque por defecto
	 * siempre está en false.
	 */
	@Test
	public void testImporteSinSeleccionar() {
		assertEquals(-12.0, vc.precioVinos());
	}
	/**
	 * Esta vez comprobamos que el importe es el esperado, activando previamente el radioBotón
	 */
	public void testImporteSeleccionado(){
		vc.seleccionarRbVinos();
		assertEquals(12.0, vc.precioVinos());
	}

}
