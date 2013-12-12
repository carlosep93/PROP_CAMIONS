/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.Comparator;

/**
 *
 * @author joanbarrosogarrido
 */
public class PQsort implements Comparator<Relation> {

    @Override
    public int compare(Relation r1, Relation r2) {
        return (r1.getValue() - r2.getValue());
    }
    
}
