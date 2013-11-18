/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

/**
 *
 * @author Joan
 */
public class CjtTours {
    private int nTours;
    private Tour[] cjtTours;
    
    public CjtTours(int nTours) {
        this.nTours = nTours;
        cjtTours = new Tour[nTours];
    }
    public void addTour(int pos, Tour T) {}
    
    public int getFitness() {
        return 1;
    }
    
    public Tour getTour(int idTours) {
        return  new Tour();
    }
    
    public int getCostTour(int idTour) {
        return 1;
    }
    public Tour getFittestTour() {
        return new Tour();
    }
}
