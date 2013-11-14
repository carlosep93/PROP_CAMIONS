
package projecte_prop;
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
    
    public boolean addPunt(Element E){
        return CjtPunts.addElement(E);
    }
    
    public void addRelation(){
        
    }
}
