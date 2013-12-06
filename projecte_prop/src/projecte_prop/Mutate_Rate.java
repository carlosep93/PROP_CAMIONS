
package projecte_prop;

public class Mutate_Rate extends Mutate{
    
    private City C;
    private double mutationRate;
    
    public Mutate_Rate(City C, double mutationRate){
        this.C = C;
        this.mutationRate = mutationRate;
    }
    
    @Override public Tour mutate(Tour tour){
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
