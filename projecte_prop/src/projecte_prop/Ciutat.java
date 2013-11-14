
package projecte_prop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josep
 */

public class Ciutat {
 
    private String nom;
    private Relations Rel;
    private Tour CjtPunts;
    
    
    public Ciutat(String nom){
        this.nom = nom;
        CjtPunts = new Tour();
        Rel = new Relations();
        
    }
    
    public void addElement(List<Integer> aux){
        Rel.addElement(aux);
        CjtPunts.addElement(new Element());
    }
    
    public void removeElement(Element elem){
        CjtPunts.removeElement(elem);
        Rel.erase(elem.getID());
    }
    
    public int num_Elements(){
        return CjtPunts.size();     
    }
    
    public Relations get_Relations(){
       return Rel;
    }
    
    public Tour get_Tour(){
        return CjtPunts;
    }
    
    
}