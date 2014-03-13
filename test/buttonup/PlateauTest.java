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
        System.out.println(plateau);
        plateau.semer(plateau.getListePiles().get(0));
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
