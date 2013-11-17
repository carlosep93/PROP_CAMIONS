/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

/**
 *
 * @author joanbarrosogarrido
 */
public class CjtTours {
    private int nTours;
    private Tour[] cjtTours;
    
    
    //Es crea un conjunt de tours de mida nTours, buit
    /** @brief
        \pre
        \post   
    */
    public CjtTours(int nTours) {
        this.nTours = nTours;
        cjtTours = new Tour[nTours];
        for(int i = 0; i < nTours; ++i) cjtTours[i] = new Tour();
    }
    
    //S'afegeix un tour al conjunt de tours
    /** @brief
        \pre    
        \post   
    */
    public void addTour(int pos, Tour T) {
        for (int i = 0; i < T.size();++i) {
            cjtTours[pos].addElement(T.getElementPos(i));
        }
    }
    
    
    /** @brief
        \pre    
        \post   
    */
    public void addElementTour(int x, int y, Element E) {
        cjtTours[x].addElement(E,y);
    }
    /** @brief
        \pre    
        \post   
    */
    public int getFitness() {
        return getFittestTour().getCost();
    }
    
    //As retorna el tour "idtour"
    /** @brief
        \pre    
        \post   
    */
    public Tour getTour(int idTour) {
        return cjtTours[idTour];
    }
    
    //Ens retorna el cost d'un Tour
    /** @brief
        \pre    
        \post   
    */
    public int getCostTour(int idTour) {
        return cjtTours[idTour].getCost();
    }
    
    //Ens retorna el Tour amb el pes minim
    /** @brief
        \pre    
        \post   
    */
    public  Tour getFittestTour() { 
        int idTour = 0;
        for (int i = 1; i < nTours; ++i) {
            if (cjtTours[idTour].getCost() > cjtTours[i].getCost()) idTour = i;
        }
        return cjtTours[idTour];
    }
    
    //Copiem el Tour de la posició id2 en la posicio id1
    /** @brief
        \pre    
        \post   
    */
    public void copyTour(int id1, int id2) {
        cjtTours[id2] = cjtTours[id1]; //alomejor peta
    }
    
    //Fem un swap de dos tours en el conjunt de tours
    /** @brief
        \pre    
        \post   
    */
    public void swapTours(int pos1,int pos2) {
        Tour T;
        T = cjtTours[pos1];
        cjtTours[pos1] = cjtTours[pos2];
        cjtTours[pos2] = T;
    }
    
    /** @brief
        \pre    
        \post   
    */
    public int sizeCjtTours() {
        return nTours;
    }
}
