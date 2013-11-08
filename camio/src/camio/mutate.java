
package camio;


public class mutate {
    
    public static int[] mutate(int tour[], int mutationRate){
        for(int i = 0; i < tour.length; ++i){
            if(Math.random() <= mutationRate){
                //trobar una altra posició random per fer switch
                int punt2 = (int)(Math.random() * tour.length);
                
                //un switch de les dues posicions
                int aux = tour[punt2];
                tour[punt2] = tour[i];
                tour[i] = aux;
            }
        }
        return tour;
    }
    
    public static int[] mutate2(int tour[], double mutationRate, double mutationSwapProbability) {
        int[] mutated=tour;
        double chance;
        // mutate each city in tour with some probability
        for(int i=0;i<tour.length;i++) {
            chance = Math.random();
            if (chance<mutationRate) {
                int punt2 = (int)(Math.random() * tour.length);
                while (punt2 == i) { // ens asegurem que de que es faci el canvi per un altre
                    punt2 = (int)(Math.random() * tour.length);
                }
                int aux = mutated[punt2];
                mutated[punt2] = mutated[i];
                mutated[i] = aux;
            }
        }
        double costTour=Solution.getCost();     //sha de fer un objecte de tipus solutions
        double costMutated=Solution.etCost();
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
