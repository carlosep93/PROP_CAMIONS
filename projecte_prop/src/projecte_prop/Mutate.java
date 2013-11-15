
package projecte_prop;

public class Mutate {
    
    public Tour mutate(Tour tour, int mutationRate){
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
    
    public Tour mutate2(Tour tour, double mutationRate, double mutationSwapProbability) {
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
        int costTour = tour.getCost();     //sha de fer un objecte de tipus solutions
        int costMutated = mutated.getCost();
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
    public static void  mutate3 (Tour t, Relations r) {
        int max1 = r.getCost(t.getElementPos(0), t.getElementPos(1));
        int max2 = 0;
        int aux;
        for (int i=1; i < t.size()-1;++i) {
            aux = r.getCost(t.getElementPos(i), t.getElementPos(i+1));
            if (max1 < aux) 
                max1 = aux;
            else if (max2 < aux)
                max2 = aux;
        }
        t.swap(max1,max2);
    }
}
