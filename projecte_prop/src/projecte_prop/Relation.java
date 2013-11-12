/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

/**
 *
 * @author Carlos2
 */
public class Relation {
    private int id1;
    private int id2;
    private int distance;
    
    public Relation (int id1,int id2, int value) {
        this.id1 = id1;
        this.id2 = id2;
        this.distance = value;
    }
    public int getValue() {
        return distance;
    }
    public int getId1() {
        return id1;
    }
    public int getId2() {
        return id2;
    }
    public void updateValue(int value){
        distance = value;
    } 
    @Override
    public boolean equals(Object o) {
        if (o instanceof Relation) {
            Relation r = (Relation)o;
            return this.id1 == r.id1 && this.id2 == r.id2;
        }
        else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return id1*id2;
    }
}
