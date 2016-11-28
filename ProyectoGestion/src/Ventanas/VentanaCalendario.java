package Ventanas;
import java.awt.FlowLayout;
import javax.swing.JFrame;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;
import org.freixas.jcalendar.JCalendarCombo;
 
/**
 *
 * @author beastieux
 */
public class VentanaCalendario extends JFrame {
    public VentanaCalendario()
    {
      JCalendar calEjemplo1=new  JCalendar();
      calEjemplo1.addDateListener(new DateListener() {
		
		@Override
		public void dateChanged(DateEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println(calEjemplo1.getDate());
			
		}
	});
      JCalendarCombo calEjemplo2=new  JCalendarCombo();
 
      this.add(calEjemplo1);
      this.add(calEjemplo2);
      this.setLayout(new FlowLayout());
      this.setSize(600, 300);
 
      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
 
    public static void main(String args[]) {
        VentanaCalendario obj = new VentanaCalendario();
        obj.setVisible(true);
    }
}