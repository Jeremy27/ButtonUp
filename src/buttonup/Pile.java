package buttonup;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Jérémy Courel
 */
public class Pile {

    private ArrayList<Bouton> listeBoutons;
    private final int numPile;
    
    public Pile(int numPile, Bouton bouton) {
        listeBoutons = new ArrayList<>();
        listeBoutons.add(bouton);
        this.numPile = numPile;
    }

    Pile(int numPile, ArrayList<Bouton> listeBoutons) {
        this.listeBoutons = listeBoutons;
        this.numPile = numPile;
    }
    
    public int getNumPile() {
        return numPile;
    }

    public int getHauteur() {
        return listeBoutons.size();
    }
    
    public boolean contientUnEspion() {
        return listeBoutons.contains(Bouton.BLANC);
    }
    
    public void poser(Bouton bouton) {
        listeBoutons.add(bouton);
    }
    
    public void poser(Pile pile) {
        listeBoutons.addAll(pile.getListeBoutons());
    }
    
    public ArrayList<Bouton> getListeBoutons() {
        return listeBoutons;
    }
    
    public Bouton getBoutonSommet() {
        return listeBoutons.get(listeBoutons.size()-1);
    }
    
    public Bouton getBoutonBase() {
        return listeBoutons.get(0);
    }
    
    public Bouton supprimerBoutonBase() {
        return listeBoutons.remove(0);
    }
    
    public Bouton supprimerBoutonSommet() {
        return listeBoutons.remove(listeBoutons.size()-1);
    }
    
    public boolean estVide() {
        return listeBoutons.isEmpty();
    }
    
    public int getScore(Bouton bouton) {
        int score = 0;
        
        for (int i = 0; i < listeBoutons.size(); i++) {
            if(listeBoutons.get(i).equals(bouton)) {
                score += i+1;
            }
        }
        
        return score;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("[");
        for(Bouton bouton : listeBoutons) {
            sb.append(bouton.name());
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.listeBoutons);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pile other = (Pile) obj;
        if (!Objects.equals(this.listeBoutons, other.listeBoutons)) {
            return false;
        }
        if(this.numPile != ((Pile) obj).getNumPile()){
            return false;
        }
            
        return true;
    }
}
