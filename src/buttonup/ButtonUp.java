package buttonup;

import java.util.Scanner;

/**
 *
 * @author Jérémy Courel
 */
public class ButtonUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        boolean redemander = true;
        boolean rejouer = false;
        System.out.print("Pseudo joueur 1 (Bouton NOIR): ");
        String pseudoJoueur1 = sc.next();
        System.out.print("Pseudo joueur 2 (Bouton ROUGE) : ");
        String pseudoJoueur2 = sc.next();
        
        Jeu jeu = new Jeu(new Joueur(pseudoJoueur1, Bouton.NOIR), new Joueur(pseudoJoueur2, Bouton.ROUGE));
        
        while(!jeu.estTermine()) {
            System.out.println(jeu.getPlateau());
            System.out.println(jeu.getJoueurCourant().getNom() + " à toi de jouer !\n");
            do {
                redemander = true;
                if(rejouer) {
                    System.out.println(jeu.getPlateau());
                    System.out.println("Bien joué, vous avez le droit de rejouer \n");
                    rejouer = false;
                }
                System.out.print("Numéro de la pile à semer : ");
                String strIndicePile = sc.next();
                if(jeu.estUnEntier(strIndicePile)) {
                    int indicePile = Integer.parseInt(strIndicePile);
                    if(jeu.indiceCorrect(indicePile) && jeu.coupPossible(indicePile)) {
                        rejouer = jeu.semer(indicePile);
                        redemander = false;
                    }
                }
            } while(redemander || rejouer);
            
            if(jeu.getPlateau().estTermine()) {
                System.out.println(jeu.getPlateau());
                jeu.calculerPoints();
                System.out.println(jeu.etatJoueurs());
                jeu.nouveauPlateau();
            }
            
            jeu.changerJoueurCourant();
        }
        
        Joueur gagnant = jeu.getJoueurGagnant();
        if(gagnant == null)
            System.out.println("Les deux joueurs sont à égalité !");
        else
            System.out.println("\n\n\nJOUEUR GAGNANT : " + gagnant);
    }
    
}
