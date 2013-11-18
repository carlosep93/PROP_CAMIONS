/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

/**
 *
 * @author Carlos2
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
    public void addTourEmpty(int pos, Tour T) {
    }
     public int sizeCjtTours() {
        return 1;
    }
    public void copyTour(int id1, int id2) {

    }
}
