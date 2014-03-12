package buttonup;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Jérémy Courel
 */
public class Pile {

    private ArrayList<Bouton> listeBoutons;

    public Pile(Bouton bouton) {
        listeBoutons = new ArrayList<>();
        listeBoutons.add(bouton);
    }

    Pile(ArrayList<Bouton> listeBoutons) {
        this.listeBoutons = listeBoutons;
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
    
    public String getCouleurSommet() {
        return listeBoutons.get(listeBoutons.size()-1).name();
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
        return true;
    }
}
