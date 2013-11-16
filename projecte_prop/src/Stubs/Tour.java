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
        size = 10;
        cjtElem = new int [10];
        cost = (int)(Math.random() *100);
        for (int i = 0; i < 10; ++i) {
            cjtElem[i] = i; 
        }
    }
    public int getCost() {
        return cost;
    }
    
    public int getCost_withRelation (Relations R) {
        return cost;
    }
    
    public int size() {
        return size;
    }
    
    public Element getElementPos(int pos) {
        return new Element();
    }
    
    public int getPosElement(Element E) {
        return 0;
    }
    
    
    
}
