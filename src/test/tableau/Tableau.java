package test.tableau;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

public class Tableau extends JPanel {

    private Image image;//l'image laquelle on va dessiner
    private Graphics2D g2;//utilise pour dessiner
    private  int currentX;
    private int currentY;
    private  int oldX;
    private int oldY;//les coordonnes de souris

    
    
    
    public Tableau() {
        setDoubleBuffered(false);

        
        
        
        
        //definir les evenement de la souris
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                fireEventPoint(e);

            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {

                fireEventLigne(e);

            }
        });

    }

    
    
    
    public void paintComponent(Graphics g) {
        if (image == null) {
            //creer le tableau
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            // activer le anti aliasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // efacer le tableau
            clear();
        }
        //dessiner l'image
        g.drawImage(image, 0, 0, null);
    }

    
    
    
    
    //definir les liteners
    void fireEventPoint(MouseEvent e) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == TableauCliqueListener.class) {
                ((TableauCliqueListener) listeners[i + 1]).dessiner_point(new TableauEvent(this), e);
            }
        }

    }

    void fireEventLigne(MouseEvent e) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == TableauGlisserListener.class) {
                ((TableauGlisserListener) listeners[i + 1]).dessiner_ligne(new TableauEvent(this), e);
            }
        }
    }

    
    
    
//ajouter les evenement
    public void addTableauGlisseListener(TableauGlisserListener listener) {
        listenerList.add(TableauGlisserListener.class, listener);
    }

    public void addTableauCliqueListener(TableauCliqueListener l) {
        listenerList.add(TableauCliqueListener.class, l);
    }

    
    
    
//supprimer les evement  
    public void removeTableauGlisseListener(TableauGlisserListener listener) {
        listenerList.remove(TableauGlisserListener.class, listener);
    }

    public void removeTableauCliqueListener(TableauCliqueListener l) {
        listenerList.remove(TableauCliqueListener.class, l);
    }

    //les operations
    public void red() {
        g2.setPaint(Color.red);
    }

    public void black() {
        g2.setPaint(Color.black);
    }

    public void magenta() {
        g2.setPaint(Color.magenta);
    }

    public void green() {
        g2.setPaint(Color.green);
    }

    public void blue() {
        g2.setPaint(Color.blue);
    }

    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    
    
    
    //les getters
    public Image getImage() {
        return image;
    }

    public Graphics2D getG2() {
        return g2;
    }

    public  int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public  int getOldX() {
        return oldX;
    }

    public int getOldY() {
        return oldY;
    }

    //setters
    public void setImage(Image image) {
        this.image = image;
    }

    public void setG2(Graphics2D g2) {
        this.g2 = g2;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public void setOldY(int oldY) {
        this.oldY = oldY;
    }

    
    
}
