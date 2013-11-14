
package projecte_prop;

public class Mutate {
    
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
        double costTour = Solution.getCost();     //sha de fer un objecte de tipus solutions
        double costMutated = Solution.getCost();
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
