package buttonup;

/**
 *
 * @author Jérémy Courel
 */
public class Jeu {
    
    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurCourant;
    
    public Jeu(Joueur joueur1, Joueur joueur2) {
        plateau = new Plateau();
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.joueurCourant = joueur1;
    }
    
    Jeu() {
        plateau = new Plateau();
        this.joueur1 = new Joueur("test", Bouton.NOIR);
        this.joueur2 = new Joueur("test2", Bouton.ROUGE);
        this.joueurCourant = joueur1;
    }
    
    public void nouveauPlateau() {
        plateau = new Plateau();
    }
    
    public boolean semer(int indicePile) {
        return plateau.semer(indicePile);
    }
    
    public void changerJoueurCourant() {
        if(joueurCourant == joueur1) {
            joueurCourant = joueur2;
        } else {
            joueurCourant = joueur1;
        }
    }
    
    public boolean indiceCorrect(int indicePile) {
        if(indicePile < 0) {
            System.out.println("[ERREUR L'indice choisi doit être supérieur à 0]");
            return false;
        } else if(indicePile >= plateau.getNbPiles()) {
            System.out.println("[ERREUR L'indice choisi doit être inférieur à "+plateau.getNbPiles()+"]");
            return false;
        }
        return true;
    }
    
    public boolean estUnEntier(String donnee) {
        try {
            Integer.parseInt(donnee);
            return true;
        }catch(NumberFormatException e) {
            System.out.println("[ERREUR] L'indice "+donnee+" doit être un entier supérieur à 0 et inférieur à "+plateau.getNbPiles());
            return false;
        }
    }
    
    public boolean coupPossible(int indicePile) {
        if(plateau.coupPossible(indicePile)) {
            return true;
        } else {
            System.out.println("[ERREUR] La pile "+indicePile+" ne contient pas d'espion, choisissez une pile avec au moins un bouton BLANC");
            return false;
        }
    }
    
    public String etatJoueurs()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(joueur1);
        sb.append("\n\n");
        sb.append(joueur2);
        
        return sb.toString();
    }
    
    public void calculerPoints() {
        joueur1.setScore(plateau.getNbPoints(Bouton.NOIR));
        joueur2.setScore(plateau.getNbPoints(Bouton.ROUGE));
    }
    
    public boolean estTermine() {
        return (joueur1.aGagne() || joueur2.aGagne());
    }
    
    public Joueur getJoueurGagnant() {
        if(joueur1.getScore() > joueur2.getScore())
            return joueur1;
        else if(joueur1.getScore() < joueur2.getScore())
            return joueur2;
        return null;
    }
    
    public Joueur getJoueurCourant() {
        return joueurCourant;
    }
    
    public Plateau getPlateau() {
        return plateau;
    }
}
