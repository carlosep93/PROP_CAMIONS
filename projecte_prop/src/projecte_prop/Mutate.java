

package projecte_prop;

import Controladors.CtrlDomini;

public class Mutate {
    
    public static Tour mutate(Tour tour,double mutationRate){
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
    
    public static Tour mutate2(Tour tour, double mutationRate, double mutationSwapProbability) {
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
    public static void  mutate3 (Tour t ) {
        int max1 = CtrlDomini.getRelations().getCost(t.getElementPos(0).getID(),
                t.getElementPos(1).getID());        
        int max2 = 0;
        int aux;
        int pos1 = 0;
        int pos2 = 1;
        for (int i=1; i < t.size()-1;++i) {
            aux = CtrlDomini.getRelations().getCost(t.getElementPos(i).getID(),
                t.getElementPos(i+1).getID());
            if (max1 < aux) {
                max2 = max1;
                max1 = aux;
                pos2 = pos1;
                pos1 = i;
                
            }        
        }
        t.swap(pos1,pos2);
    }
}
