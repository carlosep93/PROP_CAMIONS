
package projecte_prop;

public class Mutate_Little {
    
    public static void  mutate(City C, Tour tour, double mutationRate, double mutationSwapProbability){
        if (tour.size()>=1){ 
            int max1 = C.getAdjacency().get(tour.getElementPos(0).getID()).get(tour.getElementPos(1).getID());
            int max2 = 0;
            int aux;
            int pos1 = 0;
            int pos2 = 1;
            for (int i=1; i < tour.size()-1;++i) {
                aux = C.getAdjacency().get(tour.getElementPos(i).getID()).get(tour.getElementPos(i+1).getID());
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
}
