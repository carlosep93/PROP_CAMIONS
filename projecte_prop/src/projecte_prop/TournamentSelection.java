
package projecte_prop;

public class TournamentSelection {
    
    public static int[] tournamentSelection(Population pop, int tournamentSize){
        int Fittest, Fitness; Fittest = Fitness = 0;
        boolean ini = false;
        for(int i = 0; i < tournamentSize; ++i){
            int randomId = (int)(Math.random() * pop.nTours);
            if(!ini){
                Fittest = randomId;
                Fitness = (int)pop.getFitness(randomId);
                ini=true;
            }
            else if(Fitness > (int)pop.getFitness(randomId)){
                Fittest = randomId;
                Fitness = (int)pop.getFitness(randomId);
            }
        }
        return pop.getTour(Fittest);
    }
    
    public static int[] tournamentSelection_roulettewheel(Population pop){
        double limit, acom; int point;
        acom = 0;
        limit = (double)Math.random() * pop.getTotalFitness();
        point = (int)Math.random() * pop.nTours;
        while(acom < limit){
            ++point; if(point >= pop.nTours) point = 0;
            acom +=  pop.getCostRuta(point);
        }
        return pop.getTour(point);
    }
}
