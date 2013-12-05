
package projecte_prop;

public class Mutate_Little extends Mutate{
    
    @Override public Tour mutate(City C, Tour tour, double mutationRate, double mutationSwapProbability){
        if (tour.size()>=1){ 
            int max1 = C.getCost(tour.getElementPos(0), tour.getElementPos(1));
            int max2 = 0;
            int aux;
            int pos1 = 0;
            int pos2 = 1;
            for (int i=1; i < tour.size()-1;++i) {
                aux = C.getCost(tour.getElementPos(i), tour.getElementPos(i+1));
                if (max1 < aux) {
                    max2 = max1;
                    max1 = aux;
                    pos2 = pos1;
                    pos1 = i;

                }        
            }
            tour.swap(pos1,pos2);
        }
        /*int i = (int)(Math.random()*tour.size()-1);
        int j = (int)(Math.random()*tour.size()-1);
        tour.swap(i, j);*/
        return tour;
    }
}
