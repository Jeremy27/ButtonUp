/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package buttonup;

import java.util.ArrayList;

/**
 *
 * @author jeremy
 */
public class Pile {
    public static enum Bouton {
        BLANC,
        ROUGE,
        NOIR;
    }
    
    private ArrayList<Bouton> listeBoutons;
    
    public Pile(Bouton bouton) {
        listeBoutons = new ArrayList<>();
        listeBoutons.add(bouton);
    }
    
    
}
