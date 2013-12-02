
package projecte_prop;

public class Mutate_Rate extends Mutate{
    
    @Override public Tour mutate(City C, Tour tour, double mutationRate, double mutationSwapProbability){
        int mida = tour.size();
        for(int i = 0; i < mida; ++i){
            if(Math.random() <= mutationRate){
                //trobar una altra posició random per fer switch
                int punt = (int)(Math.random() * mida);
                
                //un switch de les dues posicions
                tour.swap(punt,i);
            }
        }
        return tour;
    }
}
