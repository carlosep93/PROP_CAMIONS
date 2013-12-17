
package Domini;

public class Mutate_Little extends Mutate{
    
    public Mutate_Little(){}
    
    
    @Override public Tour mutate(City C, Tour tour){
        if (tour.size()>=1){ 
            int max = C.getCost(tour.getElementPos(0), tour.getElementPos(1));
            int aux;
            int pos1 = 0;
            int pos2 = 1;
            for (int i=1; i < tour.size()-1;++i) {
                aux = C.getCost(tour.getElementPos(i), tour.getElementPos(i+1));
                if (max <= aux && pos2 != i-1) {
                    max = aux;
                    if (aux >=  C.getCost(tour.getElementPos(pos1), tour.getElementPos(pos1+1)))
                        pos1 = pos2;
                    pos2 = i;
                    
                }        
            }
            ++pos1;
            while (pos2 > pos1 && pos1 >= 0) {
                tour.swap(pos1, pos2);
                ++pos1;
                --pos2;
            }
            
        }
        /*int i = (int)(Math.random()*tour.size()-1);
        int j = (int)(Math.random()*tour.size()-1);
        tour.swap(i, j);*/
        return tour;
    }
}
