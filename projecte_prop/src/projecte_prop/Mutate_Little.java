
package projecte_prop;

public class Mutate_Little {
    
    public static void  mutate(Ciutat C, Tour tour){
        if (tour.size()>=1){ 
            int max1 = C.get_Relations().getCost(tour.getElementPos(0).getID(),
                    tour.getElementPos(1).getID());        
            int max2 = 0;
            int aux;
            int pos1 = 0;
            int pos2 = 1;
            for (int i=1; i < tour.size()-1;++i) {
                aux = C.get_Relations().getCost(tour.getElementPos(i).getID(),
                    tour.getElementPos(i+1).getID());
                if (max1 < aux) {
                    max2 = max1;
                    max1 = aux;
                    pos2 = pos1;
                    pos1 = i;

                }        
            }
            tour.swap(pos1,pos2);
        }
    }
    
    public Tour mutate(Tour tour, double mutationRate){
        return null;
    }
    
    public Tour mutate(Ciutat C, Tour tour, double mutationRate, double mutationSwapProbability){
        return null;
    }
    
}
