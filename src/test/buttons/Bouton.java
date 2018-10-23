/*
 la classe bouton permet de gerer le composant bouton 
 */
package test.buttons;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Bouton extends JButton {

    private int largeur;
    private int hauteur;
    private Color background;
    private int couleur_type;

    public Bouton(int couleur_type) {

      
        setContentAreaFilled(false);
       //definir les proprietes de bouton
        largeur = 30;
        hauteur = 30;
        setBackgroundText(couleur_type);
      setSize(largeur, hauteur);

        

       //definir l'action sur le bouton
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                click(e);
            }
        });

    }

   //gerer les listerns
    public void addBouttonListener(BouttonListener listener) {
        listenerList.add(BouttonListener.class, listener);
    }

    public void removeBouttonListener(BouttonListener listener) {
        listenerList.remove(BouttonListener.class, listener);
    }
    
    
    
    public void click(ActionEvent e) {
        fireEvent();

    }

    //definir les evenemnt de bouton
    void fireEvent() {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == BouttonListener.class) {
                ((BouttonListener) listeners[i + 1]).dessiner(new BouttonEvent(this));

            }
        }

    }

    //les getters 
    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Color getBackground() {
        return background;
    }

    public int getCouleur_type() {
        return couleur_type;
    }

    //les setters
    //changer le font   
    public void setBackgroundText(int type) {
        switch (type) {
            case 1:
                this.setText("Red");
                break;
            case 2:
                this.setText("Green");
                break;
            case 3:
                this.setText("Blue");
                break;
            case 4:
                this.setText("clear");
                break;
        }
    }

 

}
