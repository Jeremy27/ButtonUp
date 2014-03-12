package buttonup;

/**
 *
 * @author Jérémy Courel
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
