
package projecte_prop;

public class TournamentSelection {
    
    public static Tour tournamentSelection(CjtTours pop, int tournamentSize){
        int Fitness= 0;
        Tour Fittest = new Tour();
        boolean ini = false;
        for(int i = 0; i < tournamentSize; ++i){
            int randomId = (int)(Math.random() * TspGA.nTours);
            if(!ini){
                Fittest = pop.getTour(randomId);
                Fitness = Fittest.getCost();
                ini=true;
            }
            else if(Fitness > pop.getCostTour(randomId)){
                Fittest = pop.getTour(randomId);
                Fitness = Fittest.getCost();
            }
        }
        return Fittest;
    }
    
    public static Tour tournamentSelection_roulettewheel(CjtTours pop){
        /*double limit, acom; int point;
        acom = 0;
        limit = (double)Math.random() * pop.getTotalFitness();
        point = (int)Math.random() * pop.nTours;
        while(acom < limit){
            ++point; if(point >= pop.nTours) point = 0;
            acom +=  pop.getCostRuta(point);
        }*/
        return pop.getTour(0);
    }
}
