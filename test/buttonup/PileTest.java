package buttonup;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jérémy Courel
 */
public class PileTest {

    public PileTest() {
    }

    @Test
    public void testHauteur() {
        Pile pile1 = new Pile(1, Bouton.BLANC);
        assertEquals(pile1.getHauteur(), 1);

        Pile pile2 = new Pile(2, new ArrayList<>(Arrays.asList(Bouton.BLANC, Bouton.NOIR, Bouton.ROUGE)));
        assertEquals(pile2.getHauteur(), 3);

        Pile pile3 = new Pile(3, new ArrayList<>(Arrays.asList(Bouton.BLANC, Bouton.NOIR, Bouton.BLANC, Bouton.ROUGE, Bouton.NOIR)));
        assertEquals(pile3.getHauteur(), 5);
    }

    @Test
    public void testContientUnEspion() {
        Pile pile1 = new Pile(1, new ArrayList<>(Arrays.asList(Bouton.NOIR, Bouton.BLANC, Bouton.ROUGE)));
        assertTrue(pile1.contientUnEspion());

        Pile pile2 = new Pile(2, new ArrayList<>(Arrays.asList(Bouton.NOIR, Bouton.ROUGE, Bouton.ROUGE)));
        assertFalse(pile2.contientUnEspion());

        Pile pile3 = new Pile(3, new ArrayList<>(Arrays.asList(Bouton.NOIR, Bouton.BLANC, Bouton.ROUGE, Bouton.BLANC, Bouton.NOIR)));
        assertTrue(pile3.contientUnEspion());

        Pile pile4 = new Pile(4, new ArrayList<>(Arrays.asList(Bouton.NOIR, Bouton.ROUGE, Bouton.ROUGE, Bouton.NOIR, Bouton.NOIR)));
        assertFalse(pile4.contientUnEspion());
    }
    
    @Test
    public void testCouleurSommet() {
        Pile pile1 = new Pile(1, new ArrayList<>(Arrays.asList(Bouton.NOIR, Bouton.BLANC, Bouton.ROUGE)));
        assertEquals(pile1.getBoutonSommet(), Bouton.ROUGE);
        
        Pile pile2 = new Pile(2, new ArrayList<>(Arrays.asList(Bouton.NOIR, Bouton.BLANC, Bouton.NOIR)));
        assertEquals(pile2.getBoutonSommet(), Bouton.NOIR);
        
        Pile pile3 = new Pile(3, new ArrayList<>(Arrays.asList(Bouton.NOIR, Bouton.BLANC, Bouton.BLANC)));
        assertEquals(pile3.getBoutonSommet(), Bouton.BLANC);
    }
    
    @Test
    public void testPoser1() {
        Pile pile1 = new Pile(1, Bouton.BLANC);
        pile1.poser(Bouton.NOIR);
        
        assertEquals(pile1.getHauteur(), 2);
        assertEquals(pile1.getBoutonSommet(), Bouton.NOIR);
        
        pile1.poser(Bouton.ROUGE);
        assertEquals(pile1.getHauteur(), 3);
        assertEquals(pile1.getBoutonSommet(), Bouton.ROUGE);
    }
    
    @Test
    public void testPoser2() {
        Pile pile1 = new Pile(1, Bouton.BLANC);
        Pile pile2 = new Pile(2, new ArrayList<>(Arrays.asList(Bouton.NOIR, Bouton.BLANC, Bouton.ROUGE)));
        pile1.poser(pile2);
        
        assertEquals(pile1.getHauteur(), 4);
        assertEquals(pile1.getBoutonSommet(), Bouton.ROUGE);
        
        pile1.poser(Bouton.BLANC);
        assertEquals(pile1.getHauteur(), 5);
        assertEquals(pile1.getBoutonSommet(), Bouton.BLANC);
    }
    
    @Test
    public void testToString() {
        Pile pile1 = new Pile(1, Bouton.BLANC);
        assertEquals(pile1.toString(), "[BLANC]");
        
        pile1.poser(Bouton.ROUGE);
        assertEquals(pile1.toString(), "[BLANC, ROUGE]");
        
        pile1.poser(pile1);
        assertEquals(pile1.toString(), "[BLANC, ROUGE, BLANC, ROUGE]");
    }
    
    @Test
    public void testEquals() {
        Pile pile1 = new Pile(1, Bouton.BLANC);
        Pile pile2 = new Pile(2, Bouton.BLANC);
        assertNotSame(pile1, pile2);
        
        Pile pile3 = new Pile(3, Bouton.NOIR);
        Pile pile4 = new Pile(4, Bouton.ROUGE);
        assertNotSame(pile3, pile4);
        
        Pile pile5 = new Pile(5, new ArrayList<>(Arrays.asList(Bouton.NOIR, Bouton.BLANC, Bouton.NOIR)));
        Pile pile6 = new Pile(6, new ArrayList<>(Arrays.asList(Bouton.NOIR, Bouton.BLANC, Bouton.NOIR)));
        assertNotSame(pile5, pile6);
        
        Pile pile7 = pile1;
        assertEquals(pile1, pile1);
        assertEquals(pile1, pile7);
    }
}
