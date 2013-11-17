
package projecte_prop;
/**
 *
 * @author josep
 */

import Controladors.CtrlDomini;

/*quan usem el driver de TspGA:
    import Stubs.CjtTours;
    import Stubs.Tour;
*/

public class TspGA {
    //nombre de generacions sense variar per donar una solució per bona
    private static int stopCondition;
    //max de generacions que es crearan
    private static int nGeneracions;
    //numero de punts
    private static int nPunts;
    
    public static int nTours = 20;              //el valor de la quantitat de toure sobre la qual operarà
    private static boolean elitism = true;        //guarda el millor de cada generació a la posició de population
    private static int tournamentSize = 5;         //defineix la grandaria del subconjunt de pares del qual escollirem el millor
    private static double mutationRate = 0.015;    //rati deom mutació
    private static double mutationSwapProbability = 0.90;
    
    
    //passant una condició de parada, el nombre de generacions màximes,
    //el nombre de tours, elitisme, rouletewheel_TS, tournamentSize(si rouletewh...==true => tour...=null)
    //edge_crossover, mutate2, mutationRate, mutationSwapProbability(si mutate_2==true)
    public static Tour TspGA(int StopCondition, int NGeneracions, int NTours, 
            boolean Elitism, boolean Rouletewheel_TS, int TournamentSize, boolean Edge_crossover,
            boolean Mutate2, double MutationRate, double MutationSwapProbability){
        
        stopCondition = StopCondition;
        nGeneracions = NGeneracions;
        nTours = NTours;
        elitism = Elitism;
        tournamentSize = TournamentSize;
        mutationRate = MutationRate;
        mutationSwapProbability = MutationSwapProbability;

        nPunts = CtrlDomini.getCity().num_Elements();                                         

        CjtTours pop = new CjtTours(nTours);

        ompla_pop(pop);
        
        Tour Fittest = pop.getFittestTour();
        int Fitness = pop.getFitness(); 
        int nCicles = 0;

        //iteracions per evolucionar la població
        for(int i = 1; i <= nGeneracions; ++i){
            //evoluciona la població en una generació
            
            pop = envolvePopulation(pop, Rouletewheel_TS, Edge_crossover, Mutate2);
                    
            System.out.println("Generació " + i + "     Fitness: " + Fitness);

            //si fa tantes generacions que no ha cambiat el millor element de
            //la població com defineix "stopCondition" no crea més generacions
            if(Fitness > pop.getFitness()){
                Fittest = pop.getFittestTour();
                Fitness = pop.getFitness();
                nCicles = 0;
            }
            else{
                ++nCicles;
                if(nCicles == stopCondition) break;
            }
        }

        //escriu la ruta més òptima
        //System.out.println("La ruta final és: ");
        return Fittest;
    }
    
    
    private static CjtTours envolvePopulation(CjtTours pop, boolean  Rouletewheel_TS, boolean Edge_crossover, boolean Mutate2){
        CjtTours newPopulation = new CjtTours(nTours);
        Tour T = new Tour();
        int elitismOffset = 0;
        if(elitism){
            newPopulation.addTour(0, pop.getFittestTour());
            elitismOffset = 1;
        }
        
        //Crossover population
        for(int i = elitismOffset; i < nTours; ++i){
            Tour parent1 = new Tour();
            Tour parent2 = new Tour();
            if(Rouletewheel_TS){
                parent1 = TournamentSelection.tournamentSelection_roulettewheel(pop);
                parent2 = TournamentSelection.tournamentSelection_roulettewheel(pop);
            }
            else{
                parent1 = TournamentSelection.tournamentSelection(pop, tournamentSize);
                parent2 = TournamentSelection.tournamentSelection(pop, tournamentSize);
            }
            if(Edge_crossover) newPopulation.addTour(i, Crossover.crossover_edgeRecombination(parent1,parent2));
            else {
                T = Crossover.crossover(parent1, parent2);
                newPopulation.addTour(i, T);
            } 
        }
        for(int i = elitismOffset; i < nTours; ++i){
            if(Mutate2) newPopulation.addTour(i, Mutate.mutate2(newPopulation.getTour(i),mutationRate, mutationSwapProbability));
            else{
                T = Mutate.mutate(T, mutationRate);
                newPopulation.addTour(i, T);
            }
        }        
       return newPopulation;
    }
    
    
    private static void ompla_pop(CjtTours pop){
        //omplim la population
        Tour t = CtrlDomini.getCjtElement();
        for(int i = 0; i < nTours; ++i){
            pop.addTour(i,t);
        }
        //es fa un suffle de la population inicial
        for(int i = 0; i < 10; ++i){
            int pos1, pos2;
            pos1 = (int)Math.random() * nPunts;
            pos2 = (int)Math.random() * nPunts;
            for(int ii = 0; ii < nTours; ++ii){
                pop.getTour(ii).swap(pos1, pos2);
            }
        }
    }
    
    private static void escriureCjtElem(Tour t){
        for(int i = 0; i < t.size(); ++i){
            System.out.print(" " + t.getElementPos(i).getID());
        }
        System.out.print("          cost: " + t.getCost());
        System.out.println();
    }
}
