package buttonup;

import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jérémy Courel
 */
public class JeuTest {
    
    public JeuTest() {
    }
    
    @Test
    public void testNouveauPlateau() {
        Jeu jeu = new Jeu();
        Plateau plateau = jeu.getPlateau();
        jeu.nouveauPlateau();
        assertNotSame(plateau.toString(), jeu.getPlateau().toString());
    }
    
    @Test
    public void testChangerJoueurCourant() {
        Jeu jeu = new Jeu();
        Joueur joueurCourant = jeu.getJoueurCourant();
        jeu.changerJoueurCourant();
        assertNotSame(joueurCourant, jeu.getJoueurCourant());
    }
    
    @Test
    public void testIndiceCorrect() {
        Jeu jeu = new Jeu();
        assertTrue(jeu.indiceCorrect(2));
        assertTrue(jeu.indiceCorrect(4));
        assertTrue(jeu.indiceCorrect(8));
        assertTrue(jeu.indiceCorrect(0));
        
        assertFalse(jeu.indiceCorrect(-5));
        assertFalse(jeu.indiceCorrect(12));
    }
    
    @Test
    public void testEstUnEntier() {
        Jeu jeu = new Jeu();
        assertTrue(jeu.estUnEntier("-1"));
        assertTrue(jeu.estUnEntier("4"));
        assertTrue(jeu.estUnEntier("8"));
        assertTrue(jeu.estUnEntier("4000"));
        
        assertFalse(jeu.estUnEntier("-5.12"));
        assertFalse(jeu.estUnEntier("dsdq"));
    }
}
