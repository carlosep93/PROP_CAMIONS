/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

/**
 *
<<<<<<< HEAD
 * @author helewt
 */
public class Relation {
    int id_elem1;
    int id_elem2;
    int distancia;
    
    
    public Relation(int id1, int id2, int dist){
        id_elem1 = id1;
        id_elem2 = id2;
        distancia = dist;
        
    }
    
    public int relation_with(int  id){
        
        
        
    }
    
    
    
=======
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
        return id1;
    }
>>>>>>> 3b6755ab5cccd935e874809ab81946c7ed33a981
}
