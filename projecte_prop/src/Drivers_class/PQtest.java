/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;
import projecte_prop.PQsort;
import java.util.PriorityQueue;
import projecte_prop.Relation;

/**
 *
 * @author joanbarrosogarrido
 */
public class PQtest {
    
    public static void main(String args[]) {
        PQsort sort = new PQsort();
        PriorityQueue<Relation> PQ = new PriorityQueue<Relation>(8,sort);
        Relation R = new Relation(0,1,20);
        PQ.add(R);
        R = new Relation(0,2,201);
        PQ.add(R);
        R = new Relation(0,3,21);
        PQ.add(R);
        R = new Relation(0,4,10);
        PQ.add(R);
        R = new Relation(0,5,40);
        PQ.add(R);
        R = new Relation(0,6,1);
        PQ.add(R);
        R = new Relation(0,7,90);
        PQ.add(R);
        R = new Relation(0,8,3);
        PQ.add(R);
        
        for(int i = 0; i < 8; ++i) {
            System.out.println(PQ.poll().getValue());
        }
        
        
    }
    
    /*private Relation CreaRelationRandom() {
        
    }
    */
}
