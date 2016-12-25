package Data;
import java.awt.BorderLayout;

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
  
	public PanelCal(){
      JCalendar calEjemplo1=new  JCalendar();
      calEjemplo1.addDateListener(new DateListener() {
		
		@Override
		public void dateChanged(DateEvent arg0) {
			
			System.out.println(calEjemplo1.getDate().getDate());
			
		}
	});
    //  JCalendarCombo calEjemplo2=new  JCalendarCombo();
 
      this.add(calEjemplo1);
      //this.add(calEjemplo2);

  
    }
 public static void main(String[] args) {
	JFrame f = new JFrame();
	f.setBounds(100, 100, 600, 400);
	f.add(new PanelCal(),BorderLayout.CENTER);
	f.setVisible(true);
}
}