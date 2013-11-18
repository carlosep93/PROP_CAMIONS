
package projecte_prop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pol
 */



public class Ciutat {
    private String nom;
    private Relations Rel;
    private Tour CjtPunts;
    private Solution sol;
    
    
    /** @brief Creadora de Ciutat 
     \pre NULL
     \post  
  **/
    public Ciutat(){
     nom = "SenseNom";
     CjtPunts = new Tour();
     Rel = new Relations ();
     sol = new Solution();   
        
    }
    /** @brief descripció curta 
     \pre
     \post 
  **/
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
     
     public void add_Relations(Relations rel){
        this.Rel = rel;
        this.CjtPunts = new Tour(rel.size());
    }
    
    public void addElement(Element E, List<Integer> aux){ //et pasen el conjunt de relacions del element
        Rel.addElement(aux);
        CjtPunts.addElement(E);
    }
    
    public void removeElement(String nom){
        int id = CjtPunts.getElementNom(nom).getID();
        CjtPunts.inhabilitaElement(id);
        Rel.erase(id);
    }
    
    public boolean[] getActius(){
        boolean b[] = new boolean[CjtPunts.size()];
        for(int i = 0; i < CjtPunts.size(); ++i){
            b[i] = CjtPunts.getElementPos(i).isEnabled();
        }
        return b;
    }

}
