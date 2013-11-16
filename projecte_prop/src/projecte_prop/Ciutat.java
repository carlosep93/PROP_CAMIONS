
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
    private Solution sol;
    
    public Ciutat(){
     nom = "SenseNom";
     CjtPunts = new Tour();
     Rel = new Relations ();
     sol = new Solution();   
        
    }
    
    public Ciutat(String nom){
        this.nom = nom;
        CjtPunts = new Tour();
        Rel = new Relations ();
        sol = new Solution(nom);
        
    }
    
     public String get_Nom(){
        return nom;
    }
    public Relations get_Relations(){
       return Rel;
    }
    
     public Tour get_Tour(){
        return CjtPunts;
    }
   
     public Solution get_Solution(){
    return sol;
    }
    
     
    public int num_Elements(){
        return CjtPunts.size();     
    }
    

     public void add_Solution(Solution sol){
        this.sol = sol;
    }
    
    public void addElement(Element E, List<Integer> aux){ //et pasen el conjunt de relacions del element
        Rel.addElement(aux);
        CjtPunts.addElement(E);
    }
    
    public void removeElement(Element elem){
        CjtPunts.removeElement(elem);
        Rel.erase(elem.getID());
    }

}
