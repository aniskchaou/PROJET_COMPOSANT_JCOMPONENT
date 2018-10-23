package test_composant;

import test.tableau.*;
import test.buttons.BouttonEvent;
import test.buttons.BouttonListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import test.outis.Outils;

public class Composant extends JComponent {
   
    public Composant() {
    }

    public static void main(String[] args) {

        //definition des composants  
        JFrame fenetre = new JFrame("Tableau");
        final Tableau t = new Tableau();
       
        Outils o = new Outils();
      
        fenetre.getContentPane().add(o, BorderLayout.NORTH);
        fenetre.getContentPane().add(t, BorderLayout.CENTER);

        //definition WindowListener
        fenetre.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //configuration des evenement
        


        //TableauCliqueListener
        t.addTableauCliqueListener(new TableauCliqueListener() {
            @Override
            public void dessiner_point(TableauEvent e, MouseEvent e1) {

                // recuprer les coodonnes de la souris
                t.setCurrentX(e1.getX())  ;
                t.setCurrentY( e1.getY()) ;
                t.getG2().setStroke(new BasicStroke(5));
                if (t.getG2() != null) {
                    //dessiner une ligne
                    t.getG2().drawLine(t.getOldX(), t.getOldY(), t.getCurrentX(), t.getCurrentY());
                    // rafrechir
                    t.repaint();
                    // mise a jour des coodonnes de la souris
                     t.setOldX(t.getCurrentX())  ;
                    t.setOldY(t.getCurrentY())  ;

                }
            }
        });

        // TableauGlisseListener
        t.addTableauGlisseListener(new TableauGlisserListener() {
            @Override
            public void dessiner_ligne(TableauEvent e, MouseEvent e1) {
                // recuprer les coodonnes de la souris
                t.setCurrentX(e1.getX())  ;
                t.setCurrentY( e1.getY()) ;
               t.getG2().setStroke(new BasicStroke(5));
                if (t.getG2() != null) {
                    // dessiner une ligne
                    t.getG2().drawLine(t.getOldX(), t.getOldY(), t.getCurrentX(), t.getCurrentY());
                    // rafrechir
                    t.repaint();
                    // mise a jour des coodonnes de la souris
                     t.setOldX(t.getCurrentX())  ;
                    t.setOldY(t.getCurrentY())  ;

                }
            }
        });

        //BouttonListener (bouton rouge)
        o.getBouton_rouge().addBouttonListener(new BouttonListener() {
            @Override
            public void dessiner(BouttonEvent e) {

                t.red();

            }

        });

        //BouttonListener (bouton bleu)
        o.getBouton_bleu().addBouttonListener(new BouttonListener() {
            @Override
            public void dessiner(BouttonEvent e) {

                t.blue();

            }

        });

        //BouttonListener (bouton vert)
        o.getBouton_vert().addBouttonListener(new BouttonListener() {
            @Override
            public void dessiner(BouttonEvent e) {

                t.green();

            }

        });

        //BouttonListener (bouton clear)
        o.getBouton_clear().addBouttonListener(new BouttonListener() {
            @Override
            public void dessiner(BouttonEvent e) {

                t.clear();

            }

        });
        
        
        //definir la taille et afficher la fenetre
        fenetre.setSize(500, 500);
        fenetre.setResizable(false);
        fenetre.setVisible(true);
    }
}
