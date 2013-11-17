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
    
    List <List<Integer>> a; 
    
    public Relations() {
         a = new ArrayList <List<Integer>>();
    }
    
    
    
    public int getCost(int id1, int id2) {
        int cost = -1;
        if (a.isEmpty());
        else if (a.get(id2).get(a.get(id2).size()-1) == 0 && 
                a.get(id1).get(a.get(id1).size()-1) == 0) {
             if (a.get(id1).size() > id2)
                 cost = a.get(id1).get(id2);
             else if (a.get(id2).size() > id1)
                 cost = a.get(id2).get(id1);
        }
        return cost;
    }
    
    public int getCost(Element e1,Element e2) {
        int cost = -1;
        int id1 = e1.getID();
        int id2 = e2.getID();
        if (a.get(id2).get(a.get(id2).size()-1) == 0 && 
                a.get(id1).get(a.get(id1).size()-1) == 0) {
             if (a.get(id1).size() > id2)
                 cost = a.get(id1).get(id2);
             else if (a.get(id2).size() > id1)
                 cost = a.get(id2).get(id1);
        }
        return cost;
    }
    
    
    /** @brief  Esborra un element de la Relations
        \pre    La Relation ha de contenir elements    
        \post   L'element indicat per el parametre id es marca com esborrat
    */
    public void erase(int id){
        
        int n = a.get(id).size();
        a.get(id).remove(n-1);
        a.get(id).add(-1);
    }
   
    /** @brief  Agefeix un element a la Relation
        \pre    La Relation ha de estar inicialitzada    
        \post   La Relation conté les rela
    */    
    public void addElement(int id) {
        Scanner in = new Scanner(System.in);
        int x;
        List<Integer> aux = new ArrayList<Integer>();
        for (int i=0; i<id;++i) {
            if (a.get(i).get(a.get(i).size()-1) != 0) 
                aux.add(-1);
            else {
                x = in.nextInt();
                aux.add(x);
            }   
        }
        aux.add(0);
        a.add(aux);
    }
    
    public void addElement(List<Integer> l) {
        l.add(0);
        a.add(l);
    }
    
    public int [][] toMatrix() {
        int n = 0;
        boolean [] b = new boolean [a.size()];
        for (int j=0;j < a.size(); ++j) {
            if (a.get(j).get(a.get(j).size()-1) == -1) {
                System.out.println(j);
                b[j] = true;
                ++n;
            }
        }
        int [][] aux = new int [a.size()][a.size()];
        for (int i=0;i<a.size()-n;++i){
            for (int j=0;j <= i;++j) {
                aux[i][j] = aux[j][i] = a.get(i).get(j);
            }
        }
        int [][] res = new int [a.size()-n][a.size()-n];
        int a1 = 0;
        int a2;
        for (int i=0;i<a.size();++i){
            a2 = 0;
            for (int j=0;j<=i;++j) {
                if (!b[i] && !b[j]) {
                    //System.out.println("i: "+i+"j: "+j );
                    res [a1][a2] = res[a2][a1]= aux[i][j];
                    ++a2;
                }
            }
            if(!b[i]) ++a1;
        }
        return res;
    }
    
    public int size() {
        return a.size();
    }
    
    public List<Integer> Actius() {
        List<Integer> l = new ArrayList<Integer>();
        for (int i=0;i<a.size();++i) {
            if (a.get(i).get(a.get(i).size()-1) == 0)
                l.add(i);
        }
        return l;
    }
    
    public void readRelations(int n) {
        for (int i=0;i<n;++i) {
            addElement(i);
        }
    }
        
    public String toString(int id) {
        return a.get(id).toString();        
    } 

}
