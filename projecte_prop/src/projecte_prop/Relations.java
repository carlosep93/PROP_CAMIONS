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
        System.out.println("size "+a.get(id).size());
        int n = a.get(id).size();
        a.get(id).remove(n-1);
        a.get(id).add(-1);
    }
    
    public void addElement(int id) {
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
    
    public int [][] toMatrix() {
        int [][] res = new int [a.size()][a.size()];
        for (int i=0;i<a.size();++i){
            for (int j=0;j<a.get(i).size();++j) {
                res[i][j] = res[j][i] = a.get(i).get(j);
            }
        }
        return res;
    }
    
    public void readRelations(int n) {
        for (int i=0;i<n;++i) {
            addElement(i);
        }
    }
        
      public void writeRelations() {
        for (int i=0;i<a.size();++i){
            for (int j=0;j<a.get(i).size();++j) {
                System.out.print(" "+a.get(i).get(j));
            }
            System.out.println();
        }
            
    } 
    
  
    
    
}
