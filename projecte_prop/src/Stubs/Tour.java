/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

/**
 *
 * @author joan
 */
public class Tour {
    private int cost;
    int size;
    private int[] cjtElem;
    
    
    public Tour(){
        int size;
        cjtElem = new int [10];
        cost = (int)(Math.random() *100);
        for (int i = 0; i < 10; ++i) {
            cjtElem[i] = id = i; 
        }
    }
    public int getCost() {
        return cost;
    }
    public int size() {
        return size;
    }
    
    
}
