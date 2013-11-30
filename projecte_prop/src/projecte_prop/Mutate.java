
package projecte_prop;

public abstract class Mutate {
    
    public abstract Tour mutate(Tour tour, double mutationRate);
    
    public abstract Tour mutate(Ciutat C, Tour tour, double mutationRate, double mutationSwapProbability);
    
    public abstract void  mutate(Ciutat C, Tour tour);
}
