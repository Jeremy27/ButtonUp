/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package buttonup;

/**
 *
 * @author jeremy
 */
public class Joueur {
    
    private String nom;
    private Bouton bouton;
    private int score;
    
    public Joueur(String nom, Bouton bouton) {
        this.nom = nom;
        this.bouton = bouton;
    }

    public String getNom() {
        return nom;
    }

    public Bouton getBouton() {
        return bouton;
    }

    public int getScore() {
        return score;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setBouton(Bouton bouton) {
        this.bouton = bouton;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public boolean aGagne() {
        return score >= 15;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Joueur:");
        sb.append(nom);
        sb.append(" -- Bouton:");
        sb.append(bouton.name());
        sb.append(" -- Score:");
        sb.append(score);
        
        return sb.toString();
    }
}
