
package projecte_prop;

import java.util.Scanner;

public class TspGA {
    //nombre de generacions sense variar per donar una solució per bona
    private static int stopCondition;
    //max de generacions que es crearan
    private static int nGeneracions;
    //numero de punts
    private static int nPunts;
    
    private static int nTours = 20;              //el valor de la quantitat de toure sobre la qual operarà
    private static boolean elitism = true;        //guarda el millor de cada generació a la posició de population
    private static int tournamentSize = 5;         //defineix la grandaria del subconjunt de pares del qual escollirem el millor
    private static double mutationRate = 0.015;    //rati deom mutació
    private static double mutationSwapProbability = 0.90;
    
    
    //passant una ciutat, una condició de parada, el nombre de generacions màximes,
    //el nombre de tours, elitisme, rouletewheel_TS, tournamentSize(si rouletewh...==true => tour...=null)
    //edge_crossover, mutate2, mutationRate, mutationSwapProbability(si mutate_2==true)
    public static Tour tspGA(Ciutat C, int StopCondition, int NGeneracions, int NTours, 
            boolean Elitism, boolean Rouletewheel_TS, int TournamentSize, boolean Edge_crossover,
            boolean Mutate2, int MutationRate, int MutationSwapProbability){
        
        stopCondition = StopCondition;
        nGeneracions = NGeneracions;
        nTours = NTours;
        elitism = Elitism;
        tournamentSize = TournamentSize;
        mutationRate = MutationRate;
        mutationSwapProbability = MutationSwapProbability;

        nPunts = C.num_Tours();                                         

        Cjt_tours pop = new Cjt_tours(nTours);

        
        ompla_pop(pop);
        
        int Fittest = pop.getFittest();
        int Fitness = (int)pop.getFitness(Fittest); 
        System.out.println("Generació 0     Fitness: " + Fitness);

        int nCicles = 0;
        int bFittest = Fittest;
        int bFitness= Fitness;

        //iteracions per evolucionar la població
        for(int i = 1; i <= nGeneracions; ++i){
            //evoluciona la població en una generació
            envolvePopulation(pop);
                    
            //obtè el millor element de la població i el seu cost total
            Fittest = pop.getFittest();
            Fitness = (int)pop.getFitness(Fittest);
            System.out.println("Generació " + i + "     Fitness: " + Fitness);

            //si fa tantes generacions que no ha cambiat el millor element de
            //la població com defineix "stopCondition" no crea més generacions
            if(bFitness > Fitness){
                bFittest = Fittest;
                bFitness = Fitness;
                nCicles = 0;
            }
            else{
                ++nCicles;
                if(nCicles == stopCondition) break;
            }
        }

        //escriu la ruta més òptima
        //System.out.println("La ruta final és: ");
        return pop.getFittestTour();

    }
    
    
    private static void envolvePopulation(Population pop){
        Population newPopulation = new Population(nCiutats, nTours);
        
        int elitismOffset = 0;
        if(elitism){
            newPopulation.addNewTour(0, pop.getTour(pop.getFittest()));
            elitismOffset = 1;
        }
        
        //Crossover population
        for(int i = elitismOffset; i < nTours; ++i){
            int parent1[], parent2[];
            parent1 = TournamentSelection.tournamentSelection_roulettewheel(pop);
            parent2 = TournamentSelection.tournamentSelection_roulettewheel(pop);
            
            
            /*System.out.println("Pare 1: ");
            for(int ii = 0; ii < npunts; ++ii){
                System.out.print(" " + parent1[ii]);
            }
            System.out.println("");
            
            
            System.out.println("Pare 1: ");
            for(int ii = 0; ii < npunts; ++ii){
                System.out.print(" " + parent1[ii]);
            }
            System.out.println("");*/
            
            
            newPopulation.addNewTour(i, Crossover.crossover_edgeRecombination(parent1,parent2));   
        }
        
        for(int i = elitismOffset; i < nTours; ++i){
            newPopulation.addNewTour(i, mutate.mutate2(newPopulation.getTour(i),mutationRate, mutationSwapProbability));
        }
        pop = newPopulation;
        pop.ompla_pesosRutes();
    }
    
    
    private void ompla_population(Cjt_tours pop){
        
        //omplim la population
        Tour tour = new Tour();
        Element E;
        for(int i = 0; i < nTours; ++i){
            for(int ii = 0; ii < nPunts; ++ii){
                E = new Element(ii);
                tour.addElement(E, ii);
            }
            pop.addTour(i, tour);
        }
        
        //es fa un suffle de la population inicial
        
    }
}
