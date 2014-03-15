package buttonup;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jérémy Courel
 */
public class PlateauTest {
    
    public PlateauTest() {
    }
    
    // TODO
    @Test
    public void testSemer() {
        Plateau plateau = new Plateau();
        plateau.semer(0);
        Pile pile1 = plateau.getListePiles().get(0);
        assertEquals(2, pile1.getHauteur());
        
        plateau.semer(0);
        Pile pile2 = plateau.getListePiles().get(0);
        Pile pile3 = plateau.getListePiles().get(1);
        assertEquals(2, pile2.getHauteur());
        assertEquals(2, pile3.getHauteur());
        
        plateau.semer(0);
        Pile pile4 = plateau.getListePiles().get(0);
        Pile pile5 = plateau.getListePiles().get(1);
        assertEquals(3, pile4.getHauteur());
        assertEquals(2, pile5.getHauteur());
        
        plateau.semer(0);
        Pile pile7 = plateau.getListePiles().get(0);
        Pile pile8 = plateau.getListePiles().get(1);
        Pile pile9 = plateau.getListePiles().get(2);
        assertEquals(3, pile7.getHauteur());
        assertEquals(2, pile8.getHauteur());
        assertEquals(2, pile9.getHauteur());
        
        plateau.semer(0);
        plateau.semer(0);
        System.out.println(plateau);
        plateau.semer(0);
        System.out.println(plateau);
    }
    
    @Test
    public void testInitialiserPlateau() {
        Plateau plateau = new Plateau();
        ArrayList<Pile> listePiles = plateau.getListePiles();
        int nbBlanc = 0;
        int nbRouge = 0;
        int nbNoir = 0;
        
        for(Pile pile : listePiles) {
            if(pile.getBoutonSommet() == Bouton.BLANC)
                nbBlanc++;
            else if(pile.getBoutonSommet() == Bouton.NOIR)
                nbNoir++;
            else if(pile.getBoutonSommet() == Bouton.ROUGE)
                nbRouge++;
        }
        
        assertEquals(9, listePiles.size());
        assertEquals(3, nbBlanc);
        assertEquals(3, nbNoir);
        assertEquals(3, nbRouge);
    }
    
    @Test
    public void testGetPositionPile() {
        Plateau plateau = new Plateau();
        ArrayList<Pile> listePiles = plateau.getListePiles();
        
        assertEquals(0, plateau.getPositionPile(listePiles.get(0)));
        assertEquals(3, plateau.getPositionPile(listePiles.get(3)));
        assertEquals(5, plateau.getPositionPile(listePiles.get(5)));
        assertEquals(8, plateau.getPositionPile(listePiles.get(8)));
    }
    
}
