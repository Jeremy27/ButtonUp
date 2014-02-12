/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package buttonup;

import java.util.ArrayList;

/**
 *
 * @author jeremy
 */
public class Plateau {
    
    private ArrayList<Pile> listePiles;
    
    public Plateau() {
        listePiles = new ArrayList<>();
    }
    
    Plateau(ArrayList<Pile> listePiles) {
        this.listePiles = listePiles;
    }
}
