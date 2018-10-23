
package test.tableau;

import java.awt.event.MouseEvent;
import java.util.EventListener;


public interface TableauCliqueListener extends EventListener {
    public  void dessiner_point( TableauEvent e, MouseEvent e1 );
}
