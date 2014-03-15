package buttonup;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jérémy Courel
 */
public class Plateau {

    private ArrayList<Pile> listePiles;

    public Plateau() {
        listePiles = new ArrayList<>();
        initialiserPlateau();
    }

    Plateau(ArrayList<Pile> listePiles) {
        this.listePiles = listePiles;
    }

    final void initialiserPlateau() {
        int numPile = 0;
        for (int i = 0; i < 3; i++) {
            this.listePiles.add(new Pile(numPile++, Bouton.BLANC));
            this.listePiles.add(new Pile(numPile++, Bouton.NOIR));
            this.listePiles.add(new Pile(numPile++, Bouton.ROUGE));
        }
        Collections.shuffle(listePiles);
    }
    
    public boolean semer(int indicePile) {
        Pile pile = listePiles.remove(indicePile);
        int i = indicePile;
        boolean rejouer = false;
        
        while(!pile.estVide()) {
            if(getIndiceSuivant(i) == indicePile || listePiles.size() == 1) {
                int hauteurPile = pile.getHauteur();
                for (int j = 0; j < hauteurPile; j++) {
                    listePiles.get(i).poser(pile.supprimerBoutonBase());
                }
                rejouer = false;
            } else {
                if(i == listePiles.size()) {
                    i = 0;
                }
                rejouer = rejouer(listePiles.get(i).getBoutonSommet(), pile.getBoutonSommet());
                listePiles.get(i).poser(pile.supprimerBoutonSommet());
            }
            i++;
        }
        return rejouer;
    }
    
    public boolean rejouer(Bouton bouton1, Bouton bouton2) {
        return bouton1.equals(bouton2);
    }
    
    private int getIndiceSuivant(int indiceCourant) {
        if(indiceCourant == listePiles.size()-1)
            return 0;
        else
            return indiceCourant+1;
    }
    
    public boolean coupPossible(int indicePile) {
        return listePiles.get(indicePile).contientUnEspion();
    }
    
    public boolean estTermine() {
        return listePiles.size() == 1;
    }
    
    public int getPositionPile(Pile pile) {
        return listePiles.indexOf(pile);
    }
    
    public ArrayList<Pile> getListePiles() {
        return listePiles;
    }
    
    public int getNbPiles() {
        return listePiles.size();
    }
    
    public int getNbPoints(Bouton bouton) {
        return listePiles.get(0).getScore(bouton);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(Pile pile : listePiles) {
            sb.append("Pile ");
            sb.append(i++);
            sb.append(" : ");
            sb.append(pile);
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
