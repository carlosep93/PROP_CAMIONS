
package projecte_prop;

public class TournamentSelection_Random extends TournamentSelection{
    
    /** @brief  Funció que retorna un dels Tours del CjtTours
        \pre    El CjtTours pop no és buit, i el paràmetre tournamentSize és més petit que el tamany d'aquest
        \post   S'han escollit tournamentSize nombre de Tours del CjtTours a l'atzar, i d'aquest subconjunt es retorna el Tour amb menys cost
    */
    @Override public Tour selTour(Ciutat C, CjtTours pop, int tournamentSize){
        int Fitness= 0;
        Tour Fittest = new Tour();
        boolean ini = false;
        for(int i = 0; i < tournamentSize; ++i){
            int randomId = (int)(Math.random() * Tsp_GA.nTours);
            if(!ini){
                Fittest = pop.getTour(randomId);
                Fitness = Fittest.getCost(C);
                ini=true;
            }
            else if(Fitness > pop.getCostTour(C, randomId)){
                Fittest = pop.getTour(randomId);
                Fitness = Fittest.getCost(C);
            }
        }
        return Fittest;
    }
    
    @Override public Tour selTour(Ciutat C, CjtTours pop){
        return null;
    }
}
