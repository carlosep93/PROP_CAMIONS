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
    private int id;
    private int[] cjtElem;
    
    
    public Tour(){
        cjtElem = new int [10];
        cost = (int)(Math.random() *100);
        this.id = id;
        for (int i = 0; i < 10; ++i) {
            cjtElem[i] = id = i; 
        }
    }
    public int getCost() {
        return cost;
    }
    
    
}
