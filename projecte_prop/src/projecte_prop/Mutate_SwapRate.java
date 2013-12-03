
package projecte_prop;

public class Mutate_SwapRate extends Mutate{
    
    @Override public Tour mutate(City C, Tour tour, double mutationRate, double mutationSwapProbability){
        Tour mutated=tour;
        double chance;
        int mida = tour.size();
        // mutate each Element in tour with some probability
        for(int i=0;i<mida;i++) {
            chance = Math.random();
            if (chance<mutationRate) {
                int punt = (int)(Math.random() * mida);
                while (punt == i) { // ens asegurem que de que es faci el canvi per un altre
                    punt = (int)(Math.random() * mida);
                }
                mutated.swap(punt, i);
            }
        }
        int costTour = tour.getCost(C);     //sha de fer un objecte de tipus solutions
        int costMutated = mutated.getCost(C);
        // determine whether to return the shorter or longer tour of the two
        if (Math.random() < mutationSwapProbability) {
            if (costMutated < costTour) {
                return mutated;
            }
            else return tour;
        }
        else {
             if (costMutated < costTour) {
                return tour;
            }
            else return mutated;
        }
    }
}
