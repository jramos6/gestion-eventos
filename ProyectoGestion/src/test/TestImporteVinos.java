package test;

import org.junit.Test;

import Ventanas.VentanaComida;
import junit.framework.TestCase;

/**
 * Unidad de test que comprueba el correcto funcionamiento de los metodos de importe de vinos, en dos casos diferentes
 * @author Javier Rivero y Aitor Santamaria
 *
 */
public class TestImporteVinos extends TestCase{

	VentanaComida vc;
	public TestImporteVinos() {
		// Auto-generated constructor stub
		super();
		vc = new VentanaComida("1", "", 0, 0, 0, 0, false, false,"","",0,0);
	
	}
	/**
	 * Comprobamos que el importe de vinos cuando el radio button  no está seleccionado es -12, porque por defecto
	 * siempre está en false. 
	 */
	@Test
	public void testImporteSinSeleccionar() {
		assertEquals(-12.0, vc.precioVinos());
	}

	/**
	 * Esta vez comprobamos que el importe es el esperado, activando previamente el radioBoton
	 */
	public void testImporteSeleccionado(){
		vc.seleccionarRbVinos();
		assertEquals(12.0, vc.precioVinos());
	}

}
