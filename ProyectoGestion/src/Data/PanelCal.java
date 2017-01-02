package Data;
import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;
import org.freixas.jcalendar.JCalendarCombo;
 
/**
 * Clase calendario: muestra por pantalla un calendario
 */
public class PanelCal extends JPanel {
  
	public int anio;
	public int mes;
	public int dia;
	
	public PanelCal(){
      JCalendar calEjemplo1=new  JCalendar();
      calEjemplo1.addDateListener(new DateListener() {
		
		@Override
		public void dateChanged(DateEvent arg0) {
			//Recogemos la fecha seleccionada, y la guardamos en tres variables diferentes
			anio=calEjemplo1.getDate().getYear()+2000-100;
			mes=calEjemplo1.getDate().getMonth()+1;
			dia=calEjemplo1.getDate().getDate();

		}
	});
    //  JCalendarCombo calEjemplo2=new  JCalendarCombo();
 
      this.add(calEjemplo1);
     


  
    }

public static void main(String[] args) {
	JFrame f = new JFrame();
	f.setBounds(100, 100, 600, 400);
	f.add(new PanelCal(),BorderLayout.CENTER);
	f.setVisible(true);
}
}