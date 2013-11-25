/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import java.util.ArrayList;
import java.util.List;
import projecte_prop.Element;

/**
 *
 * @author josep
 */
public class Relations {
    
    List <List<Integer>> a = new ArrayList <List<Integer>>();
    
    public Relations(){
        
    }
    
    public int getCost(int id1, int id2) {
        return 1;
    }
    
    public int getCost(Element e1,Element e2) {
        return 1;
    }
    
    public void erase(int id){
        
    }
    
    public void addElement(int id) {
        
    }
    
    public void addElement(List<Integer> l) {
        
    }
    
    public int [][] toMatrix() {
        int [][] ret = new int [0][0];
        return ret;
    }
    
    public int size() {
        return 0;
    }
    
    public List<Integer> Actius() {
        return new ArrayList<Integer>();
    }
    
    public void readRelations(int n) {
        
    }
    
    public String toString(int id) {
        return "hola";
    }

}
