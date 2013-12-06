
package projecte_prop;

public class TournamentSelection_RouletteWheel extends TournamentSelection{
    
    City C;
    
    public TournamentSelection_RouletteWheel(City C){
        this.C = C;
    }
    
    /** @brief  Funció que retorna un dels Tours del CjtTours
        \pre    El CjtTours pop no és buit
        \post   Es retorna un dels Tours del CjtTours, com menor cost tenen els els Tours de CjtTours(són millors) tenen més probabilitats de ser escollits per ser retornats
    */
    @Override public Tour selTour(CjtTours pop){
        double limit, acom, totalFitness; int point;
        totalFitness = acom = 0;
        for(int i = 0; i < pop.sizeCjtTours(); ++i){
            totalFitness += 1/((double)pop.getCostTour(C, i));
        }
        limit = (double)Math.random() * totalFitness;
        point = (int)Math.random() * pop.sizeCjtTours();
        while(acom < limit){
            acom +=  1/((double)pop.getCostTour(C, point));
            ++point; if(point >= pop.sizeCjtTours()) point = 0;
        }
        return pop.getTour(point);
    }
}
