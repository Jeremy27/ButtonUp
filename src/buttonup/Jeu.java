/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package buttonup;

/**
 *
 * @author jeremy
 */
public class Jeu {
    public static enum Joueur {
        ROUGE   {@Override Joueur adversaire() {return NOIR;}},
        NOIR    {@Override Joueur adversaire() {return ROUGE;}};
        abstract Joueur adversaire();
    }
    
    private Plateau plateau;
    
    public Jeu() {
        plateau = new Plateau();
    }
}
