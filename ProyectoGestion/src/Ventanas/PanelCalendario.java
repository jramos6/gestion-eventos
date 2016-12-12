package Ventanas;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;
import org.freixas.jcalendar.JCalendarCombo;
 
/**
 * Clase calendario: muestra por pantalla un calendario
 */
public class PanelCalendario extends JPanel {
  
	public PanelCalendario(){
      JCalendar calEjemplo1=new  JCalendar();
      calEjemplo1.addDateListener(new DateListener() {
		
		@Override
		public void dateChanged(DateEvent arg0) {
			
			System.out.println(calEjemplo1.getDate().getDate());
			
		}
	});
      JCalendarCombo calEjemplo2=new  JCalendarCombo();
 
      this.add(calEjemplo1);
      this.add(calEjemplo2);
      this.setLayout(new FlowLayout());
      this.setSize(600, 300);
 
     
    }
 
}