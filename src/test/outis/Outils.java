/*
 la Classe Outils est une classe qui permet de stocker les boutons rouge ,vert,bleu et clear dans un contenaire Jpanel
a partir de cette classe l'utilisateur peut choisir n'impote quel bouton
 */
package test.outis;

import javax.swing.JPanel;
import test.buttons.Bouton;

public class Outils extends JPanel {

    private Bouton bouton_rouge;
    private Bouton bouton_vert;
    private Bouton bouton_bleu;
    private Bouton bouton_clear;

    public Outils() {

        // definir les boutons
        bouton_rouge = new Bouton(1);
        bouton_vert = new Bouton(2);
        bouton_bleu = new Bouton(3);
        bouton_clear = new Bouton(4);

        //ajouter les boutons dans le conteneur  Outils
        add(bouton_rouge);
        add(bouton_vert);
        add(bouton_bleu);
        add(bouton_clear);
    }

    //les getters
    public Bouton getBouton_rouge() {
        return bouton_rouge;
    }

    public Bouton getBouton_vert() {
        return bouton_vert;
    }

    public Bouton getBouton_bleu() {
        return bouton_bleu;
    }

    public Bouton getBouton_clear() {
        return bouton_clear;
    }

    

}
