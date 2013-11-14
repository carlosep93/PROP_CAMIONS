/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

/**
 *
 * @author joanbarrosogarrido
 */
public class Cjt_tours {
    private int nTours;
    private Tour[] cjtTours;
    
    
    //Es crea un conjunt de tours de mida nTours, buit
    public Cjt_tours(int nTours) {
        this.nTours = nTours;
        cjtTours = new Tour[nTours];
    }
    
    //S'afegeix un tour al conjunt de tours
    public void addTour(int pos, Tour T) {
        cjtTours[pos] = T;
    }
    public int Fitness() {
        return getFittestTour().getCost();
    }
    //As retorna el tour "idtour"
    public Tour getTour(int idTour) {
        return cjtTours[idTour];
    }
    
    //Ens retorna el cost d'un Tour
    public int getCostTour(int idTour) {
        return cjtTours[idTour].getCost();
    }
    
    //Ens retorna el Tour amb el pes minim
    public  Tour getFittestTour() { 
        int idTour = 0;
        for (int i = 1; i < nTours; ++i) {
            if (getCost(cjtTours[idTour]) > getCost(cjtTours[i]) idTour = i);
        }
        return cjtTours[idTour];
    }
    
    //Copiem el Tour de la posició id2 en la posicio id1
    public void copyTour(int id1, int id2) {
        cjtTours[id2] = cjtTours[id1]; //alomejor peta
    }
    
    //Fem un swap de dos tours en el conjunt de tours
    public void swapTours(int pops1,int pos2) {
        Tour T = new Tour();
        T = cjtTours[pos1];
        cjtTours[pos1] = cjtTours[pos2];
        cjtTours[pos2] = T;
    }
}
