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

    void initialiserPlateau() {
        int numPile = 0;
        for (int i = 0; i < 3; i++) {
            this.listePiles.add(new Pile(numPile++, Bouton.BLANC));
            this.listePiles.add(new Pile(numPile++, Bouton.NOIR));
            this.listePiles.add(new Pile(numPile++, Bouton.ROUGE));
        }
        Collections.shuffle(listePiles);
    }
    
    public void semer(Pile pile) {
        int position = getPositionPile(pile)+1;
        listePiles.remove(pile);
        ArrayList<Bouton> listeBoutons = pile.getListeBoutons();
        
        while(listeBoutons.isEmpty() == false) {
            if(position == pile.getListeBoutons().size()-1) {
                listePiles.get(position).poser(pile);
                listeBoutons.clear();
            } else {
                listePiles.get(position).poser(listeBoutons.remove(0));
            }
            position++;
        }
    }
    
    public int getPositionPile(Pile pile) {
        return listePiles.indexOf(pile);
    }
    
    public ArrayList<Pile> getListePiles() {
        return listePiles;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for(Pile pile : listePiles) {
            sb.append("Pile ");
            sb.append(pile.getNumPile());
            sb.append(" : ");
            sb.append(pile);
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
