/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

 import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

/**
 *
 * @author Carlos2
 */


public class Relations {
    
    List <List<Integer>> a = new ArrayList <List<Integer>>();
    
    public Relations() {
         
    }
    
    public int getCost(int id1, int id2) {
            int cost = -1;
            if (a.get(id2).get(a.size()) == 0 && a.get(id1).get(a.size()) == 0) {
                 if (a.get(id1).size() >= id2)
                     cost = a.get(id1).get(id2);
                 else if (a.get(id2).size() >= id1)
                     cost = a.get(id2).get(id1);
            }
            return cost;
    }
    
    public void erase(int id){
        int n = a.get(id).size();
        a.get(id).add(n,-1);
    }
    
    public void readRelation(int id) {
        Scanner in = new Scanner(System.in);
        int x;
        List<Integer> aux = new ArrayList<Integer>();
        for (int i=0; i<id;++i) {
            x = in.nextInt();
            aux.add(x);
        }
        aux.add(0);
        a.add(aux);
    }
    
    
    
  
    
    
}
