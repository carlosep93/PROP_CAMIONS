/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

/**
 *
 * @author Carlos2
 */
import java.util.HashSet;

public class Cjt_Relations {
    
    HashSet<Relation> cjtr = new HashSet<Relation>(); 
    
    public Cjt_Relations() {}
    
    public void add(Relation r) {
        cjtr.add(r);
    }
    
    
}
