
package Domini;

import java.util.Comparator;

public class PQsort implements Comparator<Relation> {

    @Override
    public int compare(Relation r1, Relation r2) {
        return (r1.getValue() - r2.getValue());
    }
    
}
