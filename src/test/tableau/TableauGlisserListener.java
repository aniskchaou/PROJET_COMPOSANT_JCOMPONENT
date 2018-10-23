
package test.tableau;

import java.awt.event.MouseEvent;
import java.util.EventListener;


public interface TableauGlisserListener  extends EventListener{
   
  public  void dessiner_ligne( TableauEvent e, MouseEvent e1 );
  
}
