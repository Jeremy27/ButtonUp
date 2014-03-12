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

    private void initialiserPlateau() {
        for (int i = 0; i < 3; i++) {
            this.listePiles.add(new Pile(Bouton.BLANC));
            this.listePiles.add(new Pile(Bouton.NOIR));
            this.listePiles.add(new Pile(Bouton.ROUGE));
        }
        Collections.shuffle(listePiles);
    }
    
    public void semer(Pile pile) {
        int positionDepart = getPositionPile(pile)+1;
//        for(Bouton bouton : pile.getListeBoutons()) {
//            if(positionDepart == pile.getListeBoutons().size()-1)
//                listePiles.get(positionDepart).poser(pile);
//            listePiles.get(positionDepart++).poser(pile.);
//        }
    }
    
    public int getPositionPile(Pile pile) {
        return listePiles.indexOf(pile);
    }
}
