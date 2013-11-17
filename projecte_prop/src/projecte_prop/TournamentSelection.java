
package projecte_prop;

public class TournamentSelection {
    
    /** @brief  Funció que retorna un dels Tours del CjtTours
        \pre    El CjtTours pop no és buit, i el paràmetre tournamentSize és més petit que el tamany d'aquest
        \post   S'han escollit tournamentSize nombre de Tours del CjtTours a l'atzar, i d'aquest subconjunt es retorna el Tour amb menys cost
    */
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
    
    /** @brief  Funció que retorna un dels Tours del CjtTours
        \pre    El CjtTours pop no és buit
        \post   Es retorna un dels Tours del CjtTours, com menor cost tenen els els Tours de CjtTours(són millors) tenen més probabilitats de ser escollits per ser retornats
    */
    public static Tour tournamentSelection_roulettewheel(CjtTours pop){
        double limit, acom, totalFitness; int point;
        totalFitness = acom = 0;
        for(int i = 0; i < pop.sizeCjtTours(); ++i){
            totalFitness += 1/((double)pop.getCostTour(i));
        }
        limit = (double)Math.random() * totalFitness;
        point = (int)Math.random() * pop.sizeCjtTours();
        while(acom < limit){
            acom +=  1/((double)pop.getCostTour(point));
            ++point; if(point >= pop.sizeCjtTours()) point = 0;
        }
        return pop.getTour(point);
    }
}
