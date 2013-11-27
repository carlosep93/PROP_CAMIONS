/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

/**
 *
 * @author joanbarrosogarrido
 */

//import Stubs.Tour;
//import Stubs.Element;

public class CjtTours {
    private int nTours;
    private Tour[] cjtTours;
    
    
    //Es crea un conjunt de tours de mida nTours, buit
    /** @brief Creadora de CjtTours
        \pre
        \post   el CjtTours ha sigut creat amb una llargada nTurs i tots els Tours inicialitzats
    */
    public CjtTours(int nTours) {
        this.nTours = nTours;
        cjtTours = new Tour[nTours];
        for(int i = 0; i < nTours; ++i) cjtTours[i] = new Tour();
    }
    
    //S'afegeix un tour al conjunt de tours
    /** @brief S'afegeix un tour a cjtTours
        \pre   0 >= pos < nTours, T not null
        \post  S'ha afegit un Tour a la posició pos
    */
    public void addTour(int pos, Tour T) {
        if(cjtTours[pos].size() == T.size()){
            for (int i = 0; i < T.size();++i) {
                cjtTours[pos].replaceElementPos(T.getElementPos(i), i);
            }
        }
        else{
          for(int i = 0; i < T.size(); ++i){
                cjtTours[pos].addElement(T.getElementPos(i));
            }  
        }
    }
    
    /** @brief s'afegeix un tour a CjtTours
    \pre    0 >= pos < nTours, T != null, la CjtTours[pos] == empty.
    \post   S'ha afegit un tour al CjtTours a la posició pos
    */
    
    public void addTourEmpty(int pos, Tour T) {
          for(int i = 0; i < T.size(); ++i){
                cjtTours[pos].addElement(T.getElementPos(i));
            }
    }
    
    /** @brief S'afegeix un element a un tour del conjunt
        \pre  0 >= x < nTours, E != null, y dins el rang de Tour 
        \post   S'ha afegit l'element E en la posició del tour que esta en la posició x del cjttours, en la posició y.
    */
    
    public void addElementTour(int x, int y, Punt E) {
        cjtTours[x].addElement(E,y);
    }
    
    /** @brief retorna un tour
        \pre    nTours > 0 i el conjunt no ha de tenir tours nulls
        \post   Es retorna el Tour que té el cost minim en tot el conjunt de Tours.
    */
    

    public int getFitness(Ciutat C) {
        return getFittestTour(C).getCost(C);
    }

    
    //As retorna el tour "idtour"
    /** @brief retorna un tour
        \pre    0 >= idTour < nTours
        \post   es retorna el tour que està en la posició idTour
    */
    
    public Tour getTour(int idTour) {
        return cjtTours[idTour];
    }
    
    //Ens retorna el cost d'un Tour
    /** @brief Obtenim el cost d'un tour
        \pre    0 >= idTour < nTours
        \post   retorna el cost del tour situat en la posició idTour en el cjtTour
    */
    
    public int getCostTour(Ciutat C, int idTour) {
        return cjtTours[idTour].getCost(C);
    }
    
    //Ens retorna el Tour amb el pes minim
    /** @brief sobté un tour
        \pre    nTours > 0 i el conjunts no ha de tenir tours nulls
        \post   es retorna el Tour amb el cost de pasar per tots els seus elements és el més baix del conjunt
    */
    
    public  Tour getFittestTour(Ciutat C){ 
        int idTour = 0;
        for (int i = 1; i < nTours; ++i) {
            if (cjtTours[idTour].getCost(C) > cjtTours[i].getCost(C)) idTour = i;
        }
        return cjtTours[idTour];
    }
    
    //Copiem el Tour de la posició id2 en la posicio id1
    /** @brief es copia un tour d'una posició en una altre del connjunt
        \pre    els dos tours existeixen
        \post   ara en el conjunt de tours, en les posicions id1 i id2 
    */
    
    public void copyTour(int id1, int id2) {
        cjtTours[id2] = cjtTours[id1];
    }
    
    //Fem un swap de dos tours en el conjunt de tours
    /** @brief intercanvia dos tours en el conjunt
        \pre    els dos tours existeixen en el conjunt
        \post   els dos tours queden intercanviats de posició en el conjunt
    */
    
    public void swapTours(int pos1,int pos2) {
        Tour T;
        T = cjtTours[pos1];
        cjtTours[pos1] = cjtTours[pos2];
        cjtTours[pos2] = T;
    }
    
    /** @brief mida de el conjunt de tours
        \pre    
        \post   es retorna la mida del conjunt de tours
    */
    
    public int sizeCjtTours() {
        return nTours;
    }
}
