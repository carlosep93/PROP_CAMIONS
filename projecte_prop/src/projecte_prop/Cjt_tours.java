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
    public void cjtTours(int nTours) {
        this.nTours = nTours;
        cjtTours = new Tour[nTours];
    }
    
    //S'afegeix un tour al conjunt de tours
    public void addTour(int pos, Tour T) {
        cjtTours[pos] = T;
    }
    
    //As retorna el tour "idtour"
    public Tour getTour(int idTour) {
        return cjtTours[idTour];
    }
    
    //Ens retorna el cost d'un Tour
    public getCostTour(int idTour) {
            
    }
    
    //Ens retorna el Tour amb el pes minim
    public  Tour getFittestTour() { 
        int idTour = 0;
        for (int i = 1; i < nTours; ++i) {
            if (getcost(cjtTours[idTour]) > getCost(cjtTours[i]) idTour = i);
        }
        return cjtTours[idTour];
    }
    
    //Copiem el Tour de la posició id2 en la posicio id1
    public void copyTour(int id1, int id2) {
        for(int i = 0; i < cjtTours[id1].size(); ++i) {
            cjtTours[id1].removeElementPos(i);                                  //elimina l'element de la posició i del Tour id1
            cjtTours[id1].addElementPos(cjtTours[id2].getElementPor(i), i);     //copiem l'Element del tour de id2 de la possició i, en el tour id1 en la possició i
        }
    }
    
    
    
    
    
}
