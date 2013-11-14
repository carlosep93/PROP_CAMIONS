
package projecte_prop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josep
 */

public class Ciutat {
    
    private int nPunts;
    private String nom;
    private Relations Rel;
    private Tour CjtPunts;
    
    
    public Ciutat(int nPunts){
        this.nPunts = nPunts;
        CjtPunts = new Tour();
        Rel = new Relations();
        
    }
    
    public boolean addPunt(List<Integer> aux){
        return CjtPunts.addElement(aux);
    }
    
    
}
